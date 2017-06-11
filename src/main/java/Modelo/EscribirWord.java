/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
//import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


import java.io.OutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
//import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Paragraph;



/**
 *
 * @author oskr
 */
public class EscribirWord {
    
    public void crearWord(Objeto obj) throws IOException{
        String filePath = "HojaInventarioTemplate.doc";
        String filePathFinal = "HojaInventarioObjeto.doc";
        POIFSFileSystem fs = null;
        
        try {            
            fs = new POIFSFileSystem(new FileInputStream(filePath));            
            HWPFDocument doc = new HWPFDocument(fs);
            
            doc = replaceText(doc, "$nombreObjeto", obj.getNombreObjeto());
            doc = replaceText(doc, "$formaAdquisicion", obj.getFormaAdquisicion());
            doc = replaceText(doc, "$fechaIngreso", obj.getFechaIngreso());
            doc = replaceText(doc, "$numRegistro", obj.getNumRegistro());
            doc = replaceText(doc, "$valorEconomico", obj.getValorEconomico());
            doc = replaceText(doc, "$nombreFuente", obj.getNombreFuente());
            doc = replaceText(doc, "$fechaInventario", obj.getFechaInventario());
            
            doc = replaceText(doc, "$numInventario", obj.getNumInventario());
            doc = replaceText(doc, "$otrosNumeros", obj.getOtrosNumeros());
            doc = replaceText(doc, "$direccionFuente", obj.getDireccionFuente());
            doc = replaceText(doc, "$fechaCatalogo", obj.getFechaCatalogo());
            doc = replaceText(doc, "$espesor", obj.getEspesor());
            doc = replaceText(doc, "$alto", obj.getAlto());
            doc = replaceText(doc, "$ancho", obj.getAncho());
            doc = replaceText(doc, "$largo", obj.getLargo());
            doc = replaceText(doc, "$diametro", obj.getDiametro());
            doc = replaceText(doc, "$peso", obj.getPeso());
            doc = replaceText(doc, "$procedencia", obj.getProcedencia());
            doc = replaceText(doc, "$materiaYTecnica", obj.getMateriaYTecnica());
            doc = replaceText(doc, "$numeroNegativo", obj.getNumeroNegativo());
            doc = replaceText(doc, "$autor", obj.getAutor());
            doc = replaceText(doc, "$epoca", obj.getEpoca());
            doc = replaceText(doc, "$descripcion", obj.getDescripcion());
            doc = replaceText(doc, "$documentacion", obj.getDocumentacion());
            doc = replaceText(doc, "$observaciones", obj.getObservaciones());
            doc = replaceText(doc, "$recibio", obj.getRecibio());
            doc = replaceText(doc, "$inventario", obj.getInventario());
            doc = replaceText(doc, "$catalogo", obj.getCatalogo());
            doc = replaceText(doc, "$aprobo", obj.getAprobo());
            
            
            saveWord(filePathFinal, doc);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private HWPFDocument replaceText(HWPFDocument doc, String findText, String replaceText){
        
        Range r1 = doc.getRange(); 

        for (int i = 0; i < r1.numSections(); ++i ) { 
            Section s = r1.getSection(i); 
            for (int x = 0; x < s.numParagraphs(); x++) { 
                Paragraph p = s.getParagraph(x); 
                for (int z = 0; z < p.numCharacterRuns(); z++) { 
                    CharacterRun run = p.getCharacterRun(z); 
                    String text = run.text();
                    
                    if(text.contains(findText)) {
                        
                        if (replaceText == null){
                            System.out.println("null");
                            replaceText = "";
                        }
                        
                        run.replaceText(findText, replaceText);
                    }
                    
                }
            }
        } 
        return doc;
    }

    
    private void saveWord(String filePath, HWPFDocument doc) throws FileNotFoundException, IOException{
        FileOutputStream out = null;
        try{
            out = new FileOutputStream(filePath);
            doc.write(out);
        }
        finally{
            out.close();
        }
    }
    
    
    
    
//    public void convert() throws FileNotFoundException, IOException{
//
//        POIFSFileSystem fs = null;  
//        Document document = new Document();
//
//         try {  
//             System.out.println("Starting the test");  
//             fs = new POIFSFileSystem(new FileInputStream("HojaInventarioObjeto.doc"));  
//
//             HWPFDocument doc = new HWPFDocument(fs);  
//             WordExtractor we = new WordExtractor(doc);  
//
//             OutputStream file = new FileOutputStream(new File("test.pdf")); 
//
//             PdfWriter writer = PdfWriter.getInstance(document, file);  
//
//             Range range = doc.getRange();
//             document.open();  
//             writer.setPageEmpty(true);  
//             document.newPage();  
//             writer.setPageEmpty(true);  
//
//             String[] paragraphs = we.getParagraphText();  
//             for (int i = 0; i < paragraphs.length; i++) {  
//
//                 org.apache.poi.hwpf.usermodel.Paragraph pr = range.getParagraph(i);
//                 CharacterRun run = pr.getCharacterRun(i);
//                 run.setBold(true);
//                 run.setCapitalized(true);
//                 run.setItalic(true);
//                 paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", "");  
//             System.out.println("Length:" + paragraphs[i].length());  
//             System.out.println("Paragraph" + i + ": " + paragraphs[i].toString());  
//
//             // add the paragraph to the document  
//             document.add(new com.lowagie.text.Paragraph(paragraphs[i]));  
//             }  
//
//             System.out.println("Document testing completed");  
//         } catch (Exception e) {  
//             System.out.println("Exception during test");  
//             e.printStackTrace();  
//         } finally {  
//                         // close the document  
//            document.close();  
//                     } 
//    }  
    
    
}
