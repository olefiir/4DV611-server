package com.lnu.agile.model.mapped;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tracks", propOrder = {
    "trackInfo"
})
public class Tracks {

    @XmlElement(required = true)
    protected List<TrackInfo> trackInfo;
    @XmlAttribute(name = "length", required = true)
    protected BigInteger length;

    public List<TrackInfo> getTrackInfo() {
        if (trackInfo == null) {
            trackInfo = new ArrayList<TrackInfo>();
        }
        return this.trackInfo;
    }


    public BigInteger getLength() {
        return length;
    }

 
    public void setLength(BigInteger value) {
        this.length = value;
    }

}
