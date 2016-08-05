package dao.impl;

import dao.StudentWorkDao;
import entity.StudentWork;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tools.HibernateTool;

import java.util.ArrayList;

/**
 * Description: StudentWorkDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 10:39)
 */
public class StudentWorkDaoImpl implements StudentWorkDao {
    @Override
    public StudentWork getByID(Integer studentWorkID) {
        Session session = HibernateTool.getSession() ;

        StudentWork studentWork = (StudentWork)session.get(StudentWork.class,studentWorkID) ;

        return studentWork;
    }
    @Override
    public ArrayList<StudentWork> works(Integer studentID) {
        Session session = HibernateTool.getSession() ;

        Transaction tx = session.beginTransaction() ;

        String hql = "select studentWork from StudentWork studentWork " +
                "where studentWork.student.studentId=:studentID" ;

        Query query = session.createQuery(hql) ;
        query.setParameter("studentID",studentID) ;

        ArrayList<StudentWork> studentWorks = ( ArrayList<StudentWork>)query.list() ;

        tx.commit();
        session.close() ;
        return studentWorks;
    }

    @Override
    public boolean add(StudentWork studentWork) {
        Session session = HibernateTool.getSession() ;
        try {
            session.beginTransaction() ;
            session.save(studentWork) ;
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            return false ;
        }
    }

    @Override
    public ArrayList<StudentWork> students(Integer workID) {
        Session session = HibernateTool.getSession() ;
        Transaction tx = session.beginTransaction() ;

        String hql = "select studentWork from StudentWork studentWork " +
                "where studentWork.work.workId =:workID" ;
        Query query = session.createQuery(hql) ;
        query.setParameter("workID",workID) ;

        ArrayList<StudentWork> students = (ArrayList<StudentWork>)query.list() ;

        tx.commit();
        session.close() ;

        return students;
    }
}
