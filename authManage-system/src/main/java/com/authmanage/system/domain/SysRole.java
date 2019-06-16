package com.authmanage.system.domain;

import lombok.Data;
import com.authmanage.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 角色表 sys_role
 *
 * @author authManage
 * @date 2019-06-16
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity{

    /** 角色ID */
    @TableId
    private Integer roleId;

	/** 角色名称 */
	private String roleName;

	/** 角色权限字符串 */
	private String roleKey;

	/** 显示顺序 */
	private Integer roleSort;

	/** 数据范围（1：全部数据权限 2：自定数据权限） */
	private String dataScope;

	/** 角色状态（0正常 1停用） */
	private String status;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;



}
