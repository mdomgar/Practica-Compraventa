package com.iesvdc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Date;

public class MainFrame23424 extends JFrame {
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField matriculaField;
    private JTextField anioField;
    private JTextField fechaVentaField;
    private JTextArea catalogoArea;
    private JButton agregarButton;
    private JButton listarButton;

    public MainFrame23424() {
        setTitle("Compraventa de coches");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6,2));

        inputPanel.add(new JLabel("Marca:"));
        marcaField = new JTextField();
        inputPanel.add(marcaField);

        inputPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        inputPanel.add(modeloField);

        inputPanel.add(new JLabel("Matricula:"));
        matriculaField = new JTextField();
        inputPanel.add(matriculaField);

        inputPanel.add(new JLabel("Año:"));
        anioField = new JTextField();
        inputPanel.add(anioField);

        inputPanel.add(new JLabel("Fecha de venta: DD-MM-YYYY"));
        fechaVentaField = new JTextField();
        inputPanel.add(fechaVentaField);

        agregarButton = new JButton("Agregar Coche");
        inputPanel.add(agregarButton);

        listarButton = new JButton("Mostrar Catalogo");
        inputPanel.add(listarButton);

        add(inputPanel, BorderLayout.NORTH);

        catalogoArea = new JTextArea();
        add(new JScrollPane(catalogoArea), BorderLayout.CENTER);

    }
    public String getMarca(){
        return marcaField.getText();
    }

    public String getModelo(){
        return modeloField.getText();
    }

    public String getMatricula(){
        return matriculaField.getText();
    }

    public String getAnio(){
        return anioField.getText();
    }

    public String getFeha(){
        /*String[] fecha = fechaVentaField.getText().split(",");
        return LocalDate.of(fecha[2], fecha[1], fecha[0]);*/
        return fechaVentaField.getText();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarCatalogo(String coches) {
        catalogoArea.setText(coches);
    }

    public void setAgregarButtonListener(ActionListener listener) {
        agregarButton.addActionListener(listener);
    }

    public void setListarButtonListener(ActionListener listener) {
        listarButton.addActionListener(listener);
    }
}
