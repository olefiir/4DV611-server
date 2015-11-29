/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.json.FileParser;
import com.lnu.agile.json.XmlToJsonParser;
import com.lnu.agile.model.mapped.*;
import java.io.IOException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author olefir
 */
@RestController
public class TrackController {
    //trmporary location!
    private final String PATH = "classpath:trackInfoArray.xml";
    private static final Logger logger = LoggerFactory.getLogger(TrackController.class);

    @RequestMapping(value = RestURIConstants.GET_ALL_TRACK, method = RequestMethod.GET, headers="Accept=application/json")
    public TrackInfoArray getAllTracks() {
        try {
            logger.info("Start getAllTracks");
            
            Resource resource = new DefaultResourceLoader().getResource(PATH);
            
            FileParser parser = new XmlToJsonParser();
            TrackInfoArray allTracks = parser.parseFile(resource.getFile().getAbsolutePath());
            
            return allTracks;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TrackController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @RequestMapping(value = RestURIConstants.GET_TRACK, method = RequestMethod.GET, headers="Accept=application/json")
    public @ResponseBody TrackInfo getTrack(@PathVariable("id") int trackId) {
        try {
            logger.info("Start getTracks. ID = " + trackId);
            Resource resource = new DefaultResourceLoader().getResource(PATH);
            
            FileParser parser = new XmlToJsonParser();
            TrackInfoArray allTracks = parser.parseFile(resource.getFile().getAbsolutePath());
            
            return allTracks.getTracks().get(0).getTrackInfo().get(trackId);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TrackController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}