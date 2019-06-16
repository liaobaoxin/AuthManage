package com.authmanage.system.domain;

import lombok.Data;
import com.authmanage.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 菜单权限表 sys_menu
 *
 * @author authManage
 * @date 2019-06-16
 */
@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity{

    /** 菜单ID */
    @TableId
    private Integer menuId;

	/** 菜单名称 */
	private String menuName;

	/** 父菜单ID */
	private Integer parentId;

	/** 显示顺序 */
	private Integer orderNum;

	/** 请求地址 */
	private String url;

	/** 菜单类型（M目录 C菜单 F按钮） */
	private String menuType;

	/** 菜单状态（0显示 1隐藏） */
	private String visible;

	/** 权限标识 */
	private String perms;

	/** 菜单图标 */
	private String icon;



}
