
package corp.healthware.view.cell.buttons;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableActionCellRenderNoView extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        ActionPanelNoView action = new ActionPanelNoView();
//        if (isSeleted == false && row % 2 == 0) {
//            action.setBackground(new Color(239,239,239));
//        } else {
//            action.setBackground(com.getBackground());
//        }
        action.setBackground(com.getBackground());
        return action;
    }
}
