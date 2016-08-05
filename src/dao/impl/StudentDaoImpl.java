package dao.impl;

import dao.StudentDao;
import entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tools.HibernateTool;

import java.util.ArrayList;

/**
 * Description: StudentDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 10:47)
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getByID(Integer studentID) {
        Session session = HibernateTool.getSession() ;
        Student student = (Student) session.get(Student.class,studentID) ;
        session.close() ;
        return student;
    }

    @Override
    public ArrayList<Student> students() {
        Session session = HibernateTool.getSession() ;

        Transaction tx = session.beginTransaction() ;

        String hql = "select student from Student student" ;

        Query query = session.createQuery(hql) ;

        ArrayList<Student> students = (ArrayList<Student>) query.list() ;

        tx.commit();
        session.close() ;

        return students;
    }

    @Override
    public boolean add(Student student) {
        Session session = HibernateTool.getSession() ;
        try{
            boolean flag = (session.get(Student.class,student.getStudentId()) == null) ;
            if (flag){
                session.beginTransaction() ;
                session.save(student) ;
                session.getTransaction().commit();
                return true ;
            }
            return false ;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close() ;
        }
    }

    @Override
    public ArrayList<Student> requestStudents(String workPlace) {
        Session session = HibernateTool.getSession() ;
        session.beginTransaction() ;
        String hql = "select studentRequest.student from StudentRequest  studentRequest " +
                "where studentRequest.studentFirstChoice = :workPlace or studentRequest.studenSecondChoice = :workPlace " +
                " and studentRequest.requestStatus =:status" ;
        Query query = session.createQuery(hql) ;
        query.setParameter("workPlace",workPlace) ;
        query.setParameter("status","未分配") ;
        ArrayList<Student> students = (ArrayList<Student>)query.list() ;
        session.getTransaction().commit();
        session.close() ;
        return students;
    }

    @Override
    public ArrayList<Student> workStudents(Integer workID) {
        Session session = HibernateTool.getSession() ;
        session.beginTransaction() ;
        String hql = "select studentWork.student from StudentWork studentWork " +
                "where studentWork.work.workId = :workID" ;

        Query query = session.createQuery(hql) ;
        query.setParameter("workID",workID) ;
        ArrayList<Student> students = (ArrayList<Student>)query.list() ;
        session.getTransaction().commit();
        session.close() ;
        return students;
    }


}
