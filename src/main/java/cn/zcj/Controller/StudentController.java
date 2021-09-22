package cn.zcj.Controller;

import cn.zcj.Service.StudentService;
import cn.zcj.Service.TeacherService;
import cn.zcj.Service.UserService;
import cn.zcj.domain.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @RequestMapping("students")
    public ModelAndView showStudentlist(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        String pageNum = request.getParameter("pageNum");//当前页码
        String rows = request.getParameter("rows");//每页条数
        String name = request.getParameter("name");//查询条件姓名
        if (pageNum==null || "".equals(pageNum)){
            pageNum="1";
        }
        if (rows==null || "".equals(rows)){
            rows="5";
        }
        if (name ==null || "".equals(name )){
            name="%%";
        }else {
            name="%"+name+"%";
        }
        //2.调用Service
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(rows));
        PageInfo<Student> pageInfo = new PageInfo<Student>(userService.findStudents(name));

        //3.将PageBean存入request
        modelAndView.addObject("pb",pageInfo);
        modelAndView.setViewName("/admin/index/Studentlist.jsp");
        return modelAndView;
    }

    @RequestMapping("Tstudents")
    public ModelAndView showTStudetlist(HttpServletRequest request, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String pageNum = request.getParameter("pageNum");//当前页码
        String rows = request.getParameter("rows");//每页条数
        String name = request.getParameter("name");//查询条件姓名
        String user =(String) session.getAttribute("user");
       /* if (user==null || "".equals(user)){
            System.out.println("user为空");
        }*/
        if (pageNum==null || "".equals(pageNum)){
            pageNum="1";
        }
        if (rows==null || "".equals(rows)){
            rows="5";
        }
        if (name ==null || "".equals(name )){
            name="%%";
        }else {
            name="%"+name+"%";
        }
        int id=teacherService.findteacherid(user);
        int Sno = teacherService.findclassSno(id);
        //2.调用Service
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(rows));
        PageInfo<Student> pageInfo = new PageInfo<Student>(userService.findTStudents(Sno,name));
        //3.将PageBean存入request
        modelAndView.addObject("pb",pageInfo);
        modelAndView.setViewName("/admin/index/t_Studentlist.jsp");
        return modelAndView;
    }

    @RequestMapping("updatestudentjsp")
    public ModelAndView updatestudentjsp(int id){
        ModelAndView modelAndView = new ModelAndView();
        List<BanJi> findclass = userService.findclass();
        Student student=userService.findStudent(id);
        modelAndView.addObject("student",student);
        modelAndView.addObject("classes",findclass);
        modelAndView.setViewName("/admin/index/update_student.jsp");
        return modelAndView;
    }

    @RequestMapping("updatestudent")
    public ModelAndView updatestudent(Student student){
        ModelAndView modelAndView = new ModelAndView();
        userService.StudentUpdate(student);
        modelAndView.addObject("name","");
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @RequestMapping("PEscore")
    public ModelAndView showclasslist(HttpSession session){
        String user =(String) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        int tid=userService.getTid(user);
        //查询出所有班级的列表
        PEScores pe = userService.findPEScores(tid);
        modelAndView.addObject("pe",pe);
        modelAndView.setViewName("/admin/index/PEScores.jsp");
        return modelAndView;
    }

    @RequestMapping("courses")
    public ModelAndView showCourses(HttpServletRequest request, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String pageNum = request.getParameter("pageNum");//当前页码
        String rows = request.getParameter("rows");//每页条数
        String dayofweek = request.getParameter("dayofweek");
        String user =(String) session.getAttribute("user");
        System.out.println(dayofweek+"--------------------------------------------------------------");
       /* if (user==null || "".equals(user)){
            System.out.println("user为空");
        }*/
        if (pageNum==null || "".equals(pageNum)){
            pageNum="1";
        }
        if (rows==null || "".equals(rows)){
            rows="5";
        }
        if (dayofweek==null || "".equals(dayofweek)){
            dayofweek="0";
        }
        int sno = userService.findSno(user);
        //2.调用Service
        PageHelper.startPage(Integer.parseInt(pageNum),Integer.parseInt(rows));
        PageInfo<course> pageInfo = new PageInfo<>(userService.findCoures(sno,Integer.parseInt(dayofweek)));
        //3.将PageBean存入request
        modelAndView.addObject("pb",pageInfo);
        modelAndView.setViewName("/admin/index/studentcourses.jsp");
        return modelAndView;
    }

    @RequestMapping("grades")
    public ModelAndView showgradeslist(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        //查询出所有班级的列表
        String user =(String) session.getAttribute("user");
        int sid=userService.getsidbyuser(user);
        List<grade> grades=userService.getgrades(sid);
        modelAndView.addObject("grades",grades);
        modelAndView.setViewName("/admin/index/gradeslist.jsp");
        return modelAndView;
    }

    @RequestMapping("/findStudentById")
    public void findStudentById(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
        String user =(String)session.getAttribute("user");
        int id=studentService.getidbyusername(user);
        Student student = studentService.findStudentById(id);
        request.setAttribute("sno",student.getSno());
        request.setAttribute("nameStudent",student.getName());
        request.setAttribute("phonenumber",student.getPhonenumber());
        request.setAttribute("username",student.getUsername());
        request.setAttribute("password",student.getPassword());
        request.getRequestDispatcher("/admin/index/update_student_user.jsp").forward(request,response);
    }


    @RequestMapping("/updateStudentUser")
    public String updateStudentUser(Student student, HttpServletRequest request){
        student.setId(Integer.parseInt(request.getParameter("id")));
        studentService.updateStudentById(student.getId(),student);
        return "success";
    }
}
