package service.impl;

import dao.ExamineDao;
import dao.StudentWorkDao;
import dao.WorkDao;
import dao.impl.ExamineDaoImpl;
import dao.impl.StudentWorkDaoImpl;
import dao.impl.WorkDaoImpl;
import entity.Examine;
import entity.StudentWork;
import entity.Work;
import service.WorkPlanService;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by 孙瑜 on 2016/7/1.
 */
public class WorkPlanServiceImpl implements WorkPlanService{
    private Work work;
    private Date addTime;


    public void addWork(String work_palce, String work_title, Integer work_person_num, Double work_salary,
                        Double work_hour, Time start_time, Time end_time){
        this.work = new Work();
        this.addTime = new Date(System.currentTimeMillis());

        this.work.setWorkPlace(work_palce);
        this.work.setWorkTitle(work_title);
        this.work.setWorkPersonNum(work_person_num);
        this.work.setWorkSalary(work_salary);
        this.work.setWorkHour(work_hour);
        this.work.setStartTime(start_time);
        this.work.setEndTime(end_time);
        this.work.setAddTime(this.addTime);
        this.work.setWorkState("空");

        WorkDao workDao = new WorkDaoImpl();
        workDao.add(this.work);
    }

    @Override
    public ArrayList<Work> workList() {
        WorkDao workDao = new WorkDaoImpl() ;
        ArrayList<Work> works = workDao.works() ;
        return works;
    }

    @Override
    public Work oneWork(Integer work_id) {
        WorkDao workDao = new WorkDaoImpl();
        Work oneWork = workDao.getByID(work_id);
        return oneWork;
    }

    public boolean modifyWork(Work work, String work_palce, String work_title, Integer work_person_num, Double work_salary,
                              Double work_hour, Time start_time, Time end_time){
        this.work = work;

        this.work.setWorkPlace(work_palce);
        this.work.setWorkTitle(work_title);
        this.work.setWorkPersonNum(work_person_num);
        this.work.setWorkSalary(work_salary);
        this.work.setWorkHour(work_hour);
        this.work.setStartTime(start_time);
        this.work.setEndTime(end_time);

        WorkDao workDao = new WorkDaoImpl();

        return workDao.modify(this.work);
    }

    public boolean deleteWork(Work work){
        WorkDao workDao = new WorkDaoImpl();
        return workDao.del(work);
    }

    public ArrayList<StudentWork> distributionInfo(Integer work_id){
        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl();
        return studentWorkDao.students(work_id);
    }

    public boolean distribution(Work work){
        WorkDao workDao = new WorkDaoImpl();
        return workDao.distribution(work);
    }

    public boolean addWorkExamine(Double[] student_hours, Integer[] student_work_ids){
        Date workTime = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        String workMonth = "" + (cal.get(Calendar.MONTH) + 1);

        StudentWorkDao studentWorkDao = new StudentWorkDaoImpl();

        ExamineDao examineDao = new ExamineDaoImpl();
        for(int i = 0; i < student_hours.length; i++){
            Examine examine = new Examine();

            examine.setStudentWork(studentWorkDao.getByID(student_work_ids[i]));
            examine.setExamineHour(student_hours[i]);
            examine.setWorkTime(workTime);
            examine.setMonth(workMonth);
            examine.setStatus("未结算");
            examineDao.add(examine);
        }
        return true;
    }
}
