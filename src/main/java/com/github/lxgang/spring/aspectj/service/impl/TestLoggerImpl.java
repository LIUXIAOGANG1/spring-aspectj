package com.github.lxgang.spring.aspectj.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.lxgang.spring.aspectj.service.TestLogger;

@Service
public class TestLoggerImpl implements TestLogger{
	Logger logger = LoggerFactory.getLogger(TestLoggerImpl.class);

	public void test() {
		logger.info("*************************************this is a test!*************************************");
	}

	public String testAround(String start) {
		return "hello " + start;
	}
}
