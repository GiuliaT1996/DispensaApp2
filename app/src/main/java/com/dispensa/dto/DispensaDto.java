package com.dispensa.dto;

import java.io.Serializable;

public class DispensaDto implements Serializable {

    private String name;

    private Integer quantity;

    private String section;

    private String dataScadenza;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(String dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public DispensaDto(String name, Integer quantity, String section, String dataScadenza) {
        this.name = name;
        this.quantity = quantity;
        this.section = section;
        this.dataScadenza = dataScadenza;
    }
}
