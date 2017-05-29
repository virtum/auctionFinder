
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ItemBilling complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemBilling">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="biName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="biValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemBilling", propOrder = {

})
public class ItemBilling {

    @XmlElement(required = true)
    protected String biName;
    @XmlElement(required = true)
    protected String biValue;

    /**
     * Gets the value of the biName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiName() {
        return biName;
    }

    /**
     * Sets the value of the biName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiName(String value) {
        this.biName = value;
    }

    /**
     * Gets the value of the biValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiValue() {
        return biValue;
    }

    /**
     * Sets the value of the biValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiValue(String value) {
        this.biValue = value;
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
