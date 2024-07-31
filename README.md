# Java_Payment_Error_Model

### Error 클래스

#### 개요
Error 클래스는 다양한 오류 코드와 관련된 오류 메시지를 정의하는 Java 클래스입니다. <br>
이 클래스는 오류 코드를 상수로 정의하고, 각 오류 코드에 대한 설명을 제공합니다. <br>
또한, 오류 코드에 해당하는 메시지를 쉽게 조회할 수 있는 메소드를 제공합니다.<br>

### 상수 정의
이 클래스에서는 여러 범주에 걸쳐 다양한 오류 코드를 상수로 정의하고 있습니다. 상수는 크게 다음과 같은 범주로 나뉩니다:

- 은행 응답 오류
- 논리 오류
- 프린터 오류
- EMV 관련 오류
- 통신 오류
- 데이터 읽기/쓰기 오류
각 범주와 관련된 상수는 오류의 원인과 상태를 명확하게 구분할 수 있도록 설계되었습니다.

### 주요 상수 목록
- BANK_RESP_END_ERROR: 은행 응답 종료 오류
- LOGIC_END_ERROR: 논리 종료 오류
- PRINT_END_ERROR: 프린터 종료 오류
- EMV_END_ERR: EMV 종료 오류
- EXCEPTION_ERR: 프로그램 예외
- USER_CANCEL_INPUT: 사용자 취소
- INPUT_ERR: 입력 오류
- PRN_STATUS_PAPEROUT: 프린터 용지 없음
- EMV_NOT_INIT: EMV 초기화되지 않음

### 메소드
getErrorMessage(int errorCode)
오류 코드에 대한 메시지를 반환합니다.

### 매개변수:
- errorCode (int): 오류 코드

### 반환값:
(String): 오류 코드에 해당하는 오류 메시지. 오류 코드가 정의되어 있지 않은 경우, "알 수 없는 오류 코드"를 반환합니다.

