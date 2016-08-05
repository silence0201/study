package dao;

import entity.Student;
import entity.Work;

import java.util.ArrayList;

/**
 * Description: WorkDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface WorkDao {
    //获取所有的工作
    public abstract ArrayList<Work> works() ;
    //获取工作的信息
    public abstract Work getByID(Integer workID) ;
    //添加工作
    public abstract boolean add(Work work) ;
    //修改工作信息
    public abstract boolean modify(Work work) ;
    //删除工作信息 --> 隐藏信息的显示
    public abstract boolean del(Work work) ;
    //分配工作
    public abstract boolean distribution(Work work) ;
}
