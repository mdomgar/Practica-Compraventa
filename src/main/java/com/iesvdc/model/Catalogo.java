package com.iesvdc.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "catalogo")
public class Catalogo {
    private List<Coche> catalogoList;

    public Catalogo() {
    }

    public Catalogo(List<Coche> catalogoList) {
        this.catalogoList = catalogoList;
    }

    @XmlElement(name = "coche")
    public List<Coche> getCatalogoList() {
        return catalogoList;
    }

    public void setCatalogoList(List<Coche> catalogoList) {
        this.catalogoList = catalogoList;
    }
}
