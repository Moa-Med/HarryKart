package se.atg.service.harrykart.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "participant")
public class Participant implements Serializable {
    @JacksonXmlProperty
    int lane;

    @JacksonXmlProperty
    String name;

    @JacksonXmlProperty
    int baseSpeed;

    public Participant() {}

    public Participant(int lane, String name, int baseSpeed) {
        this.lane = lane;
        this.name = name;
        this.baseSpeed = baseSpeed;
    }

    public int getLane() {
        return lane;
    }

    public String getName() {
        return name;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "lane=" + lane +
                ", name='" + name + '\'' +
                ", baseSpeed=" + baseSpeed +
                '}';
    }

}