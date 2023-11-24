
package corp.healthware.view;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class HealthWare {
    // tana vai me mamar
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatMacLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        new MainFrame().setVisible(true);
    }
    
}
