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

import org.springblade.basic.entity.Course;
import org.springblade.basic.vo.CourseVO;
import org.springblade.basic.mapper.CourseMapper;
import org.springblade.basic.service.ICourseService;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 基础课程表 服务实现类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Service
public class CourseServiceImpl extends BaseServiceImpl<CourseMapper, Course> implements ICourseService {

	@Override
	public IPage<CourseVO> selectCoursePage(IPage<CourseVO> page, CourseVO course) {
		return page.setRecords(baseMapper.selectCoursePage(page, course));
	}

}
