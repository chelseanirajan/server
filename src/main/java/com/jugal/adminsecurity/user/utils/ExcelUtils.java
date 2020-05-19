package com.jugal.adminsecurity.user.utils;

import com.jugal.adminsecurity.user.model.Student;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelUtils {

    public static ByteArrayInputStream productsToExcel(List<Student> products) throws IOException {
        String[] COLUMNs = {"Id", "Name", "Symbol No", "School name", "Roll No"};
        try (
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Products");
            int number1=sheet.addMergedRegion(CellRangeAddress.valueOf("A1:E1"));

            Row row2 = sheet.createRow(0);

            // Creating header

            Cell lastCell = row2.createCell(number1);

            CellStyle cellStyle = row2.getSheet().getWorkbook().createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            lastCell.setCellStyle(cellStyle);
            lastCell.setCellValue("Mobile");


            Header header = sheet.getHeader();
            header.setCenter("Center Header");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);
            Row row1 = sheet.createRow(3);

            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row1.createCell(0);
            cell.setCellValue("First Name");
            cell.setCellStyle(headerCellStyle);

            cell = row1.createCell(1);
            cell.setCellValue("Last Name");
            cell.setCellStyle(headerCellStyle);

            cell = row1.createCell(2);
            cell.setCellValue("Mobile");
            cell.setCellStyle(headerCellStyle);
            cell = row1.createCell(3);
            cell.setCellValue("Email");
            cell.setCellStyle(headerCellStyle);

            // Row for Header
            Row headerRow = sheet.createRow(6);
            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell1 = headerRow.createCell(col);
                cell1.setCellValue(COLUMNs[col]);
                cell1.setCellStyle(headerCellStyle);
            }

            // CellStyle for Age
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
            int rowIdx = 7;
            for (Student std : products) {

                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(std.getId());
                row.createCell(1).setCellValue(std.getName());
                row.createCell(2).setCellValue(std.getSymbolNo());
                row.createCell(3).setCellValue(std.getSchoolName());

                Cell ageCell = row.createCell(4);
                ageCell.setCellValue(std.getRollNo());
                ageCell.setCellStyle(ageCellStyle);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public static List<Student> parseExcelFile(MultipartFile file) {

        try {
            InputStream in = file.getInputStream(); // yo line  ma matra rakhe pugxa
            Workbook workbook = new XSSFWorkbook(in);
            // aba f8 thicha tala tala janxa jun thau ma error auxa tyo line pugdaina

            Sheet sheet = workbook.getSheetAt(0);  // yo line  ma errro thio. getSheet() getda
            // debug garda mathi ko button le run gara ye
            Iterator<Row> rows = sheet.iterator();

            List<Student> lstStudent = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Student std = new Student();

                int cellIndex = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    if (cellIndex == 0) { // ID
                        std.setId((long) currentCell.getNumericCellValue());
                    } else if (cellIndex == 1) { // Name
                        std.setName(currentCell.getStringCellValue());
                    } else if (cellIndex == 2) { // symbol no
                        std.setSymbolNo(currentCell.getStringCellValue());
                    } else if (cellIndex == 3) { // school name
                        std.setSchoolName(currentCell.getStringCellValue());
                    } else if (cellIndex == 4) { // roll no
                        std.setRollNo((int) currentCell.getNumericCellValue());
                    }else if (cellIndex == 5) { // date of birth
                        std.setDoB(currentCell.getStringCellValue());
                    } else if (cellIndex == 6) { // father name
                        std.setFatherName(currentCell.getStringCellValue());
                    } else if (cellIndex == 7) { // mother name
                        std.setMotherName(currentCell.getStringCellValue());
                    }else if (cellIndex == 8) { // English th
                        std.setEnglishPr((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 9) { // english th
                        std.setEnglishTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 10) { // nepali th
                        std.setNepaliTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 11) { // nepali th
                        std.setNepaliPr((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 12) { // math th
                        std.setMathTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 13) { // science th
                        std.setScienceTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 14) { // science th
                        std.setSciencePr((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 15) { // social th
                        std.setSocialTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 16) { // social th
                        std.setSocialPr((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 17) { // obt th
                        std.setObtTh((float)currentCell.getNumericCellValue());
                    }else if (cellIndex == 18) { // obt th
                        std.setObtPr((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 19) { // health th
                        std.setHealthTh((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 20) { // health th
                        std.setHealthPr((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 21) { // moral th
                        std.setMoralTh((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 22) { // moral th
                        std.setMoralPr((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 23) { // opt th
                        std.setOptTh((float)currentCell.getNumericCellValue());
                    } else if (cellIndex == 24) { // opt th
                        std.setOptPr((float)currentCell.getNumericCellValue());
                    }

                    cellIndex++;
                }

                lstStudent.add(std);
            }

            // Close WorkBook
            workbook.close();

            return lstStudent;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }
}