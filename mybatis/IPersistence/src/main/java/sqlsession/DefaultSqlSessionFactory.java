package sqlsession;

import pojo.Configuration;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 22:55
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
