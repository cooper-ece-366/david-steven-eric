package edu.cooper.ece366.project.coopercars.server;


//import statements
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class SSTest
{
    public static void main(String[] args)
    {
        try
        {
            DataFormatter formatter = new DataFormatter(Locale.US);
            FileInputStream file = new FileInputStream(new File("VINsheet.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            //Iterate through each row
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int column = 0;
                double revenue = 0;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    column++;
                    switch(column){
                        case 1:
                            System.out.print("VIN: ");
                            break;
                        case 2:
                            System.out.print("Revenues: ");
                            break;
                        case 3:
                            System.out.print("Costs ");
                            break;
                        case 4:
                            System.out.print("Date Added: ");
                            break;
                    }
                    switch (cell.getCellType())
                    {
                        case NUMERIC:
                            System.out.print(formatter.formatCellValue(cell) + "  ");
                            if(column==2){
                                revenue=cell.getNumericCellValue();
                            }
                            if(column==3){
                                System.out.print("Profit: $" + (revenue - cell.getNumericCellValue()) + "  ");
                            }
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "  ");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

