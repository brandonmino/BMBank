package com.bm.bank.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class UserIdNotProvidedException {

//     @ExceptionHandler(BMBankUserException.class)
//     @ResponseBody
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public ExceptionResponse handleUserIdNotProvidedException(ExceptionResponse err) {
//         ExceptionResponse response = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
//         final Logger logger = LoggerFactory.getLogger(UserIdNotProvidedException.class);
//         logger.warn("Error code: " + err.getErrorCode() + "Error message: " + err.getErrorMessage());
//         return response;
//     }
// }

//Exception for when user id is not provided
public class UserIdNotProvidedException extends BMBankUserException {
    public UserIdNotProvidedException() {
        super(1000, "No Id was provided in the search");
    }

    public UserIdNotProvidedException(int code, String message) {
        super(code, message);
    }
}
