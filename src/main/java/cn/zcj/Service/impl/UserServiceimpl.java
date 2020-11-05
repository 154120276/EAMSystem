package cn.zcj.Service.impl;

import cn.zcj.Mapper.LoginMapper;
import cn.zcj.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private LoginMapper loginMapper;


    @Override
    public boolean login(String username, String password, String tpye) {
        if (tpye.equals("root")) {
              if (password.equals(loginMapper.findinuser(username))){
                  return true;
              }
        }
        return false;
    }
}
