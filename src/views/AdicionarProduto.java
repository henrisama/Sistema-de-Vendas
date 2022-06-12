package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Static.StaticVariables;
import controller.RegistrarVendaControle;
import utils.Produto;

public class AdicionarProduto extends JFrame{
  
  public AdicionarProduto(
    RegistrarVendaControle controller,
    DefaultTableModel tableModel
  ){
    
    JTextField tfCodProduto = new JTextField();
    JTextField tfQtd = new JTextField();

    JLabel lbCodProduto = new JLabel("Código Produto:");
    JLabel lbQtd = new JLabel("Quantidade:");
    
    lbCodProduto.setFont(StaticVariables.staticFont);
    lbQtd.setFont(StaticVariables.staticFont);

    tfCodProduto.setFont(StaticVariables.staticFont);
    tfQtd.setFont(StaticVariables.staticFont);

    JButton btnCancelar = new JButton("Cancelar");
    JButton btnAdicionar = new JButton("Adicionar");

    btnCancelar.setFont(StaticVariables.staticFont);
    btnAdicionar.setFont(StaticVariables.staticFont);

    // action listener
    btnCancelar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        dispose();
      }
    });

    btnAdicionar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Produto produto = Produto.getProdutoByCod(tfCodProduto.getText());

        if(produto != null){
          int result = controller
            .venda
            .adicionarItem(tfCodProduto.getText(), Integer.parseInt(tfQtd.getText()));

          if(result == 1){
            tableModel.insertRow(0, new String[]{ 
              Integer.toString(produto.getID()),
              produto.getNome(),
              tfQtd.getText(),
              Double.toString(produto.getValorVenda()),
              Double.toString(Integer.parseInt(tfQtd.getText()) * produto.getValorVenda())
            });
  
            setVisible(false);
            dispose();
          }else{
            JOptionPane.showMessageDialog(
            null,
            "Quantidade inválida!", 
            "Mensagem de erro",
            JOptionPane.PLAIN_MESSAGE
          );
          }

        }else{
          JOptionPane.showMessageDialog(
            null,
            "Código inválido!", 
            "Mensagem de erro",
            JOptionPane.PLAIN_MESSAGE
          );
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


    add(formPanel, BorderLayout.NORTH);
    add(buttonsPanel, BorderLayout.SOUTH);


    setTitle("Adicionar Produto");
    setSize(600, 600);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    setVisible(true);
  }

}
