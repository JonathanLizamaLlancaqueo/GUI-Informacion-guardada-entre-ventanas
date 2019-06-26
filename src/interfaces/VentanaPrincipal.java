package interfaces;

import modeloProblema.Estacionamiento;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaPrincipal extends JFrame implements ActionListener {

      private JLabel texto, imagen, texto2;
      private JButton cargar, anadir, salir;
      private JPanel panelSuperior, panelInferior;
      private JTextField caja;
      private int contador = 0;
      private int contador2 = 0;
      private String listaVehiculos = "";
      private VentanaInformacion informacion;
      private VentanaAnadir insertar;

      private void configurarVentana() {
            this.setTitle("Estacionamiento");
            this.setSize(710, 630);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public VentanaPrincipal() {
            super();
            configurarVentana();
            iniciarComponentes();
      }

      public VentanaPrincipal getVentanaPrincipal() {
            return this;
      }

      private void iniciarComponentes() {
            texto = new JLabel();
            texto2 = new JLabel();
            cargar = new JButton();
            anadir = new JButton();
            salir = new JButton();
            panelInferior = new JPanel();
            panelSuperior = new JPanel();
            caja = new JTextField();

            panelSuperior();
            panelInferior();

      }

      private void titulo() {
            texto.setBounds(25, 25, 450, 150);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            texto.setText("ESTACIONAMIENTO");
            texto.setForeground(Color.BLACK);
            texto.setFont(new Font("Arial Black", Font.BOLD, 38));
            panelSuperior.add(texto);
      }

      private void informacion() {
            texto2.setBounds(20, 260, 130, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            texto2.setText("Ingrese Ruta:");
            texto2.setForeground(Color.BLACK);
            texto2.setFont(new Font("Arial Black", Font.BOLD, 12));
            panelInferior.add(texto2);
      }

      private void botonCargar() {
            cargar.setText("Cargar Vehiculos");
            cargar.setBounds(50, 350, 250, 50);
            cargar.addActionListener(informacion);
            panelInferior.add(cargar);
      }

      private void botonAnadir() {
            anadir.setText("Añadir Vehiculos");
            anadir.setBounds(350, 350, 250, 50);
            anadir.addActionListener(insertar);
            panelInferior.add(anadir);
      }

      private void botonSalir() {
            salir.setText("Salir");
            salir.setBounds(590, 560, 100, 30);
            salir.addActionListener(this);
            panelInferior.add(salir);

      }

      private void panelSuperior() {
            titulo();
            anadirImagen();
            panelSuperior.setBackground(Color.WHITE);
            panelSuperior.setBounds(0, 0, 710, 210);
            panelSuperior.setLayout(null);
            this.add(texto);
            this.add(imagen);
            this.add(panelSuperior);

      }

      private void anadirImagen() {
            imagen = new JLabel(new ImageIcon("C:\\Users\\Jeremias\\Documents\\NetBeansProjects\\POO\\estacionamientoOsorno\\src\\interfaces\\muni.png"));
            imagen.setBounds(530, 0, 200, 200);
            imagen.setOpaque(true);
            panelSuperior.add(imagen);
      }

      private void panelInferior() {
            botonCargar();
            botonAnadir();
            botonSalir();
            anadirCaja();
            informacion();
            panelInferior.setBackground(Color.BLUE);
            panelInferior.setBounds(0, 210, 710, 420);
            panelInferior.setLayout(null);
            this.add(cargar);
            cargar.addActionListener(this);
            this.add(anadir);
            anadir.addActionListener(this);
            this.add(caja);
            this.add(texto2);
            this.add(salir);
            this.add(panelInferior);

      }

      public void anadirCaja() {
            caja.setBounds(130, 260, 500, 25);
            caja.setText("Escriba la ruta");
            panelInferior.add(caja);

      }

      public void generarVehiculos() throws IOException {
            Estacionamiento autos = new Estacionamiento();
            boolean existencia = autos.cargarVehiculos(caja.getText());
            if (!existencia) {
                  JOptionPane.showMessageDialog(this, "Introdusca una ruta existente, porfavor!!!");
            } else {
                  listaVehiculos = autos.toString();
            }
      }

      public void mostrarVehiculos() throws IOException {
            Estacionamiento autos = new Estacionamiento();
            listaVehiculos = autos.toString();
      }

      @Override
      public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == anadir) {
                  if (contador2 == 0) {
                        try {
                              mostrarVehiculos();
                        } catch (IOException ex) {
                              Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        VentanaAnadir ins = new VentanaAnadir(getVentanaPrincipal(), listaVehiculos);
                        ins.setVisible(true);
                        this.setVisible(false);
                  } else {
                        insertar.setVisible(true);
                        this.setVisible(false);
                  }
                  contador2++;
            } else if (ae.getSource() == cargar) {
                  try {
                        generarVehiculos();
                  } catch (IOException ex) {
                        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  if (contador == 0) {
                        VentanaInformacion info = new VentanaInformacion(getVentanaPrincipal(), listaVehiculos);
                        info.setVisible(true);
                        this.setVisible(false);
                  } else {
                        informacion.setVisible(true);
                        this.setVisible(false);
                  }
                  contador++;
            } else if (ae.getSource() == salir) {
                  this.dispose();
                  informacion.dispose();
            }
      }

      public void setVentanaInformacion(VentanaInformacion informacion) {
            this.informacion = informacion;
      }

      public void setVentanaAnadir(VentanaAnadir insertar) {
            this.insertar = insertar;
      }

}
