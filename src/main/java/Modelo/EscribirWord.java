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



//import com.lowagie.text.Document;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.aspose.words.Document;
import java.util.List;
import static org.apache.poi.ss.formula.functions.NumericFunction.LOG;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
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
            
            doc = replaceText(doc, "$numCatalogo", obj.getNumCatalogo());
            
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
    
    
    //Configuracion
    public void cambiarLogo() throws FileNotFoundException, IOException, InvalidFormatException, Exception{
    
        //ASPOSE
//    Document doc = new Document("HojaInventarioObjeto.doc");
////    doc.save("Out.pdf");
    
//        HWPFDocument doc = new HWPFDocument(new FileInputStream("HojaInventarioTemplate.doc"));

    
    
        
        XWPFDocument document = new XWPFDocument(new FileInputStream("HojaInventarioTemplate.docx"));
        String imageOldName = "logo";
        try {
//            LOG.info("replaceImage: old=" + "logo" + ", new=" + "imagePathNew");
            String imagePathNew = "PlayStation_1_Logo.png";
            
            int newImageWidth = 1;
            int newImageHeight = 2;
                    
            int imageParagraphPos = -1;
            XWPFParagraph imageParagraph = null;

            List<IBodyElement> documentElements = document.getBodyElements();
            for(IBodyElement documentElement : documentElements){
                imageParagraphPos ++;
                if(documentElement instanceof XWPFParagraph){
                    imageParagraph = (XWPFParagraph) documentElement;
                    if(imageParagraph != null && imageParagraph.getCTP() != null && imageParagraph.getCTP().toString().trim().indexOf(imageOldName) != -1) {
                        break;
                    }
                }
            }

            if (imageParagraph == null) {
                throw new Exception("Unable to replace image data due to the exception:\n"
                        + "'" + imageOldName + "' not found in in document.");
            }
            ParagraphAlignment oldImageAlignment = imageParagraph.getAlignment();

            // remove old image
            document.removeBodyElement(imageParagraphPos-1);

            // now add new image

            // BELOW LINE WILL CREATE AN IMAGE
            // PARAGRAPH AT THE END OF THE DOCUMENT.
            // REMOVE THIS IMAGE PARAGRAPH AFTER 
            // SETTING THE NEW IMAGE AT THE OLD IMAGE POSITION
            XWPFParagraph newImageParagraph = document.createParagraph();    
            XWPFRun newImageRun = newImageParagraph.createRun();
            //newImageRun.setText(newImageText);
            newImageParagraph.setAlignment(oldImageAlignment);
            
            try (FileInputStream is = new FileInputStream(imagePathNew)) {
                newImageRun.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imagePathNew,
                             Units.toEMU(newImageWidth), Units.toEMU(newImageHeight)); 
            } 

            // set new image at the old image position
            document.setParagraph(newImageParagraph, imageParagraphPos);

            // NOW REMOVE REDUNDANT IMAGE FORM THE END OF DOCUMENT
            document.removeBodyElement(document.getBodyElements().size() - 1);

//            return document;
        } catch (Exception e) {
            throw new Exception("Unable to replace image '" + imageOldName + "' due to the exception:\n" + e);
        } finally {                                                 
        // cleanup code
    }
        
    }
    
    
}
