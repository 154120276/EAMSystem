package cn.zcj.Service.impl;

import cn.zcj.Mapper.TeacherMapper;
import cn.zcj.Service.TeacherService;
import cn.zcj.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int findteacherid(String username) {
        return teacherMapper.findteacherid(username);
    }

    @Override
    public int findclassSno(int teacherid) {
        return teacherMapper.findclassSno(teacherid);
    }


    @Override
    public List<Teacher> findTeacherByPageServlet(String name) {
        return teacherMapper.findTeacherByPageServlet(name);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherMapper.findAllTeacher();
    }

    @Override
    public boolean deleteTeacherById(Integer id) {
        teacherMapper.deleteTeacherById(id);
        return true;
    }

    @Override
    public boolean updateTeacherById(Integer id, Teacher teacher) {
        teacherMapper.updateTeacherById(id, teacher);
        return true;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
        return true;
    }

    @Override
    public boolean addCourse(String courseName, float credits) {
        if (teacherMapper.selectCourse(courseName) == 0) {
            teacherMapper.addCourse(courseName, credits);
            return true;
        }
        return false;
    }

    @Override
    public int getidbyusername(String user) {
        return teacherMapper.findteacherid(user);
    }
}
