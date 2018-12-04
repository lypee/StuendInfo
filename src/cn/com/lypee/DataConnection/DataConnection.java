package cn.com.lypee.DataConnection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DataConnection {
    private String resource = "SqlMapConfig.xml";
    private SqlSessionFactory sqlSessionFactory ;
    private SqlSession sqlSession ;
    public SqlSession getSqlSession() throws IOException
    {
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = sqlSessionFactory.openSession() ;
        return sqlSession ;
    }
}
