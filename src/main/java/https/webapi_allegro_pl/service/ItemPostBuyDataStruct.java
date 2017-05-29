
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for ItemPostBuyDataStruct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemPostBuyDataStruct">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="usersPostBuyData" type="{https://webapi.allegro.pl/service.php}ArrayOfUserpostbuydatastruct" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPostBuyDataStruct", propOrder = {

})
public class ItemPostBuyDataStruct {

    protected long itemId;
    protected ArrayOfUserpostbuydatastruct usersPostBuyData;

    /**
     * Gets the value of the itemId property.
     * 
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the usersPostBuyData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserpostbuydatastruct }
     *     
     */
    public ArrayOfUserpostbuydatastruct getUsersPostBuyData() {
        return usersPostBuyData;
    }

    /**
     * Sets the value of the usersPostBuyData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserpostbuydatastruct }
     *     
     */
    public void setUsersPostBuyData(ArrayOfUserpostbuydatastruct value) {
        this.usersPostBuyData = value;
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
