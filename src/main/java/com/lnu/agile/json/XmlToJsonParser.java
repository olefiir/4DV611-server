/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.json;

import com.lnu.agile.model.mapped.TrackInfoArray;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author olefir
 */
public class XmlToJsonParser implements FileParser{
    private final static String MODEL_PACKAGE = "com.lnu.agile.model.mapped";
    
    @Override
    public TrackInfoArray parseFile(String path) {
        TrackInfoArray trackinfo = new TrackInfoArray();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MODEL_PACKAGE);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            JAXBElement<TrackInfoArray> trackElement = (JAXBElement<TrackInfoArray>) unmarshaller.unmarshal(new File(path));
            trackinfo = trackElement.getValue();
          
            unmarshaller.setEventHandler(new TrackValidationEventHandler());
        }
        catch (JAXBException e) {
            System.out.println(e);
        }
        return trackinfo;
    }

    @Override
    public String getFilePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
