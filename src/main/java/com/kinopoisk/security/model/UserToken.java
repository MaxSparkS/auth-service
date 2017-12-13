package com.kinopoisk.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Maksim Shkurko on 12/13/2017
 *
 * @author m.shkurko
 */
@Entity
@Table(name = "tokens")
public class UserToken {

    @Id
    @Column(name = "UserId")
    private long id;

    @Column(name = "Token")
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
