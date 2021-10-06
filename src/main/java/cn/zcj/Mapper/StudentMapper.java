package cn.zcj.Mapper;

import cn.zcj.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentMapper")
public interface StudentMapper {
    @Select("select classname from class where Sno=#{Sno}")
    public String findclassname(int Sno);

    @Select("select * from student where name like #{name}")
    @Results({
            @Result(id = true, column = "id", property = "id"),//id=true表示为主键
            @Result(column = "Sno", property = "Sno"),
            @Result(
                    property = "classname",//要封装的属性名称
                    column = "Sno",//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findclassname")
            ),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phonenumber", property = "phonenumber"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "tid", property = "tid")
    })
    public List<Student> findStudent(String name);

    @Select("select * from student where Sno=#{Sno} and name like#{name}")
    @Results({
            @Result(id = true, column = "id", property = "id"),//id=true表示为主键
            @Result(column = "Sno", property = "Sno"),
            @Result(
                    property = "classname",//要封装的属性名称
                    column = "Sno",//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findclassname")
            ),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phonenumber", property = "phonenumber"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "tid", property = "tid")
    })
    public List<Student> findTStudent(int Sno, String name);

    @Select("select Sno,classname from class")
    public List<BanJi> findclass();

    @Select("select * from student where id=#{id}")
    public Student findstudentbyid(int id);

    @Update("update student set Sno=#{Sno},name=#{name},phonenumber=#{phonenumber},username=#{username},password=#{password} where id=#{id}")
    public void StudentUpdate(Student student);

    @Select("select tid from student where username=#{user}")
    int findTid(String user);

    @Select("select * from bodysidescore where id=#{tid}")
    public PEScores findPEScores(int tid);

    @Select("select * from course where sno=#{sno}")
    @Results({
            @Result(id = true, column = "id", property = "id"),//id=true表示为主键
            @Result(column = "Cno", property = "Cno"),
            @Result(
                    property = "name",//要封装的属性名称
                    column = "Cno",//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findcoursename")
            ),
            @Result(column = "dayofweek", property = "dayofweek"),
            @Result(column = "timeofday", property = "timeofday"),
            @Result(column = "phonenumber", property = "phonenumber"),
            @Result(column = "place", property = "place"),
            @Result(column = "teacher", property = "teacher"),
    })
    public List<course> findcourses(int sno);

    @Select("select name from courses where Cno=#{Cno}")
    public String findcoursename(int Cno);

    @Select("select Sno from student where username=#{username}")
    public int findSno(String username);

    @Select("select * from course where dayofweek=#{dayofweek} and sno=#{sno}")
    @Results({
            @Result(id = true, column = "id", property = "id"),//id=true表示为主键
            @Result(column = "Cno", property = "Cno"),
            @Result(
                    property = "name",//要封装的属性名称
                    column = "Cno",//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findcoursename")
            ),
            @Result(column = "dayofweek", property = "dayofweek"),
            @Result(column = "timeofday", property = "timeofday"),
            @Result(column = "phonenumber", property = "phonenumber"),
            @Result(column = "place", property = "place"),
            @Result(column = "teacher", property = "teacher"),
    })
    public List<course> findcourses2(int sno, int dayofweek);

    @Select("select id from student where username=#{username}")
    public int findgidbyuser(String username);

    @Select("select * from grades where sid=#{id}")
    @Results({
            @Result(id = true,column = "id", property = "id"),//id=true表示为主键
            @Result(column = "cno", property = "cno"),
            @Result(
                    property = "name",//要封装的属性名称
                    column ="cno" ,//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findcoursename")
            ),
            @Result(column = "sid", property = "sid"),
            @Result(column = "grade", property = "grade"),
            @Result(column = "updateby", property = "updateby"),

    })
    public List<grade> findgrades(int id);


    @Select("select * from student where id = #{id}")
    public Student findStudentById(Integer id);

    @Update("update student set name=#{student.name},sex=#{student.sex}, " +
            "phonenumber=#{student.phonenumber}, " +
            "username=#{student.username},password=#{student.password} where id=#{id}")
    public boolean updateTeacherById(Integer id, Student student);

    @Select("select id from student where username=#{user}")
    int findidbyuser(String user);

    @Select("select * from examination where sid=#{id}")
    List<examination> findexamination(int id);
}

