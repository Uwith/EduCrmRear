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
package org.springblade.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.basic.entity.Teacher;
import org.springblade.basic.vo.TeacherVO;
import org.springblade.basic.wrapper.TeacherWrapper;
import org.springblade.basic.service.ITeacherService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 基础教师信息表 控制器
 *
 * @author BladeX
 * @since 2021-05-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/teacher")
@Api(value = "基础教师信息表", tags = "基础教师信息表接口")
public class TeacherController extends BladeController {

	private final ITeacherService teacherService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入teacher")
	public R<TeacherVO> detail(Teacher teacher) {
		Teacher detail = teacherService.getOne(Condition.getQueryWrapper(teacher));
		return R.data(TeacherWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 基础教师信息表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入teacher")
	public R<IPage<TeacherVO>> list(Teacher teacher, Query query) {
		IPage<Teacher> pages = teacherService.page(Condition.getPage(query), Condition.getQueryWrapper(teacher));
		return R.data(TeacherWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 基础教师信息表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入teacher")
	public R<IPage<TeacherVO>> page(TeacherVO teacher, Query query) {
		IPage<TeacherVO> pages = teacherService.selectTeacherPage(Condition.getPage(query), teacher);
		return R.data(pages);
	}

	/**
	 * 新增 基础教师信息表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入teacher")
	public R save(@Valid @RequestBody Teacher teacher) {
		return R.status(teacherService.save(teacher));
	}

	/**
	 * 修改 基础教师信息表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入teacher")
	public R update(@Valid @RequestBody Teacher teacher) {
		return R.status(teacherService.updateById(teacher));
	}

	/**
	 * 新增或修改 基础教师信息表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入teacher")
	public R submit(@Valid @RequestBody Teacher teacher) {
		return R.status(teacherService.saveOrUpdate(teacher));
	}

	
	/**
	 * 删除 基础教师信息表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(teacherService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 查询所有 基础教师信息表
	 */
	@GetMapping("/selectAll")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "查询所有教师")
	public R selectAll() {
		return R.data(teacherService.list());
	}

	/**
	 * 根据学校id查询老师
	 */
	@GetMapping("/selectTeacherBySchoolId")
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "根据学校id查询老师")
	public R selectTeacherBySchoolId(String schoolId) {
		List<Teacher> teacherList=teacherService.list(Wrappers.<Teacher>lambdaQuery().eq(Teacher::getSchoolIdTeacher,schoolId));
		return R.data(teacherList);

	}
}
