package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.RegistrarVendaControle;

public class RegistrarVenda extends JFrame{
  final private Font mainFont = new Font("Arial", Font.BOLD, 18);
  JTextField tfFormaPagamento,tfDataPagamento, tfDataVenda, tfTempoGarantia;
  JLabel lbInicio;

  public void initialize() {
      RegistrarVendaControle registrarVendaControle = new RegistrarVendaControle();

      // Formulario
        //table
        JPanel tabelaPainel = new JPanel();
        tabelaPainel.setLayout(new GridLayout(1,1));
        String[] colunas = {"Código", "Nome", "Quantidade", "Valor Unitário"};
        String[][] produtos = {{"teste","teste","teste","teste"}};
        JTable tabela = new JTable(produtos, colunas);

        //scroll
        JScrollPane tabelaScroll = new JScrollPane(tabela);
        tabelaPainel.add(tabelaScroll);


      // Campo1
      JLabel lbFormaPagamento = new JLabel("Forma de pagamento:");
      lbFormaPagamento.setFont(mainFont);
      

      tfFormaPagamento = new JTextField();
      tfFormaPagamento.setFont(mainFont);
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
          registrarVendaControle.venda.setTipoPagamento(tfFormaPagamento.getText().toUpperCase());
          if(!registrarVendaControle.verificarTipoPagamento()){
            System.out.println("Tipo de pagamento inválido");
          }else{
            System.out.println("Tipo de pagamento válido");
          }
        }
      });

      // Campo2
      JLabel lbDataPagamento = new JLabel("Data Pagamento:");
      lbDataPagamento.setFont(mainFont);

     tfDataPagamento = new JTextField();
     tfDataPagamento.setFont(mainFont);
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
        registrarVendaControle.venda.setDataPagamento(tfDataPagamento.getText());
        if(!registrarVendaControle.verificarDataPagamento()){
          System.out.println("Data inválida");
        }else{
          System.out.println("Data válido");
        }
      }
    });

      // Campo3
      JLabel lbDataVenda = new JLabel("Data da venda:");
      lbDataVenda.setFont(mainFont);

      tfDataVenda = new JTextField();
      tfDataVenda.setFont(mainFont);
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
          registrarVendaControle.venda.setData(tfDataVenda.getText());
          if(!registrarVendaControle.verificarData()){
            System.out.println("Data inválida");
          }else{
            System.out.println("Data válido");
          }
        }
      });

      // Campo4
      JLabel lbTempoGarantia = new JLabel("Tempo de Garantia:");
      lbTempoGarantia.setFont(mainFont);

      tfTempoGarantia = new JTextField();
      tfTempoGarantia.setFont(mainFont);
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
          try{
            registrarVendaControle.venda.setTempoGarantia(Integer.parseInt(tfTempoGarantia.getText()));
          }catch(Exception e){
            System.out.println("Apenas numeros");
          }
        }
      });

      // Campo5
      JLabel lbValorTotal = new JLabel("Valor Total:");
      lbValorTotal.setFont(mainFont);

      JTextField tfValorTotal = new JTextField();
      tfValorTotal.setFont(mainFont);
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
            registrarVendaControle.venda.setValorTotal(0.0);
          }
          else{
            try{
              registrarVendaControle.venda.setValorTotal(Double.parseDouble(tfValorTotal.getText()));
            }catch(Exception e){
              System.out.println("Apenas numeros");
            }
          }
        }
      });

      // Campo6
      JLabel lbValorPagamento = new JLabel("Valor Pagamento:");
      lbValorPagamento.setFont(mainFont);

      JTextField tfValorPagamento = new JTextField();
      tfValorPagamento.setFont(mainFont);
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
            registrarVendaControle.venda.setValorPagamento(Double.parseDouble(tfValorPagamento.getText()));
          }catch(Exception e){
            System.out.println("Apenas numeros");
          }
        }
      });

      // Campo7
      JLabel lbCodCliente = new JLabel("CPF Cliente:");
      lbCodCliente.setFont(mainFont);

      JTextField tfCodCliente = new JTextField(11);
      tfCodCliente.setFont(mainFont);
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
              //String realcpf = cpf.substring(0, cpf.length() - 1);
              System.out.println("Apenas números");
            }
            registrarVendaControle.cliente.setCPF(tfCodCliente.getText());
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
      lbInicio.setFont(mainFont);

      // Botoes
      JButton btnConluir = new JButton("Concluir");
      btnConluir.setFont(mainFont);
      btnConluir.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {   
            System.out.println(registrarVendaControle.venda.toString());
            int result = registrarVendaControle.handleConcluir();

            switch (result) {
              case 0:
                JOptionPane.showMessageDialog(
                  null,
                  "Venda registrada!", 
                  "Mensagem de sucesso",
                  JOptionPane.ERROR_MESSAGE
                );
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
              case 7:
                JOptionPane.showMessageDialog(
                  null,
                  "Erro: Código do cliente inválido!", 
                  "Mensagem de erro",
                  JOptionPane.ERROR_MESSAGE
                );
                break;
            }
              
          }

      });

      JButton btnCancelar = new JButton("Cancelar");
      btnCancelar.setFont(mainFont);
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
      btnAdicionar.setFont(mainFont);
      btnAdicionar.addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              
          }
          
      });

      // Layout Botões
      JPanel buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
      buttonsPanel.add(btnConluir);
      buttonsPanel.add(btnCancelar);
      buttonsPanel.add(btnAdicionar); 


      // Layout Principal
      JPanel mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());
      mainPanel.setBackground(new Color(255, 250, 250));
      mainPanel.add(tabelaPainel, BorderLayout.NORTH);
      mainPanel.add(formPanel, BorderLayout.CENTER);
      mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

      add(mainPanel);

      setTitle("Registrar Venda");
      setSize(1200, 800);
      setMinimumSize(new Dimension(300, 400));
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setVisible(true);
  }
}
