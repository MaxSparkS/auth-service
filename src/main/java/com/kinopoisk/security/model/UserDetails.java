package com.kinopoisk.security.model;

/**
 * Created by Maksim Shkurko on 12/18/2017
 *
 * @author m.shkurko
 */
public class UserDetails {

    private String username;

    private String email;

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
