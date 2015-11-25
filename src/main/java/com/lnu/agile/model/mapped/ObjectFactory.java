package com.lnu.agile.model.mapped;

import com.lnu.agile.model.mapped.Tracks;
import com.lnu.agile.model.mapped.TrackBettypes;
import com.lnu.agile.model.mapped.TrackInfoArray;
import com.lnu.agile.model.mapped.TrackBettypeStart;
import com.lnu.agile.model.mapped.TrackInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.lnu.agile.model package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TrackInfoArray_QNAME = new QName("", "trackInfoArray");
    private final static QName _Tracks_QNAME = new QName("", "tracks");
    private final static QName _TrackInfo_QNAME = new QName("", "trackInfo");
    private final static QName _Bettypes_QNAME = new QName("", "bettypes");
    private final static QName _BettypeStart_QNAME = new QName("", "bettypeStart");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.lnu.agile.model
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TrackInfoArray }
     *
     */
    public TrackInfoArray createTrackInfoArray() {
        return new TrackInfoArray();
    }

    /**
     * Create an instance of {@link Tracks }
     *
     */
    public Tracks createTracks() {
        return new Tracks();
    }

    /**
     * Create an instance of {@link TrackInfo }
     *
     */
    public TrackInfo createTrackInfo() {
        return new TrackInfo();
    }

    /**
     * Create an instance of {@link TrackBettypes }
     *
     */
    public TrackBettypes createTrackBettypes() {
        return new TrackBettypes();
    }

    /**
     * Create an instance of {@link TrackBettypeStart }
     *
     */
    public TrackBettypeStart createTrackBettypeStart() {
        return new TrackBettypeStart();
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrackInfoArray }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "trackInfoArray")
    public JAXBElement<TrackInfoArray> createTrackInfoArray(TrackInfoArray value) {
        return new JAXBElement<TrackInfoArray>(_TrackInfoArray_QNAME, TrackInfoArray.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link Tracks }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "tracks")
    public JAXBElement<Tracks> createTracks(Tracks value) {
        return new JAXBElement<Tracks>(_Tracks_QNAME, Tracks.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrackInfo }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "trackInfo")
    public JAXBElement<TrackInfo> createTrackInfo(TrackInfo value) {
        return new JAXBElement<TrackInfo>(_TrackInfo_QNAME, TrackInfo.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrackBettypes }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "bettypes")
    public JAXBElement<TrackBettypes> createBettypes(TrackBettypes value) {
        return new JAXBElement<TrackBettypes>(_Bettypes_QNAME, TrackBettypes.class, null, value);
    }

    /**
     * Create an instance of
     * {@link JAXBElement }{@code <}{@link TrackBettypeStart }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "bettypeStart")
    public JAXBElement<TrackBettypeStart> createBettypeStart(TrackBettypeStart value) {
        return new JAXBElement<TrackBettypeStart>(_BettypeStart_QNAME, TrackBettypeStart.class, null, value);
    }

}
