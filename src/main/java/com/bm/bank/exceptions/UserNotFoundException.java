package com.bm.bank.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class UserNotFoundException {

//     @ExceptionHandler(BMBankUserException.class)
//     @ResponseBody
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public ExceptionResponse handleUserNotFoundException(ExceptionResponse err) {
//         ExceptionResponse response = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
//         final Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);
//         logger.warn("Error code: " + err.getErrorCode() + "Error message: " + err.getErrorMessage());
//         return response;
//     }
// }

//Exception for when a user id is not found
public class UserNotFoundException extends BMBankUserException {
    public UserNotFoundException() {
        super(1001, "Could not find content with given Id");
    }

    public UserNotFoundException(int code, String message) {
        super(code, message);
    }
}
