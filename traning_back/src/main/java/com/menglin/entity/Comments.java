package com.menglin.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Comments {

    @Id
    private Integer id;
    private Integer book_id;
    private String nickname;
    private String comments;
    private String datetime;

}
