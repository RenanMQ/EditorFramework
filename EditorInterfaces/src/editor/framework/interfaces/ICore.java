
package editor.framework.interfaces;

public abstract class ICore {
    
    public static ICore getInstance() {
        return instance;
    }

    public abstract IUiController getUiController();

    public abstract IProjectController getProjectController();
    
    public abstract IDocument getProjectDocument();

    protected static ICore instance = null;
}
