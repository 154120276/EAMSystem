package cn.zcj.Controller;

import cn.zcj.Service.StudentService;
import cn.zcj.Service.TeacherService;
import cn.zcj.Service.UserService;
import cn.zcj.Util.EasyExcelUtil;
import cn.zcj.domain.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "导出相关接口")
@RestController
public class exportController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "学生导出")
    @PostMapping("/studentExport")
    public void tradingQueryExport(@ApiParam(value = "班级编号",required = true) @RequestParam int Sno
            , HttpServletResponse response) {
        List<Student> students = userService.findTStudents(Sno,"%%");
        List<StudentExport> studentExports = new ArrayList<>();
        for (Student student : students) {
            StudentExport export = new StudentExport();
            BeanUtils.copyProperties(student,export);
            studentExports.add(export);
        }
        EasyExcelUtil.writeExcel(response, studentExports, "学生导出", "学生导出", StudentExport.class);
    }

    @ApiOperation(value = "教师导出")
    @PostMapping("/teacherExport")
    public void teacherExport(HttpServletResponse response) {
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        List<TeacherExport> teacherExports = new ArrayList<>();
        for (Teacher teacher : allTeacher) {
            TeacherExport export = new TeacherExport();
            BeanUtils.copyProperties(teacher,export);
            teacherExports.add(export);
        }
        EasyExcelUtil.writeExcel(response, teacherExports, "全部教师导出", "全部教师导出", TeacherExport.class);
    }

    @ApiOperation(value = "成绩导出")
    @PostMapping("/gradesExport")
    public void gradesExport(@ApiParam(value = "学生id",required = true) @RequestParam int sid,HttpServletResponse response) {
        List<grade> getgrades = userService.getgrades(sid);
        List<GradeExport> gradeExports = new ArrayList<>();
        for (grade grade : getgrades) {
            GradeExport export = new GradeExport();
            BeanUtils.copyProperties(grade,export);
            gradeExports.add(export);
        }
        EasyExcelUtil.writeExcel(response, gradeExports, "成绩导出", "成绩导出", GradeExport.class);
    }

    @ApiOperation(value = "课表导出")
    @PostMapping("/courseExport")
    public void courseExport(@ApiParam(value = "班级编号",required = true) @RequestParam int Sno,HttpServletResponse response) {
        List<course> coures = userService.findCoures(Sno, 0);
        List<CourseExport> gradeExports = new ArrayList<>();
        for (course course : coures) {
            CourseExport export = new CourseExport();
            BeanUtils.copyProperties(course,export);
            gradeExports.add(export);
        }
        EasyExcelUtil.writeExcel(response, gradeExports, "课表导出", "课表导出", CourseExport.class);
    }

    @ApiOperation(value = "班级导出")
    @PostMapping("/classExport")
    public void classExport(HttpServletResponse response) {
        //查询出所有班级的列表
        List<BanJi> allClass = userService.findALLClass();
        List<BanJiExport> gradeExports = new ArrayList<>();
        for (BanJi banJi : allClass) {
            BanJiExport export = new BanJiExport();
            BeanUtils.copyProperties(banJi,export);
            gradeExports.add(export);
        }
        EasyExcelUtil.writeExcel(response, gradeExports, "班级导出", "班级导出", BanJiExport.class);
    }


}
