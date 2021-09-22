package cn.zcj.Service;

import cn.zcj.domain.*;

import java.util.List;

public interface UserService {


    public boolean loginuser(String usernmae,String password);

    public List<BanJi> findALLClass();

    public void classDelete(int sno);

    public List<classteacher> findteachers();

    public void addClass(String name,int id);

    public List<BanJi> selectclass(String classname);

    public void userUpdate(int sno,int teacherid);

    public List<Student> findStudents(String name);

    public List<Student> findTStudents(int Sno,String name);

    List<BanJi> findclass();

    Student findStudent(int id);

    void StudentUpdate(Student student);

    boolean loginteacher(String username, String password);

    boolean loginstudent(String username, String password);

    int getTid(String user);

    PEScores findPEScores(int tid);

    List<course> findCoures(int sno,int dayofweek);

    int findSno(String user);

    int getsidbyuser(String user);

    List<grade> getgrades(int gid);
}
