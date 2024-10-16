package com.iesvdc.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CocheManager {
    private static final String FILE_PATH = "Compraventa.xml";

    public void guardarCoches(List<Coche> catalogoList) {
        try {
            JAXBContext context = JAXBContext.newInstance(Catalogo.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Catalogo(catalogoList), new File(FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public List<Coche> cargarCoches(){
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("El archivo Compraventa.xml no existe. Se retornará una lista vacia.");
            return new ArrayList<>(); // Devolvemos la lista vacia en caso de no haber archivo
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Catalogo.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Catalogo catalogo = (Catalogo) unmarshaller.unmarshal(new File(FILE_PATH));
            return catalogo.getCatalogoList();
        } catch (JAXBException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
