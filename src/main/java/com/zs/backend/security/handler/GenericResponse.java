package com.zs.backend.security.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public abstract class GenericResponse implements RestResponse {
    private boolean isFieldsSet = false;
    private boolean isDataSet = false;
    private Map<String, Object> fields;
    private Object data;
    private int code;
    private String message;

    public GenericResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public GenericResponse appendField(String field, Object value) {
        if (!this.isFieldsSet) {
            this.isFieldsSet = true;
            this.fields = new HashMap<>();
        }

        this.fields.put(field, value);
        return this;
    }

    public GenericResponse withData(Object data) {
        if (!this.isDataSet) {
            this.isDataSet = true;
        }

        this.data = data;
        return this;
    }

    public Optional<Map<String, Object>> getFields() {
        return this.isFieldsSet ? Optional.of(this.fields) : Optional.empty();
    }

    public Optional<Object> getData() {
        return this.isDataSet ? Optional.ofNullable(this.data) : Optional.empty();
    }

    @Override
    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}