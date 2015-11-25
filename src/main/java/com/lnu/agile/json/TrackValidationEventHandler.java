package com.lnu.agile.json;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

/**
 * Created by Nils on 2015/11/24.
 */
public class TrackValidationEventHandler implements ValidationEventHandler {
    public boolean handleEvent(ValidationEvent ve) {
        if (ve.getSeverity()==ValidationEvent.FATAL_ERROR ||
                ve .getSeverity()==ValidationEvent.ERROR){
            ValidationEventLocator locator = ve.getLocator();
            //Print message from valdation event
            System.out.println("Invalid file: "
                    + locator.getURL());
            System.out.println("Error: " + ve.getMessage());
            //Output line and column number
            System.out.println("Error at column " +
                    locator.getColumnNumber() +
                    ", line "
                    + locator.getLineNumber());
        }
        return true;
    }
}