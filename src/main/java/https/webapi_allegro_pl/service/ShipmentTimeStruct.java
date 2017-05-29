
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ShipmentTimeStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentTimeStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="shipmentTimeFrom" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipmentTimeTo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentTimeStruct", propOrder = {

})
public class ShipmentTimeStruct {

    protected int shipmentTimeFrom;
    protected int shipmentTimeTo;

    /**
     * Gets the value of the shipmentTimeFrom property.
     * 
     */
    public int getShipmentTimeFrom() {
        return shipmentTimeFrom;
    }

    /**
     * Sets the value of the shipmentTimeFrom property.
     * 
     */
    public void setShipmentTimeFrom(int value) {
        this.shipmentTimeFrom = value;
    }

    /**
     * Gets the value of the shipmentTimeTo property.
     * 
     */
    public int getShipmentTimeTo() {
        return shipmentTimeTo;
    }

    /**
     * Sets the value of the shipmentTimeTo property.
     * 
     */
    public void setShipmentTimeTo(int value) {
        this.shipmentTimeTo = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return JAXBToStringBuilder.valueOf(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
