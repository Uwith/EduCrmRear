/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package org.springblade.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础学校表实体类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Data
@TableName("basic_school")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "School对象", description = "基础学校表")
public class School extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 学校名
	*/
		@ApiModelProperty(value = "学校名")
		private String nameSchool;
	/**
	* 联系方式
	*/
		@ApiModelProperty(value = "联系方式")
		private String contactSchool;
	/**
	* 学校地址
	*/
		@ApiModelProperty(value = "学校地址")
		private String addressSchool;
	/**
	* 简介
	*/
		@ApiModelProperty(value = "简介")
		private String introduceSchool;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String remarkSchool;


}
