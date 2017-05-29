
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
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="localVersion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="webapiKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "countryCode",
    "localVersion",
    "webapiKey"
})
@XmlRootElement(name = "DoGetSellFormFieldsRequest")
public class DoGetSellFormFieldsRequest {

    protected int countryCode;
    protected long localVersion;
    @XmlElement(required = true)
    protected String webapiKey;

    /**
     * Gets the value of the countryCode property.
     * 
     */
    public int getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     */
    public void setCountryCode(int value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the localVersion property.
     * 
     */
    public long getLocalVersion() {
        return localVersion;
    }

    /**
     * Sets the value of the localVersion property.
     * 
     */
    public void setLocalVersion(long value) {
        this.localVersion = value;
    }

    /**
     * Gets the value of the webapiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebapiKey() {
        return webapiKey;
    }

    /**
     * Sets the value of the webapiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebapiKey(String value) {
        this.webapiKey = value;
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
