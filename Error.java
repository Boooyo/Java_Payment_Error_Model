package com.visionlabs;

import com.visionlabs.sdk.emv.EmvResult;
import java.util.HashMap;
import java.util.Map;

/**
 * 오류 코드와 해당 오류 메시지를 정의하는 클래스
 */
public class Error {

    // 오류 코드 범위
    public static final int BANK_RESP_END_ERROR = 0x00FF; // 은행 응답 종료 오류
    public static final int LOGIC_END_ERROR = 0x3FFF; // 논리 종료 오류
    public static final int PRINT_END_ERROR = 0x4FFF; // 프린터 종료 오류
    public static final int EMV_END_ERR = -100; // EMV 종료 오류

    // 기본 논리 오류 코드
    public static final int EXCEPTION_ERR = 0x1C00; // 프로그램 예외
    public static final int MD_STATUS_NOT_SETTEMENT_ERR = 0x1C01; // 배치 정산을 먼저 수행해야 함
    public static final int USER_CANCEL_INPUT = 0x1C02; // 사용자 취소
    public static final int INPUT_ERR = 0x1C03; // 입력 오류
    public static final int INPUT_TIME_OUT = 0x1C04; // 입력 시간 초과
    public static final int UPDATE_WK_ERROR = 0x1C06; // 작업 키 업데이트 실패
    public static final int UPDATE_BATCH_NO_ERROR = 0x1C07; // 배치 번호 업데이트 실패
    public static final int SALE_VOID_ADD_TIP = 0x1C08; // 취소 거래에 팁 추가 불가
    public static final int OLD_TRADE_HAVE_ADD_TIP = 0x1C09; // 원래 거래에 팁이 이미 추가됨
    public static final int ADD_TIP_ERROR = 0x1C0A; // 내부 카드에서 팁 추가 실패
    public static final int OLD_TRADE_HAVE_ADJUST = 0x1C0C; // 원래 거래가 조정됨, 다시 조정 불가
    public static final int CONTACT_ISSUING_BANK_BANK = 0x1C0E; // 발급 은행에 문의
    public static final int FD_ERR = 0x1C0F; // 도메인 오류
    public static final int FD_NOT_EXIST = 0x1C10; // 도메인 존재하지 않음
    public static final int UPDATE_RT_ERR = 0x1C11; // 시계 업데이트 실패
    public static final int NOT_SUPPORT_ADD_TIP = 0x1C12; // 터미널에서 팁 추가 불가
    public static final int NO_PARAM_DOWN = 0x1C13; // 백엔드에서 파라미터 다운로드 없음
    public static final int SERVICE_RESP_ERR = 0x1C14; // 백엔드 응답 오류
    public static final int DOWN_PARAM_FAIL = 0x1C15; // 파라미터 다운로드 실패
    public static final int DOWN_PARA_FD62_LEN_ERR = 0x1C16; // 응답 메시지 필드 62 길이 오류
    public static final int ORIGNAL_TXN_NOT_RIGHT = 0x1C17; // 원래 거래 유형 오류
    public static final int ORIGNAL_TXN_NOT_EXIST = 0x1C18; // 원래 거래 없음
    public static final int NOT_TRADE_REC = 0x1C19; // 거래 기록 없음
    public static final int OLD_TRADE_HAVE_VOID = 0x1C1A; // 원래 거래가 이미 취소됨
    public static final int OLD_TRADE_CANNOT_VOID = 0x1C1B; // 원래 거래가 팁을 추가하여 취소 불가
    public static final int TRADE_ID_NOT_RIGHT = 0x1C1C; // 거래 ID 오류
    public static final int NOT_TRADE_REC_NEED_UPLOAD = 0x1C1D; // 업로드할 거래 없음
    public static final int NO_TXN_CAN_BE_PRINT = 0x1C1E; // 인쇄할 거래 기록 없음
    public static final int NOT_HAVE_CERT_FILE = 0x1C1F; // 인증서 파일 없음
    public static final int OPEN_CERT_FILE_ERR = 0x1C20; // 인증서 파일 열기 실패
    public static final int POS_HAVE_NOT_LOGIN = 0x1C21; // POS 미로그인
    public static final int NOT_HAVE_ENOUGH_FLASH = 0x1C22; // 저장 공간 부족
    public static final int VOUCHER_FULL = 0x1C23; // 바우처 가득 참, 먼저 정산 필요
    public static final int TRADE_TOTAL_NUM_FULL = 0x1C24; // 거래 수 가득 참, 먼저 정산 필요
    public static final int NOT_SUPPORT_CURRENT_TRADE = 0x1C25; // 현재 거래를 지원하지 않음
    public static final int CAN_NOT_REPRINT_REFUSED_REC = 0x1C28; // 오프라인 IC 카드 거부 거래 재인쇄 불가
    public static final int NOT_ENOUGH_RECHARGE_AMOUNT = 0x1C29; // 충전 금액 초과
    public static final int NOT_APP_LIST_REC = 0x1C2A; // IC 카드 파라미터 없음
    public static final int NOT_CAPK_REC = 0x1C2B; // IC 카드 공개 키 없음
    public static final int GET_SYSTEM_FREE_SPACE_ERR = 0x1C2C; // 시스템 여유 공간 가져오기 실패
    public static final int NOT_FIND_CAPK = 0x1C2D; // 공개 키 찾을 수 없음
    public static final int NOT_FIND_AID = 0x1C2E; // IC 카드 파라미터 찾을 수 없음
    public static final int INVALID_CARD_NO = 0x1C2F; // 카드 번호 무효
    public static final int TDK_ENCRYPT_FAILED = 0x1C30; // 트랙 데이터 암호화 실패
    public static final int OFFLINE_NUM_FULL = 0x1C31; // 오프라인 거래 수 초과
    public static final int DELETE_UPFAILED_REC_ERR = 0x1C33; // 업로드 실패 거래 삭제 실패
    public static final int OFFLINE_AMOUNT_FULL = 0x1C34; // 오프라인 거래 금액 초과
    public static final int NOT_FAILED_OFFLINE_TRADE = 0x1C35; // 실패한 오프라인 거래 세부사항 없음

    // 통신 오류 코드
    public static final int NOT_CURRENT_COMM_MODE = 0x2F01; // 지원되지 않는 통신 모드
    public static final int INIT_COMM_ERR = 0x2F02; // 통신 초기화 실패
    public static final int CONNECT_HOST_ERR = 0x2F03; // 호스트 연결 실패
    public static final int SEND_ERR = 0x2F04; // 데이터 전송 오류
    public static final int RECV_TIMEOUT = 0x2F05; // 수신 시간 초과
    public static final int RECV_ERR = 0x2F06; // 데이터 수신 오류
    public static final int UNPACK8583_LEN_ERR = 0x2F07; // 8583 메시지 길이 오류

    // 데이터 읽기/쓰기 오류 코드
    public static final int READ_REVERSAL_ERR = 0x3B00; // 반전 데이터 읽기 실패
    public static final int SAVE_REVERSAL_ERR = 0x3B01; // 반전 데이터 저장 실패
    public static final int SAVE_TRADE_ERR = 0x3B02; // 거래 저장 실패
    public static final int READ_TRADE_ERR = 0x3B03; // 거래 읽기 실패
    public static final int SAVE_EMV_FILE_ERR = 0x3B04; // EMV 파일 저장 실패
    public static final int READ_EMV_FILE_ERR = 0x3B05; // EMV 파일 읽기 실패
    public static final int VERIFY_CRC_ERR = 0x3B07; // CRC 체크 오류
    public static final int SAVE_PARAM_ERR = 0x3B08; // 파라미터 저장 실패
    public static final int READ_PARAM_ERR = 0x3B09; // 파라미터 읽기 실패
    public static final int SAVE_SCRIPTRESULT_ERR = 0x3B0A; // 스크립트 결과 저장 실패
    public static final int READ_SCRIPTRESULT_ERR = 0x3B0B; // 스크립트 결과 읽기 실패
    public static final int UPDATE_TRADE_ERR = 0x3B0C; // 거래 데이터 업데이트 실패

    // 프린터 오류 코드
    public static final int PRN_STATUS_PAPEROUT = 0x4A01; // 프린터 용지 없음
    public static final int PRN_STATUS_TOOHEAT = 0x4A02; // 프린터 과열
    public static final int PRN_STATUS_FAULT = 0x4A03; // 프린터 결함
    public static final int PRINT_FAULT_ERR = 0x4A04; // 인쇄 결함 오류

    // EMV 관련 오류 코드
    public static final int EMV_NOT_INIT = EmvResult.EMV_NOT_INIT; // EMV 초기화 안 됨
    public static final int EMV_TRANS_NOT_START = EmvResult.EMV_TRANS_NOT_START; // EMV 거래 시작 안 됨
    public static final int EMV_INVALID_PARAM = EmvResult.EMV_INVALID_PARAM; // EMV 파라미터 무효
    public static final int EMV_READ_ICC_ERR = EmvResult.EMV_READ_ICC_ERR; // ICC 읽기 실패
    public static final int EMV_WRITE_ICC_ERR = EmvResult.EMV_WRITE_ICC_ERR; // ICC 쓰기 실패
    public static final int EMV_ICC_NOT_FOUND = EmvResult.EMV_ICC_NOT_FOUND; // ICC 찾을 수 없음
    public static final int EMV_TIMEOUT = EmvResult.EMV_TIMEOUT; // EMV 작업 시간 초과
    public static final int EMV_PROCESS_ERR = EmvResult.EMV_PROCESS_ERR; // EMV 처리 오류

    // 오류 메시지를 저장하는 맵
    private static final Map<Integer, String> errorMessages = new HashMap<>();

    static {
        // 오류 메시지 맵 초기화
        initializeErrorMessages();
    }

    private static void initializeErrorMessages() {
        // 논리 오류 코드 메시지
        addErrorMessage(EXCEPTION_ERR, "프로그램 예외");
        addErrorMessage(MD_STATUS_NOT_SETTEMENT_ERR, "먼저 배치 정산을 수행하십시오");
        addErrorMessage(USER_CANCEL_INPUT, "사용자 취소");
        addErrorMessage(INPUT_ERR, "입력 오류");
        addErrorMessage(INPUT_TIME_OUT, "입력 시간 초과");
        addErrorMessage(UPDATE_WK_ERROR, "작업 키 업데이트 실패");
        addErrorMessage(UPDATE_BATCH_NO_ERROR, "배치 번호 업데이트 실패");
        addErrorMessage(SALE_VOID_ADD_TIP, "취소된 거래에 팁을 추가할 수 없습니다");
        addErrorMessage(OLD_TRADE_HAVE_ADD_TIP, "원래 거래에 이미 팁이 추가되었습니다");
        addErrorMessage(ADD_TIP_ERROR, "내부 카드에서 팁 추가 실패");
        addErrorMessage(OLD_TRADE_HAVE_ADJUST, "원래 거래가 조정되었으므로 다시 조정할 수 없습니다");
        addErrorMessage(CONTACT_ISSUING_BANK_BANK, "발급 은행에 문의하십시오");
        addErrorMessage(FD_ERR, "도메인 오류");
        addErrorMessage(FD_NOT_EXIST, "도메인 존재하지 않음");
        addErrorMessage(UPDATE_RT_ERR, "시계 업데이트 실패");
        addErrorMessage(NOT_SUPPORT_ADD_TIP, "터미널에서 팁 추가를 지원하지 않습니다");
        addErrorMessage(NO_PARAM_DOWN, "백엔드에서 파라미터가 다운로드되지 않았습니다");
        addErrorMessage(SERVICE_RESP_ERR, "백엔드 응답 오류");
        addErrorMessage(DOWN_PARAM_FAIL, "파라미터 다운로드 실패");
        addErrorMessage(DOWN_PARA_FD62_LEN_ERR, "응답 메시지 필드 62 길이 오류");
        addErrorMessage(ORIGNAL_TXN_NOT_RIGHT, "원래 거래 유형이 잘못되었습니다");
        addErrorMessage(ORIGNAL_TXN_NOT_EXIST, "원래 거래가 존재하지 않습니다");
        addErrorMessage(NOT_TRADE_REC, "거래 기록이 없습니다");
        addErrorMessage(OLD_TRADE_HAVE_VOID, "원래 거래가 이미 취소되었습니다");
        addErrorMessage(OLD_TRADE_CANNOT_VOID, "원래 거래에 팁이 추가되어 취소할 수 없습니다");
        addErrorMessage(TRADE_ID_NOT_RIGHT, "거래 ID 오류");
        addErrorMessage(NOT_TRADE_REC_NEED_UPLOAD, "업로드할 거래가 없습니다");
        addErrorMessage(NO_TXN_CAN_BE_PRINT, "인쇄할 거래 기록이 없습니다");
        addErrorMessage(NOT_HAVE_CERT_FILE, "인증서 파일이 없습니다");
        addErrorMessage(OPEN_CERT_FILE_ERR, "인증서 파일 열기 실패");
        addErrorMessage(POS_HAVE_NOT_LOGIN, "POS가 로그인되지 않았습니다");
        addErrorMessage(NOT_HAVE_ENOUGH_FLASH, "저장 공간이 부족합니다");
        addErrorMessage(VOUCHER_FULL, "바우처가 가득 찼습니다. 먼저 정산하십시오");
        addErrorMessage(TRADE_TOTAL_NUM_FULL, "거래 수가 가득 찼습니다. 먼저 정산하십시오");
        addErrorMessage(NOT_SUPPORT_CURRENT_TRADE, "현재 거래를 지원하지 않습니다");
        addErrorMessage(CAN_NOT_REPRINT_REFUSED_REC, "오프라인 IC 카드 거부 거래는 재인쇄할 수 없습니다");
        addErrorMessage(NOT_ENOUGH_RECHARGE_AMOUNT, "충전 금액이 한도를 초과했습니다");
        addErrorMessage(NOT_APP_LIST_REC, "IC 카드 파라미터가 없습니다");
        addErrorMessage(NOT_CAPK_REC, "IC 카드 공개 키가 없습니다");
        addErrorMessage(GET_SYSTEM_FREE_SPACE_ERR, "시스템 여유 공간 가져오기 실패");
        addErrorMessage(NOT_FIND_CAPK, "공개 키를 찾을 수 없습니다");
        addErrorMessage(NOT_FIND_AID, "IC 카드 파라미터를 찾을 수 없습니다");
        addErrorMessage(INVALID_CARD_NO, "카드 번호가 유효하지 않습니다");
        addErrorMessage(TDK_ENCRYPT_FAILED, "트랙 데이터 암호화 실패");
        addErrorMessage(OFFLINE_NUM_FULL, "오프라인 거래 수가 한도를 초과했습니다");
        addErrorMessage(DELETE_UPFAILED_REC_ERR, "업로드 실패 거래 삭제 실패");
        addErrorMessage(OFFLINE_AMOUNT_FULL, "오프라인 거래 금액이 한도를 초과했습니다");
        addErrorMessage(NOT_FAILED_OFFLINE_TRADE, "실패한 오프라인 거래 세부정보가 없습니다");

        // 통신 오류 코드 메시지
        addErrorMessage(NOT_CURRENT_COMM_MODE, "지원되지 않는 통신 모드");
        addErrorMessage(INIT_COMM_ERR, "통신 초기화 실패");
        addErrorMessage(CONNECT_HOST_ERR, "호스트 연결 실패");
        addErrorMessage(SEND_ERR, "데이터 전송 오류");
        addErrorMessage(RECV_TIMEOUT, "수신 시간 초과");
        addErrorMessage(RECV_ERR, "데이터 수신 오류");
        addErrorMessage(UNPACK8583_LEN_ERR, "8583 메시지 길이 오류");

        // 데이터 읽기/쓰기 오류 코드 메시지
        addErrorMessage(READ_REVERSAL_ERR, "반전 데이터 읽기 실패");
        addErrorMessage(SAVE_REVERSAL_ERR, "반전 데이터 저장 실패");
        addErrorMessage(SAVE_TRADE_ERR, "거래 저장 실패");
        addErrorMessage(READ_TRADE_ERR, "거래 읽기 실패");
        addErrorMessage(SAVE_EMV_FILE_ERR, "EMV 파일 저장 실패");
        addErrorMessage(READ_EMV_FILE_ERR, "EMV 파일 읽기 실패");
        addErrorMessage(VERIFY_CRC_ERR, "CRC 체크 오류");
        addErrorMessage(SAVE_PARAM_ERR, "파라미터 저장 실패");
        addErrorMessage(READ_PARAM_ERR, "파라미터 읽기 실패");
        addErrorMessage(SAVE_SCRIPTRESULT_ERR, "스크립트 결과 저장 실패");
        addErrorMessage(READ_SCRIPTRESULT_ERR, "스크립트 결과 읽기 실패");
        addErrorMessage(UPDATE_TRADE_ERR, "거래 데이터 업데이트 실패");

        // 프린터 오류 코드 메시지
        addErrorMessage(PRN_STATUS_PAPEROUT, "프린터 용지 없음");
        addErrorMessage(PRN_STATUS_TOOHEAT, "프린터 과열");
        addErrorMessage(PRN_STATUS_FAULT, "프린터 결함");
        addErrorMessage(PRINT_FAULT_ERR, "인쇄 결함 오류");

        // EMV 관련 오류 코드 메시지
        addErrorMessage(EMV_NOT_INIT, "EMV 초기화되지 않음");
        addErrorMessage(EMV_TRANS_NOT_START, "EMV 거래 시작되지 않음");
        addErrorMessage(EMV_INVALID_PARAM, "유효하지 않은 EMV 파라미터");
        addErrorMessage(EMV_READ_ICC_ERR, "ICC 읽기 실패");
        addErrorMessage(EMV_WRITE_ICC_ERR, "ICC 쓰기 실패");
        addErrorMessage(EMV_ICC_NOT_FOUND, "ICC 찾을 수 없음");
        addErrorMessage(EMV_TIMEOUT, "EMV 작업 시간 초과");
        addErrorMessage(EMV_PROCESS_ERR, "EMV 처리 오류");
    }

    private static void addErrorMessage(int code, String message) {
        errorMessages.put(code, message);
    }

    /**
     * 오류 코드에 대한 메시지를 반환합니다.
     *
     * @param errorCode 오류 코드
     * @return 해당 오류 메시지
     */
    public static String getErrorMessage(int errorCode) {
        return errorMessages.getOrDefault(errorCode, "알 수 없는 오류 코드");
    }
}
