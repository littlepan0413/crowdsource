package base;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试基础类
 *
 * <p>
 * 单元测试基础类，所有的单元测试类都继承此类
 * 
 * @author panlu 2016年10月8日
 * @see [相关类/方法]
 * @since 1.0
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:spring/core-context.xml","classpath:spring/kse-storage-db.xml"})
@WebAppConfiguration
public class BaseTest
{
    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setUp() throws Exception
    {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }
    @Test
    public void test() throws Exception
    {
        
    }
}
