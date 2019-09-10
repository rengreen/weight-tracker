package main.java.tracker.model;

import java.math.BigDecimal;

public class User {

    private Long id;
    private String name;
    private BigDecimal height;

    public User() {
    }

    public User(Long id, String name, BigDecimal height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }
}
