package train.view.succ.teacher;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Excel文件筛选器，只能显示Excel文件
 * @Author Swy
 * @Date 1:07 2020-06-10
 * @ClassName ExcelFileFilter
 **/
class ExcelFileFilter extends FileFilter {
    @Override
    public String getDescription() {
        return "*.xls;*.xlsx";
    }

    @Override
    public boolean accept(File file) {
        String name = file.getName();
        // 仅显示目录和xls、xlsx文件
        return file.isDirectory() || name.toLowerCase().endsWith(".xls") || name.toLowerCase().endsWith(".xlsx");
    }
}