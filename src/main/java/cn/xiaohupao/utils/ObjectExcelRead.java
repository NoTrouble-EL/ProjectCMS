package cn.xiaohupao.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectExcelRead {

    public static List<PageData> readExcel(InputStream is, int startrow, int startcol, int sheetNum){
        List<PageData> varList = new ArrayList<>();

        try{
            HSSFWorkbook wb = new HSSFWorkbook(is);
            HSSFSheet sheet = wb.getSheetAt(sheetNum);
            int rowNum = sheet.getLastRowNum()+1;

            for (int i = startrow; i < rowNum; i++){
                PageData varpd = new PageData();
                HSSFRow row = sheet.getRow(i);
                int cellNum = row.getLastCellNum();

                for (int j = startcol; j < cellNum; j++){
                    HSSFCell cell = row.getCell(Short.parseShort(j+""));
                    Object cellValue;
                    if (null != cell){
                        switch (cell.getCellType()){
                            case _NONE:
                                cellValue = String.valueOf((int)cell.getNumericCellValue());
                                break;
                            case STRING:
                                cellValue = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                cellValue = cell.getNumericCellValue() + "";
                                // cellValue = String.valueOf(cell.getDateCellValue());
                                break;
                            case BOOLEAN:
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case ERROR:
                                cellValue = String.valueOf(cell.getErrorCellValue());
                                break;
                            default: cellValue = "";
                        }
                    }else {
                        cellValue = "";
                    }
                    varpd.put("var" + j, cellValue);
                }
                varList.add(varpd);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return varList;
    }
}
