package com.education.gkzx.common.constants;

import com.education.gkzx.common.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Created by hongming on 16/5/5.
 */
public class BizContext {
    private static final Logger log = LoggerFactory.getLogger(BizContext.class);
    public static String ENV; // 系统环境
    public static void init(ResourceBundle... resourceBundles) {
        ENV = ResourceUtil.get("env", resourceBundles);

        log.info("application start env {}", ENV);
    }
}
