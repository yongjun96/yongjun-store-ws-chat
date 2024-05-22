package websocket.chat.config.common.exceptioncode;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    // SERVER
    SERVER_INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "S001", "서버 에러"),
    SERVER_FORBIDDEN(403, HttpStatus.FORBIDDEN, "S002", "접근 권한이 없습니다."),
    SERVER_USER_DETAILS_USERNAME_NOT_FOUND(404, HttpStatus.NOT_FOUND, "S003", "해당 계정을 찾을 수 없습니다."),
    SERVER_UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED, "S004", "로그인이 필요합니다.");


    private final int statusCode;
    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(int statusCode, HttpStatus status, String code, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
        this.code = code;
    }

}
