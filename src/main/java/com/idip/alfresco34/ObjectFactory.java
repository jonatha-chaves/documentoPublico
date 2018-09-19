
package com.idip.alfresco34;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.idip.util.FileAndFolderResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindFilesAndFolderResponse_QNAME = new QName("http://ws.com.br/", "findFilesAndFolderResponse");
    private final static QName _UploadFileFromByteResponse_QNAME = new QName("http://ws.com.br/", "uploadFileFromByteResponse");
    private final static QName _UploadFileWithAspectFromByteResponse_QNAME = new QName("http://ws.com.br/", "uploadFileWithAspectFromByteResponse");
    private final static QName _UploadFileWithAspectFromByte_QNAME = new QName("http://ws.com.br/", "uploadFileWithAspectFromByte");
    private final static QName _FindFilesAndFolder_QNAME = new QName("http://ws.com.br/", "findFilesAndFolder");
    private final static QName _FindFilesFullTextResponse_QNAME = new QName("http://ws.com.br/", "findFilesFullTextResponse");
    private final static QName _FindFilesFullText_QNAME = new QName("http://ws.com.br/", "findFilesFullText");
    private final static QName _Exception_QNAME = new QName("http://ws.com.br/", "Exception");
    private final static QName _UploadFileFromByte_QNAME = new QName("http://ws.com.br/", "uploadFileFromByte");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindFilesFullTextResponse }
     * 
     */
    public FindFilesFullTextResponse createFindFilesFullTextResponse() {
        return new FindFilesFullTextResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link UploadFileFromByteResponse }
     * 
     */
    public UploadFileFromByteResponse createUploadFileFromByteResponse() {
        return new UploadFileFromByteResponse();
    }

    /**
     * Create an instance of {@link FileAndFolderResult }
     * 
     */
    public FileAndFolderResult createFileAndFolderResult() {
        return new FileAndFolderResult();
    }

    /**
     * Create an instance of {@link FindFilesAndFolder }
     * 
     */
    public FindFilesAndFolder createFindFilesAndFolder() {
        return new FindFilesAndFolder();
    }

    /**
     * Create an instance of {@link UploadFileWithAspectFromByteResponse }
     * 
     */
    public UploadFileWithAspectFromByteResponse createUploadFileWithAspectFromByteResponse() {
        return new UploadFileWithAspectFromByteResponse();
    }

    /**
     * Create an instance of {@link UploadFileWithAspectFromByte }
     * 
     */
    public UploadFileWithAspectFromByte createUploadFileWithAspectFromByte() {
        return new UploadFileWithAspectFromByte();
    }

    /**
     * Create an instance of {@link UploadFileFromByte }
     * 
     */
    public UploadFileFromByte createUploadFileFromByte() {
        return new UploadFileFromByte();
    }

    /**
     * Create an instance of {@link FindFilesFullText }
     * 
     */
    public FindFilesFullText createFindFilesFullText() {
        return new FindFilesFullText();
    }

    /**
     * Create an instance of {@link FindFilesAndFolderResponse }
     * 
     */
    public FindFilesAndFolderResponse createFindFilesAndFolderResponse() {
        return new FindFilesAndFolderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilesAndFolderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "findFilesAndFolderResponse")
    public JAXBElement<FindFilesAndFolderResponse> createFindFilesAndFolderResponse(FindFilesAndFolderResponse value) {
        return new JAXBElement<FindFilesAndFolderResponse>(_FindFilesAndFolderResponse_QNAME, FindFilesAndFolderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileFromByteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "uploadFileFromByteResponse")
    public JAXBElement<UploadFileFromByteResponse> createUploadFileFromByteResponse(UploadFileFromByteResponse value) {
        return new JAXBElement<UploadFileFromByteResponse>(_UploadFileFromByteResponse_QNAME, UploadFileFromByteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileWithAspectFromByteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "uploadFileWithAspectFromByteResponse")
    public JAXBElement<UploadFileWithAspectFromByteResponse> createUploadFileWithAspectFromByteResponse(UploadFileWithAspectFromByteResponse value) {
        return new JAXBElement<UploadFileWithAspectFromByteResponse>(_UploadFileWithAspectFromByteResponse_QNAME, UploadFileWithAspectFromByteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileWithAspectFromByte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "uploadFileWithAspectFromByte")
    public JAXBElement<UploadFileWithAspectFromByte> createUploadFileWithAspectFromByte(UploadFileWithAspectFromByte value) {
        return new JAXBElement<UploadFileWithAspectFromByte>(_UploadFileWithAspectFromByte_QNAME, UploadFileWithAspectFromByte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilesAndFolder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "findFilesAndFolder")
    public JAXBElement<FindFilesAndFolder> createFindFilesAndFolder(FindFilesAndFolder value) {
        return new JAXBElement<FindFilesAndFolder>(_FindFilesAndFolder_QNAME, FindFilesAndFolder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilesFullTextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "findFilesFullTextResponse")
    public JAXBElement<FindFilesFullTextResponse> createFindFilesFullTextResponse(FindFilesFullTextResponse value) {
        return new JAXBElement<FindFilesFullTextResponse>(_FindFilesFullTextResponse_QNAME, FindFilesFullTextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindFilesFullText }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "findFilesFullText")
    public JAXBElement<FindFilesFullText> createFindFilesFullText(FindFilesFullText value) {
        return new JAXBElement<FindFilesFullText>(_FindFilesFullText_QNAME, FindFilesFullText.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileFromByte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.com.br/", name = "uploadFileFromByte")
    public JAXBElement<UploadFileFromByte> createUploadFileFromByte(UploadFileFromByte value) {
        return new JAXBElement<UploadFileFromByte>(_UploadFileFromByte_QNAME, UploadFileFromByte.class, null, value);
    }

}
