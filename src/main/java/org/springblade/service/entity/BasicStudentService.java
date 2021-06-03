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
package org.springblade.service.entity;

import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础学生业务表实体类
 *
 * @author BladeX
 * @since 2021-05-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "BasicStudentService对象", description = "基础学生业务表")
public class BasicStudentService extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 学生id
	*/
		@ApiModelProperty(value = "学生id")
		private Long studentIdStu;
	/**
	* 教师id
	*/
		@ApiModelProperty(value = "教师id")
		private Long teacherIdStu;
	/**
	* 学校id
	*/
		@ApiModelProperty(value = "学校id")
		private Long schoolIdStu;
	/**
	* 来源
	*/
		@ApiModelProperty(value = "来源")
		private String sourceStu;
	/**
	* 意向
	*/
		@ApiModelProperty(value = "意向")
		private String intentionStu;
	/**
	* 意向课程
	*/
		@ApiModelProperty(value = "意向课程")
		private String intentionCourseStu;
	/**
	* 课包id
	*/
		@ApiModelProperty(value = "课包id")
		private Long packIdStu;


}
