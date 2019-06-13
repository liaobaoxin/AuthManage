package com.authmanage.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * @date 2019/6/11 11:12
 */
@Data
public class User {


    private Long id;


    private String username;

    private String avatar;


    private String email;


    private String phone;


    private Boolean enabled;

    private String password;


    private Timestamp createTime;


    private Date lastPasswordResetTime;


    private Set<Role> roles;


    private Job job;


    private Dept dept;
}
