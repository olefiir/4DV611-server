/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.json;

import com.lnu.agile.model.mapped.TrackInfoArray;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            path = "http://178.62.191.16:8080/collector/collectorserver?ACTION=GETTRACKS&DATE=2015-11-17&ENDDATE=2015-11-30";
            
            URL obj = new URL(path);

            JAXBElement<TrackInfoArray> trackElement = (JAXBElement<TrackInfoArray>) unmarshaller.unmarshal(obj);
            trackinfo = trackElement.getValue();
          
            unmarshaller.setEventHandler(new TrackValidationEventHandler());
        }
        catch (JAXBException e) {
            System.out.println(e);
        } catch (MalformedURLException ex) {
            Logger.getLogger(XmlToJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlToJsonParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trackinfo;
    }

    @Override
    public String getFilePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
