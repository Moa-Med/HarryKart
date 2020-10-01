package se.atg.service.harrykart.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;


@JacksonXmlRootElement(localName = "loop")
public class Loop implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    int number;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lane")
    ArrayList<Lane> lanes;

    public Loop() {}

    public Loop(int number, ArrayList<Lane> lanes) {
        this.number = number;
        this.lanes = lanes;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

    @Override
    public String toString() {
        return "Loop{" +
                "number=" + getNumber() +
                ", lanes='" + getLanes() + '\'' +
                '}';
    }

}