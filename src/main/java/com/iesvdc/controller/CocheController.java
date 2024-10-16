package com.iesvdc.controller;

import com.iesvdc.model.Catalogo;
import com.iesvdc.model.Coche;
import com.iesvdc.model.CocheManager;
import com.iesvdc.view.MainFrame23424;

import javax.xml.bind.annotation.XmlElement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class CocheController {
    private MainFrame23424 view;
    private CocheManager model;
    private List<Coche> catalogo;

    public CocheController(MainFrame23424 view, CocheManager model) {
        this.view = view;
        this.model = model;
        this.catalogo = model.cargarCoches();

        view.setAgregarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                agregarCoche();
            }
        });

        view.setListarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listarCatalogo();
            }
        });
    }

    private void agregarCoche(){
         String Marca = view.getMarca();
         String Modelo = view.getModelo();
         String Matricula = view.getMatricula();
         int anio = Integer.parseInt(view.getAnio());
         String FechaVenta = view.getFeha();
         //LocalDate Fecha;

         try {
             //Fecha=LocalDate.parse(view.getFeha());
            Coche coche = new Coche(Marca, Modelo, Matricula, anio, FechaVenta);
            catalogo.add(coche);
            model.guardarCoches(catalogo);
            view.mostrarMensaje("Coches agregados correctamente");
         } catch (Exception e){
             view.mostrarMensaje("Ha habido un error. ¿Cual? Yo que se");
         }
    }

    private void listarCatalogo(){
        StringBuilder sb = new StringBuilder();
        for (Coche coche : catalogo){
            sb.append(coche.toString()).append("\n");
        }
        view.mostrarCatalogo(sb.toString());
    }
}
