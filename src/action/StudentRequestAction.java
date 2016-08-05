package action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Student;
import entity.StudentRequest;
import entity.StudentWork;
import service.StudentRequestService;
import service.impl.StudentRequestServiceImpl;

import java.util.ArrayList;
import java.util.Map;

/**
 * Description: StudentRequestAction
 * Author: silence
 * Update: silence(2016-06-30 07:58)
 */
public class StudentRequestAction extends ActionSupport{
    private Integer request_id;
    private Integer student_id;
    private String student_name;
    private String student_academy;
    private String student_major;
    private String student_phone;
    private String student_first_choice;
    private String student_second_choice;

    public String requestInfo(){
        Map pragarm = ActionContext.getContext().getParameters();
        String stuId = ((String[])pragarm.get("studentId"))[0];
        Integer studentId = Integer.parseInt(stuId);
        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        ArrayList<StudentWork> studentRequestInfo = studentRequestService.requestInfo(studentId);
        ActionContext.getContext().put("requestInfo",studentRequestInfo);
        return SUCCESS;
    }

    public String delete(){
        Map pragarm = ActionContext.getContext().getParameters();
        String stuRequestId = ((String[])pragarm.get("studentRequestId"))[0];
        Integer studentRequestId = Integer.parseInt(stuRequestId);
        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        StudentRequest studentRequest =  studentRequestService.oneStudentRequest(studentRequestId);
        studentRequestService.deleteStudentRequest(studentRequest);
        return SUCCESS;
    }

    public String initModify(){
        Map pragarm = ActionContext.getContext().getParameters();
        String stuRequestId = ((String[])pragarm.get("studentRequestId"))[0];
        Integer studentRequestId = Integer.parseInt(stuRequestId);
        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        StudentRequest studentRequest = studentRequestService.oneStudentRequest(studentRequestId);
        ActionContext.getContext().put("studentRequest",studentRequest);
        return SUCCESS;
    }

    public String modify(){
        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        StudentRequest studentRequest =  studentRequestService.oneStudentRequest(request_id);
        studentRequestService.modifyStudentRequest(studentRequest,student_first_choice,student_second_choice);
        return SUCCESS;
    }

    public String initAdd(){
        return SUCCESS;
    }

    public String add(){
        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        if(studentRequestService.getStudentInfo(student_id)){
            studentRequestService.addStudent(student_id, student_name, student_academy, student_major, student_phone);
            studentRequestService.addStudentRequest(student_first_choice, student_second_choice);
            return SUCCESS;
        }
        return ERROR;
    }

    public String list(){
        StudentRequestService studentRequestService = new StudentRequestServiceImpl() ;
        ArrayList<StudentRequest> studentRequests = studentRequestService.studentRequestList() ;
        ActionContext.getContext().put("requests",studentRequests);
        return SUCCESS ;
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_academy() {
        return student_academy;
    }

    public void setStudent_academy(String student_academy) {
        this.student_academy = student_academy;
    }

    public String getStudent_major() {
        return student_major;
    }

    public void setStudent_major(String student_major) {
        this.student_major = student_major;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_first_choice() {
        return student_first_choice;
    }

    public void setStudent_first_choice(String student_first_choice) {
        this.student_first_choice = student_first_choice;
    }

    public String getStudent_second_choice() {
        return student_second_choice;
    }

    public void setStudent_second_choice(String student_second_choice) {
        this.student_second_choice = student_second_choice;
    }
}
