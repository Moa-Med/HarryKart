package se.atg.service.harrykart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class showing the ranking of the competition
 */

public class HorseRank implements Comparable<HorseRank>{
    int position;
    String horse;
    double points;

    public HorseRank() {}

    public HorseRank(int position, String horse, double time) {
        this.position = position;
        this.horse = horse;
        this.points = time;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getHorse() {
        return horse;
    }

    public double getPoints() {
        return points;
    }

    public void setTime(double time) {
        this.points = time;
    }

    /*
     *  comparing the points and selecting the order 
     * */
    @Override
    public int compareTo(HorseRank other) {
        if(this.getPoints() == other.getPoints())
            return 0;
        else if(this.getPoints() > other.getPoints())
            return 1;
        else
            return -1;
    }

   
    @Override
    public String toString() {
        return "[" +
                "position=" + position +
                ", horse='" + horse + '\'' +
                ", Points =" + points +
                ']';
    }
}
