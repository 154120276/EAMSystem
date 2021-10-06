package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
public class Student  {

    private int id;

    private int Sno;

    private String classname;

    private String name;

    private String sex;

    private String phonenumber;

    private String username;

    private String password;

    private int tid;

}
