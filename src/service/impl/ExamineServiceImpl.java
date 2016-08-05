package service.impl;

import dao.ExamineDao;
import dao.MonetaryDao;
import dao.impl.ExamineDaoImpl;
import dao.impl.MonetaryDaoImpl;
import entity.Examine;
import entity.Monetary;
import entity.Student;
import service.ExamineService;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: ExamineServiceImpl
 * Author: silence
 * Update: silence(2016-07-03 09:51)
 */
public class ExamineServiceImpl implements ExamineService {
    @Override
    public HashMap<Student, Double> examineCount() {
        ExamineDao examineDao = new ExamineDaoImpl() ;
        ArrayList<Examine> examines = examineDao.examine() ;
        HashMap<Student,Double> studentIntegerHashMap = new HashMap<>() ;
        for (Examine examine : examines){
            Double countOfTime = studentIntegerHashMap.get(examine.getStudentWork().getStudent()) ;
            if (countOfTime == null){
                countOfTime = new Double(0) ;
            }
            countOfTime += examine.getExamineHour() ;
            studentIntegerHashMap.put(examine.getStudentWork().getStudent(),countOfTime) ;
        }
        return studentIntegerHashMap;
    }

    @Override
    public ArrayList<Examine> examins(String studentID) {
        ExamineDao examineDao = new ExamineDaoImpl() ;
        ArrayList<Examine> examines = examineDao.examineOfStudent(new Integer(studentID)) ;
        return examines;
    }

    @Override
    public HashMap<Student,Double> needMonetary() {
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        HashMap<Student,Double> monetaries = monetaryDao.studentMonery() ;
        return monetaries;
    }

    @Override
    public boolean settlet() {
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        boolean flag = monetaryDao.settleMent() ;
        return flag;
    }

    @Override
    public ArrayList<Monetary> studentMonetary(String studentID) {
        MonetaryDao monetaryDao = new MonetaryDaoImpl() ;
        ArrayList<Monetary> monetaries = monetaryDao.needSettleMent() ;
        ArrayList<Monetary> mos = new ArrayList<>() ;
        for (Monetary mo : monetaries){
            if (mo.getStudentWork().getStudent().getStudentId().equals(new Integer(studentID))){
                mos.add(mo) ;
            }
        }
        return mos;
    }
}
