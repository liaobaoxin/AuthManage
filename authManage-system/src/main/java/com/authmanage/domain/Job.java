package com.authmanage.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author jie
* @date 2019-03-29
*/
@Data
public class Job implements Serializable {

    /**
     * ID
     */

    private Long id;

    /**
     * 名称
     */

    private String name;


    private Long sort;

    /**
     * 状态
     */

    private Boolean enabled;


    private Dept dept;

    /**
     * 创建日期
     */

    private Timestamp createTime;


}