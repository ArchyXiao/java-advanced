package sqlsession;

import pojo.Configuration;
import pojo.MappedStatement;

import java.util.List;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/6 22:41
 */
public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) throws Exception;
}
