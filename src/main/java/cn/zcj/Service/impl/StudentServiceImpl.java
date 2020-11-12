package cn.zcj.Service.impl;

import cn.zcj.Mapper.StudentMapper;
import cn.zcj.Service.StudentService;
import cn.zcj.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("studentService")
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudentById(Integer id) {
        Student student = studentMapper.findStudentById(id);
        return student;
    }


    @Override
    public boolean updateStudentById(Integer id,Student student) {
        studentMapper.updateTeacherById(id,student);
        return true;
    }

    @Override
    public int getidbyusername(String user) {
        return studentMapper.findidbyuser(user);
    }


}
