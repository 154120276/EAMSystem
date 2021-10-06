package cn.zcj.Service;

import cn.zcj.domain.Student;
import cn.zcj.domain.announcement;

import java.util.List;

public interface StudentService {

    Student findStudentById(Integer id);

    boolean updateStudentById(Integer id, Student student);

    int getidbyusername(String user);


}
