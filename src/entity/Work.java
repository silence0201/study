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
import javax.persistence.OneToMany;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

/**
 * Description: Work
 * Author: silence
 * Update: silence(2016-06-29 14:52)
 */
@Entity
public class Work {
    private Integer workId;  //工作的编号
    private String workPlace;  //工作的地点
    private String workTitle;  //工作标题
    private int workPersonNum; //工作需要的人数
    private double workHour;  //工作最短工时
    private double workSalary;  //工作的时薪
    private Time startTime;  //工作的时间段开始时间
    private Time endTime;  //工作的时间段结束时间
    private Date addTime;  //工作的添加时间
    private String workState;  //工作的状态


    @Id
    @Column(name = "work_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    @Basic
    @Column(name = "work_place")
    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Basic
    @Column(name = "work_title")
    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    @Basic
    @Column(name = "work_person_num")
    public int getWorkPersonNum() {
        return workPersonNum;
    }

    public void setWorkPersonNum(int workPersonNum) {
        this.workPersonNum = workPersonNum;
    }

    @Basic
    @Column(name = "work_hour")
    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    @Basic
    @Column(name = "work_salary")
    public double getWorkSalary() {
        return workSalary;
    }

    public void setWorkSalary(double workSalary) {
        this.workSalary = workSalary;
    }

    @Basic
    @Column(name = "start_time")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
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
    @Column(name = "work_state")
    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Work)) return false;
        Work work = (Work) o;
        return getWorkPersonNum() == work.getWorkPersonNum() &&
                Double.compare(work.getWorkHour(), getWorkHour()) == 0 &&
                Double.compare(work.getWorkSalary(), getWorkSalary()) == 0 &&
                Objects.equals(getWorkId(), work.getWorkId()) &&
                Objects.equals(getWorkPlace(), work.getWorkPlace()) &&
                Objects.equals(getWorkTitle(), work.getWorkTitle()) &&
                Objects.equals(getStartTime(), work.getStartTime()) &&
                Objects.equals(getEndTime(), work.getEndTime()) &&
                Objects.equals(getAddTime(), work.getAddTime()) &&
                Objects.equals(getWorkState(), work.getWorkState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkId(), getWorkPlace(), getWorkTitle(), getWorkPersonNum(), getWorkHour(), getWorkSalary(), getStartTime(), getEndTime(), getAddTime(), getWorkState());
    }

    @Override
    public String toString() {
        return "Work{" +
                "addTime=" + addTime +
                ", workId=" + workId +
                ", workPlace='" + workPlace + '\'' +
                ", workTitle='" + workTitle + '\'' +
                ", workPersonNum=" + workPersonNum +
                ", workHour=" + workHour +
                ", workSalary=" + workSalary +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", workState='" + workState + '\'' +
                '}';
    }
}
