package com.authmanage.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 角色
 * @author jie
 * @date 2018-11-22
 */
@Data
public class Role implements Serializable {


    private Long id;


    private String name;

    // 数据权限类型 全部 、 本级 、 自定义

    private String dataScope = "本级";

    // 数值越小，级别越大

    private Integer level = 3;


    private String remark;


    private Set<User> users;


    private Set<Permission> permissions;


    private Set<Menu> menus;


    private Set<Dept> depts;


    private Timestamp createTime;


}
