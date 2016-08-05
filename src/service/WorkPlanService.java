package service;

import entity.StudentWork;
import entity.Work;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Description: WorkPlanService
 * Author: silence
 * Update: silence(2016-06-30 08:02)
 */
public interface WorkPlanService {
    public void addWork(String work_palce, String work_title, Integer work_person_num, Double work_salary,
                        Double work_hour, Time start_time, Time end_time) ;
    public ArrayList<Work> workList() ;

    public Work oneWork(Integer work_id);

    public boolean modifyWork(Work work,String work_palce, String work_title, Integer work_person_num, Double work_salary,
                              Double work_hour, Time start_time, Time end_time);
    public boolean deleteWork(Work work);

    public abstract ArrayList<StudentWork> distributionInfo(Integer work_id);

    public abstract boolean distribution(Work work);

    public boolean addWorkExamine(Double[] student_hours, Integer[] student_work_ids);
}
