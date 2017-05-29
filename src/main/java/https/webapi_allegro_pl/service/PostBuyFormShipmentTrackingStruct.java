
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for PostBuyFormShipmentTrackingStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostBuyFormShipmentTrackingStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="postBuyFormOperatorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="postBuyFormPackageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postBuyFormPackageStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostBuyFormShipmentTrackingStruct", propOrder = {

})
public class PostBuyFormShipmentTrackingStruct {

    protected int postBuyFormOperatorId;
    @XmlElement(required = true)
    protected String postBuyFormPackageId;
    @XmlElement(required = true)
    protected String postBuyFormPackageStatus;

    /**
     * Gets the value of the postBuyFormOperatorId property.
     * 
     */
    public int getPostBuyFormOperatorId() {
        return postBuyFormOperatorId;
    }

    /**
     * Sets the value of the postBuyFormOperatorId property.
     * 
     */
    public void setPostBuyFormOperatorId(int value) {
        this.postBuyFormOperatorId = value;
    }

    /**
     * Gets the value of the postBuyFormPackageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostBuyFormPackageId() {
        return postBuyFormPackageId;
    }

    /**
     * Sets the value of the postBuyFormPackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostBuyFormPackageId(String value) {
        this.postBuyFormPackageId = value;
    }

    /**
     * Gets the value of the postBuyFormPackageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostBuyFormPackageStatus() {
        return postBuyFormPackageStatus;
    }

    /**
     * Sets the value of the postBuyFormPackageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostBuyFormPackageStatus(String value) {
        this.postBuyFormPackageStatus = value;
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
