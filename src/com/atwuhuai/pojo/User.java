package com.atwuhuai.pojo;

/**
 * 此类为User表的bean类
 */
public class User {
    private Integer id;
    private String username;
    private  String password;
    private  String email;
    private  String level;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", level=" + level +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User(Integer id, String username, String password, String email, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.level = level;
    }
}
