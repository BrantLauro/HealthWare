
package corp.healthware.view.cell.buttons;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorNoView extends DefaultCellEditor {
    
    private TableActionEventNoView event;
    
    public TableActionCellEditorNoView(TableActionEventNoView event) {
        super(new JCheckBox());
        this.event = event;
    }

    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActionPanelNoView action = new ActionPanelNoView();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
