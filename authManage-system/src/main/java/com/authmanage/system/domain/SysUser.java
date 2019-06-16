package com.authmanage.system.domain;

import lombok.Data;
import com.authmanage.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户表 sys_user
 *
 * @author authManage
 * @date 2019-06-16
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity{

    /** 用户ID */
    @TableId
    private Integer userId;

	/** 部门ID */
	private Integer deptId;

	/** 登录账号 */
	private String loginName;

	/** 用户昵称 */
	private String userName;

	/** 用户类型（00系统用户） */
	private String userType;

	/** 用户邮箱 */
	private String email;

	/** 手机号码 */
	private String phoneNumber;

	/** 用户性别（0男 1女 2未知） */
	private String sex;

	/** 头像路径 */
	private String avatar;

	/** 密码 */
	private String password;

	/** 盐加密 */
	private String salt;

	/** 帐号状态（0正常 1停用） */
	private String status;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	/** 最后登陆IP */
	private String loginIp;

	/** 最后登陆时间 */
	private LocalDateTime loginDate;

	/**角色**/
	private List<SysRole> roles;

	/**部门**/
	private SysDept dept;

	/**
	 * 菜单
	 */
	private List<SysMenu> menus;



}
