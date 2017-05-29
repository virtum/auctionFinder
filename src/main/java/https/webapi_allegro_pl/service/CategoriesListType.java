
package https.webapi_allegro_pl.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.apache.cxf.jaxb.JAXBToStringBuilder;
import org.apache.cxf.jaxb.JAXBToStringStyle;


/**
 * <p>Java class for CategoriesListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CategoriesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="categoriesTree" type="{https://webapi.allegro.pl/service.php}ArrayOfCategorytreetype" minOccurs="0"/>
 *         &lt;element name="categoriesPath" type="{https://webapi.allegro.pl/service.php}ArrayOfCategorypathtype" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoriesListType", propOrder = {

})
public class CategoriesListType {

    protected ArrayOfCategorytreetype categoriesTree;
    protected ArrayOfCategorypathtype categoriesPath;

    /**
     * Gets the value of the categoriesTree property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCategorytreetype }
     *     
     */
    public ArrayOfCategorytreetype getCategoriesTree() {
        return categoriesTree;
    }

    /**
     * Sets the value of the categoriesTree property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCategorytreetype }
     *     
     */
    public void setCategoriesTree(ArrayOfCategorytreetype value) {
        this.categoriesTree = value;
    }

    /**
     * Gets the value of the categoriesPath property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCategorypathtype }
     *     
     */
    public ArrayOfCategorypathtype getCategoriesPath() {
        return categoriesPath;
    }

    /**
     * Sets the value of the categoriesPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCategorypathtype }
     *     
     */
    public void setCategoriesPath(ArrayOfCategorypathtype value) {
        this.categoriesPath = value;
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
