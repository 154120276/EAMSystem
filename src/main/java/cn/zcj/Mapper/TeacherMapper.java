package cn.zcj.Mapper;

import cn.zcj.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherMapper")
public interface TeacherMapper {
    @Select("select id from teacher where username=#{username}")
    public int findteacherid(String username);

    @Select("select Sno from class where teacherid=#{id}")
    public int findclassSno(int id);


    @Select("select * from teacher where name = #{name}")
    public List<Teacher> findTeacherByPageServlet(String name);

    @Select("select * from teacher")
    public List<Teacher> findAllTeacher();

    @Delete("delete from teacher where id =#{id}")
    public boolean deleteTeacherById(Integer id);


    @Update("update teacher set name=#{teacher.name},sex=#{teacher.sex}, " +
            "phonenumber=#{teacher.phonenumber},email=#{teacher.email}, " +
            "username=#{teacher.username},password=#{teacher.password} where id=#{id}")
    public boolean updateTeacherById(Integer id, Teacher teacher);

    @Insert("insert into teacher(name,sex,phonenumber,email,username,password)values(#{name},#{sex}," +
            "#{phonenumber},#{email},#{username},#{password})")
    public boolean addTeacher(Teacher teacher);

    @Insert("insert into courses(name,credits)values(#{courseName},#{credits})")
    public boolean addCourse(String courseName, float credits);

    @Select("select count(*) from courses where name=#{courseName}")
    public int selectCourse(String courseName);
}
