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
package org.springblade.basic.service.impl;

import org.springblade.basic.entity.School;
import org.springblade.basic.excel.SchoolExcel;
import org.springblade.basic.vo.SchoolVO;
import org.springblade.basic.mapper.SchoolMapper;
import org.springblade.basic.service.ISchoolService;
import org.springblade.core.log.exception.ServiceException;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springblade.core.tool.utils.BeanUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * 基础学校表 服务实现类
 *
 * @author BladeX
 * @since 2021-05-10
 */
@Service
public class SchoolServiceImpl extends BaseServiceImpl<SchoolMapper, School> implements ISchoolService {


    @Override
    public IPage<SchoolVO> selectSchoolPage(IPage<SchoolVO> page, SchoolVO school) {
        return page.setRecords(baseMapper.selectSchoolPage(page, school));
    }

    /**
     * 真实删除 基础学校表
     */
    @Override
    public boolean deleteByIdzs(String id) {
        boolean bool = baseMapper.deleteByIdzs(id);
        return bool;

    }

    /**
     * Excel导入学校 基础学校表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importSchool(List<SchoolExcel> data, Boolean isCovered) {
        List<School> list = new ArrayList<>();
        data.forEach(schoolExcel -> {
            if (schoolExcel.getNameSchool() == null) {
//
                throw new ServiceException("学校名不能为空");
            } else if (schoolExcel.getContactSchool() == null) {
                throw new ServiceException("学校联系方式不能为空");
            } else if (schoolExcel.getAddressSchool() == null) {
                throw new ServiceException("学校地址不能为空");
            } else if (schoolExcel.getIntroduceSchool() == null) {
                throw new ServiceException("学校简介不能为空");
            } else {
                School school = BeanUtil.copy(schoolExcel, School.class);
                list.add(school);
            }

        });
        if (isCovered) {
            this.saveOrUpdateBatch(list);
        } else {
            this.saveBatch(list);
        }
    }

}
