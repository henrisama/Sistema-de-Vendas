package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import utils.Produto;
import utils.Produtos;

public class AdicionarProduto extends JFrame{
  final private Font mainFont = new Font("Arial", Font.BOLD, 18);

  public AdicionarProduto(Produtos produtos){
    JLabel lbCodProduto = new JLabel("Código Produto:");
    lbCodProduto.setFont(mainFont);
    

    JTextField tfCodProduto = new JTextField();
    tfCodProduto.setFont(mainFont);
    tfCodProduto.getDocument().addDocumentListener(new DocumentListener() {
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
      }
    });

    // Campo2
    JLabel lbQtd = new JLabel("Quantidade:");
    lbQtd.setFont(mainFont);

    JTextField tfQtd = new JTextField();
    tfQtd.setFont(mainFont);
    tfQtd.getDocument().addDocumentListener(new DocumentListener() {
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
        
      }
    });

    JButton btnCancelar = new JButton("Cancelar");
    btnCancelar.setFont(mainFont);
    btnCancelar.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
      }
    });

    JButton btnAdicionar = new JButton("Adicionar");
    btnAdicionar.setFont(mainFont);
    btnAdicionar.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        
        Produto produto = Produto.getProduto(tfCodProduto.getText());

        if(produto != null){
          produtos.produtos[produtos.index_produtos][0] = produto.getCodigo();
          produtos.produtos[produtos.index_produtos][1] = produto.getNome();
          produtos.produtos[produtos.index_produtos][2] = tfQtd.getText();
          produtos.produtos[produtos.index_produtos][3] = Double.toString(produto.getValorCusto());

          
          int i;
          for(i=0; i<=produtos.index_produtos; i++){
            System.out.print(produtos.produtos[i][0]+" ");
            System.out.print(produtos.produtos[i][1]+" ");
            System.out.print(produtos.produtos[i][2]+" ");
            System.out.println(produtos.produtos[i][3]+" ");
          }
          System.out.println(produtos.index_produtos);
          produtos.index_produtos++;

          setVisible(false);
          dispose();
        }
      }
      
    });

    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(2, 2, 5, 5));
    formPanel.add(lbCodProduto);
    formPanel.add(tfCodProduto);
    formPanel.add(lbQtd);
    formPanel.add(tfQtd);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
    buttonsPanel.add(btnCancelar);
    buttonsPanel.add(btnAdicionar); 

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.setBackground(new Color(255, 250, 250));
    //mainPanel.add(tabelaPainel, BorderLayout.NORTH);
    mainPanel.add(formPanel, BorderLayout.NORTH);
    mainPanel.add(buttonsPanel, BorderLayout.SOUTH);


    add(mainPanel);


    setTitle("Registrar Venda");
    setSize(400, 400);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
  }

}
