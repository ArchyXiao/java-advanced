package sqlsession;

import config.XMLConfigBuilder;
import org.dom4j.DocumentException;
import pojo.Configuration;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 18:47
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        // 1. 使用 dom4j 解析配置文件，将解析出来的内容封装到 Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        //  2. 创建 SqlSessionFactory 对象
        //  工厂类：生产 SqlSession 会话对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);


        return defaultSqlSessionFactory;
     }
}
