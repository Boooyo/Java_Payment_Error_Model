package com.visionlabs;

import com.visionlabs.sdk.emv.EmvHandler;

/**
 * EMV 트랜잭션 처리를 위한 클래스
 */
public class EmvTrans {

    private final EmvHandler emvHandler = EmvHandler.getInstance();

    /**
     * EMV 트랜잭션 상태를 정의하는 열거형입니다.
     */
    public enum TransactionState {
        INIT(0), EMV_CORE_INIT(1), ONLINE(8), TRANS_END(9), TRANS(10),
        BALANCE_QUERY(11), READ_CARD_NO(12), READ_TRANS_LOG(13), TRANS_AUTO_TEST(16), PRINT(19),
        INPUT_AMOUNT(20), SWIPE_CARD(21), INPUT_PIN(22), INPUT_AMOUNT_END(23),
        INPUT_PIN_END(24), SWIPE_CARD_END(25), DETECTED_CARD(26), SWIPE_MULTI_CARD(27),
        SWIPE_CARD_CHECK_PHONE(28);

        private final int code;

        TransactionState(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static TransactionState fromCode(int code) {
            for (TransactionState state : values()) {
                if (state.getCode() == code) {
                    return state;
                }
            }
            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }

    /**
     * 지정된 TAG에 대한 TLV 데이터 반환
     * @param tag TLV 태그
     * @return TLV 데이터의 HEX 문자열
     */
    public String getTLVData(int tag) {
        byte[] data = emvHandler.getTlvData(tag);
        return data != null ? emvHandler.bytesToHexString(data) : "";
    }

    /**
     * 인증 요청 메시지 패키징
     * @return 인증 요청 메시지의 HEX 문자열
     */
    public String packAuthorisationRequest() {
        return packageTlvList(
            0x82, 0x9F36, 0x9F26, 0x9F27, 0x9F34, 0x9F1E, 0x9F10, 0x9F33, 0x9F35, 0x95, 
            0x9F37, 0x9F01, 0x9F02, 0x9F03, 0x5F25, 0x5F24, 0x5A, 0x5F34, 0x9F15, 0x9F16, 
            0x9F1A, 0x9F1C, 0x57, 0x5F2A, 0x9A, 0x9F21, 0x9C, 0x99, 0x9F39, 0x9F24, 0x5F20, 
            0x9F5D, 0x9F63
        );
    }

    /**
     * 금융 요청 메시지 패키징
     * @return 금융 요청 메시지의 HEX 문자열
     */
    public String packRequest() {
        return packageTlvList(
            0x82, 0x9F36, 0x9F07, 0x9F26, 0x9F27, 0x8E, 0x9F34, 0x9F1E, 0x9F0D, 
            0x9F0E, 0x9F0F, 0x9F10, 0x9F33, 0x9F35, 0x95, 0x9F37, 0x9F01, 0x9F02, 0x9F03, 
            0x5F25, 0x5F24, 0x5A, 0x5F34, 0x5F28, 0x9F15, 0x9F16, 0x9F1A, 0x9F1C, 0x57, 
            0x5F2A, 0x9A, 0x9F21, 0x9C, 0x99, 0x9F39, 0x9F24
        );
    }

    /**
     * 금융 확인 메시지 패키징
     * @return 금융 확인 메시지의 HEX 문자열
     */
    public String packConfirmation() {
        return packageTlvList(
            0x9F36, 0x9F26, 0x9F33, 0x9F35, 0x95, 0x9F37, 0x9F01, 0x9F02, 0x9F03, 
            0x5F25, 0x5F24, 0x5A, 0x9C, 0x8A, 0xDF31, 0x71, 0x72, 0x9F1C, 0x9F41, 
            0x9B, 0x9F39, 0x9F24
        );
    }

    /**
     * 배치 전송 메시지 패키징
     * @return 배치 전송 메시지의 HEX 문자열
     */
    public String packBatch() {
        return packageTlvList(
            0x82, 0x9F36, 0x9F07, 0x9F27, 0x8E, 0x9F34, 0x9F1E, 0x9F0D, 0x9F0E, 
            0x9F0F, 0x9F10, 0xDF31, 0x9F33, 0x9F35, 0x95, 0x9F26, 0x9F37, 0x9F01, 
            0x9F02, 0x9F03, 0x5F25, 0x5F24, 0x5A, 0x5F34, 0x89, 0x8A, 0x5F28, 
            0x9F15, 0x9F16, 0x9F1A, 0x9F1C, 0x81, 0x5F2A, 0x9A, 0x9F21, 0x9C, 
            0x9B, 0x9F4C, 0x9F74, 0x9F39, 0x9F24, 0x57, 0x5F20, 0x9F5D, 0x9F63
        );
    }

    /**
     * 충정 메시지 패키징
     * @return 충정 메시지의 HEX 문자열
     */
    public String packReversal() {
        return packageTlvList(
            0x82, 0x9F36, 0x9F1E, 0x9F10, 0x9F33, 0x9F35, 0x95, 0x9F01, 0x5F24,
            0x5A, 0x5F34, 0x9F15, 0x9F16, 0x9F1A, 0x5F2A, 0x9A, 0x9F21, 0x9C, 0x57,
            0x8A, 0xDF31, 0x71, 0x72, 0x9F1C, 0x9F41, 0x9B, 0x9F39, 0x9F24
        );
    }

    /**
     * 거래 결과 메시지 패키징
     * @return 거래 결과 메시지의 HEX 문자열
     */
    public String packTransResult() {
        return packageTlvList(0xDF31, 0x95, 0x9B);
    }

    /**
     * 지정된 TAG 배열에 대해 TLV 데이터를 패키징하여 HEX 문자열로 반환
     * @param tags TLV 태그 배열
     * @return 패키징된 TLV 데이터의 HEX 문자열
     */
    private String packageTlvList(int... tags) {
        return emvHandler.bytesToHexString(emvHandler.packageTlvList(tags));
    }

    /**
     * 정수를 HEX 문자열로 변환
     * @param i 변환할 정수
     * @return HEX 문자열
     */
    public static String getHexString(int i) {
        String hex = Integer.toHexString(i);
        return hex.length() == 1 ? "0" + hex : hex;
    }
}
