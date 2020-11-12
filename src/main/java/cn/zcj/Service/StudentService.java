package cn.zcj.Service;

import cn.zcj.domain.Student;

public interface StudentService {

    public Student findStudentById(Integer id);

    public boolean updateStudentById(Integer id, Student student);

    int getidbyusername(String user);
}
