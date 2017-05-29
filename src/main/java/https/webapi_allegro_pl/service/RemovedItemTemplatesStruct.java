
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for RemovedItemTemplatesStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemovedItemTemplatesStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="itemTemplateIds" type="{https://webapi.allegro.pl/service.php}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="itemTemplateIncorrectIds" type="{https://webapi.allegro.pl/service.php}ArrayOfInt" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemovedItemTemplatesStruct", propOrder = {

})
public class RemovedItemTemplatesStruct {

    protected ArrayOfInt itemTemplateIds;
    protected ArrayOfInt itemTemplateIncorrectIds;

    /**
     * Gets the value of the itemTemplateIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getItemTemplateIds() {
        return itemTemplateIds;
    }

    /**
     * Sets the value of the itemTemplateIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setItemTemplateIds(ArrayOfInt value) {
        this.itemTemplateIds = value;
    }

    /**
     * Gets the value of the itemTemplateIncorrectIds property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getItemTemplateIncorrectIds() {
        return itemTemplateIncorrectIds;
    }

    /**
     * Sets the value of the itemTemplateIncorrectIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setItemTemplateIncorrectIds(ArrayOfInt value) {
        this.itemTemplateIncorrectIds = value;
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
