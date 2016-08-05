package test;

import entity.Work;
import service.WorkPlanService;
import service.impl.WorkPlanServiceImpl;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by 孙瑜 on 2016/7/2.
 */
public class WorkAddServiceTest {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        String workMonth = "0" + (cal.get(Calendar.MONTH) + 1);
        System.out.print(workMonth);
    }
}
