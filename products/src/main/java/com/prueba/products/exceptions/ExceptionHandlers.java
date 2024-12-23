package com.prueba.products.exceptions;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.prueba.products.models.dto.GenericExceptionDTO;


@RestControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler
	public ResponseEntity<GenericExceptionDTO> handlerException(GenericException exc){
		GenericExceptionDTO excDto = new GenericExceptionDTO(exc.getTechMessage(),
				exc.getUserMessage(),exc.getExceptionCode());
		return new ResponseEntity<>(excDto, HttpStatus.valueOf(excDto.getExceptionCode()));
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
