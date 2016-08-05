package dao;

import entity.Examine;

import java.util.ArrayList;

/**
 * Description: ExamineDao
 * Author: silence
 * Update: silence(2016-06-30 07:54)
 */
public interface ExamineDao {
    //根据id获取指定的信息
    public abstract Examine getByID(Integer examineID) ;
    //添加考核信息
    public abstract boolean add(Examine examine) ;
    //获取考勤列表
    public abstract ArrayList<Examine> examines(Integer studentWorkID) ;
    //获取需要结算的考核呢
    public abstract ArrayList<Examine> NeedSettleExamines() ;
    //获取某个学生的考勤信息
    public abstract ArrayList<Examine> examineOfStudent(Integer studentID) ;
    //考核列表
    public abstract ArrayList<Examine> examine() ;
}
