
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for AfterSalesServiceConditionsStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AfterSalesServiceConditionsStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="impliedWarranty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnPolicy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="warranty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AfterSalesServiceConditionsStruct", propOrder = {

})
public class AfterSalesServiceConditionsStruct {

    @XmlElement(required = true)
    protected String impliedWarranty;
    @XmlElement(required = true)
    protected String returnPolicy;
    @XmlElement(required = true)
    protected String warranty;

    /**
     * Gets the value of the impliedWarranty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpliedWarranty() {
        return impliedWarranty;
    }

    /**
     * Sets the value of the impliedWarranty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpliedWarranty(String value) {
        this.impliedWarranty = value;
    }

    /**
     * Gets the value of the returnPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnPolicy() {
        return returnPolicy;
    }

    /**
     * Sets the value of the returnPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnPolicy(String value) {
        this.returnPolicy = value;
    }

    /**
     * Gets the value of the warranty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * Sets the value of the warranty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarranty(String value) {
        this.warranty = value;
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
