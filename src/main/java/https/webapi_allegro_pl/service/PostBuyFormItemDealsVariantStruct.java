
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for PostBuyFormItemDealsVariantStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostBuyFormItemDealsVariantStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="variantName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="variantValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostBuyFormItemDealsVariantStruct", propOrder = {

})
public class PostBuyFormItemDealsVariantStruct {

    @XmlElement(required = true)
    protected String variantName;
    @XmlElement(required = true)
    protected String variantValue;

    /**
     * Gets the value of the variantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantName() {
        return variantName;
    }

    /**
     * Sets the value of the variantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantName(String value) {
        this.variantName = value;
    }

    /**
     * Gets the value of the variantValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariantValue() {
        return variantValue;
    }

    /**
     * Sets the value of the variantValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariantValue(String value) {
        this.variantValue = value;
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
