package com.authmanage.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
* @author jie
* @date 2019-03-25
*/
@Data
public class Dept implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */

    private String name;


    private Boolean enabled;

    /**
     * 上级部门
     */

    private Long pid;


    private Set<Role> roles;


    private Timestamp createTime;


}