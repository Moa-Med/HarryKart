package se.atg.service.harrykart.services;

import se.atg.service.harrykart.entity.HarryKart;
import se.atg.service.harrykart.entity.HorseRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * calculate the competition ranking
 */
public class HarryKartResultService {
    private static final double TRACK_LENGTH = 1000.0;
    HarryKart race;

  
    public HarryKartResultService(HarryKart race) {
        this.race = race;
    }
    
    public List<HorseRank> getResults() {
        ArrayList<HorseRank> standings = new ArrayList<>();

        /*
        For each participant
            1) Go through each race loop
            2) Get the lane where lane.number = participant.lane
            3) baseSpeed += lane.power. baseSpeed <= 0 means the lap is not run and the horse is out of the race.
            4) point += TRACK_LENGTH / baseSpeed
        */
        race.getStartList().forEach(participant -> {
            HorseRank horseRank = new HorseRank(0, participant.getName(), TRACK_LENGTH/participant.getBaseSpeed());
            race.getPowerUps().stream()
                    .forEach(loop -> loop.getLanes().stream()
                            .filter(lane -> lane.getNumber() == participant.getLane()).
                                    forEach(lane -> {
                                        int loopSpeed = participant.getBaseSpeed() + lane.getPowerValue();
                                        if(loopSpeed <= 0){
                                            horseRank.setTime(horseRank.getPoints() + Double.MAX_VALUE); 
                                        } else {
                                            participant.setBaseSpeed(participant.getBaseSpeed() + lane.getPowerValue());
                                            horseRank.setTime(horseRank.getPoints() + (TRACK_LENGTH/participant.getBaseSpeed()) );
                                        }
                                    }));
            standings.add(horseRank);
        });

        Collections.sort(standings);
        standings.removeIf(rank -> rank.getPoints() >= Double.MAX_VALUE);
    
        int finalPlacement = 1;
        standings.get(0).setPosition(finalPlacement);
        for(int positionIndex = 1; positionIndex < standings.size(); positionIndex++){
            if(standings.get(positionIndex).getPoints() == standings.get(positionIndex-1).getPoints()){
                standings.get(positionIndex).setPosition(finalPlacement);
            }else{
                standings.get(positionIndex).setPosition(++finalPlacement);
            }
        }
       
        return standings.stream().filter(rank -> rank.getPosition() <= 3).collect(toList());
    }

}