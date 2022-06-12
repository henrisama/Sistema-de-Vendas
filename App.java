
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Static.StaticVariables;
import views.Vendas;


public class App extends JFrame{

  public App(){
    // buttons
    JButton vendasButton = new JButton("Vendas");
    JButton devolucoesButton = new JButton("Devoluções");
    JButton produtosButton = new JButton("Produtos");

    vendasButton.setFont(StaticVariables.staticFont);
    devolucoesButton.setFont(StaticVariables.staticFont);
    produtosButton.setFont(StaticVariables.staticFont);

    vendasButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        new Vendas().setVisible(true);
      }
    });

    devolucoesButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        
      }
    });

    produtosButton.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent e) {
        
      }
    });

    // buttons panel
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(1, 3, 5, 5));
    buttonsPanel.add(vendasButton);
    buttonsPanel.add(devolucoesButton);
    buttonsPanel.add(produtosButton);

    // config
    add(buttonsPanel, BorderLayout.CENTER);
    setTitle("Sistema de Vendas");
    setSize(1200, 800);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    new App().setVisible(true);;
  }
}