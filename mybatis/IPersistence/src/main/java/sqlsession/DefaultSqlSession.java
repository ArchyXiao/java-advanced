package sqlsession;

import pojo.Configuration;
import pojo.MappedStatement;

import java.lang.reflect.*;
import java.util.List;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 23:01
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {

        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);

        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = selectList(statementId, params);
        if (objects.size() == 1) {
            return (T) objects.get(0);
        } else {
            throw new RuntimeException("查询结果异常");
        }

    }

    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        //  使用 JDK 动态代理来为 Dao 接口生成代理对象，并返回
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass},
                                          new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //  底层还是执行 JDBC 代码
                //  根据不同情况，调用 selectList 或者 selectOne
                //  准备参数 1：statementid：sql 语句唯一标识 namespace.id  接口全限定名，方法名
                //  方法名：findAll
                String methodName = method.getName();
                String className = method.getDeclaringClass().getName();

                String  statementId = className + "." + methodName;

                //  准备参数2：params：args
                //  获取被调用方法的返回值类型
                Type genericReturnType = method.getGenericReturnType();
                //   判断是否进行了泛型类型参数化
                if (genericReturnType instanceof ParameterizedType) {
                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }

                return selectOne(statementId, args);
            }
        });

        return (T) proxyInstance;

    }
}
