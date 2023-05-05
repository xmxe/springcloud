package com.xmxe.springmvc.dto;

/**
 * The type OAuth Authorization dto
 */
public class OAuth2DTO {

    /**
     * oauth token
     */
    private String token;

    /**
     * Get token.
     *
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * Set token.
     *
     * @param token token
     */
    public void setToken(final String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "OAuth2DTO{" + "token='" + token + '\'' + '}';
    }

}