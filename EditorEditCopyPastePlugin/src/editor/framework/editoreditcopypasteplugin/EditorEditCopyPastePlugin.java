package editor.framework.editoreditcopypasteplugin;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IPlugin;

public class EditorEditCopyPastePlugin  implements IPlugin {

    @Override
    public void initialize() {
        System.out.println("Initializing example plugin");
        ICore.getInstance().getUiController().addMenuItem("Edit", new javax.swing.JMenuItem("Copy"));
    }
    
}
