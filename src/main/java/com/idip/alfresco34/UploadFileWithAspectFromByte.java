
package com.idip.alfresco34;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uploadFileWithAspectFromByte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uploadFileWithAspectFromByte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="folderSequenceTree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aspectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aspectDomain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aspectKeys" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aspectValues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="newSpace" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
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
     * Gets the value of the token property.
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
     * Sets the value of the token property.
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
     * Gets the value of the folderSequenceTree property.
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
     * Sets the value of the folderSequenceTree property.
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
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the aspectName property.
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
     * Sets the value of the aspectName property.
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
     * Gets the value of the aspectDomain property.
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
     * Sets the value of the aspectDomain property.
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
     * Gets the value of the aspectKeys property.
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
     * Sets the value of the aspectKeys property.
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
     * Gets the value of the aspectValues property.
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
     * Sets the value of the aspectValues property.
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
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setData(byte[] value) {
        this.data = ((byte[]) value);
    }

    /**
     * Gets the value of the newSpace property.
     * 
     */
    public boolean isNewSpace() {
        return newSpace;
    }

    /**
     * Sets the value of the newSpace property.
     * 
     */
    public void setNewSpace(boolean value) {
        this.newSpace = value;
    }

    /**
     * Gets the value of the user property.
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
     * Sets the value of the user property.
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
     * Gets the value of the password property.
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
     * Sets the value of the password property.
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