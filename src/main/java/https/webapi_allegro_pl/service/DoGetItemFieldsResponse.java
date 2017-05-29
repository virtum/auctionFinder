
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemFields" type="{https://webapi.allegro.pl/service.php}ArrayOfFieldsvalue" minOccurs="0"/>
 *         &lt;element name="afterSalesServiceConditions" type="{https://webapi.allegro.pl/service.php}AfterSalesServiceConditionsStruct" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemFields",
    "afterSalesServiceConditions"
})
@XmlRootElement(name = "doGetItemFieldsResponse")
public class DoGetItemFieldsResponse {

    protected ArrayOfFieldsvalue itemFields;
    protected AfterSalesServiceConditionsStruct afterSalesServiceConditions;

    /**
     * Gets the value of the itemFields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFieldsvalue }
     *     
     */
    public ArrayOfFieldsvalue getItemFields() {
        return itemFields;
    }

    /**
     * Sets the value of the itemFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFieldsvalue }
     *     
     */
    public void setItemFields(ArrayOfFieldsvalue value) {
        this.itemFields = value;
    }

    /**
     * Gets the value of the afterSalesServiceConditions property.
     * 
     * @return
     *     possible object is
     *     {@link AfterSalesServiceConditionsStruct }
     *     
     */
    public AfterSalesServiceConditionsStruct getAfterSalesServiceConditions() {
        return afterSalesServiceConditions;
    }

    /**
     * Sets the value of the afterSalesServiceConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link AfterSalesServiceConditionsStruct }
     *     
     */
    public void setAfterSalesServiceConditions(AfterSalesServiceConditionsStruct value) {
        this.afterSalesServiceConditions = value;
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
