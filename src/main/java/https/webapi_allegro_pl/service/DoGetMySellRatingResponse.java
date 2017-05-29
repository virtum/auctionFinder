
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
 *         &lt;element name="sellRatingTotalCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sellRatingAverage" type="{https://webapi.allegro.pl/service.php}ArrayOfSellratingaveragestruct" minOccurs="0"/>
 *         &lt;element name="sellRatingDetails" type="{https://webapi.allegro.pl/service.php}ArrayOfSellratingdetailstruct" minOccurs="0"/>
 *         &lt;element name="sellRatingStatsPerMonth" type="{https://webapi.allegro.pl/service.php}ArrayOfSellratingaveragepermonthstruct" minOccurs="0"/>
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
    "sellRatingTotalCount",
    "sellRatingAverage",
    "sellRatingDetails",
    "sellRatingStatsPerMonth"
})
@XmlRootElement(name = "doGetMySellRatingResponse")
public class DoGetMySellRatingResponse {

    protected int sellRatingTotalCount;
    protected ArrayOfSellratingaveragestruct sellRatingAverage;
    protected ArrayOfSellratingdetailstruct sellRatingDetails;
    protected ArrayOfSellratingaveragepermonthstruct sellRatingStatsPerMonth;

    /**
     * Gets the value of the sellRatingTotalCount property.
     * 
     */
    public int getSellRatingTotalCount() {
        return sellRatingTotalCount;
    }

    /**
     * Sets the value of the sellRatingTotalCount property.
     * 
     */
    public void setSellRatingTotalCount(int value) {
        this.sellRatingTotalCount = value;
    }

    /**
     * Gets the value of the sellRatingAverage property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratingaveragestruct }
     *     
     */
    public ArrayOfSellratingaveragestruct getSellRatingAverage() {
        return sellRatingAverage;
    }

    /**
     * Sets the value of the sellRatingAverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratingaveragestruct }
     *     
     */
    public void setSellRatingAverage(ArrayOfSellratingaveragestruct value) {
        this.sellRatingAverage = value;
    }

    /**
     * Gets the value of the sellRatingDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratingdetailstruct }
     *     
     */
    public ArrayOfSellratingdetailstruct getSellRatingDetails() {
        return sellRatingDetails;
    }

    /**
     * Sets the value of the sellRatingDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratingdetailstruct }
     *     
     */
    public void setSellRatingDetails(ArrayOfSellratingdetailstruct value) {
        this.sellRatingDetails = value;
    }

    /**
     * Gets the value of the sellRatingStatsPerMonth property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSellratingaveragepermonthstruct }
     *     
     */
    public ArrayOfSellratingaveragepermonthstruct getSellRatingStatsPerMonth() {
        return sellRatingStatsPerMonth;
    }

    /**
     * Sets the value of the sellRatingStatsPerMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSellratingaveragepermonthstruct }
     *     
     */
    public void setSellRatingStatsPerMonth(ArrayOfSellratingaveragepermonthstruct value) {
        this.sellRatingStatsPerMonth = value;
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
