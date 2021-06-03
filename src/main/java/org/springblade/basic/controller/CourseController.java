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

import org.springblade.basic.entity.Teacher;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.basic.entity.Course;
import org.springblade.basic.vo.CourseVO;
import org.springblade.basic.wrapper.CourseWrapper;
import org.springblade.basic.service.ICourseService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 基础课程表 控制器
 *
 * @author BladeX
 * @since 2021-05-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/course")
@Api(value = "基础课程表", tags = "基础课程表接口")
public class CourseController extends BladeController {

	private final ICourseService courseService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入course")
	public R<CourseVO> detail(Course course) {
		Course detail = courseService.getOne(Condition.getQueryWrapper(course));
		return R.data(CourseWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 基础课程表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入course")
	public R<IPage<CourseVO>> list(Course course, Query query) {
		IPage<Course> pages = courseService.page(Condition.getPage(query), Condition.getQueryWrapper(course));
		return R.data(CourseWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 基础课程表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入course")
	public R<IPage<CourseVO>> page(CourseVO course, Query query) {
		IPage<CourseVO> pages = courseService.selectCoursePage(Condition.getPage(query), course);
		return R.data(pages);
	}

	/**
	 * 新增 基础课程表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入course")
	public R save(@Valid @RequestBody Course course) {
		return R.status(courseService.save(course));
	}

	/**
	 * 修改 基础课程表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入course")
	public R update(@Valid @RequestBody Course course) {
		return R.status(courseService.updateById(course));
	}

	/**
	 * 新增或修改 基础课程表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入course")
	public R submit(@Valid @RequestBody Course course) {
		return R.status(courseService.saveOrUpdate(course));
	}

	
	/**
	 * 删除 基础课程表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(courseService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 查询 基础课程表
	 */
	@GetMapping("/selectAll")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "查询所有课程")
	public R selectAll() {
		return R.data(courseService.list());
	}
	//todo

	/**
	 * 根据老师id查询课程
	 */
	@GetMapping("/selectCourseByTeacherId")
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "根据老师id查询课程")
	public R selectCourseByTeacherId(String teacherId) {
		List<Course> teacherList=courseService.list(Wrappers.<Course>lambdaQuery().eq(Course::getTeacherIdCourse,teacherId));
		return R.data(teacherList);
	}
}
