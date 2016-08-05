package service.impl;

import dao.StudentDao;
import dao.StudentRequestDao;
import dao.StudentWorkDao;
import dao.impl.StudentDaoImpl;
import dao.impl.StudentRequestDaoImpl;
import dao.impl.StudentWorkDaoImpl;
import entity.Student;
import entity.StudentRequest;
import entity.StudentWork;
import service.StudentRequestService;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by 孙瑜 on 2016/7/2.
 */
public class StudentRequestServiceImpl implements StudentRequestService {
    private Student student;
    private StudentRequest studentRequest;
    private Integer student_id;
    private String student_name;
    private String student_academy;
    private String student_major;
    private String student_phone;
    private Date addTime;
    private String requestStatus;

    public boolean getStudentInfo(Integer student_id){
        StudentDao studentDao = new StudentDaoImpl();
        Student stu = new Student();
        stu = studentDao.getByID(student_id);
        if(stu == null){
            return true;
        }
        return false;
    }

    public void addStudent(Integer student_id, String student_name, String student_academy, String student_major,
                           String student_phone){
        this.student = new Student();
        student.setStudentId(student_id);
        student.setStudentName(student_name);
        student.setStudentAcademy(student_academy);
        student.setStudentMajor(student_major);
        student.setStudentPhone(student_phone);
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.add(this.student);
    }

    public void addStudentRequest(String student_first_choice, String student_second_choice){
        this.studentRequest = new StudentRequest();
        this.addTime = new Date(System.currentTimeMillis());
        studentRequest.setStudentFirstChoice(student_first_choice);
        studentRequest.setStudenSecondChoice(student_second_choice);
        studentRequest.setAddTime(this.addTime);
        studentRequest.setRequestStatus("未分配");
        studentRequest.setStudent(this.student);
        StudentRequestDao studentDao = new StudentRequestDaoImpl();
        studentDao.add(this.studentRequest);
    }

    @Override
    public ArrayList<StudentRequest> studentRequestList() {
        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl() ;
        ArrayList<StudentRequest> studentRequests = studentRequestDao.requests() ;
        return studentRequests;
    }

    public boolean modifyStudentRequest(StudentRequest studentRequest, String student_first_choice,
                                        String student_second_choice){
        this.studentRequest = studentRequest;
        this.studentRequest.setStudentFirstChoice(student_first_choice);
        this.studentRequest.setStudenSecondChoice(student_second_choice);

        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl();
        return studentRequestDao.modify(this.studentRequest);
    }

    public StudentRequest oneStudentRequest(Integer request_id){
        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl();
        StudentRequest oneStudentRequest = studentRequestDao.getByID(request_id);
        return oneStudentRequest;
    }

    public boolean deleteStudentRequest(StudentRequest studentRequest){
        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl();
        return studentRequestDao.del(studentRequest);
    }

    //单个学生工作详情
    public ArrayList<StudentWork> requestInfo(Integer student_id) {
        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl();
        return studentWorkDao.works(student_id);
    }

    public ArrayList<StudentRequest> workRequests(String work_place){
        StudentRequestDao studentRequestDao = new StudentRequestDaoImpl();
        return studentRequestDao.workRequests(work_place);
    }
}
