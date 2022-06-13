package views;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import utils.ItemVendido;

public class ItemsVenda extends JFrame{
  private List<String> columns = new ArrayList<String>();
  private List<String[]> values = new ArrayList<String[]>();

  public ItemsVenda(String idVenda){
    // table
    columns.add("ID");
    columns.add("Quantidade");
    columns.add("Valor Unitário");
    columns.add("Valor Total");
    columns.add("ID Produto");
    columns.add("ID Venda");
    
    values = ItemVendido.getTodosItemsVendidos(idVenda);

    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
    JTable itemsTable = new JTable(tableModel){
      public boolean editCellAt(int row, int column, java.util.EventObject e) {
         return false;
      }
    };

    // popup
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem devolucaoMenu = new JMenuItem("Registrar devolução");
    popupMenu.add(devolucaoMenu);
    itemsTable.setComponentPopupMenu(popupMenu);
    
    // listener
    devolucaoMenu.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Component c = (Component)e.getSource();
        JPopupMenu popup = (JPopupMenu)c.getParent();
        JTable table = (JTable)popup.getInvoker();

        if(table.getSelectedRow() >= 0){
          String codItemVenda = (String)itemsTable.getValueAt(table.getSelectedRow(), 0);
          // open registrar devolucao window
        }
      }
    });

    itemsTable.addMouseListener(new MouseAdapter(){
      @Override
      public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(me)) {
          JTable target = (JTable)me.getSource();
          int row = target.getSelectedRow();
          JOptionPane.showMessageDialog(null, itemsTable.getValueAt(row, 0));
        }
     }
    });

    add(itemsTable.getTableHeader(), BorderLayout.NORTH);
    add(new JScrollPane(itemsTable), BorderLayout.CENTER);

    // config
    setTitle("Sistema de Vendas");
    setSize(1200, 800);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
}
