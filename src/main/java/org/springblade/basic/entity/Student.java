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
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础学生表实体类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Data
@TableName("basic_student")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Student对象", description = "基础学生表")
public class Student extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 学生姓名
	*/
		@ApiModelProperty(value = "学生姓名")
		private String nameStu;
	/**
	* 学生性别
	*/
		@ApiModelProperty(value = "学生性别")
		private Integer sexStu;
	/**
	* 学生联系方式
	*/
		@ApiModelProperty(value = "学生联系方式")
		private String contactStu;
	/**
	* 学生出生日期
	*/
		@ApiModelProperty(value = "学生出生日期")
		private LocalDate birthStu;
	/**
	* 学生省份
	*/
		@ApiModelProperty(value = "学生省份")
		private String provinceStu;
	/**
	* 学生城市
	*/
		@ApiModelProperty(value = "学生城市")
		private String cityStu;
	/**
	* 学生地区
	*/
		@ApiModelProperty(value = "学生地区")
		private String districtStu;
	/**
	* 学生详细地址
	*/
		@ApiModelProperty(value = "学生详细地址")
		private String detailAddressStu;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String remarkStu;


}
