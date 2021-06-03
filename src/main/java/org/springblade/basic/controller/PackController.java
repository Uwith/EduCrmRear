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
import org.springblade.basic.entity.Pack;
import org.springblade.basic.vo.PackVO;
import org.springblade.basic.wrapper.PackWrapper;
import org.springblade.basic.service.IPackService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 基础课包信息 控制器
 *
 * @author BladeX
 * @since 2021-05-11
 */
@RestController
@AllArgsConstructor
@RequestMapping("/pack")
@Api(value = "基础课包信息", tags = "基础课包信息接口")
public class PackController extends BladeController {

	private final IPackService packService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入pack")
	public R<PackVO> detail(Pack pack) {
		Pack detail = packService.getOne(Condition.getQueryWrapper(pack));
		return R.data(PackWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 基础课包信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入pack")
	public R<IPage<PackVO>> list(Pack pack, Query query) {
		IPage<Pack> pages = packService.page(Condition.getPage(query), Condition.getQueryWrapper(pack));
		return R.data(PackWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 基础课包信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入pack")
	public R<IPage<PackVO>> page(PackVO pack, Query query) {
		IPage<PackVO> pages = packService.selectPackPage(Condition.getPage(query), pack);
		return R.data(pages);
	}

	/**
	 * 新增 基础课包信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入pack")
	public R save(@Valid @RequestBody Pack pack) {
		return R.status(packService.save(pack));
	}

	/**
	 * 修改 基础课包信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入pack")
	public R update(@Valid @RequestBody Pack pack) {
		return R.status(packService.updateById(pack));
	}

	/**
	 * 新增或修改 基础课包信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入pack")
	public R submit(@Valid @RequestBody Pack pack) {
		return R.status(packService.saveOrUpdate(pack));
	}

	
	/**
	 * 删除 基础课包信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(packService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 查询所有 基础课包
	 */
	@GetMapping("/selectAll")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "查询所有课包")
	public R selectAll() {
		return R.data(packService.list());
	}


	
}
