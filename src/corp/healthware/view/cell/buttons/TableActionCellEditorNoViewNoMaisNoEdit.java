
package corp.healthware.view.cell.buttons;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableActionCellEditorNoViewNoMaisNoEdit extends DefaultCellEditor {
    
    private TableActionEventNoViewNoMais event;
    
    public TableActionCellEditorNoViewNoMaisNoEdit(TableActionEventNoViewNoMais event) {
        super(new JCheckBox());
        this.event = event;
    }

    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        ActionPanelNoViewNoMais action = new ActionPanelNoViewNoMais();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }
}
