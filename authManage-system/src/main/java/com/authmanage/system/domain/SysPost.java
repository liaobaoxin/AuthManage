package com.authmanage.system.domain;

import lombok.Data;
import com.authmanage.common.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 岗位表 sys_post
 *
 * @author authManage
 * @date 2019-06-16
 */
@Data
@TableName("sys_post")
public class SysPost extends BaseEntity{

    /** 岗位ID */
    @TableId
    private Integer postId;

	/** 岗位编码 */
	private String postCode;

	/** 岗位名称 */
	private String postName;

	/** 显示顺序 */
	private Integer postSort;

	/** 状态（0正常 1停用） */
	private String status;



}
