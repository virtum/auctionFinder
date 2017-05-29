
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for RangeIntValueStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RangeIntValueStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="fvalueRangeIntMin" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fvalueRangeIntMax" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeIntValueStruct", propOrder = {

})
public class RangeIntValueStruct {

    protected Integer fvalueRangeIntMin;
    protected Integer fvalueRangeIntMax;

    /**
     * Gets the value of the fvalueRangeIntMin property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFvalueRangeIntMin() {
        return fvalueRangeIntMin;
    }

    /**
     * Sets the value of the fvalueRangeIntMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFvalueRangeIntMin(Integer value) {
        this.fvalueRangeIntMin = value;
    }

    /**
     * Gets the value of the fvalueRangeIntMax property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFvalueRangeIntMax() {
        return fvalueRangeIntMax;
    }

    /**
     * Sets the value of the fvalueRangeIntMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFvalueRangeIntMax(Integer value) {
        this.fvalueRangeIntMax = value;
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
