package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


/**
 * Description: Student
 * Author: silence
 * Update: silence(2016-06-29 14:56)
 */
@Entity
public class Student {
    private Integer studentId;   //学生的学号
    private String studentName;  //学生的姓名
    private String studentAcademy;  //学生的学院
    private String studentMajor;  //学生的专业
    private String studentPhone;  //学生的电话


    @Id
    @Column(name = "student_id")
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "student_academy")
    public String getStudentAcademy() {
        return studentAcademy;
    }

    public void setStudentAcademy(String studentAcademy) {
        this.studentAcademy = studentAcademy;
    }

    @Basic
    @Column(name = "student_major")
    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    @Basic
    @Column(name = "student_phone")
    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getStudentId(), student.getStudentId()) &&
                Objects.equals(getStudentName(), student.getStudentName()) &&
                Objects.equals(getStudentAcademy(), student.getStudentAcademy()) &&
                Objects.equals(getStudentMajor(), student.getStudentMajor()) &&
                Objects.equals(getStudentPhone(), student.getStudentPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getStudentName(), getStudentAcademy(), getStudentMajor(), getStudentPhone());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentAcademy='" + studentAcademy + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                '}';
    }
}
