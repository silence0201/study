package dao.impl;

import dao.StudentRequestDao;
import entity.StudentRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tools.HibernateTool;

import java.util.ArrayList;

/**
 * Description: StudentRequestDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 10:42)
 */
public class StudentRequestDaoImpl implements StudentRequestDao {
    @Override
    public ArrayList<StudentRequest> requests() {
        Session session = HibernateTool.getSession() ;
        String hql = "from StudentRequest " ;
        Query query = session.createQuery(hql) ;
        ArrayList<StudentRequest> requests = (ArrayList<StudentRequest>)query.list() ;
        session.close() ;
        return requests;
    }

    @Override
    public StudentRequest getByID(Integer requestID) {
        Session session = HibernateTool.getSession() ;
        StudentRequest studentRequest = (StudentRequest)session.get(StudentRequest.class,requestID) ;
        return studentRequest;
    }

    @Override
    public boolean add(StudentRequest studentRequest) {
        boolean isExist = (new StudentDaoImpl().getByID(studentRequest.getStudent().getStudentId()) != null) ;

        if (!isExist){
            new StudentDaoImpl().add(studentRequest.getStudent()) ;
        }
        Session session = HibernateTool.getSession() ;

        try{
            session.beginTransaction() ;

            session.save(studentRequest) ;

            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close() ;
        }
    }

    @Override
    public boolean del(StudentRequest studentRequest) {
        Session session = HibernateTool.getSession() ;
        try {
            session.beginTransaction() ;
            session.delete(studentRequest);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            return  false ;
        }finally {
            session.close() ;
        }
        return true;
    }

    @Override
    public boolean modify(StudentRequest studentRequest) {
        Session session = HibernateTool.getSession() ;
        try {
            session.beginTransaction() ;
            session.update(studentRequest);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().commit();
            return false ;
        }finally {
            session.close() ;
        }
    }

    @Override
    public ArrayList<StudentRequest> requests(Integer studentID) {
        Session session = HibernateTool.getSession() ;

        Transaction tx = session.beginTransaction() ;

        String hql = "select request from StudentRequest request" +
                " where request.student.studentId =:studentID" ;

        Query query = session.createQuery(hql) ;
        query.setParameter("studentID",studentID) ;

        ArrayList<StudentRequest> requests = (ArrayList<StudentRequest>)query.list() ;

        tx.commit();
        session.close() ;

        return requests;
    }

    @Override
    public boolean requestDistribution(Integer requestID) {
        StudentRequest request = getByID(requestID) ;
        Session session = HibernateTool.getSession() ;
        try {
            request.setRequestStatus("已分配");
            session.update(request);
            session.getTransaction().commit();
            return  true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close() ;
        }

    }

    @Override
    public ArrayList<StudentRequest> workRequests(String workPlace) {
        Session session = HibernateTool.getSession() ;

        Transaction t = session.beginTransaction() ;
        String hql = "select studentRequest from StudentRequest studentRequest " +
                " where studentRequest.studentFirstChoice = :workPlace or " +
                "studentRequest.studenSecondChoice = :workPlace" ;
        Query query = session.createQuery(hql) ;
        query.setParameter("workPlace",workPlace) ;

        ArrayList<StudentRequest> studentRequests = (ArrayList<StudentRequest>) query.list();
        t.commit();
        session.close() ;

        return studentRequests;
    }
}
