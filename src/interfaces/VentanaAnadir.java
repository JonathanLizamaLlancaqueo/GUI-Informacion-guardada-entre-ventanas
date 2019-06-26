package interfaces;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import modeloProblema.Estacionamiento;

/**
 *
 * @author JonathanLizama
 */
public class VentanaAnadir extends JFrame implements ActionListener {

      private JLabel patente, modelo, textoTipo, tiempo;
      private JPanel panelSuperior, panelInferior;
      private VentanaPrincipal princ;
      private JButton volver, anadir, actualizar;
      private JTextField cajaPatente, cajaModelo, cajaTiempo;
      private JComboBox tipo;
      private JTextArea cuadro;
      private String textoPatente, listado, vehiculoAgregado = "";
      private int tiempoEstacionamiento;

      private void configurarVentana() {
            this.setTitle("Añadir Vehiculos");
            this.setSize(710, 630);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public VentanaAnadir(VentanaPrincipal princ , String listaVehiculos) {
            super();
            configurarVentana();
            iniciarComponentes(listaVehiculos);
            this.princ = princ;
            listado = listaVehiculos;
      }

      private void iniciarComponentes(String listaVehiculos) {
            cuadro = new JTextArea(listaVehiculos);
            patente = new JLabel();
            tiempo = new JLabel();
            modelo = new JLabel();
            textoTipo = new JLabel();
            volver = new JButton();
            actualizar = new JButton();
            anadir = new JButton();
            tipo = new JComboBox();
            cajaPatente = new JTextField();
            cajaModelo = new JTextField();
            cajaTiempo = new JTextField();
            panelInferior = new JPanel();
            panelSuperior = new JPanel();
            panelSuperior();
            panelInferior();

      }

      private void patente() {
            patente.setBounds(20, 20, 100, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            patente.setText("Patente:");
            patente.setForeground(Color.BLACK);
            patente.setFont(new Font("Arial Black", Font.BOLD, 14));
            panelSuperior.add(patente);
      }

      public void cajaPatente() {
            cajaPatente.setBounds(100, 20, 130, 30);
            panelSuperior.add(cajaPatente);
      }

      public void cajaModelo() {
            cajaModelo.setBounds(100, 60, 130, 30);
            panelSuperior.add(cajaModelo);
      }

      public void cajaTiempo() {
            cajaTiempo.setBounds(440, 60, 130, 30);
            panelSuperior.add(cajaTiempo);
      }

      private void modelo() {
            modelo.setBounds(20, 60, 100, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            modelo.setText("Modelo:");
            modelo.setForeground(Color.BLACK);
            modelo.setFont(new Font("Arial Black", Font.BOLD, 14));
            panelSuperior.add(modelo);
      }

      private void textoTiempo() {
            tiempo.setBounds(370, 60, 100, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            tiempo.setText("Tiempo:");
            tiempo.setForeground(Color.BLACK);
            tiempo.setFont(new Font("Arial Black", Font.BOLD, 14));
            panelSuperior.add(tiempo);
      }

      private void textoTipo() {
            textoTipo.setBounds(403, 20, 100, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
            textoTipo.setText("Tipo:");
            textoTipo.setForeground(Color.BLACK);
            textoTipo.setFont(new Font("Arial Black", Font.BOLD, 14));
            panelSuperior.add(textoTipo);
      }

      private void botonAnadir() {
            anadir.setText("Añadir");
            anadir.setBounds(100, 140, 100, 30);
            anadir.addActionListener(this);
            panelSuperior.add(anadir);
      }

      private void botonVolver() {
            volver.setText("Volver");
            volver.setBounds(300, 140, 100, 30);
            volver.addActionListener(this);
            panelSuperior.add(volver);
      }

      private void botonActualizar() {
            actualizar.setText("Actualizar");
            actualizar.setBounds(500, 140, 100, 30);
            actualizar.addActionListener(this);
            panelSuperior.add(actualizar);
      }

      public void llenarLista(JComboBox tipo) {
            tipo.setBounds(450, 20, 100, 30);
            tipo.addItem("Suv");
            tipo.addItem("Sedan");
            tipo.addItem("HatchBack");
            tipo.addItem("Camioneta");
            tipo.addItem("Moto");
      }

      // configuración del panel superior
      private void panelSuperior() {
            patente();
            modelo();
            botonVolver();
            botonAnadir();
            cajaPatente();
            botonActualizar();
            cajaModelo();
            cajaTiempo();
            textoTipo();
            textoTiempo();
            llenarLista(tipo);
            panelSuperior.setBackground(Color.BLUE);
            panelSuperior.setBounds(0, 0, 710, 210);
            panelSuperior.setLayout(null);
            this.add(textoTipo);
            this.add(tipo);
            this.add(actualizar);
            this.add(tiempo);
            this.add(anadir);
            this.add(cajaPatente);
            this.add(cajaModelo);
            this.add(cajaTiempo);
            this.add(patente);
            this.add(modelo);
            this.add(panelSuperior);

      }

      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      private void panelInferior() {
            area();
            panelInferior.setBackground(Color.LIGHT_GRAY);
            panelInferior.setBounds(0, 210, 710, 420);
            panelInferior.setLayout(null);
            this.add(cuadro);
            this.add(panelSuperior);
      }

      private void area() {
            cuadro.setBounds(140, 260, 450, 300);
            cuadro.setBorder(new LineBorder(Color.BLACK));
            panelInferior.add(cuadro);

      }

      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //                                                                                                                             //
      // METODO PARA AÑADIR VEHICULOS                                                                                                //
      //                                                                                                                             //
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      public void agregarVehiculo() {
            Estacionamiento autos = new Estacionamiento();
            textoPatente = cajaPatente.getText();
            if (autos.validarPatente(textoPatente) && !cajaModelo.getText().equals("") && !cajaTiempo.getText().equals("")) {
                  tiempoEstacionamiento = Integer.parseInt(cajaTiempo.getText());
                  double valor = autos.calcularValor(tiempoEstacionamiento);
                  autos.agregarVehiculo(textoPatente, cajaModelo.getText(), autos.StringToTipo(tipo.getSelectedItem().toString()), tiempoEstacionamiento, valor);
                  vehiculoAgregado = autos.toString();
            } else {
                  JOptionPane.showMessageDialog(this, "Ingrese los campos requeridos por favor!!!");
            }
      }

      public void actualizarVehiculos() {
            listado = listado + vehiculoAgregado;
            cuadro.setText(listado);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == volver) {
                  this.setVisible(false);
                  princ.setVentanaAnadir(this);
                  princ.setVisible(true);
            } else if (e.getSource() == anadir) {
                  agregarVehiculo();
            } else if (e.getSource() == actualizar) {
                  actualizarVehiculos();

            }
      }
}
