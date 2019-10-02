package net.mate.testmaven.exception;

import lombok.Getter;
import lombok.Setter;
import net.mate.testmaven.exception.handler.NotFoundRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseHandler {

    @ExceptionHandler(NotFoundRuntimeException.class)
    public BaseResponse handlerNotFoundException(NotFoundRuntimeException message) {
        return BaseResponse.bildErrorResponse(404, message.getMessage());
    }

    @Getter
    @Setter
    private static class BaseResponse {
        private int errorCode = 200;
        private boolean success = true;
        private String errorMessage;

        public static BaseResponse bildErrorResponse(int errorCode, String errorMessage) {
            BaseResponse response = new BaseResponse();
            response.setErrorCode(errorCode);
            response.setErrorMessage(errorMessage);
            response.setSuccess(Boolean.FALSE);
            return response;
        }

    }
}
