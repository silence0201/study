package dao.impl;

import dao.WorkDao;
import entity.Student;
import entity.StudentRequest;
import entity.StudentWork;
import entity.Work;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tools.HibernateTool;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Description: WorkDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 10:22)
 */
public class WorkDaoImpl implements WorkDao {

    @Override
    public ArrayList<Work> works() {
        Session session = HibernateTool.getSession() ;

        Transaction tx = session.beginTransaction() ;

        String hql = "select work from Work work" ;
        Query query = session.createQuery(hql) ;

        ArrayList<Work> works = (ArrayList<Work>)query.list() ;

        tx.commit();
        session.close();

        return works;
    }

    @Override
    public Work getByID(Integer workID) {
        Session session = HibernateTool.getSession() ;

        Work work = (Work)session.get(Work.class,workID) ;

        return work;
    }

    @Override
    public boolean add(Work work) {
        Session session = HibernateTool.getSession() ;
        try{
            session.beginTransaction() ;
            session.save(work) ;
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            System.out.println(e);
            session.getTransaction().rollback();
            return false ;
        }finally {
            session.close() ;
        }
    }

    @Override
    public boolean modify(Work work) {
        Session session = HibernateTool.getSession() ;
        try{
            session.beginTransaction() ;
            session.update(work);
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
    public boolean del(Work work) {
        if (!work.getWorkState().equals("空")){
            return false ;
        }
        Session session = HibernateTool.getSession() ;
        try {
            session.beginTransaction() ;
            session.delete(work);
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
    public boolean distribution(Work work) {
        ArrayList<StudentRequest> request = new StudentRequestDaoImpl().workRequests(work.getWorkPlace()) ;
        ArrayList<StudentRequest> studentRequests = new ArrayList<>() ;
        for (StudentRequest request1 : request){
            if (request1.getRequestStatus().equals("未分配")){
                studentRequests.add(request1);
            }
        }
        int count = studentRequests.size() ;
        int num = work.getWorkPersonNum() ;
        Session session = HibernateTool.getSession() ;
        session.beginTransaction() ;
        boolean flag = false ;
        try{
            while(num > 0 && count > 0){
                flag = true ;
                StudentRequest studentRequest = studentRequests.get(count-1) ;
                StudentWork studentWork = new StudentWork() ;
                studentWork.setWork(work);
                studentWork.setStudent(studentRequest.getStudent());
                studentWork.setStartTime(new Date(System.currentTimeMillis()));
                studentRequest.setRequestStatus("已分配");
                session.save(studentWork) ;
                session.update(studentRequest);
                count-- ;
                num-- ;
            }
            if (flag){
                if (num>0){
                    work.setWorkState("未满");
                }else{
                    work.setWorkState("已满");
                }
            }
            work.setWorkPersonNum(num);
            session.update(work);
            session.getTransaction().commit();
            return true ;
        }catch (Exception e){
            session.getTransaction().rollback();
            return false ;
        }
    }

}
