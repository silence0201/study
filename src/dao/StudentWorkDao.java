package dao;

import entity.Student;
import entity.StudentWork;

import java.util.ArrayList;


/**
 * Description: StudentWorkDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface StudentWorkDao {
    //根据id获取相应的学生工作信息
    public abstract StudentWork getByID(Integer studentWorkID) ;
    //获取工作的列表
    public abstract ArrayList<StudentWork> works(Integer studentID) ;
    //添加工作支配
    public abstract  boolean add(StudentWork studentWork) ;
    //获取学生工作安排列表
    public abstract ArrayList<StudentWork> students(Integer workID) ;

}
