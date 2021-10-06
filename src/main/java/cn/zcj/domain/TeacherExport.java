package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TeacherExport extends BaseRowModel {

    @ApiModelProperty("id")
    @ExcelProperty(value = "id", index = 0)
    private Integer id;

    @ApiModelProperty("名称")
    @ExcelProperty(value = "名称", index = 1)
    private String name;

    @ApiModelProperty("性别")
    @ExcelProperty(value = "性别", index =2)
    private String sex;

    @ApiModelProperty("电话")
    @ExcelProperty(value = "电话", index = 3)
    private String phonenumber;

    @ApiModelProperty("邮箱")
    @ExcelProperty(value = "邮箱", index = 4)
    private String email;
}