package com.happy.base;

/**
 * @Author: Administrator
 * @CreateDate: 21:41 2018/7/28
 */
public class ApiResponse<T> {

    private int code;

    private String message;

    private T data;

    private boolean more;

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public static <T> ApiResponse ofMessage(int code,String message){
        return new ApiResponse<T>(code,message,null);
    }

    public static <T> ApiResponse ofSuccess(T data){
        return new ApiResponse<T>(Status.SUCCESS.getCode(),Status.SUCCESS.getStandardMessage(),data);
    }

    public static <T> ApiResponse ofStatus(Status status){
        return new ApiResponse<T>(status.getCode(),status.getStandardMessage(),null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public enum Status{

        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        INTERNAL_SERVER_ERROR(500,"Unkonw Internal Error"),
        NOT_VALID_PARAM(40005,"Not Valid Params"),
        NOT_SUPPORTED_OPERATION(40006,"Operation not Supported"),
        NOT_LOGIN(50000,"Not Login");

        private int code;

        private String standardMessage;

        Status(int code, String standardMessage) {
            this.code = code;
            this.standardMessage = standardMessage;
        }

        public int getCode() {
            return code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }
    }





}
