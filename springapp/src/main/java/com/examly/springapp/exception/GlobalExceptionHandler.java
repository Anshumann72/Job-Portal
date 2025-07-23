
package com.examly.springapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
// @ExceptionHandler(AlreadyAppliedForJobException.class)
// public ResponseEntity<?> method1(AlreadyAppliedForJobException e){
//     return ResponseEntity.status(409).body(e.getMessage());
// }

@ExceptionHandler(UserAlreadyExists.class)
public ResponseEntity<?> method2(UserAlreadyExists e){
    return ResponseEntity.status(409).body(e.getMessage());
}
@ExceptionHandler(UserNotExists.class)
public ResponseEntity<?> method3(UserNotExists e){
    return ResponseEntity.status(409).body(e.getMessage());
}

@ExceptionHandler(PasswordIncorrect.class)
public ResponseEntity<?> method4(PasswordIncorrect e){
    return ResponseEntity.status(409).body(e.getMessage());
}

@ExceptionHandler(JobNotFoundException.class)
public ResponseEntity<?> method5(JobNotFoundException e){
    return ResponseEntity.status(409).body(e.getMessage());
}

@ExceptionHandler(ApplicationNotFoundException.class)
public ResponseEntity<?> method6(ApplicationNotFoundException e){
    return ResponseEntity.status(409).body(e.getMessage());
}

@ExceptionHandler(InvalidUserException.class)
public ResponseEntity<?> method7(InvalidUserException e){
    return ResponseEntity.status(409).body(e.getMessage());
}

@ExceptionHandler(UserAlreadyApplied.class)
public ResponseEntity<?> method8(UserAlreadyApplied e){
    return ResponseEntity.status(409).body(e.getMessage());
}

// @ExceptionHandler(InvalidDateException.class)
// public ResponseEntity<?> method9(InvalidDateException e){
//     return ResponseEntity.status(409).body(e.getMessage());
// }

// @ExceptionHandler(PhoneNumberInvalid.class)
// public ResponseEntity<?> method10(PhoneNumberInvalid e){
//     return ResponseEntity.status(409).body(e.getMessage());
// }

// @ExceptionHandler(UserProfileNotFoundException.class)
// public ResponseEntity<?> method11(UserProfileNotFoundException e){
//     return ResponseEntity.status(409).body(e.getMessage());
// }

}

