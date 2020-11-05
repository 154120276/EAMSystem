package cn.zcj.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("loginMapper")
public interface LoginMapper {
    @Select("select password from user where username=#{username}")
    public String findinuser(String username);


}
