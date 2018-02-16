package edu.nju.ise.dao;

import edu.nju.ise.model.User;
import edu.nju.ise.utils.TimeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:*.xml"})
public class UserMapperTest extends AbstractJUnit4SpringContextTests {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

//    @Before
//    public void init() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:*.xml");
//        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
//    }

    @Test
    public void test() {
        User user = new User();
        user.setUsername("13813375770");
        user.setPassword("123456");
        user.setLastPasswordResetDate(TimeUtils.commonDate2Str(new Date()));

        Integer state = userMapper.insert(user);

        System.out.println(state);
        System.out.println(user.getId());
    }
}
