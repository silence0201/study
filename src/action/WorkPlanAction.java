package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.StudentRequest;
import entity.StudentWork;
import entity.Work;
import service.StudentRequestService;
import service.WorkPlanService;
import service.impl.StudentRequestServiceImpl;
import service.impl.WorkPlanServiceImpl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;

/**
 * Description: WorkPlanAction
 * Author: silence
 * Update: silence(2016-06-30 07:58)
 */
public class WorkPlanAction extends ActionSupport {
    private Integer[] student_work_ids;
    private Double[] work_hours;
    private Integer work_id;
    private String work_place;
    private String work_title;
    private Integer work_person_num;
    private Double work_salary;
    private Double work_hour;
    private String start_time;
    private String end_time;

    public String workExamine(){
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        workPlanService.addWorkExamine(this.work_hours, this.student_work_ids);
        return SUCCESS;
    }

    public String initWorkExamine(){
        Map pragarm = ActionContext.getContext().getParameters();
        String wId = ((String[])pragarm.get("workId"))[0];
        Integer workId = Integer.parseInt(wId);
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(workId);
        ActionContext.getContext().put("work",work);

        //
        ArrayList<StudentWork> studentWorks = workPlanService.distributionInfo(workId);
        ActionContext.getContext().put("studentWorks",studentWorks);
        return SUCCESS;
    }

    public String initDistribution(){
        Map pragarm = ActionContext.getContext().getParameters();
        String wId = ((String[])pragarm.get("workId"))[0];
        Integer workId = Integer.parseInt(wId);
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(workId);
        ActionContext.getContext().put("work",work);

        StudentRequestService studentRequestService = new StudentRequestServiceImpl();
        ArrayList<StudentRequest> studentRequests = studentRequestService.workRequests(work.getWorkPlace());
        ActionContext.getContext().put("studentRequests",studentRequests);
        return SUCCESS;
    }

    public String distribution(){
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(work_id);
        workPlanService.distribution(work);
        return SUCCESS;
    }

    public String distributionInfo(){
        Map pragarm = ActionContext.getContext().getParameters();
        String wId = ((String[])pragarm.get("workId"))[0];
        Integer workId = Integer.parseInt(wId);
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        ArrayList<StudentWork> workDistributionInfo = workPlanService.distributionInfo(workId);
        ActionContext.getContext().put("distributionInfo",workDistributionInfo);

        Work work = workPlanService.oneWork(workId);
        ActionContext.getContext().put("work",work);
        return SUCCESS;
    }

    public String delete(){
        Map pragarm = ActionContext.getContext().getParameters();
        String wId = ((String[])pragarm.get("workId"))[0];
        Integer workId = Integer.parseInt(wId);
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(workId);
        workPlanService.deleteWork(work);
        return SUCCESS;
    }

    public String initModify(){
        Map pragarm = ActionContext.getContext().getParameters();
        String wId = ((String[])pragarm.get("workId"))[0];
        Integer workId = Integer.parseInt(wId);
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(workId);
        ActionContext.getContext().put("work",work);
        return SUCCESS;
    }

    public String modify(){
        this.start_time = this.start_time + ":00";
        this.end_time = this.end_time + ":00";
        String[] startT = start_time.split(":");
        String[] endT = end_time.split(":");
        Time sT = new Time(Integer.parseInt(startT[0]),Integer.parseInt(startT[1]),Integer.parseInt(startT[2]));
        Time eT = new Time(Integer.parseInt(endT[0]),Integer.parseInt(endT[1]),Integer.parseInt(endT[2]));
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        Work work = workPlanService.oneWork(work_id);
        workPlanService.modifyWork(work, work_place, work_title, work_person_num, work_salary, work_hour, sT, eT);
        return SUCCESS;
    }

    public  String initAdd(){
        return SUCCESS ;
    }
    public String add(){
        this.start_time = this.start_time + ":00";
        this.end_time = this.end_time + ":00";
        String[] startT = start_time.split(":");
        String[] endT = end_time.split(":");
        Time sT = new Time(Integer.parseInt(startT[0]),Integer.parseInt(startT[1]),Integer.parseInt(startT[2]));
        Time eT = new Time(Integer.parseInt(endT[0]),Integer.parseInt(endT[1]),Integer.parseInt(endT[2]));
        WorkPlanService workPlanService = new WorkPlanServiceImpl();
        workPlanService.addWork(work_place, work_title, work_person_num, work_salary, work_hour, sT, eT);
        return SUCCESS;
    }

    public String list(){
        WorkPlanService workPlanService = new WorkPlanServiceImpl() ;
        ArrayList<Work> works = workPlanService.workList() ;
        ActionContext.getContext().put("works",works);
        return SUCCESS ;
    }

    public Integer[] getStudent_work_ids() {
        return student_work_ids;
    }

    public void setStudent_work_ids(Integer[] student_work_ids) {
        this.student_work_ids = student_work_ids;
    }

    public Double[] getWork_hours() {
        return work_hours;
    }

    public void setWork_hours(Double[] work_hours) {
        this.work_hours = work_hours;
    }

    public Integer getWork_id() {
        return work_id;
    }

    public void setWork_id(Integer work_id) {
        this.work_id = work_id;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getWork_title() {
        return work_title;
    }

    public void setWork_title(String work_title) {
        this.work_title = work_title;
    }

    public Integer getWork_person_num() {
        return work_person_num;
    }

    public void setWork_person_num(Integer work_person_num) {
        this.work_person_num = work_person_num;
    }

    public Double getWork_salary() {
        return work_salary;
    }

    public void setWork_salary(Double work_salary) {
        this.work_salary = work_salary;
    }

    public Double getWork_hour() {
        return work_hour;
    }

    public void setWork_hour(Double work_hour) {
        this.work_hour = work_hour;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
