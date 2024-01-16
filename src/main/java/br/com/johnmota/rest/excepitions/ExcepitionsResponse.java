package br.com.johnmota.rest.excepitions;

import java.io.Serializable;
import java.util.Date;

public class ExcepitionsResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

    public ExcepitionsResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
