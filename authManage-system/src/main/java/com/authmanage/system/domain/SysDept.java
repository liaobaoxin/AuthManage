package com.authmanage.system.domain;

import lombok.Data;
import com.authmanage.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 部门表 sys_dept
 *
 * @author authManage
 * @date 2019-06-16
 */
@Data
@TableName("sys_dept")
public class SysDept extends BaseEntity{

    /** 部门id */
    @TableId
    private Integer deptId;

	/** 父部门id */
	private Integer parentId;

	/** 祖级列表 */
	private String ancestors;

	/** 部门名称 */
	private String deptName;

	/** 显示顺序 */
	private Integer orderNum;

	/** 负责人 */
	private String leader;

	/** 联系电话 */
	private String phone;

	/** 邮箱 */
	private String email;

	/** 部门状态（0正常 1停用） */
	private String status;

	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;



}
