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

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springblade.basic.excel.SchoolExcel;
import org.springblade.basic.excel.SchoolImporter;
import org.springblade.core.excel.util.ExcelUtil;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.modules.system.excel.UserExcel;
import org.springblade.modules.system.excel.UserImporter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.basic.entity.School;
import org.springblade.basic.vo.SchoolVO;
import org.springblade.basic.wrapper.SchoolWrapper;
import org.springblade.basic.service.ISchoolService;
import org.springblade.core.boot.ctrl.BladeController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础学校表 控制器
 *
 * @author BladeX
 * @since 2021-05-10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/school")
@Api(value = "基础学校表", tags = "基础学校表接口")
public class SchoolController extends BladeController {

	private final ISchoolService schoolService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入school")
	public R<SchoolVO> detail(School school) {
		School detail = schoolService.getOne(Condition.getQueryWrapper(school));
		return R.data(SchoolWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 基础学校表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入school")
	public R<IPage<SchoolVO>> list(School school, Query query) {
		IPage<School> pages = schoolService.page(Condition.getPage(query), Condition.getQueryWrapper(school));
		return R.data(SchoolWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 基础学校表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入school")
	public R<IPage<SchoolVO>> page(SchoolVO school, Query query) {
		IPage<SchoolVO> pages = schoolService.selectSchoolPage(Condition.getPage(query), school);
		return R.data(pages);
	}

	/**
	 * 新增 基础学校表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入school")
	public R save(@Valid @RequestBody School school) {
		return R.status(schoolService.save(school));
	}

	/**
	 * 修改 基础学校表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入school")
	public R update(@Valid @RequestBody School school) {
		return R.status(schoolService.updateById(school));
	}

	/**
	 * 新增或修改 基础学校表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入school")
	public R submit(@Valid @RequestBody School school) {
		return R.status(schoolService.saveOrUpdate(school));
	}

	
	/**
	 * 删除 基础学校表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(schoolService.deleteLogic(Func.toLongList(ids)));
	}

	/**
	 * 真实删除 基础学校表
	 */
	@PostMapping("/deleteByIdzs")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "真实删除", notes = "传入id")
	public R deleteByIdzs(@ApiParam(value = "主键集合", required = true) @RequestParam String id) {

		boolean bool = schoolService.deleteByIdzs(id);

		if (bool){
			return R.success("删除成功");
		}else {
			return R.fail("删除失败");
		}

	}

	/**
	 * 查询所有 基础学校表
	 */
	@GetMapping("/selectAll")
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "查询所有学校")
	public R selectAll() {
		return R.data(schoolService.list());
	}

	/**
	 * 导入学校
	 */
	@PostMapping("/import-school")
	@ApiOperationSupport(order = 10)
	@ApiOperation(value = "导入学校", notes = "传入excel")
	public R importSchool(MultipartFile file, Integer isCovered) {
		SchoolImporter schoolImporter = new SchoolImporter(schoolService, isCovered == 1);
		ExcelUtil.save(file, schoolImporter, SchoolExcel.class);
		return R.success("操作成功");
	}

	/**
	 * 导出模板
	 */
	@GetMapping("/export-template")
	@ApiOperationSupport(order = 11)
	@ApiOperation(value = "导出模板")
	public void exportSchool(HttpServletResponse response) {
		List<SchoolExcel> list = new ArrayList<>();
		ExcelUtil.export(response, "用户数据模板", "用户数据表", list, SchoolExcel.class);
	}

}
