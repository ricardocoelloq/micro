package logic.studio.projectmicro.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import login.studio.projectmicro.model.Response;


public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        var response = new Response();
        response.setMessage(message);
        response.setStatus(status.value());
        response.setData(responseObj);

        return new ResponseEntity<>(response,status);
    }
}