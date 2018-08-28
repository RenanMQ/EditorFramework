package editor.framework.shell;

import editor.framework.interfaces.ICore;
import editor.framework.interfaces.IDocument;
import editor.framework.interfaces.IPlugin;
import editor.framework.interfaces.IProjectController;
import editor.framework.interfaces.IUiController;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Core extends ICore {

    private UiController uiController;
    private ProjectController projectController;
    private DocumentPDF documentPDF;
    
    public static void initialize() {
        if (instance == null) {
            instance = new Core();
        }
    }
    
    @Override
    public IUiController getUiController() {
        return uiController;
    }

    @Override
    public IProjectController getProjectController() {
        return projectController;
    }
    
    @Override
    public IDocument getProjectDocument() {
        return documentPDF;
    }
    
    protected Core() {
        uiController = new UiController();
        projectController = new ProjectController();
        documentPDF = new DocumentPDF();
    }
    
    public static void getDocument() throws IOException{
        //IDocument document = new AdapterDocument(new DocumentTXT()); //com adapter
        IDocument document = new DocumentPDF(); //sem o adapter
        document.openDocument();
        document.showDocument(); 
    }
    
    public static void initPlugins() {
        File currentDir = new File("./plugins");
        String[] plugins = currentDir.list();
        int i;
        URL[] jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; i++) {
            System.out.println(i + 1 + " - " + plugins[i].split("\\.")[0]);
            try {
                jars[i] = (new File("./plugins/" + plugins[i])).toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        URLClassLoader ulc = new URLClassLoader(jars);
        for (i = 0; i < plugins.length; i++) {
            String factoryName = plugins[i].split("\\.")[0];
            try {
                IPlugin plugin = (IPlugin) Class.forName("editor.framework." + factoryName.toLowerCase() + "." + factoryName, true, ulc).newInstance();
                plugin.initialize();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
