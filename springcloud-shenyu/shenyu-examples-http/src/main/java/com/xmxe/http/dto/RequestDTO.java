package com.xmxe.http.dto;

import java.util.StringJoiner;

/**
 * The type Request dto.
 */
public class RequestDTO {

    private String module;

    private String method;

    private String content;

    private String extInfo;

    public RequestDTO() {
    }

    public RequestDTO(final String module, final String method, final String content, final String extInfo) {
        this.module = module;
        this.method = method;
        this.content = content;
        this.extInfo = extInfo;
    }

    /**
     * Get module.
     *
     * @return module
     */
    public String getModule() {
        return module;
    }

    /**
     * Set module.
     *
     * @param module module
     */
    public void setModule(final String module) {
        this.module = module;
    }

    /**
     * Get method.
     *
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Set method.
     *
     * @param method method
     */
    public void setMethod(final String method) {
        this.method = method;
    }

    /**
     * Get content.
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content.
     *
     * @param content content
     */
    public void setContent(final String content) {
        this.content = content;
    }

    /**
     * Get extInfo.
     *
     * @return extInfo
     */
    public String getExtInfo() {
        return extInfo;
    }

    /**
     * Set extInfo.
     *
     * @param extInfo extInfo
     */
    public void setExtInfo(final String extInfo) {
        this.extInfo = extInfo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RequestDTO.class.getSimpleName() + "[", "]")
                .add("module='" + module + "'")
                .add("method='" + method + "'")
                .add("content='" + content + "'")
                .add("extInfo='" + extInfo + "'")
                .toString();
    }

}