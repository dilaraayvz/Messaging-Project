package com.messaging_app.authserver.core.utils;
import com.messaging_app.authserver.core.utils.details.BusinessProblemDetails;
import com.messaging_app.authserver.core.utils.details.ValidationExceptionDetails;
import com.messaging_app.authserver.core.utils.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
        @ExceptionHandler({BusinessException.class})
        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        public BusinessProblemDetails handleBusinessException(BusinessException exception) {

            BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
            businessProblemDetails.setDetail(exception.getMessage());
            return businessProblemDetails;
        }

        @ExceptionHandler({ MethodArgumentNotValidException.class })
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ValidationExceptionDetails handleValidationException(MethodArgumentNotValidException exception) {

            Map<String,String> validationErrors = new HashMap<>();

            exception.getBindingResult().getFieldErrors().stream().map(error ->
                    validationErrors.put(error.getField(),error.getDefaultMessage())
            ).toList();

            ValidationExceptionDetails validationProblemDetails = new ValidationExceptionDetails();
            validationProblemDetails.setErrors(validationErrors);
            return validationProblemDetails;
        }

    }
