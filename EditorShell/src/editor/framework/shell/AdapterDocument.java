package editor.framework.shell;

import editor.framework.interfaces.IDocument;
import java.io.IOException;

public class AdapterDocument implements IDocument {

    private DocumentTXT document;
    
    public AdapterDocument(DocumentTXT document){
        this.document = document;
    }
    
    @Override
    public boolean openDocument() throws IOException {
       this.document.openDocumentTXT();
       return true;
    }

    @Override
    public void showDocument() {
        this.document.showDocumentTXT();
    }

   
}
