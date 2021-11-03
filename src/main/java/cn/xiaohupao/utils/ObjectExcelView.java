package cn.xiaohupao.utils;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiaohupao
 * @Date: 2021/11/3 14:10
 */
public class ObjectExcelView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fileName = sdf.format(new Date());

        //设置下载头部文件信息
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");

        //创建一个sheet,相当于一个excel sheet
        Sheet sheet = workbook.createSheet("sheet1");

        //得到excel标题内容
        List<String> titles = (List<String>) model.get("titles");
        int len = titles.size();

        //设置单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //设置字体
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 11);
        cellStyle.setFont(headerFont);
        short width = 20, height = 25 * 20;
        sheet.setDefaultColumnWidth(width);

        //创建第一行，用来放标题
        Row header = sheet.createRow(0);
        for (int i = 0; i < len; i++){
            String title = titles.get(i);
            Cell cell = header.createCell(i);
            cell.setCellValue(title);
            cell.setCellStyle(cellStyle);
        }
        header.setHeight(height);

        //设置内容样式
        CellStyle contentStyle = workbook.createCellStyle();
        contentStyle.setAlignment(HorizontalAlignment.CENTER);
        //得到Controller传来的数据，填充到每一行
        List<PageData> varList = (List<PageData>) model.get("varList");
        int varCount = varList.size();
        for (int i = 0; i < varCount; i++){
            Row userRow = sheet.createRow(i+1);
            PageData vpd = varList.get(i);
            int mapLen = vpd.size();
            for (int j = 0; j < mapLen; j++){
                String varStr = vpd.getString("var" + (j+1)) != null ? vpd.getString("var"+ (j+1)) : "";
                Cell cell = userRow.createCell(j);
                cell.setCellValue(varStr);
                cell.setCellStyle(contentStyle);
            }
        }
    }
}
