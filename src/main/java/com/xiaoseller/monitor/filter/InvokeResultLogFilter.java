package com.xiaoseller.monitor.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.xiaoseller.monitor.ResultLogger;


@Activate(group = Constants.CONSUMER)
public class InvokeResultLogFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(InvokeResultLogFilter.class);
	private static final boolean DEFAULT_ASYNC_EXECUTE_MODE = false;

	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		Result result = invoker.invoke(invocation);
		try {
			if (!isAsyncExecution(invoker.getUrl())) {
				ResultLogger.log(invoker, invocation, result);
			}
		} catch (Exception e) {
			LOGGER.error("记录日志异常, 提供者:{}, 方法:{}", invoker.getInterface().getName(), invocation.getMethodName(), e);
		}
		return result;
	}
	
	public static boolean isAsyncExecution(URL url) {
		if (url != null) {
			boolean asyncExecute = url.getParameter("asyncExecute", DEFAULT_ASYNC_EXECUTE_MODE);
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("asyncExecute:" + asyncExecute);
			}
			return asyncExecute;
		}
		return DEFAULT_ASYNC_EXECUTE_MODE;
	}

}
