
package corp.healthware.view.cell.buttons;

public interface TableActionEvent {
    
    public void onMais(int row);
    
    public void onView(int row);
    
    public void onEdit(int row);

    public void onDelete(int row);

    
}
