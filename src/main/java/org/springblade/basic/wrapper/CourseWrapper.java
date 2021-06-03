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
package org.springblade.basic.wrapper;

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.basic.entity.Course;
import org.springblade.basic.vo.CourseVO;
import java.util.Objects;

/**
 * 基础课程表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2021-05-10
 */
public class CourseWrapper extends BaseEntityWrapper<Course, CourseVO>  {

	public static CourseWrapper build() {
		return new CourseWrapper();
 	}

	@Override
	public CourseVO entityVO(Course course) {
		CourseVO courseVO = Objects.requireNonNull(BeanUtil.copy(course, CourseVO.class));

		//User createUser = UserCache.getUser(course.getCreateUser());
		//User updateUser = UserCache.getUser(course.getUpdateUser());
		//courseVO.setCreateUserName(createUser.getName());
		//courseVO.setUpdateUserName(updateUser.getName());

		return courseVO;
	}

}
