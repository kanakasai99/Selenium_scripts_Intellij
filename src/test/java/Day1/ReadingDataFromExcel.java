package Day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//FileInputStream-- Reading
//FileOutputStream--Writing

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        //FileInputStream file=new FileInputStream("D:\\SeleniumPractice\\SeleniumWebdriver\\src\\TestData\\data.xlsx");
      //  FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "/src/test/testdata/data.xlsx");
        FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "/src/test/testdata/data2.xlsx");
        XSSFWorkbook wbFile=new XSSFWorkbook(file);
        XSSFSheet sheet=wbFile.getSheet("Sheet1");

        int noOfRows=sheet.getLastRowNum();
        int noOfCells=sheet.getRow(0).getLastCellNum();
        System.out.println("noOfRows: "+noOfRows); //rows count from 0 in excel and also 0 in java
        System.out.println("noOfCells: "+noOfCells); //cells count from 1 in excel but in java count from 0

        for(int r=0;r<=noOfRows;r++) {
            XSSFRow row=sheet.getRow(r);
            for(int c=0;c<noOfCells;c++) {
                XSSFCell cell=	sheet.getRow(r).getCell(c);
                System.out.print(cell.toString()+"\t");
            }
            System.out.println();
        }
        wbFile.close();
        file.close();

    }
}
