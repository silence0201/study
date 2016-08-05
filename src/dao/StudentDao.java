package dao;

import entity.Student;
import entity.StudentRequest;
import entity.StudentWork;
import entity.Work;

import java.util.ArrayList;

/**
 * Description: StudentDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface StudentDao {
    //根据id获取指定的对象信息
    public abstract Student getByID(Integer studentID) ;
    //获取学生信息列表
    public abstract ArrayList<Student> students() ;
    //添加学生信息
    public abstract boolean add(Student student) ;
    //获取所有申请某工作的学生信息
    public abstract ArrayList<Student> requestStudents(String workPlace) ;
    //获取参加这个工作的学生的信息
    public abstract ArrayList<Student> workStudents(Integer workID) ;

}
