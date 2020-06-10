package train.excel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import train.entity.Grade;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


/**
 * Excel处理类，解析Excel文件
 *
 * @Author Swy
 * @Date 0:36 2020-06-10
 * @ClassName ExcelData
 **/
public class ExcelData {
    /**
     * sheet Excel中的表
     */
    private XSSFSheet sheet;

    public ExcelData(String filePath) throws IOException {
        FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream(filePath);
//            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            sheet = sheets.getSheet("grade");
    }


    /**
     * 根据行跟列读取
     *
     * @return 返回读取到的值
     * @Author Swy
     * @Date 0:37 2020-06-10
     * @Param row 行 column 列
     */
    public String getExcelDateByIndex(int row, int column) {
        XSSFRow row1 = sheet.getRow(row);
        String cell = row1.getCell(column).toString();
        return cell;
    }

    /**
     * 读取整个Excel表
     *
     * @return null
     * @Author Swy
     * @Date 0:38 2020-06-10
     * @Param Grade 对象数组，将Excel中的所有成绩做成一个数组返回去
     */
    public Grade[] readExcelData() {
        //获取行数,包含开头，总数据行数+1
        int rows = sheet.getPhysicalNumberOfRows();
        Grade[] grades = new Grade[rows - 1];
        String name = null;
        String num = null;
        String grade = null;
        for (int i = 0; i < rows - 1; i++) {
            XSSFRow row = sheet.getRow(i+1);

//            //获取列数
//            int columns = row.getPhysicalNumberOfCells();
//            for (int j = 0; j < columns; j++) {
//                String cell = row.getCell(j).toString();
//                System.out.println(cell);
//            }
            name = row.getCell(0).toString();
            num = row.getCell(1).toString();
            grade = row.getCell(2).toString();
            num = num.substring(0, 1) + num.substring(2, 11);
            grades[i] = new Grade();
            grades[i].setStuName(name);
            grades[i].setStuNum(num);
            grades[i].setStuGrade(grade);
        }
        return grades;
    }
}

