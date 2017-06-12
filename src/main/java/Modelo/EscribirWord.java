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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;



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
    
    public void cambiarLogo() throws FileNotFoundException, IOException, InvalidFormatException{
        //Colocar imagen
//        XWPFDocument doc = new XWPFDocument();
////        XWPFDocument doc = new XWPFDocument(new FileInputStream("HojaInventarioObjeto.doc"));
////
//        XWPFParagraph title = doc.createParagraph();    
//        XWPFRun run = title.createRun();
//        run.setText("Fig.1 A Natural Scene");
//        run.setBold(true);
//        title.setAlignment(ParagraphAlignment.CENTER);
//
//        String imgFile = "PlayStation_1_Logo.png";
//        FileInputStream is = new FileInputStream(imgFile);
//        run.addBreak();
//        run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
//        is.close();
//
//        FileOutputStream fos = new FileOutputStream("test4.doc");
//        doc.write(fos);
//        fos.close();

        //Header
//        
//        XWPFDocument docu = new XWPFDocument(new FileInputStream("test4.doc"));
//        
//        XWPFHeaderFooterPolicy headerFooterPolicy = docu.getHeaderFooterPolicy();
//        XWPFHeader defaultHeader = headerFooterPolicy.getDefaultHeader();
//        
//        defaultHeader.getParagraphs().get(0).getRuns().get(0).setText("New Text", 0);
//        // this is only to put some space between the content in the header and the real content
//        defaultHeader.getParagraphs().get(defaultHeader.getParagraphs().size() - 1).setSpacingAfter(300);

    
    }
    
    
}
