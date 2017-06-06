package com.xiaoseller.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.fastjson.JSON;

public class ResultLogger {
	private static Logger LOGGER = LoggerFactory.getLogger(ResultLogger.class);

	public static void log(Invoker<?> invoker, Invocation invocation, Object result) {
		try {
			LOGGER.info("调用提供者:{}, 方法:{}, 参数:{}, 响应:{}", invoker.getInterface().getName(), invocation.getMethodName(),
					JSON.toJSONString(invocation.getArguments()),
					JSON.toJSONString(result));
		} catch (Exception e) {
			LOGGER.error("记录日志异常, 提供者:{}, 方法:{}", invoker.getInterface().getName(), invocation.getMethodName(), e);
		}
	}
}
