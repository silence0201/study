package dao.impl;

import dao.ExamineDao;
import entity.Examine;
import entity.StudentWork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tools.HibernateTool;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Description: ExamineDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 11:20)
 */
public class ExamineDaoImpl implements ExamineDao {
    @Override
    public Examine getByID(Integer examineID) {
        Session session = HibernateTool.getSession() ;
        Examine examine = (Examine)session.get(Examine.class,examineID) ;
        return examine;
    }

    @Override
    public boolean add(Examine examine) {
        Session session = HibernateTool.getSession() ;

        try {
            Transaction tx = session.beginTransaction() ;
            session.save(examine) ;
            tx.commit();

            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close() ;
        }
    }

    @Override
    public ArrayList<Examine> examines(Integer studentWorkID) {
        Session session = HibernateTool.getSession() ;

        session.beginTransaction() ;

        String hql = "select examin from Examine examin " +
                "where examin.studentWork.studentWorkId = :studentWorkId " +
                "and examin.month = :month" ;
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1 ;
        Query query = session.createQuery(hql) ;
        query.setParameter("month",month+"") ;
        query.setParameter("studentWorkId",studentWorkID) ;
        ArrayList<Examine> examines = (ArrayList<Examine>)query.list() ;

        session.getTransaction().commit();
        session.close() ;

        return examines;
    }

    @Override
    public ArrayList<Examine> NeedSettleExamines() {
        Session session = HibernateTool.getSession() ;

        session.beginTransaction() ;

        String hql = "select examine from  Examine examine " +
                "where examine.status =:status" ;
        Query query = session.createQuery(hql) ;
        query.setParameter("status","未结算") ;
        ArrayList<Examine> examines = (ArrayList<Examine>)query.list() ;

        session.getTransaction().commit();
        session.close() ;

        return examines;
    }

    @Override
    public ArrayList<Examine> examineOfStudent(Integer studentID) {

        Session session  = HibernateTool.getSession() ;
        session.beginTransaction() ;

        String hql = "select examine from Examine  examine " +
                "where examine.studentWork.student.studentId = :studentID " +
                "and examine.month = :month" ;
        int month = Calendar.getInstance().get(Calendar.MONTH)+1 ;

        Query query = session.createQuery(hql) ;
        query.setParameter("studentID",studentID) ;
        query.setParameter("month",month+"") ;

        ArrayList<Examine> examines  = (ArrayList<Examine>) query.list() ;

        session.getTransaction().commit();
        session.close() ;

        return examines;
    }

    @Override
    public ArrayList<Examine> examine() {
        Session session = HibernateTool.getSession() ;
        String hql = "select examine from Examine examine " +
                "where examine.month = :month";

        session.beginTransaction() ;
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1 ;
        Query query = session.createQuery(hql) ;
        query.setParameter("month",month+"") ;

        ArrayList<Examine> examines = (ArrayList<Examine>)query.list() ;


        session.getTransaction().commit();
        session.close() ;
        return examines;
    }
}
