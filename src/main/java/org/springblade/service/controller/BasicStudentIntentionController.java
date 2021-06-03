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
import org.springblade.service.entity.BasicStudentIntention;
import org.springblade.service.vo.BasicStudentIntentionVO;
import org.springblade.service.wrapper.BasicStudentIntentionWrapper;
import org.springblade.service.service.IBasicStudentIntentionService;
import org.springblade.core.boot.ctrl.BladeController;

import java.util.List;

/**
 * 学生基础追踪表 控制器
 *
 * @author BladeX
 * @since 2021-05-13
 */
@RestController
@AllArgsConstructor
@RequestMapping("/basicstudentintention")
@Api(value = "学生基础追踪表", tags = "学生基础追踪表接口")
public class BasicStudentIntentionController extends BladeController {

	private final IBasicStudentIntentionService basicStudentIntentionService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入basicStudentIntention")
	public R<BasicStudentIntentionVO> detail(BasicStudentIntention basicStudentIntention) {
		BasicStudentIntention detail = basicStudentIntentionService.getOne(Condition.getQueryWrapper(basicStudentIntention));
		return R.data(BasicStudentIntentionWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 学生基础追踪表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入basicStudentIntention")
	public R<IPage<BasicStudentIntentionVO>> list(BasicStudentIntention basicStudentIntention, Query query) {
		IPage<BasicStudentIntention> pages = basicStudentIntentionService.page(Condition.getPage(query), Condition.getQueryWrapper(basicStudentIntention));
		return R.data(BasicStudentIntentionWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 学生基础追踪表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入basicStudentIntention")
	public R<IPage<BasicStudentIntentionVO>> page(BasicStudentIntentionVO basicStudentIntention, Query query) {
		IPage<BasicStudentIntentionVO> pages = basicStudentIntentionService.selectBasicStudentIntentionPage(Condition.getPage(query), basicStudentIntention);
		return R.data(pages);
	}

	/**
	 * 新增 学生基础追踪表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入basicStudentIntention")
	public R save(@Valid @RequestBody BasicStudentIntention basicStudentIntention) {
		return R.status(basicStudentIntentionService.save(basicStudentIntention));
	}

	/**
	 * 修改 学生基础追踪表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入basicStudentIntention")
	public R update(@Valid @RequestBody BasicStudentIntention basicStudentIntention) {
		return R.status(basicStudentIntentionService.updateById(basicStudentIntention));
	}


	/**
	 * 新增或修改 学生基础追踪表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入basicStudentIntention")
	public R submit(@Valid @RequestBody BasicStudentIntention basicStudentIntention) {
		return R.status(basicStudentIntentionService.saveOrUpdate(basicStudentIntention));
	}

	
	/**
	 * 删除 学生基础追踪表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(basicStudentIntentionService.deleteLogic(Func.toLongList(ids)));
	}


	/**
	 * 时间轴
	 */
	@GetMapping("/timeLine")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "时间线")
	public R<List> timeLine(String id){
		List<BasicStudentIntention> studentIntentionList = basicStudentIntentionService.list(Wrappers.<BasicStudentIntention>lambdaQuery().eq(BasicStudentIntention::getStudentServiceId, id));
		return R.data(studentIntentionList);
	}

}


