package dao.impl;

import dao.MonetaryDao;
import entity.Examine;
import entity.Monetary;
import entity.Student;
import entity.StudentWork;
import org.hibernate.Query;
import org.hibernate.Session;
import tools.HibernateTool;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Description: MonetaryDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 11:25)
 */
public class MonetaryDaoImpl implements MonetaryDao {
    @Override
    public Monetary getByID(Integer MonetaryID) {
        Session session = HibernateTool.getSession() ;
        Monetary monetary = (Monetary) session.get(Monetary.class,MonetaryID) ;
        return monetary;
    }

    @Override
    public boolean add(Monetary monetary) {
        Session session = HibernateTool.getSession() ;

        try {
            session.beginTransaction() ;
            session.save(monetary) ;
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }
        return true ;
    }

    @Override
    public ArrayList<Monetary> monetraies() {
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1 ;
        Session session = HibernateTool.getSession() ;
        session.beginTransaction() ;
        String hql = "select montary from Monetary montary " +
                "where montary.monetaryMonth = :month" ;
        Query query = session.createQuery(hql) ;
        query.setParameter("month",month+"") ;
        ArrayList<Monetary> monetaries = (ArrayList<Monetary>) query.list();
        session.getTransaction().commit();
        session.close() ;
        return monetaries;
    }

    @Override
    public ArrayList<Monetary> needSettleMent() {
        ArrayList<Examine> examines = new ExamineDaoImpl().NeedSettleExamines() ;

        HashMap<StudentWork,ArrayList<Examine>> examineMap = new HashMap<StudentWork,ArrayList<Examine>> () ;
        for (Examine examine : examines){
            ArrayList<Examine> examineList = examineMap.get(examine.getStudentWork()) ;
            if (examineList == null){
                examineList = new ArrayList<Examine>() ;
                examineMap.put(examine.getStudentWork(),examineList) ;
            }
            examineList.add(examine) ;
        }

        int month = Calendar.getInstance().get(Calendar.MONTH) + 1 ;

        double sum = 0 ;
        ArrayList<Monetary> monetarys = new ArrayList<Monetary>() ;

        Set<Map.Entry<StudentWork,ArrayList<Examine>>> entry = examineMap.entrySet() ;
        Iterator<Map.Entry<StudentWork,ArrayList<Examine>>> it = entry.iterator() ;

        while (it.hasNext()){
            Map.Entry<StudentWork,ArrayList<Examine>> en = it.next() ;
            StudentWork sw = en.getKey() ;
            ArrayList<Examine> examins = en.getValue() ;
            for (Examine ex : examines){
                sum += sw.getWork().getWorkSalary() * ex.getExamineHour() ;
            }
            Monetary mon = new Monetary() ;
            mon.setMonetaryMonth(month+"");
            mon.setSalary(sum);
            mon.setStudentWork(sw);
            monetarys.add(mon) ;
        }
        return monetarys;
    }

    @Override
    public boolean settleMent() {
        settleExamine() ;
        ArrayList<Monetary> monetarys = needSettleMent() ;
        Date setTime = new Date(System.currentTimeMillis()) ;
        boolean flag = true ;
        for (Monetary mo  : monetarys){
            mo.setSettleTime(setTime);
            flag = flag && add(mo) ;
        }
        return flag;
    }

    public boolean settleExamine(){
        ArrayList<Examine> examines = new ExamineDaoImpl().NeedSettleExamines() ;
        boolean flag = true ;
        Session session = HibernateTool.getSession() ;
        session.beginTransaction() ;
        for (Examine examine : examines){
            try{
                examine.setStatus("已结算");
                session.update(examine);
            }catch (Exception e){
                flag = false ;
                session.getTransaction().rollback();
            }
        }
        session.getTransaction().commit();
        session.close() ;
        return flag ;
    }

    @Override
    public HashMap<Student,Double> studentMonery(){
        ArrayList<Monetary> monetaries = needSettleMent() ;
        HashMap<Student,Double> mo = new HashMap<>() ;

        for (Monetary monetary : monetaries){
            Double d = mo.get(monetary.getStudentWork().getStudent()) ;
            if (d == null){
                d = new Double(0) ;
            }
            d += monetary.getSalary() ;
            mo.put(monetary.getStudentWork().getStudent(),d) ;
        }
        return mo ;
    }
}
