package com.iesvdc;

import com.iesvdc.controller.CocheController;
import com.iesvdc.model.Catalogo;
import com.iesvdc.model.CocheManager;
import com.iesvdc.view.MainFrame23424;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame23424 frame = new MainFrame23424();
            CocheManager model = new CocheManager();
            new CocheController(frame, model);
            frame.setVisible(true);
        });
    }
}