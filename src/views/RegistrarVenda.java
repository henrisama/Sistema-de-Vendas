package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import Static.StaticVariables;
import controller.RegistrarVendaControle;

public class RegistrarVenda extends JFrame{
  RegistrarVendaControle controller = new RegistrarVendaControle();
  private List<String> columns = new ArrayList<String>();
  private List<String[]> values = new ArrayList<String[]>();

  

  public RegistrarVenda() {
    // table
    columns.add("Código");
    columns.add("Nome");
    columns.add("Quantidade");
    columns.add("Valor Unitário");
    columns.add("Valor Total");
    
    DefaultTableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
    JTable registerTable = new JTable(tableModel){
      public boolean editCellAt(int row, int column, java.util.EventObject e) {
        return false;
      }
    };
    
    // labels
    JLabel lbDataVenda = new JLabel("Data da venda:");
    JLabel lbValorTotal = new JLabel("Valor Total:");
    JLabel lbTempoGarantia = new JLabel("Tempo de Garantia:");
    JLabel lbFormaPagamento = new JLabel("Forma de pagamento:");
    JLabel lbDataPagamento = new JLabel("Data Pagamento:");
    JLabel lbValorPagamento = new JLabel("Valor Pagamento:");
    JLabel lbCodCliente = new JLabel("CPF Cliente:");
    
    // text fields
    JTextField tfDataVenda = new JTextField();
    JTextField tfValorTotal = new JTextField();
    JTextField tfTempoGarantia = new JTextField();
    JTextField tfFormaPagamento = new JTextField();
    JTextField tfDataPagamento = new JTextField();
    JTextField tfValorPagamento = new JTextField();
    JTextField tfCodCliente = new JTextField();

    // buttons
    JButton btnConluir = new JButton("Concluir");
    JButton btnCancelar = new JButton("Cancelar");
    JButton btnAdicionar = new JButton("Adicionar");
    
    //fonts
    lbDataVenda.setFont(StaticVariables.staticFont);
    tfDataVenda.setFont(StaticVariables.staticFont);
    lbValorTotal.setFont(StaticVariables.staticFont);
    tfValorTotal.setFont(StaticVariables.staticFont);
    lbTempoGarantia.setFont(StaticVariables.staticFont);
    tfTempoGarantia.setFont(StaticVariables.staticFont);
    lbFormaPagamento.setFont(StaticVariables.staticFont);
    tfFormaPagamento.setFont(StaticVariables.staticFont);
    lbDataPagamento.setFont(StaticVariables.staticFont);
    tfDataPagamento.setFont(StaticVariables.staticFont);
    lbValorPagamento.setFont(StaticVariables.staticFont);
    tfValorPagamento.setFont(StaticVariables.staticFont);
    lbCodCliente.setFont(StaticVariables.staticFont);
    tfCodCliente.setFont(StaticVariables.staticFont);
    btnConluir.setFont(StaticVariables.staticFont);
    btnCancelar.setFont(StaticVariables.staticFont);
    btnAdicionar.setFont(StaticVariables.staticFont);

    // listeners
    tfFormaPagamento.getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) { warn(); }
      public void removeUpdate(DocumentEvent e) { warn(); }
      public void insertUpdate(DocumentEvent e) { warn(); }

      public void warn(){
        controller.venda.setTipoPagamento(tfFormaPagamento.getText().toUpperCase());
        if(!controller.verificarTipoPagamento()){
          System.out.println("Tipo de pagamento inválido");
        }else{
          System.out.println("Tipo de pagamento válido");
        }
      }
    });

      // Campo2

     tfDataPagamento.getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) { warn(); }
      public void removeUpdate(DocumentEvent e) { warn(); }
      public void insertUpdate(DocumentEvent e) { warn(); }

      public void warn(){
        controller.venda.setDataPagamento(tfDataPagamento.getText());
        if(!controller.verificarDataPagamento()){
          System.out.println("Data inválida");
        }else{
          System.out.println("Data válido");
        }
      }
    });

      // Campo3
      tfDataVenda.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { warn(); }
        public void removeUpdate(DocumentEvent e) { warn(); }
        public void insertUpdate(DocumentEvent e) { warn(); }

        public void warn(){
          controller.venda.setData(tfDataVenda.getText());
          if(!controller.verificarData()){
            System.out.println("Data inválida");
          }else{
            System.out.println("Data válido");
          }
        }
      });

      // Campo4
      
      tfTempoGarantia.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { warn(); }
        public void removeUpdate(DocumentEvent e) { warn(); }
        public void insertUpdate(DocumentEvent e) { warn(); }

        public void warn(){
          String tg = tfTempoGarantia.getText();
          if(tg.length() == 0){
            controller.venda.setTempoGarantia(0);
          }else{
            try{
              controller.venda.setTempoGarantia(Integer.parseInt(tfTempoGarantia.getText()));
            }catch(Exception e){
              System.out.println("Apenas numeros");
            }
          }
        }
      });

      // Campo5
      
      tfValorTotal.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { warn(); }
        public void removeUpdate(DocumentEvent e) { warn(); }
        public void insertUpdate(DocumentEvent e) { warn(); }

        public void warn(){
          String num = tfValorTotal.getText();

          if(num.length() == 0){
            controller.venda.setValorTotal(0.0);
          }
          else{
            try{
              controller.venda.setValorTotal(Double.parseDouble(tfValorTotal.getText()));
            }catch(Exception e){
              System.out.println("Apenas numeros");
            }
          }
        }
      });

      // Campo6
      
      tfValorPagamento.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { warn(); }
        public void removeUpdate(DocumentEvent e) { warn(); }
        public void insertUpdate(DocumentEvent e) { warn(); }

        public void warn(){
          try{
            controller.venda.setValorPagamento(Double.parseDouble(tfValorPagamento.getText()));
          }catch(Exception e){
            System.out.println("Apenas numeros");
          }
        }
      });

      // Campo7
      
      
      tfCodCliente.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) { warn(); }
        public void removeUpdate(DocumentEvent e) { warn(); }
        public void insertUpdate(DocumentEvent e) { warn(); }

        public void warn(){
          String cpf = tfCodCliente.getText();
          if(cpf.length() > 0){
            char lastCaracter = cpf.charAt(cpf.length() - 1);
  
            if(lastCaracter < '0' || lastCaracter > '9'){
              System.out.println("Apenas números");
            }
            controller.venda.getCliente().setCPF(cpf);
          }
        }
      });
      
    btnConluir.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        int result = controller.handleConcluir();

        switch (result) {
          case 0:
            JOptionPane.showMessageDialog(
              null,
              "Venda registrada!", 
              "Mensagem de sucesso",
              JOptionPane.PLAIN_MESSAGE
            );
            setVisible(false);
            dispose();
            break;
          case 1:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Data inválida!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 2:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Valor inválido!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 3:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Período de garantia inválido!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 4:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Forma de pagamento inválida!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 5:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Data de pagamento inválida!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 6:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Valor de pagamento inválido!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 7:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Código do cliente inválido!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 8:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Código do atendente inválido!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
          case 9:
            JOptionPane.showMessageDialog(
              null,
              "Erro: Problema no banco de dados!", 
              "Mensagem de erro",
              JOptionPane.ERROR_MESSAGE
            );
            break;
        }
      }
    });

    btnCancelar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        tfDataVenda.setText("");
        tfValorTotal.setText("");
        tfTempoGarantia.setText("");
        tfFormaPagamento.setText("");
        tfDataPagamento.setText("");
        tfValorPagamento.setText("");
        tfCodCliente.setText("");

        controller.venda.clearItemsVendidos();
        
        while(tableModel.getRowCount() > 0){
          tableModel.removeRow(0);
        }
      }
    });

    btnAdicionar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
          new AdicionarProduto(controller, tableModel).setVisible(true);;
      }
    });

    // panels
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(7, 2, 5, 5));
    formPanel.add(lbDataVenda);
    formPanel.add(tfDataVenda);
    formPanel.add(lbValorTotal);
    formPanel.add(tfValorTotal);
    formPanel.add(lbTempoGarantia);
    formPanel.add(tfTempoGarantia);
    formPanel.add(lbFormaPagamento);
    formPanel.add(tfFormaPagamento);
    formPanel.add(lbDataPagamento);
    formPanel.add(tfDataPagamento);
    formPanel.add(lbValorPagamento);
    formPanel.add(tfValorPagamento);
    formPanel.add(lbCodCliente);
    formPanel.add(tfCodCliente);


    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
    buttonsPanel.add(btnConluir);
    buttonsPanel.add(btnCancelar);
    buttonsPanel.add(btnAdicionar); 


    add(new JScrollPane(registerTable), BorderLayout.NORTH);
    add(formPanel, BorderLayout.CENTER);
    add(buttonsPanel, BorderLayout.SOUTH);

    setTitle("Registrar Venda");
    setSize(1200, 800);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
}
