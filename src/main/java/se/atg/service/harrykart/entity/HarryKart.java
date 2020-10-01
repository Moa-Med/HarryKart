package se.atg.service.harrykart.entity;


import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 *Class Containing Participants,Loops,power-ups
 */
@JacksonXmlRootElement(localName = "harryKart")
public class HarryKart implements Serializable {
    int numberOfLoops;
    ArrayList<Participant> startList;
    ArrayList<Loop> powerUps;

    public HarryKart() {}

    public HarryKart(int numberOfLoops, ArrayList<Participant> startList, ArrayList<Loop> powerUps) {
        this.numberOfLoops = numberOfLoops;
        this.startList = startList;
        this.powerUps = powerUps;
    }

  
    public int getNumberOfLoops() {
        return numberOfLoops;
    }

   
    public ArrayList<Participant> getStartList() {
        return startList;
    }

    public ArrayList<Loop> getPowerUps() {
        return powerUps;
    }

    @Override
    public String toString() {
        return "StartList: " + this.getStartList() + "\n" +
                "Loops: " + this.getNumberOfLoops() + "\n" +
                "PowerUps: " + this.getPowerUps();
    }


}