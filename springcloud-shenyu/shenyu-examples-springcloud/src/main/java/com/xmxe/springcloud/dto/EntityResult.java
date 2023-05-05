package com.xmxe.springcloud.dto;

/**
 * EntityResult.
 */
public class EntityResult {

    /**
     * code.
     */
    private int code;

    /**
     * message.
     */
    private String message;

    public EntityResult(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * getCode.
     *
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * setCode.
     *
     * @param code code
     */
    public void setCode(final int code) {
        this.code = code;
    }

    /**
     * getMessage.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * setMessage.
     *
     * @param message message
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}