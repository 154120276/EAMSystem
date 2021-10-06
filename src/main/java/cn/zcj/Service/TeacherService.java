package cn.zcj.Service;

import cn.zcj.domain.Teacher;

import java.util.List;

public interface TeacherService {

    int findteacherid(String username);

    int findclassSno(int teacherid);

    public List<Teacher> findTeacherByPageServlet(String name);

    public List<Teacher> findAllTeacher();

    public boolean deleteTeacherById(Integer id);

    public boolean updateTeacherById(Integer id, Teacher teacher);

    public boolean addTeacher(Teacher teacher);

    public boolean addCourse(String courseName, float credits);

    public int getidbyusername(String user);
}
