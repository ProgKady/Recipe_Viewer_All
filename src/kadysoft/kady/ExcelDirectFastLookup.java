package kadysoft.kady;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelDirectFastLookup {

    public static void main(String[] args) {
        org.apache.poi.util.IOUtils.setByteArrayMaxOverride(200_000_000);
        String filePath = "D:\\Absent_2025.xlsx"; // XLSX file
        String targetCode = "20673";              // Code in column E

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Absent");
            if (sheet == null) {
                System.out.println("? Sheet 'Absent' not found.");
                return;
            }

            for (Row row : sheet) {
                Cell codeCell = row.getCell(4); // Column E
                if (codeCell == null) continue;

                String code = getCellValue(codeCell);
                if (targetCode.equals(code)) {
                    String name = getCellValue(row.getCell(5));   // Column F
                    String shift = getCellValue(row.getCell(13)); // Column N

                    System.out.println("? Code found: " + code);
                    System.out.println("? Name: " + name);
                    System.out.println("? Shift: " + shift);
                    return;
                }
            }

            System.out.println("? Code not found: " + targetCode);

        } catch (Exception e) {
            System.out.println("? Error: " + e.getMessage());
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue().trim();
            case NUMERIC: return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default: return cell.toString().trim();
        }
    }
}
