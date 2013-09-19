/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.08.27 at 01:43:57 PM EDT
//


package org.energyos.espi.datacustodian.domain;

import org.energyos.espi.datacustodian.models.atom.adapters.IntervalBlockAdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * Time sequence of Readings of the same ReadingType.
 *
 * <p>Java class for IntervalBlock complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IntervalBlock">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="interval" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="IntervalReading" type="{http://naesb.org/espi}IntervalReading" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalBlock", propOrder = {
    "interval",
    "intervalReadings"
})
@Entity
@Table(name = "interval_blocks")
@NamedQueries(value = {
        @NamedQuery(name = IntervalBlock.QUERY_ALL_BY_METER_READING_ID,
                query = "SELECT block FROM IntervalBlock block WHERE block.meterReading.id = :meterReadingId")
})
@XmlRootElement(name = "IntervalBlock")
@XmlJavaTypeAdapter(IntervalBlockAdapter.class)
public class IntervalBlock
    extends IdentifiedObject
{
    public static final String QUERY_ALL_BY_METER_READING_ID = "IntervalBlock.findAllByMeterReadingId";

    @Embedded
    protected DateTimeInterval interval;

    @OneToMany(mappedBy = "intervalBlock", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @XmlElementRefs({
            @XmlElementRef(name = "IntervalReading", namespace = "http://naesb.org/espi", type = JAXBElement.class, required = false),
    })
    @XmlAnyElement(lax = true)
    protected List<IntervalReading> intervalReadings = new ArrayList<>();

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "meter_reading_id")
    protected MeterReading meterReading;

    /**
     * Gets the value of the interval property.
     *
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *
     */
    public DateTimeInterval getInterval() {
        return interval;
    }

    /**
     * Sets the value of the interval property.
     *
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *
     */
    public void setInterval(DateTimeInterval value) {
        this.interval = value;
    }

    /**
     * Gets the value of the intervalReading property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intervalReading property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntervalReading().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntervalReading }
     *
     *
     */
    public List<IntervalReading> getIntervalReadings() {
        return this.intervalReadings;
    }

    public void setIntervalReadings(List<IntervalReading> intervalReadings) {
        this.intervalReadings = intervalReadings;
    }

    public MeterReading getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(MeterReading meterReading) {
        this.meterReading = meterReading;
    }
}
