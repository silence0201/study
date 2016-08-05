package service;

import entity.Student;
import entity.StudentRequest;
import entity.StudentWork;

import java.util.ArrayList;

/**
 * Description: StudentRequestService
 * Author: silence
 * Update: silence(2016-06-30 08:02)
 */
public interface StudentRequestService {
    public abstract boolean getStudentInfo(Integer student_id);

    public abstract void addStudent(Integer student_id, String student_name, String student_academy, String student_major,
                                    String student_phone);
    public abstract void addStudentRequest(String student_first_choice, String student_second_choice);

    public abstract ArrayList<StudentRequest> studentRequestList() ;

    public abstract boolean modifyStudentRequest(StudentRequest studentRequest, String student_first_choice,
                                                  String student_second_choice);
    public abstract StudentRequest oneStudentRequest(Integer request_id);

    public abstract boolean deleteStudentRequest(StudentRequest studentRequest);

    public abstract ArrayList<StudentWork> requestInfo(Integer student_id);
    //获取和地点匹配的学生申请
    public abstract ArrayList<StudentRequest> workRequests(String work_place);
}
