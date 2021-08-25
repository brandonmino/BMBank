package com.bm.bank.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ControllerAdvice
// public class ExcessiveWithdrawException {

//     @ExceptionHandler(BMBankUserException.class)
//     @ResponseBody
//     @ResponseStatus(HttpStatus.BAD_REQUEST)
//     public ExceptionResponse handleUserNotFoundException(ExceptionResponse err) {
//         ExceptionResponse response = new ExceptionResponse(err.getErrorCode(), err.getErrorMessage());
//         final Logger logger = LoggerFactory.getLogger(ExcessiveWithdrawException.class);
//         logger.warn("Error code: " + err.getErrorCode() + "Error message: " + err.getErrorMessage());
//         return response;
//     }
// }

//Exception for trying to withdraw more funds than you have
public class ExcessiveWithdrawException extends BMBankWithdrawException {
    public ExcessiveWithdrawException() {
        super(3000, "Withdraw was blocked as you attempted to withdraw more than your current balance");
    }

    public ExcessiveWithdrawException(int code, String message) {
        super(code, message);
    }
}
