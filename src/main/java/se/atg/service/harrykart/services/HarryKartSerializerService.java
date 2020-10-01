package se.atg.service.harrykart.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.xml.sax.SAXException;
import se.atg.service.harrykart.exceptions.HarryKartException;
import se.atg.service.harrykart.entity.HarryKart;
import se.atg.service.harrykart.entity.HorseRank;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.util.List;
import java.util.Objects;

/**
 * Class to handle the conversion of Harry Kart races from XML to POJO to JSON
 */
public class HarryKartSerializerService {

    private XmlMapper xmlMapper;
    private static final String SCHEMA_FILE = "input.xsd";

    public HarryKartSerializerService() {
        this.xmlMapper = new XmlMapper();
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private String getResource(String filename) throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(filename);
        Objects.requireNonNull(resource);
        return resource.getFile();
    }

    public HarryKart deserializeFromXML(String xmlString) throws HarryKartException {

        HarryKart harryKartObj = null;
        try {
            harryKartObj = xmlMapper.readValue(xmlString, HarryKart.class);

        } catch (IOException e) {
            System.out.println("IOException while trying to de-serialize input XML");
            System.out.println(e);
        }
        return harryKartObj;
    }

    public String serializeToJson(List<HorseRank> ranking){
        ObjectMapper mapper = new ObjectMapper();
        String jsonRanking = "[]";
        try {
            jsonRanking = mapper.writeValueAsString(ranking);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"json-processing-error\": " + e.getMessage() + " }";
        }
        return "{\"ranking\": " + jsonRanking + " }";
    }

}