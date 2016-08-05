package test;

import dao.WorkDao;
import dao.impl.WorkDaoImpl;
import entity.Work;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Description: WorkTest
 * Author: silence
 * Update: silence(2016-06-30 10:37)
 */
public class WorkTest {
    public static void main(String[] args) {
//        works();
//        modify();
//        del();
//        add();
//        distribution();
    }

    public static void getByID(){
        WorkDao workDao = new WorkDaoImpl() ;
        Work work = workDao.getByID(10001) ;
        System.out.println(work);
    }

    public static  void works(){
        WorkDao workDao = new WorkDaoImpl() ;
        ArrayList<Work> works = workDao.works() ;
        System.out.println(works);
    }

    public  static void modify(){
        WorkDao workDao = new WorkDaoImpl() ;
        Work work = workDao.getByID(10001) ;
        work.setAddTime(new Date(System.currentTimeMillis()));
        work.setWorkPlace("第二食堂");
        work.setEndTime(new Time(System.currentTimeMillis()));
        System.out.println(workDao.modify(work));
    }

    public static void del(){
        WorkDao workDao = new WorkDaoImpl() ;
        Work work = workDao.getByID(10000) ;
        System.out.println(workDao.del(work));
    }

    public static void add(){
        WorkDao workDao = new WorkDaoImpl() ;
        Work work = new Work() ;
        work.setStartTime(new Time(8,30,0));
        work.setEndTime(new Time(11,30,0));
        work.setWorkTitle("搽桌子");
        work.setWorkPlace("体育馆");
        work.setWorkState("空");
        work.setWorkPersonNum(10);
        work.setWorkHour(20);
        work.setWorkSalary(10);
        work.setAddTime(new Date(System.currentTimeMillis()));
        System.out.println(workDao.add(work) );

    }

    public static void distribution(){
        WorkDao workDao  = new WorkDaoImpl() ;
        Work work = workDao.getByID(10000);
        System.out.println(workDao.distribution(work));
    }
}
