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
import org.springblade.service.entity.BasicStudentService;
import org.springblade.service.vo.BasicStudentServiceVO;
import org.springblade.service.wrapper.BasicStudentServiceWrapper;
import org.springblade.service.service.IBasicStudentServiceService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 基础学生业务表 控制器
 *
 * @author BladeX
 * @since 2021-05-19
 */
@RestController
@AllArgsConstructor
@RequestMapping("/basicstudentservice")
@Api(value = "基础学生业务表", tags = "基础学生业务表接口")
public class BasicStudentServiceController extends BladeController {

	private final IBasicStudentServiceService basicStudentServiceService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入basicStudentService")
	public R<BasicStudentServiceVO> detail(BasicStudentService basicStudentService) {
		BasicStudentService detail = basicStudentServiceService.getOne(Condition.getQueryWrapper(basicStudentService));
		return R.data(BasicStudentServiceWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 基础学生业务表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入basicStudentService")
	public R<IPage<BasicStudentServiceVO>> list(BasicStudentService basicStudentService, Query query) {
		IPage<BasicStudentService> pages = basicStudentServiceService.page(Condition.getPage(query), Condition.getQueryWrapper(basicStudentService));
		return R.data(BasicStudentServiceWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 基础学生业务表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入basicStudentService")
	public R<IPage<BasicStudentServiceVO>> page(BasicStudentServiceVO basicStudentService, Query query) {
		IPage<BasicStudentServiceVO> pages = basicStudentServiceService.selectBasicStudentServicePage(Condition.getPage(query), basicStudentService);
		return R.data(pages);
	}

	/**
	 * 新增 基础学生业务表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入basicStudentService")
	public R save(@Valid @RequestBody BasicStudentService basicStudentService) {
		return R.status(basicStudentServiceService.save(basicStudentService));
	}

	/**
	 * 修改 基础学生业务表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入basicStudentService")
	public R update(@Valid @RequestBody BasicStudentService basicStudentService) {
		return R.status(basicStudentServiceService.updateById(basicStudentService));
	}

	/**
	 * 新增或修改 基础学生业务表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入basicStudentService")
	public R submit(@Valid @RequestBody BasicStudentService basicStudentService) {
		return R.status(basicStudentServiceService.saveOrUpdate(basicStudentService));
	}

	
	/**
	 * 删除 基础学生业务表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(basicStudentServiceService.deleteLogic(Func.toLongList(ids)));
	}

	
}
