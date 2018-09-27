package com.education.gkzx.base.lisenter;

import com.education.gkzx.common.constants.BizContext;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by yu on 16/5/5.
 * 系统上下文
 */
public class SystemContextLoaderListener extends ContextLoaderListener {

	private static final Logger log = LoggerFactory.getLogger(SystemContextLoaderListener.class);

	private static final String[] resources = {"web"};

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			List<ResourceBundle> rbList = Lists.newArrayListWithExpectedSize(resources.length);
			for (String resource : resources) {
				rbList.add(ResourceBundle.getBundle(resource, Locale.getDefault()));
			}
			// 加载系统配置文件
			BizContext.init(rbList.toArray(new ResourceBundle[]{}));
		} catch (Exception ex) {
			log.error("important!!! load properties occurs exception!!", ex);
			// 加载失败，抛runtime异常，使jvm启动失败
			throw new RuntimeException(ex);
		}
		super.contextInitialized(event);
	}
}
