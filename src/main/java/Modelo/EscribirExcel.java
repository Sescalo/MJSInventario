/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sescalo
 */
public class EscribirExcel {
    
    public void actualizarCelda() throws FileNotFoundException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{

        try {
            FileInputStream file = new FileInputStream("/home/sescalo/NetBeansProjects/MJSInventario/prueba.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            

            //Retrieve the row and check for null
            Row sheetrow = sheet.getRow(1);
            if(sheetrow == null){
                sheetrow = sheet.createRow(1);
            }
            //Update the value of cell
            Cell cell = sheetrow.getCell(2);
            if(cell == null){
                cell = sheetrow.createCell(2);
            }
            cell.setCellValue("Pass");
            
            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("/home/sescalo/NetBeansProjects/MJSInventario/prueba.xlsx"));
            workbook.write(outFile);
            outFile.close();
            
            } catch (Exception ex) {
            ex.printStackTrace();
            }
    }
}
