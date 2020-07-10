package org.vite.gateway.blockchain.transport.rest;

public class RestResponse<T> {

    private Object id;
    private Error error;
    private T result;

    public RestResponse() {
    }

    public RestResponse(Object id, Error error, T result ) {
        this.id = id;
        this.error = error;
        this.result = result;
    }

    public Object getId() {
        return id;
    }

    public void setId( Object id ) {
        this.id = id;
    }

    public Error getError() {
        return error;
    }

    public void setError( Error error ) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult( T result ) {
        this.result = result;
    }

    public static class Error {
        private Integer code;
        private String message;

        public Error() {
        }

        public Error( Integer code, String message ) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode( Integer code ) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage( String message ) {
            this.message = message;
        }
    }
}
