package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseExport extends BaseRowModel {


    @ApiModelProperty("id")
    @ExcelProperty(value = "id", index = 0)
    private int id;

    @ApiModelProperty("课程名称")
    @ExcelProperty(value = "课程名称", index = 1)
    private String name;

    @ApiModelProperty("星期几")
    @ExcelProperty(value = "星期几", index = 2)
    private int dayofweek;

    @ApiModelProperty("节数")
    @ExcelProperty(value = "节数", index = 3)
    private String timeofday;

    @ApiModelProperty("教学地点")
    @ExcelProperty(value = "教学地点", index = 4)
    private String place;

    @ApiModelProperty("授课教师")
    @ExcelProperty(value = "授课教师", index = 5)
    private String teacher;
}
