package com.xmxe.springmvc.result;

/**
 * ResultBean.
 */
public class ResultBean {

    /**
     * code describe status
     */
    private Integer code;

    /**
     * msg describe result
     */
    private String msg;

    /**
     * result data
     */
    private Object data;

    public ResultBean() {
    }

    public ResultBean(final Integer code, final String msg, final Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * Get code.
     *
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * Set code.
     *
     * @param code code
     */
    public void setCode(final Integer code) {
        this.code = code;
    }

    /**
     * Get msg.
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Set msg.
     *
     * @param msg msg
     */
    public void setMsg(final String msg) {
        this.msg = msg;
    }

    /**
     * Get data.
     *
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * Set data.
     *
     * @param data data
     */
    public void setData(final Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }

}