package sqlsession;

/**
 * @Description:
 * @Auther: Archy
 * @Date: 2020/12/5 18:54
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
