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
 * Description: StudentWork
 * Author: silence
 * Update: silence(2016-06-29 14:58)
 */
@Entity
@Table(name = "student_work", schema = "study")
public class StudentWork {
    private int studentWorkId;  //工作安排编号
    private Date startTime;  //工作安排开始的时间

    private Student student ;  //工作安排的学生
    private Work work ;  //工作安排的工作
//    private List<Monetary> monetarys ;  //工作的酬金
//    private List<Examine> examines ;  //工作的考核

    @Id
    @Column(name = "student_work_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getStudentWorkId() {
        return studentWorkId;
    }

    public void setStudentWorkId(int studentWorkId) {
        this.studentWorkId = studentWorkId;
    }

    @Basic
    @Column(name = "start_time")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "work_id")
    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentWork)) return false;
        StudentWork that = (StudentWork) o;
        return getStudentWorkId() == that.getStudentWorkId() &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getStudent(), that.getStudent()) &&
                Objects.equals(getWork(), that.getWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentWorkId(), getStartTime(), getStudent(), getWork());
    }

    @Override
    public String toString() {
        return "StudentWork{" +
                "startTime=" + startTime +
                ", studentWorkId=" + studentWorkId +
                ", student=" + student +
                ", work=" + work +
                '}';
    }
}
