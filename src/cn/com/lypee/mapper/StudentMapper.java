package cn.com.lypee.mapper;

import cn.com.lypee.Student.Student;

import java.io.IOException;

public interface StudentMapper {
    public Student findStudentByNum(int id) throws IOException ;
    public void  insertStudent(Student student) throws  IOException;
    public void deleteStudentById(int number) throws IOException;
    public void updateStudent(Student student) throws  IOException ;
}
