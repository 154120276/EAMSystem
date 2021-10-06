package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GradeExport extends BaseRowModel {

    @ApiModelProperty("id")
    @ExcelProperty(value = "id", index = 0)
    private int id;

    @ApiModelProperty("课程名称")
    @ExcelProperty(value = "课程名称", index = 1)
    private String name;

    @ApiModelProperty("成绩")
    @ExcelProperty(value = "成绩", index = 2)
    private String grade;

    @ApiModelProperty("上传教师")
    @ExcelProperty(value = "上传教师", index = 3)
    private String updateby;
}
