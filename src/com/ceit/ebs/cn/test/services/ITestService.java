package com.ceit.ebs.cn.test.services;

import java.util.List;

import com.ceit.ebs.cn.test.entity.Test;

public interface ITestService {
	
	public List<Test> getAll() throws Exception;

}
