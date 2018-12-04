package cn.com.lypee.test;

import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;
import cn.com.lypee.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

public class test {
    DataConnection dataConnection  = new DataConnection();
    @Test
    public void testget() throws IOException
    {
        SqlSession sqlSession = dataConnection.getSqlSession() ;
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findStudentByNum(2);
        System.out.println("\n" + student.getName() + " "  + student.getTel());
    }
    @Test
    public void testinsert() throws IOException
    {
        SqlSession sqlSession = dataConnection.getSqlSession() ;
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student() ;
        student.setNumber(3);student.setName("4");
        student.setTel("5");student.setDepartment("6");
        System.out.println("\n" + student.getName() + " " + student.getDepartment());
        studentMapper.insertStudent(student);
        sqlSession.commit();
    }
    @Test
    public void deletetest() throws  IOException
    {
        SqlSession sqlSession = dataConnection.getSqlSession() ;
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.deleteStudentById(2);
    }
}
