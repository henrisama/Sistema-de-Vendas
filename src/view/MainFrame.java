package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfFormaPagamento, tfGastosAdicionais, tfDataVenda, tfTempoGarantia;
    JLabel lbInicio;

    public void initialize() {
        // Formulario

        // Campo1
        JLabel lbFormaPagamento = new JLabel("Forma de pagamento:");
        lbFormaPagamento.setFont(mainFont);

        tfFormaPagamento = new JTextField();
        tfFormaPagamento.setFont(mainFont);

        // Campo2
        JLabel lbGastosAdicionais = new JLabel("Gastos adicionais:");
        lbGastosAdicionais.setFont(mainFont);

        tfGastosAdicionais = new JTextField();
        tfGastosAdicionais.setFont(mainFont);

        // Campo3
        JLabel lbDataVenda = new JLabel("Data da venda:");
        lbDataVenda.setFont(mainFont);

        tfDataVenda = new JTextField();
        tfDataVenda.setFont(mainFont);

        // Campo
        JLabel lbTempoGarantia = new JLabel("Tempo de Garantia:");
        lbTempoGarantia.setFont(mainFont);

        tfTempoGarantia = new JTextField();
        tfTempoGarantia.setFont(mainFont);

        // Grid
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.add(lbFormaPagamento);
        formPanel.add(tfFormaPagamento);
        formPanel.add(lbGastosAdicionais);
        formPanel.add(tfGastosAdicionais);
        formPanel.add(lbTempoGarantia);
        formPanel.add(tfTempoGarantia);
        formPanel.add(lbDataVenda);
        formPanel.add(tfDataVenda);

        // Página inicial
        lbInicio = new JLabel();
        lbInicio.setFont(mainFont);

        // Botoes
        JButton btnConluir = new JButton("Concluir");
        btnConluir.setFont(mainFont);
        btnConluir.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String formaPagamento = tfFormaPagamento.getText();
                String gastosAdd = tfGastosAdicionais.getText();
                String dataVenda = tfDataVenda.getText();
                String tempoGarantia = tfTempoGarantia.getText();
                lbInicio.setText("Forma de pagamento: " + formaPagamento+ " Gastos Adicionais: " 
                + gastosAdd + "Data venda: " + dataVenda+ " Tempo de garantia: " + tempoGarantia);
                
            }

        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(mainFont);
        btnCancelar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                tfFormaPagamento.setText("");
                tfGastosAdicionais.setText("");
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
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(lbInicio, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Registrar Venda");
        setSize(1440, 1024);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.initialize();
    }
}
