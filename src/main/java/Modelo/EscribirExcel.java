/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author sescalo
 */
public class EscribirExcel {
    
//    public void crearHojaCalculo(Objeto pObjeto) throws FileNotFoundException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
//
//        try {
//            FileInputStream file = new FileInputStream("HojaInv.xls");
//
//            HSSFWorkbook workbook = new HSSFWorkbook(file);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            
//            
//            //Objeto
//            //Retrieve the row and check for null
//            Row fila = sheet.getRow(5);
//            //Update the value of columna
//            Cell columna = fila.getCell(1);
//            columna.setCellValue(pObjeto.getNombreObjeto());
//            
//            //Forma Adquisicion
//            fila = sheet.getRow(8);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getFormaAdquisicion());
//            
//            //Fecha Ingreso
//            fila = sheet.getRow(8);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getFechaIngreso());
//            
//            //No. Registro
//            fila = sheet.getRow(8);
//            columna = fila.getCell(4);
//            columna.setCellValue(pObjeto.getNumRegistro());
//            
//            //Valor Economico
//            fila = sheet.getRow(8);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getValorEconomico());
//            
//            //Nombre de la Fuente
//            fila = sheet.getRow(11);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getNombreFuente());
//            
//            //Fecha Inventario
//            fila = sheet.getRow(11);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getFechaInventario());
//            
//            //No. Inventario
//            fila = sheet.getRow(11);
//            columna = fila.getCell(4);
//            columna.setCellValue(pObjeto.getNumInventario());
//            
//            //Otros numeros
//            fila = sheet.getRow(11);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getOtrosNumeros());
//            
//            //Direccion fuente
//            fila = sheet.getRow(14);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getDireccionFuente());
//            
//            //Fecha Catalogo
//            fila = sheet.getRow(14);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getFechaCatalogo());
//            
//            //No. Catalogo
//            fila = sheet.getRow(14);
//            columna = fila.getCell(4);
//            columna.setCellValue(pObjeto.getNumCatalogo());
//            
//            //Espesor
//            fila = sheet.getRow(14);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getEspesor());
//            
//            //Alto
//            fila = sheet.getRow(17);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getAlto());
//            
//            //Ancho
//            fila = sheet.getRow(17);
//            columna = fila.getCell(1);
//            columna.setCellValue(pObjeto.getAncho());
//            
//            //Largo
//            fila = sheet.getRow(17);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getLargo());
//            
//            //Diametro
//            fila = sheet.getRow(17);
//            columna = fila.getCell(4);
//            columna.setCellValue(pObjeto.getDiametro());
//            
//            //Peso
//            fila = sheet.getRow(17);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getPeso());
//            
//            //Procedencia
//            fila = sheet.getRow(20);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getProcedencia());
//            
//            //Materia y tecnica
//            fila = sheet.getRow(20);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getMateriaYTecnica());
//            
//            //Numero negativo
//            fila = sheet.getRow(20);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getNumeroNegativo());
//            
//            //Autor
//            fila = sheet.getRow(24);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getAutor());
//            
//            //Epoca
//            fila = sheet.getRow(24);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getEpoca());
//            
//            //Descripcion
//            fila = sheet.getRow(27);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getDescripcion());
//            
//            //Documentacion
//            fila = sheet.getRow(35);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getDocumentacion());
//            
//            //Observaciones
//            fila = sheet.getRow(43);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getObservaciones());
//            
//            //Recibió
//            fila = sheet.getRow(51);
//            columna = fila.getCell(0);
//            columna.setCellValue(pObjeto.getRecibio());
//            
//            //Inventarió
//            fila = sheet.getRow(51);
//            columna = fila.getCell(2);
//            columna.setCellValue(pObjeto.getInventario());
//            
//            //Catalogó
//            fila = sheet.getRow(51);
//            columna = fila.getCell(4);
//            columna.setCellValue(pObjeto.getCatalogo());
//            
//            //Aprobó
//            fila = sheet.getRow(51);
//            columna = fila.getCell(5);
//            columna.setCellValue(pObjeto.getAprobo());
//            
//            
//            //Cerramos archivo
//            file.close();
//            FileOutputStream outFile = new FileOutputStream(new File("Objeto.xls"));
//            workbook.write(outFile);
//            outFile.close();
//            
//            } catch (Exception ex) {
//            ex.printStackTrace();
//            }
//    }


    public void crearPDF() throws Exception{
//==========Aspose
//        //Instantiate a new workbook with Excel file path
//        Workbook workbook = new Workbook("DatosObjeto.xlsx");
//        
//        //Save the document in PDF format
//        workbook.save("MyPdfFile.pdf", SaveFormat.PDF);

//=========Apache Poi
//        FileInputStream input_document = new FileInputStream(new File("DatosObjeto.xls"));
//            // Read workbook into HSSFWorkbook
//            HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
//            // Read worksheet into HSSFSheet
//            HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0); 
//            // To iterate over the rows
//            Iterator<Row> rowIterator = my_worksheet.iterator();
//            //We will create output PDF document objects at this point
//            Document iText_xls_2_pdf = new Document();
//            
//            PdfWriter.getInstance(iText_xls_2_pdf, new FileOutputStream("Excel2PDF_Output.pdf"));
//            iText_xls_2_pdf.open();
//            //we have two columns in the Excel sheet, so we create a PDF table with two columns
//            //Note: There are ways to make this dynamic in nature, if you want to.
//            PdfPTable my_table = new PdfPTable(2);
//            //We will use the object below to dynamically add new data to the table
//            PdfPCell table_cell;
//            //Loop through rows.
//            while(rowIterator.hasNext()) {
//                Row row = rowIterator.next(); 
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while(cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next(); //Fetch CELL
//                    switch(cell.getCellType()) { //Identify CELL type
//                            //you need to add more code here based on
//                            //your requirement / transformations
//                    case Cell.CELL_TYPE_STRING:
//                            //Push the data from Excel to PDF Cell
//                             table_cell=new PdfPCell(new Phrase(cell.getStringCellValue()));
//                             //feel free to move the code below to suit to your needs
//                             my_table.addCell(table_cell);
//                            break;
//                    }
//                        //next line
//                }
//
//            }
//            //Finally add the table to PDF document
//            iText_xls_2_pdf.add(my_table);                       
//            iText_xls_2_pdf.close();                
//            //we created our pdf file..
//            input_document.close(); //close xls
    
        //===OpenOffice Api
//        XComponentContext xContext = Bootstrap.bootstrap();
//
//        XMultiComponentFactory xMCF = xContext.getServiceManager();
//
//        Object oDesktop = xMCF.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);
//
//        XDesktop xDesktop = (XDesktop) UnoRuntime.queryInterface(XDesktop.class, oDesktop);
//
//        // Load the Document
//        String workingDir = "C:/projects/";
//        String myTemplate = "HojaInv.xls";
//
//        if (!new File(workingDir + myTemplate).canRead()) {
//         throw new RuntimeException("Cannot load template:" + new File(/*workingDir + */myTemplate));
//        }
//        System.out.println("eEAEAEAEAEE");
//
//        XComponentLoader xCompLoader = (XComponentLoader) UnoRuntime
//         .queryInterface(com.sun.star.frame.XComponentLoader.class, xDesktop);
//
//        String sUrl = /*"file:///" + workingDir +*/ myTemplate;
//
//        PropertyValue[] propertyValues = new PropertyValue[0];
//
//        propertyValues = new PropertyValue[1];
//        propertyValues[0] = new PropertyValue();
//        propertyValues[0].Name = "Hidden";
//        propertyValues[0].Value = new Boolean(true);
//
//        XComponent xComp = xCompLoader.loadComponentFromURL(sUrl, "_blank", 0, propertyValues);
//
//        // save as a PDF
//        XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, xComp);
//
//        propertyValues = new PropertyValue[2];
//        propertyValues[0] = new PropertyValue();
//        propertyValues[0].Name = "Overwrite";
//        propertyValues[0].Value = new Boolean(true);
//        propertyValues[1] = new PropertyValue();
//        propertyValues[1].Name = "FilterName";
//        propertyValues[1].Value = "writer_pdf_Export";
//
//        // Appending the favoured extension to the origin document name
//        String myResult = /*workingDir + */"letter1.pdf";
//
//        xStorable.storeToURL(/*"file:///" + */myResult, propertyValues);
//
//        System.out.println("Saved " + myResult);
//
//        xDesktop.terminate();
    }
    


}