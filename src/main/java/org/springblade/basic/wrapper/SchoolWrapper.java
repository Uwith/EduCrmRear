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
import org.springblade.basic.entity.School;
import org.springblade.basic.vo.SchoolVO;
import java.util.Objects;

/**
 * 基础学校表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2021-05-10
 */
public class SchoolWrapper extends BaseEntityWrapper<School, SchoolVO>  {

	public static SchoolWrapper build() {
		return new SchoolWrapper();
 	}

	@Override
	public SchoolVO entityVO(School school) {
		SchoolVO schoolVO = Objects.requireNonNull(BeanUtil.copy(school, SchoolVO.class));

		//User createUser = UserCache.getUser(school.getCreateUser());
		//User updateUser = UserCache.getUser(school.getUpdateUser());
		//schoolVO.setCreateUserName(createUser.getName());
		//schoolVO.setUpdateUserName(updateUser.getName());

		return schoolVO;
	}

}
