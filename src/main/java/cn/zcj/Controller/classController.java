package cn.zcj.Controller;

import cn.zcj.Service.UserService;
import cn.zcj.domain.BanJi;
import cn.zcj.domain.announcement;
import cn.zcj.domain.classteacher;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value = "班级接口")
@RestController
public class classController {
    @Autowired
    private UserService userService;

    @RequestMapping("class")
    public ModelAndView showclasslist() {
        ModelAndView modelAndView = new ModelAndView();
        //查询出所有班级的列表
        List<BanJi> allClass = userService.findALLClass();
        modelAndView.addObject("classes", allClass);
        modelAndView.setViewName("/admin/index/classlist.jsp");
        return modelAndView;
    }

    @RequestMapping("teachers")
    public ModelAndView findteachers() {
        ModelAndView modelAndView = new ModelAndView();
        List<classteacher> findteachers = userService.findteachers();
        modelAndView.addObject("classteachers", findteachers);
        modelAndView.setViewName("/admin/index/add_class.jsp");
        return modelAndView;
    }

    @RequestMapping("deleteone")
    public ModelAndView deleteone(int sno) {
        ModelAndView modelAndView = new ModelAndView();
        userService.classDelete(sno);
        modelAndView.setViewName("class");
        return modelAndView;
    }

    @RequestMapping("deleteall")
    public ModelAndView deleteAll(String[] uid) {
        ModelAndView modelAndView = new ModelAndView();
        for (String id : uid) {
            //删除
            userService.classDelete(Integer.parseInt(id));
        }
        modelAndView.setViewName("class");
        return modelAndView;
    }

    @RequestMapping("addClass")
    public ModelAndView addClass(String name, int teacherid) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name + "--------------" + teacherid);
        userService.addClass(name, teacherid);
        modelAndView.setViewName("class");
        return modelAndView;
    }

    @RequestMapping("selectclass")
    public ModelAndView selectclass(String name) {
        ModelAndView modelAndView = new ModelAndView();
        List<BanJi> selectclass = userService.selectclass(name);
        modelAndView.addObject("classes", selectclass);
        modelAndView.setViewName("/admin/index/classlist.jsp");
        return modelAndView;
    }

    @RequestMapping("updateclassjsp")
    public ModelAndView updateclassjsp(int Sno) {
        ModelAndView modelAndView = new ModelAndView();
        List<classteacher> findteachers = userService.findteachers();
        modelAndView.addObject("Sno", Sno);
        modelAndView.addObject("classteachers", findteachers);
        modelAndView.setViewName("/admin/index/update_class.jsp");
        return modelAndView;
    }

    @RequestMapping("updateclass")
    public ModelAndView updateclass(int Sno, int teacherid) {
        ModelAndView modelAndView = new ModelAndView();
        userService.userUpdate(Sno, teacherid);
        modelAndView.setViewName("class");
        return modelAndView;
    }


}
