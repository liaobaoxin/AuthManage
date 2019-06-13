package com.authmanage.domain;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-03
 */
@Data
public class Permission implements Serializable{


	private Long id;


	private String name;

	/**
	 * 上级类目
	 */

	private Long pid;


	private String alias;


	private Set<Role> roles;


	private Timestamp createTime;


}
