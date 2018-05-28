package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import products.Product;
import products.Smartphone;

import java.io.*;
import java.util.*;

public class FileUtils {
    public static File writeProductToTXTFile(List<Product> products) throws IOException {
        Date date = new Date();
        File file=new File("temp"+date.getTime()+".txt");
        FileWriter fileWriter  = new FileWriter(file);
        file.setWritable(true);
        file.setReadable(true);
        for(Product pro:products){
            System.out.println(pro);
            fileWriter.write(pro.toString()+"\n");
        }
        fileWriter.flush();
        return file;
    }

    public static File writeProductToEXCELFile(List<Product> products) throws IOException {
        String[] columns = {"Name", "Price", "Popular"};
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Products");

        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        int rowNum = 1;
        products.sort(Comparator.comparingInt(Product::getPrice).reversed());
        for(Product product: products) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(product.getName());

            row.createCell(1)
                    .setCellValue(product.getPrice());

            row.createCell(2)
                    .setCellValue(product.getPopular());

        }

        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        Date date = new Date();
        File xlsxFile=new File("temp"+date.getTime()+".xlsx");
        FileOutputStream fileOut = new FileOutputStream(xlsxFile);
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
        return xlsxFile;
    }
}
