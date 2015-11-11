package com.github.lxgang.spring.aspectj.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.lxgang.spring.aspectj.service.TestLogger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestLoggerImplTest {

	@Resource
	private TestLogger testLogger;
	
	@Test
	public void test() {
		testLogger.test();
	}
	
	@Test
	public void testAround() {
		testLogger.testAround("word");
	}
}
