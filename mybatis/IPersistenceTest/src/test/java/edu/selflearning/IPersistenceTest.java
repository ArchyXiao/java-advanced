package edu.selflearning;

import edu.selflearning.dao.IUserDao;
import edu.selflearning.pojo.User;
import io.Resources;
import org.junit.Test;
import sqlsession.SqlSession;
import sqlsession.SqlSessionFactory;
import sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 16:42
 */
public class IPersistenceTest {

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setUsername("lucy");

        // User user2  = sqlSession.selectOne("user.findOne", user);
        // System.out.println(user2);
        //
        // List<User> users = sqlSession.selectList("user.findAll");
        // for (User user1 : users) {
        //     System.out.println(user1);
        // }

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // User user1 = userDao.findByCondition(user);
        // System.out.println(user1);

        List<User> all = userDao.findAll();
        for (User user2 : all) {
            System.out.println(user2);
        }


    }


}
