package cn.zcj.Mapper;

import cn.zcj.domain.BanJi;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("loginMapper")
public interface LoginMapper {
    @Select("select password from user where username=#{username}")
    public String findinuser(String username);
    @Select("select password from teacher where username=#{username}")
    public String findinteacher(String username);

    @Select("select name from teacher where id=#{teacherid}")
    public String findteachername(int teacherid);

    @Select("select * from class")
    @Results({
            @Result(id = true,column = "Sno", property = "Sno"),//id=true表示为主键
            @Result(column = "classname", property = "classname"),
            @Result(column = "teacherid", property = "teacherid"),
            @Result(
                    property = "teachername",//要封装的属性名称
                    column ="teacherid" ,//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "findteachername")
            )

    })
    public List<BanJi> findBanji();

    @Select("select password from student where username=#{username}")
    String findinstudent(String username);
}
