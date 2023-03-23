package com.votre.login.config;

import java.io.Serializable;

public class ViolationDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String value;
    private String message;
    private String code;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ViolationDTO [value=" + value + ", message=" + message + ", code=" + code + "]";
    }
}
