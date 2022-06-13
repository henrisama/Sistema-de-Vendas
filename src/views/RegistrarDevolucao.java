package views;

import javax.swing.*;

import Static.StaticVariables;

import java.awt.*;

public class RegistrarDevolucao extends JFrame{
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
