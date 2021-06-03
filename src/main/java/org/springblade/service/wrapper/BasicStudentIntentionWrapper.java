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
package org.springblade.service.wrapper;

import org.springblade.core.mp.support.BaseEntityWrapper;
import org.springblade.core.tool.utils.BeanUtil;
import org.springblade.service.entity.BasicStudentIntention;
import org.springblade.service.vo.BasicStudentIntentionVO;
import java.util.Objects;

/**
 * 学生基础追踪表包装类,返回视图层所需的字段
 *
 * @author BladeX
 * @since 2021-05-13
 */
public class BasicStudentIntentionWrapper extends BaseEntityWrapper<BasicStudentIntention, BasicStudentIntentionVO>  {

	public static BasicStudentIntentionWrapper build() {
		return new BasicStudentIntentionWrapper();
 	}

	@Override
	public BasicStudentIntentionVO entityVO(BasicStudentIntention basicStudentIntention) {
		BasicStudentIntentionVO basicStudentIntentionVO = Objects.requireNonNull(BeanUtil.copy(basicStudentIntention, BasicStudentIntentionVO.class));

		//User createUser = UserCache.getUser(basicStudentIntention.getCreateUser());
		//User updateUser = UserCache.getUser(basicStudentIntention.getUpdateUser());
		//basicStudentIntentionVO.setCreateUserName(createUser.getName());
		//basicStudentIntentionVO.setUpdateUserName(updateUser.getName());

		return basicStudentIntentionVO;
	}

}
