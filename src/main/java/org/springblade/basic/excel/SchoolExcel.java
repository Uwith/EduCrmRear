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
package org.springblade.basic.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * SchoolExcel
 *
 * @author Chill
 */
@Data
@ColumnWidth(25)
@HeadRowHeight(20)
@ContentRowHeight(18)

public class SchoolExcel implements Serializable {
	private static final long serialVersionUID = 1L;

	@ColumnWidth(20)
	@ExcelProperty("学校名")
	private String nameSchool;

	@ColumnWidth(20)
	@ExcelProperty("联系方式")
	private String contactSchool;

	@NotNull
	@ColumnWidth(20)
	@ExcelProperty("学校地址")
	private String addressSchool;

	@ColumnWidth(50)
	@ExcelProperty("简介")
	private String introduceSchool;

	@ExcelProperty("备注")
	private String remarkSchool;


}
