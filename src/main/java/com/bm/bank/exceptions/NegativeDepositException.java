package com.bm.bank.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class NegativeDepositException {

//     @ExceptionHandler(BMBankUserException.class)
//     @ResponseBody
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public ExceptionResponse handleUserNotFoundException(ExceptionResponse err) {
//         ExceptionResponse response = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
//         final Logger logger = LoggerFactory.getLogger(NegativeDepositException.class);
//         logger.warn("Error code: " + err.getErrorCode() + "Error message: " + err.getErrorMessage());
//         return response;
//     }
// }

//Exception for trying to withdraw more funds than you have
public class NegativeDepositException extends BMBankDepositException {
    public NegativeDepositException() {
        super(2000, "Deposit was blocked as you attempted to deposit a negative amount");
    }

    public NegativeDepositException(int code, String message) {
        super(code, message);
    }
}