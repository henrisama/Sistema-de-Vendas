package views;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import utils.Venda;

public class Vendas extends JFrame{
  private List<String> columns = new ArrayList<String>();
  private List<String[]> values = new ArrayList<String[]>();

  public Vendas(){
    // table
    columns.add("ID");
    columns.add("Data");
    columns.add("Valor Total");
    columns.add("Tempo Garantia");
    columns.add("Tipo Pagamento");
    columns.add("Data Pagmento");
    columns.add("Valor Pagamento");
    columns.add("ID Funcionario");
    columns.add("CPF Cliente");

    values = Venda.getTodasVendas();

    TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
    JTable salesTable = new JTable(tableModel){
      public boolean editCellAt(int row, int column, java.util.EventObject e) {
         return false;
      }
    };
    
    salesTable.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
          JTable target = (JTable)me.getSource();
          int row = target.getSelectedRow();
          String idVenda = (String)salesTable.getValueAt(row, 0);
          new ItemsVenda(idVenda).setVisible(true);
        }
     }
    });

    // button
    JButton registrarVendaButton = new JButton("Resgitrar Venda");
    registrarVendaButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        new RegistrarVenda().setVisible(true);
      }
    });

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1,1,5,5));
    buttonsPanel.add(registrarVendaButton);


    add(new JScrollPane(salesTable), BorderLayout.CENTER);
    add(salesTable.getTableHeader(), BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);

    // config
    setTitle("Sistema de Vendas");
    setSize(1200, 800);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
}
