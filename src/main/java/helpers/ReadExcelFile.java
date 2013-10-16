package helpers;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcelFile implements ReadData {

    @Override
    public String[][] getData() {

        // Assigning the location of the Excel file.
        String path = "/Users/sakodali/Sandbox/VoucherCodes/src/test/resources/LoginData.xls";

        // Create an ArrayList to store the data read from excel sheet.
        List<HSSFCell> dataList = new ArrayList<HSSFCell>();
        FileInputStream fis = null;
        try
        {
            // Create a FileInputStream that will be use to read the excel file.
            fis = new FileInputStream(path);

            HSSFWorkbook workbook = new HSSFWorkbook(fis);

            // Get the first sheet on the workbook.
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator rows = sheet.rowIterator();

            //Iterator on each sheet's rows and on each row's cells and store the data read on an ArrayList.
            String[][] data = new String[sheet.getPhysicalNumberOfRows()][];
            int i = 0;
            while (rows.hasNext())
            {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                String[] rowData = new String[row.getPhysicalNumberOfCells()];
                int j = 0;
                while (cells.hasNext())
                {
                    HSSFCell cell = (HSSFCell) cells.next();
                    rowData[j] = cell.getStringCellValue();
                    j++;
                }
                data[i] = rowData;
                i++;
            }
            return data;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

//return new ReadJsonFile().getData(); (to read in the dataprovider)
