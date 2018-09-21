
package br.com.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de findFilesAndFolder complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="findFilesAndFolder"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="folderSequenceTree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="listExtesionBlock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="file" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="folder" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
@XmlType(name = "findFilesAndFolder", propOrder = {
    "token",
    "folderSequenceTree",
    "listExtesionBlock",
    "file",
    "folder",
    "user",
    "password"
})
public class FindFilesAndFolder {

    protected String token;
    protected String folderSequenceTree;
    protected String listExtesionBlock;
    protected boolean file;
    protected boolean folder;
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
     * Obtém o valor da propriedade listExtesionBlock.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListExtesionBlock() {
        return listExtesionBlock;
    }

    /**
     * Define o valor da propriedade listExtesionBlock.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListExtesionBlock(String value) {
        this.listExtesionBlock = value;
    }

    /**
     * Obtém o valor da propriedade file.
     * 
     */
    public boolean isFile() {
        return file;
    }

    /**
     * Define o valor da propriedade file.
     * 
     */
    public void setFile(boolean value) {
        this.file = value;
    }

    /**
     * Obtém o valor da propriedade folder.
     * 
     */
    public boolean isFolder() {
        return folder;
    }

    /**
     * Define o valor da propriedade folder.
     * 
     */
    public void setFolder(boolean value) {
        this.folder = value;
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
