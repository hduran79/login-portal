package com.votre.login.config;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class LoginPortletValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    
    public Response toResponse(ConstraintViolationException exception) {
    	
    	List<ViolationDTO> violations = exception.getConstraintViolations().stream()
        .map(v -> {

            ViolationDTO violation = new ViolationDTO();
            violation.setValue((v.getInvalidValue() != null ? v.getInvalidValue().toString() : "(null)"));
            violation.setMessage(v.getMessage());
            violation.setCode(v.getClass().getSimpleName());

            return violation;
        })
        .collect(Collectors.toList());
            	    	
        return Response.status(Status.BAD_REQUEST).entity(violations).build();
    }
}
