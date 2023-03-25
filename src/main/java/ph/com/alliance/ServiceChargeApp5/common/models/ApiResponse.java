package ph.com.alliance.ServiceChargeApp5.common.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ApiResponse {
	
    private enum Status {
        SUCCESS, ERROR
    }
    
	public Object data;
    public Status status;
    public String message;
    public int code;
    public String stackTrace;
    public List<String> messageList;

    
    public ApiResponse(Status status, Object model) {
        this.status = status;
        this.data = model;
    }
    
    public ApiResponse(Status status, Object model, String message) {
        this.status = status;
        this.data = model;
        this.message = message;
    }
    
    public ApiResponse(Status status, List<String> strMessage) {
        this.status = status;
        this.messageList = strMessage;
    }
    
    public static ApiResponse CreateSuccess(Object model) {
        return new ApiResponse(Status.SUCCESS, model);
    }
    
    /**
     * Response Entity
     * @param model - the object to be returned
     * @param message - message
     * @return
     */
    public static ApiResponse CreateSuccess(Object model, String message) {
        return new ApiResponse(Status.SUCCESS, model, message);
    }
    
    public static ApiResponse CreateError(String... strMessage) {
        return new ApiResponse(Status.ERROR, strMessage);
    }
    
    /**
     * Response Entity
     * @param model - the object to be returned
     * @param message - message
     * @return
     */
    public static ApiResponse CreateError(Object model, String message) {
        return new ApiResponse(Status.ERROR, model, message);
    }
}
