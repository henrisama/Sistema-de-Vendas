package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Static.StaticVariables;
import controller.DevolucaoControle;
import utils.Devolucao;
import utils.ItemVendido;

import java.awt.*;

public class RegistrarDevolucao extends JFrame{
  DevolucaoControle controle = new DevolucaoControle();

  public RegistrarDevolucao(String codItemVendido){
    
    // labels
    JLabel lbCodItemVenda_label = new JLabel("Código Item Vendido:");
    JLabel lbCodItemVenda_valor = new JLabel(codItemVendido);
    JLabel lbData = new JLabel("Data:");
    JLabel lbValor = new JLabel("Valor:");
    JLabel lbForma = new JLabel("Forma:");
    JLabel lbMotivo = new JLabel("Motivo:");

    // text fields
    JTextField tfData = new JTextField();
    JTextField tfValor = new JTextField();
    JTextField tfForma = new JTextField();
    JTextField tfMotivo = new JTextField();

    // buttons
    JButton cancelarButton = new JButton("Cancelar");
    JButton confirmarButton = new JButton("Confirmar");

    // listener
    confirmarButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        Devolucao devolucao = controle.getDevolucao();
        devolucao.setData(tfData.getText());
        devolucao.setForma(tfForma.getText());
        devolucao.setMotivo(tfMotivo.getText());
        devolucao.setValor(Double.parseDouble(tfValor.getText()));
        devolucao.getItem().setId(Integer.parseInt(codItemVendido));

        int result = devolucao.resgitrarDevolucao();

        if(result == 1){
          JOptionPane.showMessageDialog(
            null,
            "Devolução registrada!", 
            "Mensagem de sucesso",
            JOptionPane.PLAIN_MESSAGE
          );
          setVisible(false);
          dispose();
        }else{
          JOptionPane.showMessageDialog(
            null,
            "Erro ao fazer devolução", 
            "Mensagem de erro",
            JOptionPane.ERROR_MESSAGE
          );
        }
      }
    });

    // font
    lbCodItemVenda_label.setFont(StaticVariables.staticFont);
    lbCodItemVenda_valor.setFont(StaticVariables.staticFont);
    lbData.setFont(StaticVariables.staticFont);
    lbValor.setFont(StaticVariables.staticFont);
    lbForma.setFont(StaticVariables.staticFont);
    lbMotivo.setFont(StaticVariables.staticFont);

    tfData.setFont(StaticVariables.staticFont);
    tfValor.setFont(StaticVariables.staticFont);
    tfForma.setFont(StaticVariables.staticFont);
    tfMotivo.setFont(StaticVariables.staticFont);

    cancelarButton.setFont(StaticVariables.staticFont);
    confirmarButton.setFont(StaticVariables.staticFont);

    // panels
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new GridLayout(5, 2, 5, 5));
    formPanel.add(lbCodItemVenda_label);
    formPanel.add(lbCodItemVenda_valor);
    formPanel.add(lbData);
    formPanel.add(tfData);
    formPanel.add(lbValor);
    formPanel.add(tfValor);
    formPanel.add(lbForma);
    formPanel.add(tfForma);
    formPanel.add(lbMotivo);
    formPanel.add(tfMotivo);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1,2));
    buttonPanel.add(cancelarButton);
    buttonPanel.add(confirmarButton);

    add(formPanel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.SOUTH);


    setTitle("Registrar Devolução");
    setSize(1200, 800);
    setMinimumSize(new Dimension(300, 400));
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }
}
