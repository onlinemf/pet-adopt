package com.pet.adopt.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务加载器
 * User: wenjun
 * Date: 2015-03-10
 * Time: 10:50
 */
public class StandardProjectServiceLauncher {
    private static final Logger LOGGER = LoggerFactory.getLogger(StandardProjectServiceLauncher.class);

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });
        LOGGER.info("服务端启动完成！");

        // 启动本地服务，然后hold住本地服务
        synchronized (StandardProjectServiceLauncher.class) {
            while (true) {
                try {
                    StandardProjectServiceLauncher.class.wait();
                } catch (InterruptedException e) {
                    LOGGER.error("后台服务异常终止:" + e.getMessage(), e);
                }
            }
        }
    }
}
