package editor.framework.shell;

import editor.framework.interfaces.IDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DocumentPDF implements IDocument {

    @Override
    public boolean openDocument() throws IOException {
        try (PDDocument document = PDDocument.load(new File("documents/factoryMethod.pdf"))) {
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                String lines[] = pdfFileInText.split("\\r?\\n");
                System.out.println("\nLendo o arquivo...\n");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
            return true;
        } catch (IOException e) {
            Logger.getLogger(DocumentPDF.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public void showDocument() {
        try {
            if (openDocument() == true) {
                JOptionPane.showMessageDialog(null,"Arquivo lido com sucesso", "Sucesso",JOptionPane.NO_OPTION);
            } else {
                JOptionPane.showMessageDialog(null,"Não foi possivel ler o arquivo", "Erro",JOptionPane.OK_OPTION);
            }
        } catch (IOException ex) {
            Logger.getLogger(DocumentPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
