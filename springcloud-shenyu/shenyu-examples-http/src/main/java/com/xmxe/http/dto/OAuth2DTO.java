package com.xmxe.http.dto;

public class OAuth2DTO {

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