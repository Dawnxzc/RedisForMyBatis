package com.xzc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xzc.mybatis.entities.Cust;
import com.xzc.mybatis.entities.CustExample;

public interface CustMapper {
    int countByExample(CustExample example);

    int deleteByExample(CustExample example);

    int deleteByPrimaryKey(Integer custId);

    int insert(Cust record);

    int insertSelective(Cust record);

    List<Cust> selectByExample(CustExample example);

    Cust selectByPrimaryKey(Integer custId);

    int updateByExampleSelective(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByExample(@Param("record") Cust record, @Param("example") CustExample example);

    int updateByPrimaryKeySelective(Cust record);

    int updateByPrimaryKey(Cust record);
}