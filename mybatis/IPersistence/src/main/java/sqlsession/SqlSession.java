package sqlsession;

import java.util.List;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 22:58
 */
public interface SqlSession {

    //  查询所有
    <E> List<E> selectList(String statementId, Object... params) throws Exception;

    //  根据条件查询单个
    <T> T selectOne(String statementId, Object... params) throws Exception;

}
