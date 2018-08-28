
package editor.framework.shell;

import editor.framework.interfaces.IUiController;
import javax.swing.JMenuItem;

public class UiController implements IUiController {

    public UiController()
    {
        mainWindow = new MainWindow();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow.setVisible(true);
            }
        });
    }
    
    @Override
    public JMenuItem addMenuItem(String menuText, JMenuItem item) {
        return mainWindow.addMenuItem(menuText, item);
    }
    
    private MainWindow mainWindow;
}
