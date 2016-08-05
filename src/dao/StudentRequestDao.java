package dao;

import entity.StudentRequest;

import java.util.ArrayList;

/**
 * Description: StudentRequestDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface StudentRequestDao {
    //获取申请列表
    public abstract ArrayList<StudentRequest> requests() ;
    //获取指定的申请
    public abstract StudentRequest getByID(Integer requestID) ;
    //添加学生申请
    public abstract boolean add(StudentRequest studentRequest) ;
    //删除学生的申请
    public abstract boolean del(StudentRequest studentRequest) ;
    //修改学生的申请
    public abstract boolean modify(StudentRequest studentRequest) ;
    //获取学生申请的列表
    public abstract ArrayList<StudentRequest> requests(Integer studentID) ;
    //分配工作
    public abstract boolean requestDistribution(Integer requestID) ;
    //获取匹配某地址的工作申请
    public abstract ArrayList<StudentRequest> workRequests(String workPlace) ;
}
