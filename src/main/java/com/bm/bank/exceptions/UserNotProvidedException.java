package com.bm.bank.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class UserNotProvidedException {

//     @ExceptionHandler(BMBankUserException.class)
//     @ResponseBody
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public ExceptionResponse handleUserNotFoundException(ExceptionResponse err) {
//         ExceptionResponse response = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
//         final Logger logger = LoggerFactory.getLogger(UserNotProvidedException.class);
//         logger.warn("Error code: " + err.getErrorCode() + "Error message: " + err.getErrorMessage());
//         return response;
//     }
// }

//Exception for when an invalid user was provided
public class UserNotProvidedException extends BMBankUserException {
    public UserNotProvidedException() {
        super(1002, "A user object with valid information was not provided");
    }

    public UserNotProvidedException(int code, String message) {
        super(code, message);
    }
}
