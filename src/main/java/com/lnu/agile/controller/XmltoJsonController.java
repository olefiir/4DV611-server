package com.lnu.agile.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import com.lnu.agile.model.mapped.TrackInfoArray;
import com.lnu.agile.json.TrackValidationEventHandler;

/**
 * Created by Nils on 2015/11/23.
 */

@RestController
public class XmltoJsonController {
        @RequestMapping("/getJAXBJson")
    public TrackInfoArray getJAXBJson(@RequestParam(value="", defaultValue="trackInfoArray.xml") String json) {

        TrackInfoArray trackinfo = new TrackInfoArray();
        try {
            //Specify the Java packge containing your JAXB-mapped classes
            JAXBContext jaxbContext = JAXBContext.newInstance("com.lnu.agile.model");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            //The unmarshaller can process XML data from a wide variety of data sources: files, input streams, URLs, DOM objects, SAX parsers, and more
            JAXBElement<TrackInfoArray> trackElement = (JAXBElement<TrackInfoArray>) unmarshaller.unmarshal(new File("src/main/java/com/lnu/agile/json/"+json));
            trackinfo = trackElement.getValue();
            //Document validation
            unmarshaller.setEventHandler(new TrackValidationEventHandler());

            //System.out.println(trackinfo.getTracks().get(0).getTrackInfo().size());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return trackinfo;
    }
}