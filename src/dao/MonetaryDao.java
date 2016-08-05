package dao;

import entity.Monetary;
import entity.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: MonetaryDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface MonetaryDao {
    //根据id获取对象信息
    public abstract Monetary getByID(Integer MonetaryID) ;
    //添加酬金
    public abstract boolean add(Monetary monetary) ;
    //获得酬金列表
    public abstract ArrayList<Monetary> monetraies() ;
    //获取需要结算的酬金信息
    public abstract ArrayList<Monetary> needSettleMent() ;
    //结算酬金
    public abstract boolean settleMent() ;

    public abstract HashMap<Student,Double> studentMonery() ;
}
