package com.learn.datajpa.cassandra.exception;

import com.learn.datajpa.cassandra.constant.ApiErrorCode;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.stream.Collectors;

/****************************************************************************************************
 * Date: 5/1/22 9:19 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 * Description: This exception class is used to handler invalid request. Such as when user pass null
 * value for mandatory fields.
 *
 *****************************************************************************************************/

@Provider
public class AppBadRequestException extends Throwable implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(this.prepareMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    private ApiError prepareMessage(ConstraintViolationException exception) {
        final Map<String, String> errorMsgMap = exception.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(value -> value.getPropertyPath().toString(), ConstraintViolation::getMessage));

       return new ApiError()
               .setHttpStatus(Response.Status.BAD_REQUEST.getStatusCode())
               .setCode(ApiErrorCode.BAD_REQUEST.getApiErrorCode())
               .setMessage(exception.getMessage())
               .setDeveloperMessage(errorMsgMap);
    }

}
