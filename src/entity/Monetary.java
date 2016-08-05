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
import java.sql.Date;
import java.util.Objects;

/**
 * Description: Monetary
 * Author: silence
 * Update: silence(2016-06-29 15:00)
 */
@Entity
public class Monetary {
    private Integer monetaryId;
    private String monetaryMonth;
    private Date settleTime;
    private double salary;

    private StudentWork studentWork ;

    @Id
    @Column(name = "monetary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMonetaryId() {
        return monetaryId;
    }

    public void setMonetaryId(Integer monetaryId) {
        this.monetaryId = monetaryId;
    }

    @Basic
    @Column(name = "monetary_month")
    public String getMonetaryMonth() {
        return monetaryMonth;
    }

    public void setMonetaryMonth(String monetaryMonth) {
        this.monetaryMonth = monetaryMonth;
    }

    @Basic
    @Column(name = "settle_time")
    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    @Basic
    @Column(name = "salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_work_id")
    public StudentWork getStudentWork() {
        return studentWork;
    }

    public void setStudentWork(StudentWork studentWork) {
        this.studentWork = studentWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monetary)) return false;
        Monetary monetary = (Monetary) o;
        return Double.compare(monetary.getSalary(), getSalary()) == 0 &&
                Objects.equals(getMonetaryId(), monetary.getMonetaryId()) &&
                Objects.equals(getMonetaryMonth(), monetary.getMonetaryMonth()) &&
                Objects.equals(getSettleTime(), monetary.getSettleTime()) &&
                Objects.equals(getStudentWork(), monetary.getStudentWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonetaryId(), getMonetaryMonth(), getSettleTime(), getSalary(), getStudentWork());
    }

    @Override
    public String toString() {
        return "Monetary{" +
                "monetaryId=" + monetaryId +
                ", monetaryMonth='" + monetaryMonth + '\'' +
                ", settleTime=" + settleTime +
                ", salary=" + salary +
                ", studentWork=" + studentWork +
                '}';
    }
}
