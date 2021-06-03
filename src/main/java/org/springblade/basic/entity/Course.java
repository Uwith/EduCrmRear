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
 * 基础课程表实体类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Data
@TableName("basic_course")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Course对象", description = "基础课程表")
public class Course extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 课程名
	*/
		@ApiModelProperty(value = "课程名")
		private String nameCourse;
	/**
	* 所属学校
	*/
		@ApiModelProperty(value = "所属学校")
		private Long schoolIdCourse;
	/**
	* 任课教师
	*/
		@ApiModelProperty(value = "任课教师")
		private Long teacherIdCourse;
	/**
	* 简介
	*/
		@ApiModelProperty(value = "简介")
		private String introduceCourse;
	/**
	* 备注
	*/
		@ApiModelProperty(value = "备注")
		private String remarkCourse;


}
