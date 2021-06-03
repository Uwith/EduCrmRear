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
package org.springblade.basic.service.impl;

import org.springblade.basic.entity.Teacher;
import org.springblade.basic.vo.TeacherVO;
import org.springblade.basic.mapper.TeacherMapper;
import org.springblade.basic.service.ITeacherService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 基础教师信息表 服务实现类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

	@Override
	public IPage<TeacherVO> selectTeacherPage(IPage<TeacherVO> page, TeacherVO teacher) {
		return page.setRecords(baseMapper.selectTeacherPage(page, teacher));
	}

}
