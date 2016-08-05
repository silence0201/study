package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

/**
 * Description: StudentRequest
 * Author: silence
 * Update: silence(2016-06-29 14:57)
 */
@Entity
@Table(name = "student_request", schema = "study")
public class StudentRequest {
    private int requestId;
    private String studentFirstChoice;
    private String studenSecondChoice;
    private Date addTime;
    private String requestStatus ;
//    private StudentWork studentWork ;
    private Student student ;  //申请人

    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    @Basic
    @Column(name = "student_first_choice")
    public String getStudentFirstChoice() {
        return studentFirstChoice;
    }

    public void setStudentFirstChoice(String studentFirstChoice) {
        this.studentFirstChoice = studentFirstChoice;
    }

    @Basic
    @Column(name = "studen_second_choice")
    public String getStudenSecondChoice() {
        return studenSecondChoice;
    }

    public void setStudenSecondChoice(String studenSecondChoice) {
        this.studenSecondChoice = studenSecondChoice;
    }

    @Basic
    @Column(name = "add_time")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "request_status")
    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_work_id")
//    public StudentWork getStudentWork() {
//        return studentWork;
//    }
//
//    public void setStudentWork(StudentWork studentWork) {
//        this.studentWork = studentWork;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentRequest)) return false;
        StudentRequest that = (StudentRequest) o;
        return getRequestId() == that.getRequestId() &&
                Objects.equals(getStudentFirstChoice(), that.getStudentFirstChoice()) &&
                Objects.equals(getStudenSecondChoice(), that.getStudenSecondChoice()) &&
                Objects.equals(getAddTime(), that.getAddTime()) &&
                Objects.equals(getRequestStatus(), that.getRequestStatus()) &&
                Objects.equals(getStudent(), that.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getStudentFirstChoice(), getStudenSecondChoice(), getAddTime(), getRequestStatus(), getStudent());
    }

    @Override
    public String toString() {
        return "StudentRequest{" +
                "addTime=" + addTime +
                ", requestId=" + requestId +
                ", studentFirstChoice='" + studentFirstChoice + '\'' +
                ", studenSecondChoice='" + studenSecondChoice + '\'' +
                ", requestStatus='" + requestStatus + '\'' +
                ", student=" + student +
                '}';
    }
}
