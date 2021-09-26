package cn.zcj.Util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author lenovo
 * @date 2019年2月19日
 */
@Slf4j
public class EasyExcelUtil {


    /**
     * 导出 Excel ：一个 sheet，带表头
     *
     * @param response  HttpServletResponse
     * @param list      数据 list，每个元素为一个 BaseRowModel
     * @param fileName  导出的文件名
     * @param sheetName 导入文件的 sheet 名
     * @param clas    映射实体类，Excel 模型
     */
    public static void writeExcel(final HttpServletResponse response, final List<? extends BaseRowModel> list, final String fileName, final String sheetName,
                                  final Class<? extends BaseRowModel> clas) {
        final ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        final Sheet sheet = new Sheet(1, 0, clas);
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        writer.finish();
    }


    /**
     * 导出文件时为Writer生成OutputStream 不生成临时文件
     */
    private static OutputStream getOutputStream(final String fileName, final HttpServletResponse response) {
        try {
            final String newFileName = new String((fileName + (new SimpleDateFormat("yyyy-MM-dd").format(new Date()))).getBytes(), "UTF-8") + ".xlsx";
            response.addHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(newFileName, "UTF-8") + "\"");
            response.setContentType("application/octet-stream");
            return response.getOutputStream();
        } catch (final IOException e) {
            log.error("发生异常",e);
            e.printStackTrace();
        }
        return null;
    }
    
    public static void export(List<BaseRowModel> datas,String filePath, Class<? extends BaseRowModel> clazz,String sheetName) {
    	OutputStream outputStream = null;
    	try {
    		 outputStream =new FileOutputStream(filePath);
    		 ExcelWriter excelWriter =EasyExcelFactory.getWriter(outputStream);
    		 Sheet sheet =new Sheet(1,0,clazz);
    		 sheet.setSheetName(sheetName);
    		 excelWriter.write(datas,sheet);
    		 excelWriter.finish();
		} catch (Exception e) {
			 log.error("生成excel文件错误" + e);
		}finally {
			if(outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					log.error("关闭流文件异常", e);
				}
			}
		}
    }
}
