
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for SellRatingDetailStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellRatingDetailStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sellRatingGroupTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sellRatingReasonsSummary" type="{https://webapi.allegro.pl/service.php}ArrayOfSellratingreasonsumstruct" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellRatingDetailStruct", propOrder = {

})
public class SellRatingDetailStruct {

    @XmlElement(required = true)
    protected String sellRatingGroupTitle;
    protected ArrayOfSellratingreasonsumstruct sellRatingReasonsSummary;

    /**
     * Gets the value of the sellRatingGroupTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellRatingGroupTitle() {
        return sellRatingGroupTitle;
    }

    /**
     * Sets the value of the sellRatingGroupTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellRatingGroupTitle(String value) {
        this.sellRatingGroupTitle = value;
    }

    /**
     * Gets the value of the sellRatingReasonsSummary property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratingreasonsumstruct }
     *     
     */
    public ArrayOfSellratingreasonsumstruct getSellRatingReasonsSummary() {
        return sellRatingReasonsSummary;
    }

    /**
     * Sets the value of the sellRatingReasonsSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratingreasonsumstruct }
     *     
     */
    public void setSellRatingReasonsSummary(ArrayOfSellratingreasonsumstruct value) {
        this.sellRatingReasonsSummary = value;
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
