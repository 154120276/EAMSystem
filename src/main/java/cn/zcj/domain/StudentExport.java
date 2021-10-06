package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class StudentExport extends BaseRowModel {

    @ApiModelProperty("id")
    @ExcelProperty(value = "id", index = 0)
    private int id;

    @ApiModelProperty("班级名")
    @ExcelProperty(value = "班级名", index = 1)
    private String classname;

    @ApiModelProperty("学生名称")
    @ExcelProperty(value = "学生名称", index = 2)
    private String name;

    @ApiModelProperty("性别")
    @ExcelProperty(value = "性别", index = 3)
    private String sex;

    @ApiModelProperty("电话")
    @ExcelProperty(value = "电话", index = 4)
    private String phonenumber;
}
