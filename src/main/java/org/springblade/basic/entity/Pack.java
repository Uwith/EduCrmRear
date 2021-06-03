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
package org.springblade.basic.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础课包信息实体类
 *
 * @author BladeX
 * @since 2021-05-11
 */
@Data
@TableName("basic_pack")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Pack对象", description = "基础课包信息")
public class Pack extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	* 包含课程
	*/
		@ApiModelProperty(value = "包含课程")
		private Long coursePack;
	/**
	* 包含教师
	*/
		@ApiModelProperty(value = "包含教师")
		private Long teacherPack;
	/**
	* 所属学校
	*/
		@ApiModelProperty(value = "所属学校")
		private Long schoolPack;
	/**
	* 课包类型
	*/
		@ApiModelProperty(value = "课包类型")
		private String typePack;
	/**
	* 时间
	*/
		@ApiModelProperty(value = "时间")
		private Integer durationPack;
	/**
	* 次数
	*/
		@ApiModelProperty(value = "次数")
		private Integer amountPack;
	/**
	* 价格
	*/
		@ApiModelProperty(value = "价格")
		private BigDecimal pricePack;


}
