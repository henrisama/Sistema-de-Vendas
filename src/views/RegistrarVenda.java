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

  JTextField tfFormaPagamento,tfDataPagamento, tfDataVenda, tfTempoGarantia;
  JLabel lbInicio;

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

    

      // Campo1
      JLabel lbFormaPagamento = new JLabel("Forma de pagamento:");
      lbFormaPagamento.setFont(StaticVariables.staticFont);
      

      tfFormaPagamento = new JTextField();
      tfFormaPagamento.setFont(StaticVariables.staticFont);
      tfFormaPagamento.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

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
      JLabel lbDataPagamento = new JLabel("Data Pagamento:");
      lbDataPagamento.setFont(StaticVariables.staticFont);

     tfDataPagamento = new JTextField();
     tfDataPagamento.setFont(StaticVariables.staticFont);
     tfDataPagamento.getDocument().addDocumentListener(new DocumentListener() {
      public void changedUpdate(DocumentEvent e) {
        warn();
      }
      public void removeUpdate(DocumentEvent e) {
        warn();
      }
      public void insertUpdate(DocumentEvent e) {
        warn();
      }

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
      JLabel lbDataVenda = new JLabel("Data da venda:");
      lbDataVenda.setFont(StaticVariables.staticFont);

      tfDataVenda = new JTextField();
      tfDataVenda.setFont(StaticVariables.staticFont);
      tfDataVenda.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

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
      JLabel lbTempoGarantia = new JLabel("Tempo de Garantia:");
      lbTempoGarantia.setFont(StaticVariables.staticFont);

      tfTempoGarantia = new JTextField();
      tfTempoGarantia.setFont(StaticVariables.staticFont);
      tfTempoGarantia.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

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
      JLabel lbValorTotal = new JLabel("Valor Total:");
      lbValorTotal.setFont(StaticVariables.staticFont);

      JTextField tfValorTotal = new JTextField();
      tfValorTotal.setFont(StaticVariables.staticFont);
      tfValorTotal.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

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
      JLabel lbValorPagamento = new JLabel("Valor Pagamento:");
      lbValorPagamento.setFont(StaticVariables.staticFont);

      JTextField tfValorPagamento = new JTextField();
      tfValorPagamento.setFont(StaticVariables.staticFont);
      tfValorPagamento.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

        public void warn(){
          try{
            controller.venda.setValorPagamento(Double.parseDouble(tfValorPagamento.getText()));
          }catch(Exception e){
            System.out.println("Apenas numeros");
          }
        }
      });

      // Campo7
      JLabel lbCodCliente = new JLabel("CPF Cliente:");
      lbCodCliente.setFont(StaticVariables.staticFont);

      JTextField tfCodCliente = new JTextField(11);
      tfCodCliente.setFont(StaticVariables.staticFont);
      tfCodCliente.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
          warn();
        }
        public void removeUpdate(DocumentEvent e) {
          warn();
        }
        public void insertUpdate(DocumentEvent e) {
          warn();
        }

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

      // Grid
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

      // Página inicial
      lbInicio = new JLabel();
      lbInicio.setFont(StaticVariables.staticFont);

      // Botoes
      JButton btnConluir = new JButton("Concluir");
      btnConluir.setFont(StaticVariables.staticFont);
      btnConluir.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {   
            System.out.println(controller.venda.toString());
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

      JButton btnCancelar = new JButton("Cancelar");
      btnCancelar.setFont(StaticVariables.staticFont);
      btnCancelar.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
            tfFormaPagamento.setText("");
            tfDataPagamento.setText("");
            tfTempoGarantia.setText("");
            tfDataVenda.setText("");
          }
      });

      JButton btnAdicionar = new JButton("Adicionar");
      btnAdicionar.setFont(StaticVariables.staticFont);
      btnAdicionar.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              new AdicionarProduto(controller, tableModel);
          }
      });

      // Layout Botões
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
