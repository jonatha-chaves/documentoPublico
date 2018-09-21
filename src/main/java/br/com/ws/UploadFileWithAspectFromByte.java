
package br.com.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de uploadFileWithAspectFromByte complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="uploadFileWithAspectFromByte"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="folderSequenceTree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aspectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aspectDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aspectKeys" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aspectValues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="newSpace" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadFileWithAspectFromByte", propOrder = {
    "token",
    "folderSequenceTree",
    "name",
    "aspectName",
    "aspectDomain",
    "aspectKeys",
    "aspectValues",
    "data",
    "newSpace",
    "user",
    "password"
})
public class UploadFileWithAspectFromByte {

    protected String token;
    protected String folderSequenceTree;
    protected String name;
    protected String aspectName;
    protected String aspectDomain;
    protected String aspectKeys;
    protected String aspectValues;
    protected byte[] data;
    protected boolean newSpace;
    protected String user;
    protected String password;

    /**
     * Obtém o valor da propriedade token.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Define o valor da propriedade token.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Obtém o valor da propriedade folderSequenceTree.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFolderSequenceTree() {
        return folderSequenceTree;
    }

    /**
     * Define o valor da propriedade folderSequenceTree.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFolderSequenceTree(String value) {
        this.folderSequenceTree = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade aspectName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspectName() {
        return aspectName;
    }

    /**
     * Define o valor da propriedade aspectName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspectName(String value) {
        this.aspectName = value;
    }

    /**
     * Obtém o valor da propriedade aspectDomain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspectDomain() {
        return aspectDomain;
    }

    /**
     * Define o valor da propriedade aspectDomain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspectDomain(String value) {
        this.aspectDomain = value;
    }

    /**
     * Obtém o valor da propriedade aspectKeys.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspectKeys() {
        return aspectKeys;
    }

    /**
     * Define o valor da propriedade aspectKeys.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspectKeys(String value) {
        this.aspectKeys = value;
    }

    /**
     * Obtém o valor da propriedade aspectValues.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspectValues() {
        return aspectValues;
    }

    /**
     * Define o valor da propriedade aspectValues.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspectValues(String value) {
        this.aspectValues = value;
    }

    /**
     * Obtém o valor da propriedade data.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Define o valor da propriedade data.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = value;
    }

    /**
     * Obtém o valor da propriedade newSpace.
     * 
     */
    public boolean isNewSpace() {
        return newSpace;
    }

    /**
     * Define o valor da propriedade newSpace.
     * 
     */
    public void setNewSpace(boolean value) {
        this.newSpace = value;
    }

    /**
     * Obtém o valor da propriedade user.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Define o valor da propriedade user.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Obtém o valor da propriedade password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define o valor da propriedade password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

}
