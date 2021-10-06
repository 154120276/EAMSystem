package cn.zcj.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BanJiExport extends BaseRowModel {

    @ApiModelProperty("id")
    @ExcelProperty(value = "id", index = 0)
    private int Sno;

    @ApiModelProperty("班级名")
    @ExcelProperty(value = "班级名", index = 1)
    private String classname;

    @ApiModelProperty("教师名")
    @ExcelProperty(value = "教师名", index = 2)
    private String teachername;


}
