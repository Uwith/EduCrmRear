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
package org.springblade.basic.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springblade.basic.entity.School;
import org.springblade.basic.excel.SchoolExcel;
import org.springblade.basic.vo.SchoolVO;
import org.springblade.core.mp.base.BaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;

/**
 * 基础学校表 服务类
 *
 * @author BladeX
 * @since 2021-05-10
 */
public interface ISchoolService extends BaseService<School> {

	/**
	 * 自定义分页
	 *
	 * @param page
	 * @param school
	 * @return
	 */
	IPage<SchoolVO> selectSchoolPage(IPage<SchoolVO> page, SchoolVO school);

	/**
	 * 真实删除 基础学校表
	 */
	boolean deleteByIdzs(String id);

	/**
	 * 导入用户数据
	 *
	 * @param data
	 * @param isCovered
	 * @return
	 */
	void importSchool(List<SchoolExcel> data, Boolean isCovered);

}
