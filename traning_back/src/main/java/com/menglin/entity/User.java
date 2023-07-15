package com.menglin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private Integer power;
    private String lasttime;
    public User() {
    }

    public User(Integer id, String nickname, String username, Integer power, String lasttime) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.power = power;
        this.lasttime = lasttime;
    }

    public User(Integer id, String nickname, String username, String password, Integer power, String lasttime) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.power = power;
        this.lasttime = lasttime;
    }
}
