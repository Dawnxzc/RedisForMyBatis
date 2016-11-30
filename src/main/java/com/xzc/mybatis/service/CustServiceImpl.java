package com.xzc.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xzc.mybatis.entities.Cust;
import com.xzc.mybatis.mapper.CustMapper;

@Service
public class CustServiceImpl implements CustService {
	
	@Autowired
	private CustMapper custMapper;
	
	@Override
	public Cust getCustById(Integer custId) {
		return custMapper.selectByPrimaryKey(custId);
	}

}
