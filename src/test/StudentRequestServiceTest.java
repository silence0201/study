package test;

import action.StudentRequestAction;
import service.StudentRequestService;
import service.impl.StudentRequestServiceImpl;

/**
 * Created by 孙瑜 on 2016/7/2.
 */
public class StudentRequestServiceTest {
    public static void main(String[] args){
        StudentRequestService srs = new StudentRequestServiceImpl();
        if(srs.getStudentInfo(1234567)){
            srs.addStudent(1234567,"1234","计算机","软工","13832329438");
            srs.addStudentRequest("第一食堂","图书馆");
        }else{
            System.out.println("111111");
        }
    }
}
