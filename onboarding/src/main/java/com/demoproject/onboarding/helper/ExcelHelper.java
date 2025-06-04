package com.demoproject.onboarding.helper;

import com.demoproject.onboarding.entity.AssociateTracker;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static List<AssociateTracker> convertExcelToAssociates(InputStream is) {
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<AssociateTracker> list = new ArrayList<>();
            if (rows.hasNext()) rows.next(); // skip header

            while (rows.hasNext()) {
                Row row = rows.next();

                AssociateTracker assoc = new AssociateTracker();
                assoc.setCnum(getCellString(row.getCell(0)));
                assoc.setName(getCellString(row.getCell(1)));
                assoc.setInternetEmail(getCellString(row.getCell(2)));
                assoc.setJrs(getCellString(row.getCell(3)));
                assoc.setStatus(getCellString(row.getCell(4)));
                assoc.setSentToDefDate(getCellDate(row.getCell(5)));
                assoc.setLastUpdateDate(getCellDate(row.getCell(6)));
                assoc.setLastUpdatedBy(getCellString(row.getCell(7)));
                assoc.setCohortId(getCellLong(row.getCell(8)));

                list.add(assoc);
            }

            return list;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
    }

    private static String getCellString(Cell cell) {
        return cell == null ? null : cell.getCellType() == CellType.STRING
                ? cell.getStringCellValue()
                : String.valueOf((long) cell.getNumericCellValue());
    }

    private static LocalDate getCellDate(Cell cell) {
        if (cell == null || cell.getCellType() == CellType.BLANK) return null;
        if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            return cell.getLocalDateTimeCellValue().toLocalDate();
        }
        return null;
    }

    private static Long getCellLong(Cell cell) {
        if (cell == null) return null;
        return (long) cell.getNumericCellValue();
    }
}
