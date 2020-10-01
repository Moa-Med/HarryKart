package se.atg.service.harrykart.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.io.Serializable;


public class Lane implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    int number;

    @JacksonXmlText
    int powerValue;

    public Lane() {}
    
    public Lane(int number, int powerValue) {
        this.number = number;
        this.powerValue = powerValue;
    }

    public int getNumber() {
        return number;
    }

    public int getPowerValue() {
        return powerValue;
    }

    @Override
    public String toString() {
        return "Lane{" +
                "number=" + getNumber() +
                ", power='" + getPowerValue() + '\'' +
                '}';
    }

}