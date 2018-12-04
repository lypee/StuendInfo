package cn.com.lypee.Dao;

import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;
import cn.com.lypee.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.IOException;

public class StudentDao {
    Student student = new Student() ;
    DataConnection dataConnection = new DataConnection() ;
   public Student findDao(int number) throws IOException{
       SqlSession sqlSession = dataConnection.getSqlSession() ;
       StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       student = studentMapper.findStudentByNum(number);
       sqlSession.commit();
       sqlSession.close();
       return student;
   }
   @Test
   public void insertDao(Student student)throws IOException {
       SqlSession sqlSession = dataConnection.getSqlSession() ;
       StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       System.out.println("\n" + student.getName() + " " + student.getDepartment());
       studentMapper.insertStudent(student);
       sqlSession.commit();
       sqlSession.close();
   }
   public void deleteDao(int number) throws  IOException{
       SqlSession sqlSession = dataConnection.getSqlSession() ;
       StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       studentMapper.deleteStudentById(number);
       sqlSession.commit();
       sqlSession.close();
   }
   public void updateDao(Student student) throws IOException
   {
       SqlSession sqlSession = dataConnection.getSqlSession() ;
       StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
       studentMapper.updateStudent(student);
       sqlSession.commit();
       sqlSession.close();
   }
}
