package entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.criteria.Fetch;
import java.sql.Date;
import java.util.Objects;

/**
 * Description: Examine
 * Author: silence
 * Update: silence(2016-06-29 15:01)
 */
@Entity
public class Examine {
    private Integer examineId;
    private double examineHour;
    private Date workTime;
    private String month ;
    private String status ;

    private StudentWork studentWork ;

    @Id
    @Column(name = "examine_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    @Basic
    @Column(name = "examine_hour")
    public double getExamineHour() {
        return examineHour;
    }

    public void setExamineHour(double examineHour) {
        this.examineHour = examineHour;
    }

    @Basic
    @Column(name = "work_time")
    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "examine_month")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_work_id")
    public StudentWork getStudentWork() {
        return studentWork;
    }

    public void setStudentWork(StudentWork studentWork) {
        this.studentWork = studentWork;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Examine)) return false;
        Examine examine = (Examine) o;
        return Double.compare(examine.getExamineHour(), getExamineHour()) == 0 &&
                Objects.equals(getExamineId(), examine.getExamineId()) &&
                Objects.equals(getWorkTime(), examine.getWorkTime()) &&
                Objects.equals(getMonth(), examine.getMonth()) &&
                Objects.equals(getStatus(), examine.getStatus()) &&
                Objects.equals(getStudentWork(), examine.getStudentWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExamineId(), getExamineHour(), getWorkTime(), getMonth(), getStatus(), getStudentWork());
    }

    @Override
    public String toString() {
        return "Examine{" +
                "examineHour=" + examineHour +
                ", examineId=" + examineId +
                ", workTime=" + workTime +
                ", month='" + month + '\'' +
                ", status='" + status + '\'' +
                ", studentWork=" + studentWork +
                '}';
    }
}
