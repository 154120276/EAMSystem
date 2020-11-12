package cn.zcj.Mapper;

import cn.zcj.domain.BanJi;
import cn.zcj.domain.classteacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("classMapper")
public interface ClassMapper {
    @Delete("delete from class where Sno=#{Sno}")
    public void classDelete(int Sno);

    @Select("select id,name from teacher")
    public List<classteacher> findteachers();

    @Insert("INSERT INTO class(`classname`, `teacherid`) VALUES (#{name}, #{id})")
    public void addclass(String name,int id);

    @Select("select * from class where classname like #{classname}")
    @Results({
            @Result(id = true,column = "Sno", property = "Sno"),//id=true表示为主键
            @Result(column = "classname", property = "classname"),
            @Result(column = "teacherid", property = "teacherid"),
            @Result(
                    property = "teachername",//要封装的属性名称
                    column ="teacherid" ,//根据哪个字段去查询orders表的数据
                    javaType = String.class,//要封装的实体类型
                    //select 属性，代表查询哪个接口的方法获得数据
                    many = @Many(select = "cn.zcj.Mapper.LoginMapper.findteachername")
            )

    })
    public List<BanJi> selectclass(String classname);

    @Update("update class set teacherid=#{teacherid} where Sno=#{sno}")
    public void userUpdate(int sno,int teacherid);
}
