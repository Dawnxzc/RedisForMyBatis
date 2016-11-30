package com.xzc.mybatis.entities;

import java.io.Serializable;

public class Cust implements Serializable {
	private Integer custId;

	private String custName;

	private Integer custAge;

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	public Integer getCustAge() {
		return custAge;
	}

	public void setCustAge(Integer custAge) {
		this.custAge = custAge;
	}

	@Override
	public String toString() {
		return "Cust [custId=" + custId + ", custName=" + custName
				+ ", custAge=" + custAge + "]";
	}

}