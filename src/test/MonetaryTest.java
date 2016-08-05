package test;

import dao.MonetaryDao;
import dao.impl.MonetaryDaoImpl;
import dao.impl.StudentWorkDaoImpl;
import entity.Monetary;
import service.ExamineService;
import service.impl.ExamineServiceImpl;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Description: MonetaryTest
 * Author: silence
 * Update: silence(2016-06-30 14:12)
 */
public class MonetaryTest {
    public static void main(String[] args) {
//        add();
//        monetraies();
//        needSettleMent();
//        setMon();
        demo();
    }

    public static void ID(){
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        Monetary monetary = monetaryDao.getByID(10000) ;
        System.out.println(monetary);
    }

    public static void add(){
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        Monetary monetary = new Monetary() ;
        monetary.setMonetaryMonth("7");
        monetary.setSettleTime(new Date(System.currentTimeMillis()));
        monetary.setStudentWork(new StudentWorkDaoImpl().getByID(10000));
        monetary.setSalary(12.1);
        monetaryDao.add(monetary) ;
    }

    public static void monetraies(){
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        System.out.println(monetaryDao.monetraies());
    }

    public static void needSettleMent(){
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        System.out.println(monetaryDao.needSettleMent());
    }

    public static void setMon(){
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        System.out.println(monetaryDao.settleMent());
    }

    public static void demo(){
        ExamineService examineService = new ExamineServiceImpl() ;
        System.out.println(examineService.examineCount());
    }
}
