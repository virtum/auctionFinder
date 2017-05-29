
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for AmountStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmountStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="amountValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="amountCurrencySign" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountStruct", propOrder = {

})
public class AmountStruct {

    protected float amountValue;
    @XmlElement(required = true)
    protected String amountCurrencySign;

    /**
     * Gets the value of the amountValue property.
     * 
     */
    public float getAmountValue() {
        return amountValue;
    }

    /**
     * Sets the value of the amountValue property.
     * 
     */
    public void setAmountValue(float value) {
        this.amountValue = value;
    }

    /**
     * Gets the value of the amountCurrencySign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountCurrencySign() {
        return amountCurrencySign;
    }

    /**
     * Sets the value of the amountCurrencySign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountCurrencySign(String value) {
        this.amountCurrencySign = value;
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
