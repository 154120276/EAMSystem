package cn.zcj.Controller;

import cn.zcj.Service.TeacherService;
import cn.zcj.domain.Student;
import cn.zcj.domain.Teacher;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Api(value = "教师相关接口")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @RequestMapping("/findTeacherByPageServlet")
    public void findTeacherByPageServlet(String name, HttpServletRequest req,HttpServletResponse rep) throws Exception{
        List<Teacher> teachers;
        if("".equals(name)||name==null)
            teachers = teacherService.findAllTeacher();
        else
            teachers = teacherService.findTeacherByPageServlet(name);

        String rows = req.getParameter("rows");
        if(rows==null||"".equals(rows))
            rows = "10";

        if(teachers.size()%Integer.parseInt(rows)!=0)
            req.setAttribute("totalPage",String.valueOf(teachers.size()/Integer.parseInt(rows) + 1));
        else
            req.setAttribute("totalPage",String.valueOf(teachers.size()/Integer.parseInt(rows)));

        String currentPage = req.getParameter("currentPage");
        if(currentPage==null||"".equals(currentPage)){
            currentPage = "1";
        }
        req.setAttribute("currentPage",currentPage);

        int rowsInteger = Integer.parseInt(rows);
        int currentPageInteger = Integer.parseInt(currentPage);
        int index = 0;
        List<Teacher> teacherPart = new ArrayList<Teacher>();
        for(int i = 0;i<rowsInteger;i++){
            index = (currentPageInteger-1)*10+i;
            if(index>=teachers.size())
                break;
            teacherPart.add(teachers.get(index));
        }
        req.setAttribute("list",teacherPart);
        req.setAttribute("totalCount",teachers.size());

        req.getRequestDispatcher("/admin/index/list.jsp").forward(req,rep);
    }


    @RequestMapping("/delSelectedServlet")
    public void delSelectedServlet(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String[] ids = request.getParameterValues("uid");
        for(String id : ids){
            teacherService.deleteTeacherById(Integer.valueOf(id));
        }
        response.sendRedirect("/findTeacherByPageServlet");
    }


    @RequestMapping("/delTeacherServlet")
    public void delUserServlet(HttpServletRequest request,HttpServletResponse response)throws Exception{
        teacherService.deleteTeacherById(Integer.valueOf(request.getParameter("id")));
        response.sendRedirect("/findTeacherByPageServlet");
    }

    @RequestMapping("/updateTeacherServlet")
    public void updateTeacherServlet(Teacher teacher, HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception{
        String user =(String)session.getAttribute("user");
        int id=teacherService.findteacherid(user);
        teacherService.updateTeacherById(id,teacher);
        response.sendRedirect("/findTeacherByPageServlet");
    }

    @RequestMapping("/addTeacherServlet")
    public void addTeacherServlet(Teacher teacher, HttpServletResponse response) throws Exception{
        teacherService.addTeacher(teacher);
        response.sendRedirect("/findTeacherByPageServlet");
    }

    @RequestMapping("/addCourse")
    public String addCourse(String courseName,float credits) throws Exception{
        boolean result = teacherService.addCourse(courseName,credits);
        if(result){
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher,HttpServletRequest request,HttpServletResponse response)throws Exception{
        teacher.setId(Integer.valueOf(request.getParameter("id")));
        teacherService.updateTeacherById(teacher.getId(),teacher);
        return "success";
    }

    @RequestMapping("add_course")
    public ModelAndView addcourse(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/index/add_course.jsp");
        return modelAndView;
    }

    @RequestMapping("update_teacher")
    public ModelAndView updatestudent(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/index/update_teacher.jsp");
        return modelAndView;
    }




}
