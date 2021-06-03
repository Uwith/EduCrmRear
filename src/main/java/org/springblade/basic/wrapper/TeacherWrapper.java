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
import org.springblade.basic.entity.Teacher;
import org.springblade.basic.vo.TeacherVO;
import java.util.Objects;

/**
 * 基础教师信息表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2021-05-10
 */
public class TeacherWrapper extends BaseEntityWrapper<Teacher, TeacherVO>  {

	public static TeacherWrapper build() {
		return new TeacherWrapper();
 	}

	@Override
	public TeacherVO entityVO(Teacher teacher) {
		TeacherVO teacherVO = Objects.requireNonNull(BeanUtil.copy(teacher, TeacherVO.class));

		//User createUser = UserCache.getUser(teacher.getCreateUser());
		//User updateUser = UserCache.getUser(teacher.getUpdateUser());
		//teacherVO.setCreateUserName(createUser.getName());
		//teacherVO.setUpdateUserName(updateUser.getName());

		return teacherVO;
	}

}
