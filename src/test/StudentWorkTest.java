package test;

import dao.StudentDao;
import dao.StudentWorkDao;
import dao.impl.StudentDaoImpl;
import dao.impl.StudentWorkDaoImpl;
import entity.Student;
import entity.StudentWork;

import java.util.ArrayList;

/**
 * Description: StudentWorkTest
 * Author: silence
 * Update: silence(2016-06-30 10:40)
 */
public class StudentWorkTest {
    public static void main(String[] args) {
//        students();
        works();
//        add();
    }

    public static void getByID(){
        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl() ;
        StudentWork studentWork = studentWorkDao.getByID(10000) ;
        System.out.println(studentWork);
    }

    public static void students(){
        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl() ;
        ArrayList<StudentWork> studentWorks = studentWorkDao.students(10000) ;
        System.out.println(studentWorks);
    }

    public static void add(){
        StudentDao studentDao = new StudentDaoImpl() ;
        Student student = new Student() ;
        student.setStudentId(13110);
        student.setStudentName("大神2号");
        student.setStudentAcademy("计算机");
        student.setStudentMajor("软件工程");
        student.setStudentPhone("11011101110");
        studentDao.add(student) ;
    }

    public static void works(){
        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl() ;
        ArrayList<StudentWork> studentWorks = studentWorkDao.works(1208100) ;
        System.out.println(studentWorks);
    }
}
