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
package org.springblade.service.controller;

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
import org.springblade.service.entity.BasicStudentCourseService;
import org.springblade.service.vo.BasicStudentCourseServiceVO;
import org.springblade.service.wrapper.BasicStudentCourseServiceWrapper;
import org.springblade.service.service.IBasicStudentCourseServiceService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 课程学生关联表 控制器
 *
 * @author BladeX
 * @since 2021-05-13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/basicstudentcourseservice")
@Api(value = "课程学生关联表", tags = "课程学生关联表接口")
public class BasicStudentCourseServiceController extends BladeController {

	private final IBasicStudentCourseServiceService basicStudentCourseServiceService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入basicStudentCourseService")
	public R<BasicStudentCourseServiceVO> detail(BasicStudentCourseService basicStudentCourseService) {
		BasicStudentCourseService detail = basicStudentCourseServiceService.getOne(Condition.getQueryWrapper(basicStudentCourseService));
		return R.data(BasicStudentCourseServiceWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 课程学生关联表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入basicStudentCourseService")
	public R<IPage<BasicStudentCourseServiceVO>> list(BasicStudentCourseService basicStudentCourseService, Query query) {
		IPage<BasicStudentCourseService> pages = basicStudentCourseServiceService.page(Condition.getPage(query), Condition.getQueryWrapper(basicStudentCourseService));
		return R.data(BasicStudentCourseServiceWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 课程学生关联表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入basicStudentCourseService")
	public R<IPage<BasicStudentCourseServiceVO>> page(BasicStudentCourseServiceVO basicStudentCourseService, Query query) {
		IPage<BasicStudentCourseServiceVO> pages = basicStudentCourseServiceService.selectBasicStudentCourseServicePage(Condition.getPage(query), basicStudentCourseService);
		return R.data(pages);
	}

	/**
	 * 新增 课程学生关联表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入basicStudentCourseService")
	public R save(@Valid @RequestBody BasicStudentCourseService basicStudentCourseService) {
		return R.status(basicStudentCourseServiceService.save(basicStudentCourseService));
	}

	/**
	 * 修改 课程学生关联表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入basicStudentCourseService")
	public R update(@Valid @RequestBody BasicStudentCourseService basicStudentCourseService) {
		return R.status(basicStudentCourseServiceService.updateById(basicStudentCourseService));
	}

	/**
	 * 新增或修改 课程学生关联表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入basicStudentCourseService")
	public R submit(@Valid @RequestBody BasicStudentCourseService basicStudentCourseService) {
		return R.status(basicStudentCourseServiceService.saveOrUpdate(basicStudentCourseService));
	}

	
	/**
	 * 删除 课程学生关联表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(basicStudentCourseServiceService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 查询所有 课程学生关联表
	 */
	@GetMapping("/selectAll")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "查询所有")
	public R selectAll() {
		return R.data(basicStudentCourseServiceService.list());
	}

//	/**
//	 * 根据课程id查询课程业务
//	 */
//	@GetMapping("/selectCourseServiceByCourseId")
//	@ApiOperationSupport(order = 8)
//	@ApiOperation(value = "根据课程id查询课程业务")
//	public R selectCourseServiceByCourseId(String courseId) {
//		List<Course> courseServiceList=basicStudentCourseServiceService.list(
//				Wrappers.<Course>lambdaQuery().eq(BasicStudentCourseService::getCourseTableIdList,courseId)
//		);
//		return R.data(courseServiceList);
//
//	}
	
}
