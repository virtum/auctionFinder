
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ItemPriceStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemPriceStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="priceType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="priceValue" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPriceStruct", propOrder = {

})
public class ItemPriceStruct {

    protected int priceType;
    protected float priceValue;

    /**
     * Gets the value of the priceType property.
     * 
     */
    public int getPriceType() {
        return priceType;
    }

    /**
     * Sets the value of the priceType property.
     * 
     */
    public void setPriceType(int value) {
        this.priceType = value;
    }

    /**
     * Gets the value of the priceValue property.
     * 
     */
    public float getPriceValue() {
        return priceValue;
    }

    /**
     * Sets the value of the priceValue property.
     * 
     */
    public void setPriceValue(float value) {
        this.priceValue = value;
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
