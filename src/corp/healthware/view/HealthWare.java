
package corp.healthware.view;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class HealthWare {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        UIManager.put( "Component.focusWidth", 0);

        new LoginFrame().setVisible(true);
        
    }
    
}
