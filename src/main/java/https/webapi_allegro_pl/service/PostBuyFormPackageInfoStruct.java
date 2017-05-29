
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for PostBuyFormPackageInfoStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostBuyFormPackageInfoStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="packageIdsAdded" type="{https://webapi.allegro.pl/service.php}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="packageIdsNotAddedIncorrectOperatorId" type="{https://webapi.allegro.pl/service.php}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="packageIdsNotAddedIncorrectPackageId" type="{https://webapi.allegro.pl/service.php}ArrayOfString" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostBuyFormPackageInfoStruct", propOrder = {

})
public class PostBuyFormPackageInfoStruct {

    protected ArrayOfString packageIdsAdded;
    protected ArrayOfString packageIdsNotAddedIncorrectOperatorId;
    protected ArrayOfString packageIdsNotAddedIncorrectPackageId;

    /**
     * Gets the value of the packageIdsAdded property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPackageIdsAdded() {
        return packageIdsAdded;
    }

    /**
     * Sets the value of the packageIdsAdded property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPackageIdsAdded(ArrayOfString value) {
        this.packageIdsAdded = value;
    }

    /**
     * Gets the value of the packageIdsNotAddedIncorrectOperatorId property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPackageIdsNotAddedIncorrectOperatorId() {
        return packageIdsNotAddedIncorrectOperatorId;
    }

    /**
     * Sets the value of the packageIdsNotAddedIncorrectOperatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPackageIdsNotAddedIncorrectOperatorId(ArrayOfString value) {
        this.packageIdsNotAddedIncorrectOperatorId = value;
    }

    /**
     * Gets the value of the packageIdsNotAddedIncorrectPackageId property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getPackageIdsNotAddedIncorrectPackageId() {
        return packageIdsNotAddedIncorrectPackageId;
    }

    /**
     * Sets the value of the packageIdsNotAddedIncorrectPackageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setPackageIdsNotAddedIncorrectPackageId(ArrayOfString value) {
        this.packageIdsNotAddedIncorrectPackageId = value;
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
