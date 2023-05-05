package com.xmxe.http.dto;

import java.util.StringJoiner;

/**
 * The type User dto.
 */
public class UserDTO {

    private String userId;

    private String userName;

    /**
     * Get userId.
     *
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Set userId.
     *
     * @param userId userId
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Get userName.
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set userName.
     *
     * @param userName userName
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDTO.class.getSimpleName() + "[", "]")
                .add("userId='" + userId + "'")
                .add("userName='" + userName + "'")
                .toString();
    }

}