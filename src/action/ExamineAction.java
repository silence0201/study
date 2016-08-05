package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.Examine;
import entity.Monetary;
import entity.Student;
import service.ExamineService;
import service.impl.ExamineServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: ExamineAction
 * Author: silence
 * Update: silence(2016-06-30 07:57)
 */
public class ExamineAction extends ActionSupport{

    public String list(){
        ExamineService examineService = new ExamineServiceImpl() ;
        HashMap<Student,Double> examineCount = examineService.examineCount() ;
        ActionContext.getContext().put("examineCounts",examineCount);
        return SUCCESS ;
    }

    public String examinOfStudent(){
        Map pragram = ActionContext.getContext().getParameters() ;
        String studentID = ((String[]) pragram.get("studentID"))[0];
        ExamineService examineService = new ExamineServiceImpl() ;
        ArrayList<Examine> examines = examineService.examins(studentID) ;
        ActionContext.getContext().put("examines",examines);
        return SUCCESS ;
    }

    public String monetaries(){
        ExamineService examineService = new ExamineServiceImpl() ;
        HashMap<Student,Double> monetaries = examineService.needMonetary() ;
        ActionContext.getContext().put("monetaries",monetaries);
        return SUCCESS ;
    }

    public String setleMonetary(){
        ExamineService examineService = new ExamineServiceImpl() ;
        examineService.settlet() ;
        return SUCCESS ;
    }

    public String studentMonInfo(){
        Map pragram = ActionContext.getContext().getParameters() ;
        String studentID = ((String[]) pragram.get("studentID"))[0];
        ExamineService examineService = new ExamineServiceImpl() ;
        ArrayList<Monetary> monetaries = examineService.studentMonetary(studentID) ;
        ActionContext.getContext().put("monetaries",monetaries);
        return SUCCESS ;
    }
}
