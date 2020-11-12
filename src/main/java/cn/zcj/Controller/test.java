package cn.zcj.Controller;

import cn.zcj.Mapper.ClassMapper;
import cn.zcj.Mapper.StudentMapper;
import cn.zcj.Mapper.TeacherMapper;
import cn.zcj.Service.TeacherService;
import cn.zcj.Service.UserService;
import cn.zcj.domain.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    private UserService userService;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findclass(){
       /* PageHelper.startPage(0,5);
        PageInfo<Student> pageInfo = new PageInfo<Student>(userService.findStudents("%%"));
        System.out.println(pageInfo.getList());
        System.out.println("---------------------------------");
        System.out.println(pageInfo);*/
        /*List<BanJi> findclass = userService.findclass();
        for (BanJi banJi : findclass) {
            System.out.println(banJi.getSno()+"---"+banJi.getClassname());
        }*/

        /*int i = teacherMapper.findclassSno(1);
        System.out.println(i);*/
        /*PageInfo<Student> pageInfo = new PageInfo<Student>(userService.findTStudents(2,"%%"));
        System.out.println(pageInfo.getList());*/
        /*PEScores peScores = userService.findPEScores(9);
        System.out.println(peScores);*/
        /*List<course> findcourses = studentMapper.findcourses(2);
        System.out.println(findcourses);*/
        /*int changjiang = studentMapper.findSno("zhuchangjiang");
        System.out.println(changjiang);

*/
       /* PageHelper.startPage(0,5);
        PageInfo<course> pageInfo = new PageInfo<>(userService.findCoures(2,1));
        System.out.println(pageInfo.getList());*/

        int gid=userService.getgidbyuser("zhuchangjiang");
        String grades=userService.getgrades(gid);
        System.out.println(grades);
        System.out.println("==========================================================================");
        String[] split = grades.split(";");
        List<grade> list=new ArrayList<>();
        for (String s : split) {
            String[] split1 = s.split(":");
            grade grade = new grade();
            grade.setName(split1[0]);
            grade.setScore(split1[1]);
            list.add(grade);
        }
        for (grade grade : list) {
            System.out.println(grade);
        }
    }


}
