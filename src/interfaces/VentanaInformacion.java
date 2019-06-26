package interfaces;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class VentanaInformacion extends JFrame implements ActionListener {

      private VentanaPrincipal princ;
      private JLabel titulo, info;
      private JPanel panelSuperior, panelInferior;
      private JTextArea area;
      private String listado;
      private JButton volver;

      public VentanaInformacion(VentanaPrincipal princ, String listaVehiculos) {
            super();
            configurarVentana();
            iniciarComponentes(listaVehiculos);
            this.princ = princ;
            listado = listaVehiculos;
      }

      private void configurarVentana() {
            this.setTitle("Estacionamiento");
            this.setSize(710, 630);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      private void iniciarComponentes(String listaVehiculos) {
            panelInferior = new JPanel();
            panelSuperior = new JPanel();
            area = new JTextArea(listaVehiculos);
            info = new JLabel();
            titulo = new JLabel();
            volver = new JButton();
            panelSuperior();
            panelInferior();

      }

      private void panelSuperior() {
            Titulo();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 710, 210);
            panelSuperior.setLayout(null);
            this.add(titulo);
            this.add(panelSuperior);

      }

      private void Titulo() {
            titulo = new JLabel();
            titulo.setBounds(25, 25, 450, 150);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            titulo.setText("VEHICULOS");
            titulo.setForeground(Color.BLACK);
            titulo.setFont(new Font("Arial Black", Font.BOLD, 38));
            panelSuperior.add(titulo);
      }

      private void panelInferior() {
            crearInfo();
            botonVolver();
            area.setBounds(125, 70, 440, 190);   //x,y,ancho,alto
            panelInferior.add(area);
            panelInferior.setBackground(Color.BLUE);
            panelInferior.setBounds(0, 210, 710, 420);
            panelInferior.setLayout(null);

            this.add(panelInferior);

      }

      private void crearInfo() {
            info = new JLabel();
            info.setBounds(200, 30, 180, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            info.setText("Información: ");
            info.setForeground(Color.BLACK);
            info.setFont(new Font("Arial Black", Font.BOLD, 14));
            panelInferior.add(info);
      }

      private void botonVolver() {
            volver.setText("Volver");
            volver.setBounds(300, 300, 100, 30);
            volver.addActionListener(this);
            panelInferior.add(volver);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == volver) {
                  this.setVisible(false);
                  princ.setVentanaInformacion(this);
                  princ.setVisible(true);

            }
      }
}
