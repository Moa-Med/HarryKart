package se.atg.service.harrykart.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.atg.service.harrykart.exceptions.HarryKartException;
import se.atg.service.harrykart.entity.HarryKart;
import se.atg.service.harrykart.entity.HorseRank;
import se.atg.service.harrykart.services.*;

import java.util.List;

/**
 * Entry-point for the application. API accepts XML POST requests at http://localhost:8080/api/play
 */
@RestController
@RequestMapping("/api")
public class HarryKartController {

 
    @RequestMapping(method = { RequestMethod.POST, RequestMethod.GET} , path = "/play", consumes = "application/xml", produces = "application/json")
    public String playHarryKart(@RequestBody String inputXML) {
        HarryKartSerializerService hkSerializer = new HarryKartSerializerService();
        try {
            // deserialize the XML
            HarryKart hk = hkSerializer.deserializeFromXML(inputXML);
            // competition results
            List<HorseRank> ranking = new HarryKartResultService(hk).getResults();
            // JSON results
            return hkSerializer.serializeToJson(ranking);
        } catch(HarryKartException e) {
            System.out.println("HarryKartException: " + e.getMessage());
            return "{\"message\": " + e.getMessage() + " }";
        }
    }

}