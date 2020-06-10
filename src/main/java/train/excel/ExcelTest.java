package train.excel;

import train.entity.Grade;

import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName: ExcelTest
 * @Author: Swy
 * @Date: 2020-06-10 1:18
 **/
public class ExcelTest {
    /**
     * 测试方法
     *
     * @Author Swy
     * @Date 0:43 2020-06-10
     */
    public static void main(String[] args) throws IOException {
        ExcelData sheet1 = new ExcelData("src/main/java/train/excel/grade.xlsx");
        Grade[] grades = sheet1.readExcelData();
        System.out.println(Arrays.toString(grades));
        //row行 column列
        //String cell2 = sheet1.getExcelDateByIndex(0, 2);
    }
}
