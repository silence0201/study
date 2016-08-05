package test;

import dao.ExamineDao;
import dao.impl.ExamineDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.StudentWorkDaoImpl;
import entity.Examine;
import entity.StudentWork;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Description: ExamineTest
 * Author: silence
 * Update: silence(2016-06-30 14:14)
 */
public class ExamineTest {

    public static void main(String[] args) {
//        examins();
//        add();
//        NeedSettleExamines();
        examStu();
    }

    public static void ID(){
        ExamineDao examineDao = new ExamineDaoImpl() ;
        Examine examine = (Examine)examineDao.getByID(10000) ;
        System.out.println(examine);
    }

    public static void examins(){
        ExamineDao examineDao = new ExamineDaoImpl() ;
        ArrayList<Examine> examines = examineDao.examines(10000) ;
        System.out.println(examines);
    }

    public static void add(){
        ExamineDao examineDao = new ExamineDaoImpl() ;
        Examine examine = new Examine() ;
        examine.setExamineHour(12);
        examine.setMonth("7");
        examine.setStatus("未结算");
        examine.setStudentWork(new StudentWorkDaoImpl().getByID(10000));
        examine.setWorkTime(new Date(System.currentTimeMillis()));
        examineDao.add(examine) ;
    }

    public static void NeedSettleExamines(){
        ExamineDao examineDao = new ExamineDaoImpl() ;
        System.out.println(examineDao.NeedSettleExamines());
    }

    public static void examStu(){
        ExamineDao examineDao = new ExamineDaoImpl() ;
        System.out.println(examineDao.examineOfStudent(1208100));
    }
}
