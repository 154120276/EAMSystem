package cn.zcj.Controller;

import cn.zcj.Service.StudentService;
import cn.zcj.Service.UserService;
import cn.zcj.Util.EasyExcelUtil;
import cn.zcj.domain.Student;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(value = "导出相关接口")
@RestController
public class exportController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

   /* @ApiOperation(value = "学生导出")
    @PostMapping("/studentExport")
    public void tradingQueryExport(@ApiParam(value = "班级编号",required = true) @RequestParam int Sno
            , HttpServletResponse response) {
        List<Student> students = userService.findTStudents(Sno,null);
        EasyExcelUtil.writeExcel(response, students, "全部学生导出", "全部学生导出", Student.class);
    }*/
}
