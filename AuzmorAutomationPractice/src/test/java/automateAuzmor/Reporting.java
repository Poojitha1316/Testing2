import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Reporting{
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\91889\\Downloads\\Report.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheet("Learner info");

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        int index = -1;
        int statusIndex = -1;
        int cellCount = sheet.getRow(0).getLastCellNum();

        for (int k = 0; k < cellCount; k++) {
            if ("Progress Status".equals(sheet.getRow(0).getCell(k).getStringCellValue())) {
                statusIndex = k;
            }
            if ("Email/Username".equals(sheet.getRow(0).getCell(k).getStringCellValue())) {
                index = k;
            }
        }

        if (index == -1 || statusIndex == -1) {
            System.out.println("Columns not found.");
            return;
        }

        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            if (row == null) {
                System.out.println("Row " + i + " is null.");
                continue;
            }

            XSSFCell cell = row.getCell(index);
            XSSFCell cell2 = row.getCell(statusIndex);

            if (cell == null || cell2 == null) {
                System.out.println("One of the cells in row " + i + " is null.");
                continue;
            }

            String mail = getCellValueAsString(cell);
            String status = getCellValueAsString(cell2);

            if ("Completed".equals(status)) {
                System.out.println("The person with " + mail + " had the status " + status);
            } else {
                System.out.println("The person with " + mail + " had the status " + status);
            }
        }
    }

    private static String getCellValueAsString(XSSFCell cell) {
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return ""; // Handle other cell types as needed
        }
    }
}