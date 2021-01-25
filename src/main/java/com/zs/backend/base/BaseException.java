package com.zs.backend.base;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -4271274584614989089L;
    protected String[] i18nMsg;
    protected String businessCode;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message, Throwable cause, String businessCode, String... i18nMsg) {
        super(message, cause);
        this.businessCode = businessCode;
        this.i18nMsg = i18nMsg;
    }

    public static BaseException createMessages(String message, String... i18nMsg) {
        BaseException exception = new BaseException(message);
        exception.setI18nMsg(i18nMsg);
        return exception;
    }

    public static BaseException createBusinessCode(String businessCode) {
        BaseException exception = new BaseException();
        exception.setBusinessCode(businessCode);
        return exception;
    }

    public static BaseException createBusinessCode(String businessCode, String message) {
        BaseException exception = new BaseException(message);
        exception.setBusinessCode(businessCode);
        return exception;
    }

    public String[] getI18nMsg() {
        return this.i18nMsg;
    }

    public void setI18nMsg(String... i18nMsg) {
        this.i18nMsg = i18nMsg;
    }

    public String getBusinessCode() {
        return this.businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }
}
