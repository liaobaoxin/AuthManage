package com.authmanage.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-17
 */
@Data
public class Menu implements Serializable {


    private Long id;


    private String name;


    private Long sort;


    private String path;

    private String component;

    private String icon;

    /**
     * 上级菜单ID
     */

    private Long pid;

    /**
     * 是否为外链 true/false
     */

    private Boolean iFrame;


    private Set<Role> roles;

    private Timestamp createTime;

    public interface Update{}
}
