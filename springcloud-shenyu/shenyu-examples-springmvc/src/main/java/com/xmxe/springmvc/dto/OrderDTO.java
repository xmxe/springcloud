package com.xmxe.springmvc.dto;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * The type Order dto.
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 852118216655025857L;

    private String id;

    private String name;

    /**
     * Get id.
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Set id.
     *
     * @param id id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Get name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     *
     * @param name name
     */
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDTO.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .toString();
    }

}