package com.vrhotelservice.Controller;

import com.vrhotelservice.Exception.AttachmentNotFoundException;
import com.vrhotelservice.Exception.CommentNotFoundException;
import com.vrhotelservice.Exception.HotelAlreadyExistsException;
import com.vrhotelservice.Exception.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class ExceptionController {
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<String> handleHotelNotFoundException(HotelNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HotelAlreadyExistsException.class)
	public ResponseEntity<String> handleHotelAlreadyExistsException(HotelAlreadyExistsException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CommentNotFoundException.class)
	public ResponseEntity<String> handleCommentNotFoundException(CommentNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AttachmentNotFoundException.class)
	public ResponseEntity<String> handleAttachmentNotFoundException(AttachmentNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnknownException(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
}
