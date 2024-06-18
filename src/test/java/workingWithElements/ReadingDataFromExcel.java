package workingWithElements;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"testdata/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int totalRows = sheet.getLastRowNum();

    }
}
