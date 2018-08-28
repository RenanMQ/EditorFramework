package editor.framework.shell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class DocumentTXT {
    
    public boolean openDocumentTXT() {

        try {
            FileReader arq = new FileReader("documents/hello.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            System.out.println("\nLendo o arquivo...\n");
            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
            return true;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return false;
        }
    }
 
    public void showDocumentTXT() {
        if (openDocumentTXT() == true) {
            JOptionPane.showMessageDialog(null, "Arquivo lido com sucesso", "Sucesso", JOptionPane.NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel ler o arquivo", "Erro", JOptionPane.OK_OPTION);
        }

    }
}
