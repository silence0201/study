package test;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;

import java.util.ArrayList;

/**
 * Description: StudentTest
 * Author: silence
 * Update: silence(2016-06-30 10:57)
 */
public class StudentTest {
    public static void main(String[] args) {
//        workStudets();
//        requestStudents();
//        students();
        add();
    }

    public static void getByID(){
        StudentDao studentDao = new StudentDaoImpl() ;
        Student student = studentDao.getByID(1208100) ;
        System.out.println(student);
    }

    public static void workStudets() {
        StudentDao studentDao = new StudentDaoImpl() ;
        ArrayList<Student> students = studentDao.workStudents(10000) ;
        System.out.println(students);
    }

    public static void requestStudents(){
        StudentDao studentDao = new StudentDaoImpl() ;
        ArrayList<Student> students = studentDao.requestStudents("第二食堂") ;
        System.out.println(students);
    }

    public static void students(){
        StudentDao studentDao = new StudentDaoImpl() ;
        ArrayList<Student> students = studentDao.students() ;
        System.out.println(students);
    }

    public static void add(){
        StudentDao studentDao = new StudentDaoImpl() ;
        Student student = new Student() ;
        student.setStudentId(1210543);
        student.setStudentName("大神");
        student.setStudentAcademy("计算机学院");
        student.setStudentMajor("软件工程");
        student.setStudentPhone("12345678910");
        studentDao.add(student) ;

    }

}
