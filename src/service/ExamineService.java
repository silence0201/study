package service;

import entity.Examine;
import entity.Monetary;
import entity.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: ExamineService
 * Author: silence
 * Update: silence(2016-06-30 08:01)
 */
public interface ExamineService {
    public abstract HashMap<Student,Double> examineCount() ;
    public abstract ArrayList<Examine> examins(String studentID) ;
    public abstract HashMap<Student,Double> needMonetary() ;
    public abstract boolean settlet() ;
    public abstract ArrayList<Monetary> studentMonetary(String studentID) ;
}
