
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for RelatedItemsShipmentDataStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelatedItemsShipmentDataStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="sellerShipmentData" type="{https://webapi.allegro.pl/service.php}ArrayOfSellershipmentdatastruct" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedItemsShipmentDataStruct", propOrder = {

})
public class RelatedItemsShipmentDataStruct {

    protected ArrayOfSellershipmentdatastruct sellerShipmentData;

    /**
     * Gets the value of the sellerShipmentData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellershipmentdatastruct }
     *     
     */
    public ArrayOfSellershipmentdatastruct getSellerShipmentData() {
        return sellerShipmentData;
    }

    /**
     * Sets the value of the sellerShipmentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellershipmentdatastruct }
     *     
     */
    public void setSellerShipmentData(ArrayOfSellershipmentdatastruct value) {
        this.sellerShipmentData = value;
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
