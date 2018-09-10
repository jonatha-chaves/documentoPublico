/**
 * 
 */
package com.idip.mbean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idip.json.BaseRest;
import com.idip.json.Entry;
import com.idip.json.Entry_;

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
		pastaReferencia = "7bcac91c-4560-4e8a-b7f0-cab55c6faeb5";
		baseRestUrl = "/alfresco/api/-default-/public/alfresco/versions/1/";
		restUrlFullText = "queries/nodes?term={term}&rootNodeId={rootNodeId}";
		restUrlDownload = "nodes/{nodeId}/content";
		restUrlTree = "nodes/{nodeId}/children?include=properties";
		restUrlParent = "nodes/{nodeId}";
		usuario = "admin";
		senha = "1234";
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
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
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

	public String urlRestFullText(String consulta) {
		return (urlBaseAlfresco + baseRestUrl + restUrlFullText).replace("{term}&rootNodeId={rootNodeId}", consulta);
	}

	public String urlRestFullText(String consulta, String pastaReferencia) {
		return (urlBaseAlfresco + baseRestUrl + restUrlFullText).replace("{term}", consulta).replace("{rootNodeId}", pastaReferencia);
	}

	public String urlRestDownload(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlDownload).replace("{nodeId}", nodeId);
	}

	public String urlRestTree(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlTree).replace("{nodeId}", nodeId);
	}

	public String urlRestParent(String nodeId) {
		return (urlBaseAlfresco + baseRestUrl + restUrlParent).replace("{nodeId}", nodeId);
	}

	public Entry rootDocumento() throws IOException {
		String resultado = resultadoRest(urlRestParent(pastaReferencia));
		ObjectMapper mapper = new ObjectMapper();
		Entry entry = mapper.readValue(resultado, Entry.class);
		return entry;
	}
	
	public BaseRest filhosRoot() throws IOException {
		String resultado = resultadoRest(urlRestTree(pastaReferencia));
		ObjectMapper mapper = new ObjectMapper();
		BaseRest baseRest = mapper.readValue(resultado, BaseRest.class);
		return baseRest;
	}
	
	public BaseRest filhos(String nodeId) throws IOException {
		String resultado = resultadoRest(urlRestTree(nodeId));
		ObjectMapper mapper = new ObjectMapper();
		BaseRest baseRest = mapper.readValue(resultado, BaseRest.class);
		return baseRest;
	}
	
	public BaseRest fullText(String query, String rootNodeId) throws IOException {
		String resultado = resultadoRest(urlRestFullText(query,rootNodeId));
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
		StreamedContent file = new DefaultStreamedContent(conn.getInputStream(), entry.getContent().getMimeType(), entry.getName());
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
