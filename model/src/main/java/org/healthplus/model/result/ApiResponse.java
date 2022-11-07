package org.healthplus.model.result;

import lombok.Getter;

@Getter
public final class ApiResponse<T> {

    private final boolean success;
    private final T body;
    private final Error error;

    /*
    * Api response constructor
    * */
    public ApiResponse(boolean success, T body, Error error) {
        this.success = success;
        this.body = body;
        this.error = error;
    }

    /*
    * Success Response form
    * */
    public static <T> ApiResponse success(T data) {
        return new ApiResponse(true, data, null);
    }

    /*
    * Fail Response form
    * */
    public static <T> ApiResponse fail(String code, String message) {
        return new ApiResponse(false, null, new Error(code, message));
    }

    /*
    * Error nested class
    * */
    @Getter
    public static class Error {

        private final String code;
        private final String message;

        public Error(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
