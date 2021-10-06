package cn.zcj.Service.impl;

import cn.zcj.Mapper.ClassMapper;
import cn.zcj.Mapper.LoginMapper;
import cn.zcj.Mapper.StudentMapper;
import cn.zcj.Service.UserService;
import cn.zcj.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private StudentMapper studentMapper;

    /*
        登录管理员方法
     */
    @Override
    public boolean loginuser(String username, String password) {
        if (password.equals(loginMapper.findinuser(username))) {
            return true;
        }

        return false;
    }

    /*
        登录教师方法
     */
    @Override
    public boolean loginteacher(String username, String password) {
        if (password.equals(loginMapper.findinteacher(username))) {
            return true;
        }

        return false;
    }

    @Override
    public boolean loginstudent(String username, String password) {
        if (password.equals(loginMapper.findinstudent(username))) {
            return true;
        }
        return false;
    }

    /*
        tid获取
     */
    @Override
    public int getTid(String user) {
        return studentMapper.findTid(user);
    }

    /*
        体侧查询
     */
    @Override
    public PEScores findPEScores(int tid) {
        return studentMapper.findPEScores(tid);
    }

    /*
        返回所有课程
     */
    @Override
    public List<course> findCoures(int sno, int dayofweek) {

        if (dayofweek != 0) {
            return studentMapper.findcourses2(sno, dayofweek);
        } else {
            return studentMapper.findcourses(sno);
        }
    }

    @Override
    public int findSno(String user) {
        return studentMapper.findSno(user);
    }

    @Override
    public int getsidbyuser(String user) {
        return studentMapper.findgidbyuser(user);
    }

    @Override
    public List<grade> getgrades(int gid) {
        return studentMapper.findgrades(gid);
    }

    @Override
    public List<announcement> getAnnouncement(int sno) {
        return classMapper.selectAnnouncement(sno);
    }

    @Override
    public List<examination> getexamination(int sid) {
        return studentMapper.findexamination(sid);
    }


    /*
     返回所有班级
     */
    @Override
    public List<BanJi> findALLClass() {
        return loginMapper.findBanji();
    }
    /*
     根据sno删除班级
     */

    @Override
    public void classDelete(int sno) {
        classMapper.classDelete(sno);
    }

    /*

        返回所有老师
     */
    @Override
    public List<classteacher> findteachers() {
        return classMapper.findteachers();
    }

    /*
        添加班级

     */
    @Override
    public void addClass(String name, int id) {
        classMapper.addclass(name, id);
    }

    /*
        模糊查询班级

     */
    @Override
    public List<BanJi> selectclass(String classname) {
        classname = "%" + classname + "%";
        return classMapper.selectclass(classname);


    }

    /*
    修改班级老师
    */
    @Override
    public void userUpdate(int sno, int teacherid) {
        classMapper.userUpdate(sno, teacherid);
    }


    /*
        查询所有学生方法
     */
    @Override
    public List<Student> findStudents(String name) {
        return studentMapper.findStudent(name);
    }

    @Override
    public List<Student> findTStudents(int Sno, String name) {
        return studentMapper.findTStudent(Sno, name);
    }

    @Override
    public List<BanJi> findclass() {
        return studentMapper.findclass();
    }

    /*
        根据id找学生
     */
    @Override
    public Student findStudent(int id) {
        return studentMapper.findstudentbyid(id);
    }

    /*
        更新学生
     */
    @Override
    public void StudentUpdate(Student student) {
        studentMapper.StudentUpdate(student);
    }

}
