package editor.framework.editorexampleplugin;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class EditorExamplePlugin implements IPlugin {

    @Override
    public void initialize() {
        System.out.println("Initializing example plugin");
        JMenuItem newItem = ICore.getInstance().getUiController().addMenuItem("File", new javax.swing.JMenuItem("New text document"));
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        }
    }
    
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        JOptionPane.showMessageDialog(null, "Parabéns ! Voce clicou no item do plugin !", "Plugin de Teste", JOptionPane.INFORMATION_MESSAGE);
    }                                      

}
