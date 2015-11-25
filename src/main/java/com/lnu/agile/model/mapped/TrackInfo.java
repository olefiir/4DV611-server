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
@XmlType(name = "TrackInfo", propOrder = {
    "bettypes",
    "bettypeStart"
})
public class TrackInfo {

    @XmlElement(required = true)
    protected List<TrackBettypes> bettypes;
    @XmlElement(required = true)
    protected List<TrackBettypeStart> bettypeStart;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
    @XmlAttribute(name = "date", required = true)
    protected String date;
    @XmlAttribute(name = "track", required = true)
    protected String track;
    @XmlAttribute(name = "raceCount", required = true)
    protected BigInteger raceCount;
    @XmlAttribute(name = "trackId", required = true)
    protected BigInteger trackId;
    @XmlAttribute(name = "nbrOfRaces", required = true)
    protected BigInteger nbrOfRaces;

    /**
     * Gets the value of the bettypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bettypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBettypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackBettypes }
     * 
     * 
     */
    public List<TrackBettypes> getBettypes() {
        if (bettypes == null) {
            bettypes = new ArrayList<TrackBettypes>();
        }
        return this.bettypes;
    }

    /**
     * Gets the value of the bettypeStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bettypeStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBettypeStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackBettypeStart }
     * 
     * 
     */
    public List<TrackBettypeStart> getBettypeStart() {
        if (bettypeStart == null) {
            bettypeStart = new ArrayList<TrackBettypeStart>();
        }
        return this.bettypeStart;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger value) {
        this.id = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String value) {
        this.track = value;
    }

    public BigInteger getRaceCount() {
        return raceCount;
    }

    public void setRaceCount(BigInteger value) {
        this.raceCount = value;
    }

    public BigInteger getTrackId() {
        return trackId;
    }

    public void setTrackId(BigInteger value) {
        this.trackId = value;
    }

    public BigInteger getNbrOfRaces() {
        return nbrOfRaces;
    }

    public void setNbrOfRaces(BigInteger value) {
        this.nbrOfRaces = value;
    }

}