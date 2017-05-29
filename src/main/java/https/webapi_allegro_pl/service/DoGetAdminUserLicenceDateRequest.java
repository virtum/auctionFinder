
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="adminSessionHandle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userLicLogin" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "adminSessionHandle",
    "userLicLogin"
})
@XmlRootElement(name = "DoGetAdminUserLicenceDateRequest")
public class DoGetAdminUserLicenceDateRequest {

    @XmlElement(required = true)
    protected String adminSessionHandle;
    @XmlElement(required = true)
    protected String userLicLogin;

    /**
     * Gets the value of the adminSessionHandle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdminSessionHandle() {
        return adminSessionHandle;
    }

    /**
     * Sets the value of the adminSessionHandle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdminSessionHandle(String value) {
        this.adminSessionHandle = value;
    }

    /**
     * Gets the value of the userLicLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLicLogin() {
        return userLicLogin;
    }

    /**
     * Sets the value of the userLicLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLicLogin(String value) {
        this.userLicLogin = value;
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
