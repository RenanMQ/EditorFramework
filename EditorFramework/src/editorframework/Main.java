
package editorframework;

import editor.framework.shell.Core;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException
    {
        Core.initialize();   
        Core.initPlugins();
    }
}
