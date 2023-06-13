package comskcc.caremoa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CareReviewException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public CareReviewException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = null;
    }


}
