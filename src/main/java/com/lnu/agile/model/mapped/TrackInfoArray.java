package com.lnu.agile.model.mapped;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrackInfoArray complex type? Java ??
 * 
 * <p>????????????????????
 * 
 * <pre>
 * &lt;complexType name="TrackInfoArray"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}tracks" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackInfoArray", propOrder = {
    "tracks"
})
public class TrackInfoArray {

    @XmlElement(required = true)
    protected List<Tracks> tracks;

    /**
     * Gets the value of the tracks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tracks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTracks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tracks }
     * 
     * 
     */
    public List<Tracks> getTracks() {
        if (tracks == null) {
            tracks = new ArrayList<Tracks>();
        }
        return this.tracks;
    }

}