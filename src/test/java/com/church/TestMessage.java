package com.church;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Class Name   : com.church
 * Description  :
 * <p/>
 * <p/>
 * Modification Information
 * -----------------------------------------------------------
 * 수정일                 수정자                 수정내용
 * -----------------------------------------------------------
 * <p/>
 * 2015. 8. 8.             ronkzoo             최초생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:/props/common-properties.xml",
    "classpath:/spring/context-common.xml",
    "classpath:/spring/context-datasource.xml",
    "classpath:/spring/context-transactionManager.xml",
    "classpath:/spring/context-sqlmap.xml",
    "classpath:/sqlmap/mybatis-config.xml"
})
public class TestMessage extends Assert {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource ReloadableResourceBundleMessageSource messageSource;

    @Test
    public void test(){
        logger.debug("TEST TEST");
        logger.debug(messageSource.getMessage("msg.insert.success", null, Locale.ENGLISH));
        assertNotNull(messageSource);
    }
}
