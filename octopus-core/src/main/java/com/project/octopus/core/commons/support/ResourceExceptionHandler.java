package com.project.octopus.core.commons.support;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class ResourceExceptionHandler {

//	private final MessageManager messages;

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseError handleValidationExceptions(MethodArgumentNotValidException ex) {
//		log.error(ex);
//
//	    Map<String, List<String>> fields = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach(e -> {
//			var key = ((FieldError) e).getField();
//			var val = messages.get(e);
//			
//			if(fields.containsKey(key))
//				fields.get(key).add(val);
//			else
//				fields.put(key, new ArrayList<>(List.of(val)));
//		});
//		
//        return ResponseError.builder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .description(messages.get("vdt.err.campo_invalido"))
//                .fields(fields)
//                .build();
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
//    public ResponseError handleConstraintViolationException(jakarta.validation.ConstraintViolationException ex) {
//		log.error(ex);
//
//	    Map<String, List<String>> fields = new HashMap<>();
//	    ex.getConstraintViolations().forEach(cv -> {
//			var key = cv.getPropertyPath() == null ? "" : cv.getPropertyPath().toString();
//			var val = cv.getMessage();
//			
//			if(fields.containsKey(key))
//				fields.get(key).add(val);
//			else
//				fields.put(key, new ArrayList<>(List.of(val)));
//		});
//		
//        return ResponseError.builder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .description(messages.get("vdt.err.campo_invalido"))
//                .fields(fields)
//                .build();
//    }
//
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ExceptionHandler({ExpiredJwtException.class, SignatureException.class, BadCredentialsException.class, MalformedJwtException.class})
//    public ResponseError handleJwtException(Exception e) {
//		log.error(e);
//		
//		var msgKey = switch (e) {
//				    case ExpiredJwtException ex -> "auth.err.expirado";
//				    case SignatureException ex -> "auth.err.token";
//				    case MalformedJwtException ex -> "auth.err.token";
//				    case BadCredentialsException ex -> "auth.err.credenciais_invalidas";
//				    default -> "auth.err.generico";
//				};
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.FORBIDDEN.value())
//                            .description(messages.get(msgKey))
//                            .build();
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler({AuthorizationDeniedException.class})
//    public ResponseError handleAccessException(AuthorizationDeniedException e) {
//		log.error(e);
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.NOT_FOUND.value())
//                            .description(messages.get("sys.err.nao_encontrado"))
//                            .build();
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseError handleDataIntegrityViolationException(DataIntegrityViolationException e) {
//		log.error(e);
//		var constEx = ExceptionUtils.throwableOfThrowable(e, ConstraintViolationException.class);
//		var constName = constEx.getConstraintName();
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.BAD_REQUEST.value())
//                            .description(messages.get("db.err.constraint", constName))
//                            .build();
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BusinessException.class)
//    public ResponseError handleBusinessException(BusinessException e) {
//		log.error(e);
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.BAD_REQUEST.value())
//                            .description(e.getMessage())
//                            .build();
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler({NoSuchElementException.class, NotFoundException.class, NoResourceFoundException.class})
//    public ResponseError handleNotFoundExceptions(Exception ex) {
//		log.error(ex);
//		
//		var msg = (ex instanceof NotFoundException nfe) 
//				? messages.get("db.alert.nao_encontrado", nfe.getEntityName(), nfe.getCode())
//				: messages.get("sys.err.nao_encontrado");
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.NOT_FOUND.value())
//                            .description(msg)
//                            .build();
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ResponseError handleException(Exception e) {
//		e.printStackTrace();
//		
//        return ResponseError.builder()
//                            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                            .description(messages.get("sys.err.inesperado"))
//                            .build();
//    }
//
//    @ExceptionHandler(ResponseStatusException.class)
//    public ResponseEntity<Object> handleValidationExceptions(ResponseStatusException ex) {
//		log.error(ex);
//        return new ResponseEntity<>(ResponseError.builder()
//                                                 .code(ex.getStatusCode().value())
//                                                 .description(ex.getMessage())
//                                                 .build(), ex.getStatusCode());
//    }

}
