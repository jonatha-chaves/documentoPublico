/**
 * 
 */
package com.idip.cdi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idip.alfresco52.BaseRest;
import com.idip.alfresco52.Content;
import com.idip.alfresco52.Entry;
import com.idip.alfresco52.Entry_;
import com.idip.alfresco52.Properties;

import br.com.ws.Exception_Exception;
import br.com.ws.FileAndFolderResult;
import br.com.ws.OnlinePublicAlfrescoService;
import br.com.ws.Public;

/**
 * @author jonatha.chaves
 *
 */
@Named("controle")
@ApplicationScoped
public class ControleCDI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String urlBaseAlfresco;
	private String versaoAlfresco;
	private String pastaReferencia;
	private String baseRestUrl;
	private String restUrlFullText;
	private String restUrlDownload;
	private String restUrlTree;
	private String restUrlParent;
	private String usuario;
	private String senha;

	@PostConstruct
	public void init() {
		urlBaseAlfresco = "http://127.0.0.1:8085";
		versaoAlfresco = "5.2";
//		versaoAlfresco = "3.4";
		pastaReferencia = "7bcac91c-4560-4e8a-b7f0-cab55c6faeb5";
//		pastaReferencia = "Legislação Tributária";
		baseRestUrl = "/alfresco/api/-default-/public/alfresco/versions/1/";
		restUrlFullText = "queries/nodes?term={term}&rootNodeId={rootNodeId}";
		restUrlDownload = "nodes/{nodeId}/content";
		restUrlTree = "nodes/{nodeId}/children?include=properties";
		restUrlParent = "nodes/{nodeId}";
		usuario = "admin";
		senha = "1234";
		
//		usuario = "guest";
//		senha = "guest";
	}

	private void adicionarMensagem(Severity sev, String title, String content) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(sev, title, content));
	}

	private String resultadoRest(String urlConsulta) throws IOException {
		URL url = new URL(urlConsulta);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		String userCredentials = usuario + ":" + senha;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
		conn.setRequestProperty("Authorization", basicAuth);
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream()),"UTF-8"));
		String output;
		String str = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			str += output;
		}
		conn.disconnect();
		return str;
	}

	public void save() {
		adicionarMensagem(FacesMessage.SEVERITY_INFO, "Alteração realizada", null);
	}

	private String urlRestFullText(String consulta, String pastaReferencia) {
		return (urlBaseAlfresco + baseRestUrl + restUrlFullText).replace("{term}", consulta).replace("{rootNodeId}",
				pastaReferencia);
	}

	private String urlRestDownload(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlDownload).replace("{nodeId}", nodeId);
	}

	private String urlRestTree(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlTree).replace("{nodeId}", nodeId);
	}

	private String urlRestParent(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlParent).replace("{nodeId}", nodeId);
	}

	public Entry rootDocumento() throws IOException {
		Entry entry;
		System.out.println("Pasta Referencia:" + pastaReferencia);
		if (versaoAlfresco.equals("5.2")) {
			String resultado = resultadoRest(urlRestParent(pastaReferencia));
			ObjectMapper mapper = new ObjectMapper();
			entry = mapper.readValue(resultado, Entry.class);
		} else {
			Entry_ entry_ = new Entry_();
			entry_.setIsFolder(true);
			entry_.setName(pastaReferencia);
			entry_.setId(pastaReferencia);
			entry = new Entry();
			entry.setEntry(entry_);
		}
		return entry;
	}

	public BaseRest filhosRoot() throws IOException, Exception_Exception {
		BaseRest baseRest;
		if (versaoAlfresco.equals("5.2")) {
			String resultado = resultadoRest(urlRestTree(pastaReferencia));
			ObjectMapper mapper = new ObjectMapper();
			baseRest = mapper.readValue(resultado, BaseRest.class);
		} else {
			Public publicAlfresco = new OnlinePublicAlfrescoService().getPublicPort();
			List<FileAndFolderResult> result = publicAlfresco.findFilesAndFolder("#", "company_home#" + pastaReferencia,
					"p7s", true, true, usuario, senha);
			baseRest = new BaseRest();
			com.idip.alfresco52.List list = new com.idip.alfresco52.List();
			List<Entry> entries = new ArrayList<>();
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i).getName() + " " + result.get(i).getDescription());
				Entry_ entry_ = new Entry_();
				entry_.setIsFolder(result.get(i).getType().equals("folder"));
				entry_.setIsFile(!result.get(i).getType().equals("folder"));
				entry_.setName(result.get(i).getName());
				entry_.setNodeType(result.get(i).getType());
				entry_.setId(result.get(i).getUuid());
				Properties properties = new Properties();
				properties.setCmDescription(result.get(i).getDescription());
				properties.setCmTitle(result.get(i).getName());
				entry_.setUrlFile34(result.get(i).getUrl());
				entry_.setProperties(properties);
				Entry entry = new Entry();				
				entry.setEntry(entry_);
				entries.add(entry);
			}
			list.setEntries(entries);
			baseRest.setList(list);
		}
		return baseRest;
	}

	public BaseRest filhos(String nodeId) throws IOException, Exception_Exception {
		BaseRest baseRest;
		if (versaoAlfresco.equals("5.2")) {
			String resultado = resultadoRest(urlRestTree(nodeId));
			ObjectMapper mapper = new ObjectMapper();
			baseRest = mapper.readValue(resultado, BaseRest.class);
		} else {
			Public publicAlfresco = new OnlinePublicAlfrescoService().getPublicPort();
			List<FileAndFolderResult> result = publicAlfresco.findFilesAndFolder("#",
					"company_home#" + nodeId, "p7s", true, true, usuario, senha);
			baseRest = new BaseRest();
			com.idip.alfresco52.List list = new com.idip.alfresco52.List();
			List<Entry> entries = new ArrayList<>();
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i).getName() + " " + result.get(i).getDescription());
				Entry_ entry_ = new Entry_();
				entry_.setIsFolder(result.get(i).getType().equals("folder"));
				entry_.setIsFile(!result.get(i).getType().equals("folder"));
				entry_.setName(result.get(i).getName());
				entry_.setNodeType(result.get(i).getType());
				entry_.setId(result.get(i).getUuid());
				Properties properties = new Properties();
				properties.setCmDescription(result.get(i).getDescription());
				properties.setCmTitle(result.get(i).getName());
				entry_.setUrlFile34(result.get(i).getUrl());
				Content content = new Content();
				content.setMimeType(result.get(i).getType());
				entry_.setContent(content);
				entry_.setProperties(properties);
				Entry entry = new Entry();
				entry.setEntry(entry_);
				entries.add(entry);
			}
			list.setEntries(entries);
			baseRest.setList(list);
		}
		return baseRest;
	}

	public BaseRest fullText(String query, String rootNodeId) throws IOException {
		String resultado = resultadoRest(urlRestFullText(query.replace(" ", "%20"), rootNodeId));
		ObjectMapper mapper = new ObjectMapper();
		BaseRest baseRest = mapper.readValue(resultado, BaseRest.class);
		return baseRest;
	}

	public StreamedContent downloadFile(Entry_ entry) throws IOException {
		URL url = new URL(urlRestDownload(entry.getId()));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		String userCredentials = usuario + ":" + senha;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
		conn.setRequestProperty("Authorization", basicAuth);
		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		StreamedContent file = new DefaultStreamedContent(conn.getInputStream(), entry.getContent().getMimeType(),
				entry.getName());
		return file;
	}

	// gets and sets
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUrlBaseAlfresco() {
		return urlBaseAlfresco;
	}

	public void setUrlBaseAlfresco(String urlBaseAlfresco) {
		this.urlBaseAlfresco = urlBaseAlfresco;
	}

	public String getVersaoAlfresco() {
		return versaoAlfresco;
	}

	public void setVersaoAlfresco(String versaoAlfresco) {
		this.versaoAlfresco = versaoAlfresco;
	}

	public String getPastaReferencia() {
		return pastaReferencia;
	}

	public void setPastaReferencia(String pastaReferencia) {
		this.pastaReferencia = pastaReferencia;
	}

	public String getBaseRestUrl() {
		return baseRestUrl;
	}

	public void setBaseRestUrl(String baseRestUrl) {
		this.baseRestUrl = baseRestUrl;
	}

}
