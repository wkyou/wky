package com.wang.dao.mapper;

import com.wang.dao.model.TWxFwhXcxPatient;
import com.wang.dao.model.TWxFwhXcxPatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWxFwhXcxPatientMapper {
    long countByExample(TWxFwhXcxPatientExample example);

    int deleteByExample(TWxFwhXcxPatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWxFwhXcxPatient record);

    int insertSelective(TWxFwhXcxPatient record);

    List<TWxFwhXcxPatient> selectByExample(TWxFwhXcxPatientExample example);

    TWxFwhXcxPatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWxFwhXcxPatient record, @Param("example") TWxFwhXcxPatientExample example);

    int updateByExample(@Param("record") TWxFwhXcxPatient record, @Param("example") TWxFwhXcxPatientExample example);

    int updateByPrimaryKeySelective(TWxFwhXcxPatient record);

    int updateByPrimaryKey(TWxFwhXcxPatient record);
}