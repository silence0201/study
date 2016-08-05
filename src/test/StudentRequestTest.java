package test;

import dao.StudentRequestDao;
import dao.impl.StudentDaoImpl;
import dao.impl.StudentRequestDaoImpl;
import entity.StudentRequest;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Description: StudentRequestTest
 * Author: silence
 * Update: silence(2016-06-30 10:45)
 */
public class StudentRequestTest {
    public static void main(String[] args) {
//        requests();
//        add();
//        del();
//        modify();
        requests();
    }

    public static void ID(){
        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl() ;
        StudentRequest studentRequest = studentRequestDao.getByID(10000) ;
        System.out.println(studentRequest);
    }

    public static void requests(){
        StudentRequestDao requestDao =  new StudentRequestDaoImpl() ;
        ArrayList<StudentRequest> studentRequests = requestDao.requests() ;
        System.out.println(studentRequests);
    }

    public static void add(){
        StudentRequestDao requestDao =  new StudentRequestDaoImpl() ;
        StudentRequest studentRequest =  new StudentRequest() ;
        studentRequest.setRequestStatus("未分配");
        studentRequest.setAddTime(new Date(System.currentTimeMillis()));
        studentRequest.setStudenSecondChoice("第一食堂");
        studentRequest.setStudentFirstChoice("第二食堂");
        studentRequest.setStudent(new StudentDaoImpl().getByID(1210563));
        requestDao.add(studentRequest) ;
    }

    public static void del(){
        StudentRequestDao requestDao = new StudentRequestDaoImpl() ;
        requestDao.del(requestDao.getByID(10004)) ;
    }
    public static void modify(){
        StudentRequestDao requestDao = new StudentRequestDaoImpl() ;
        StudentRequest studentRequest = requestDao.getByID(10005) ;
        studentRequest.setStudentFirstChoice("科技馆");
        requestDao.modify(studentRequest) ;
    }

    public static void request(){
        StudentRequestDao requestDao = new StudentRequestDaoImpl() ;
        System.out.println(requestDao.requests(10000));
    }

    public static void works(){
        StudentRequestDao requestDao = new StudentRequestDaoImpl() ;
        System.out.println(requestDao.workRequests("第一食堂"));
    }
}
