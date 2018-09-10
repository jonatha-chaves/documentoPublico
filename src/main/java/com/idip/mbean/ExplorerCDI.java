package com.idip.mbean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

import com.idip.json.BaseRest;
import com.idip.json.Entry;
import com.idip.json.Entry_;
import com.idip.util.FileType;

@Named("explorer")
@SessionScoped
public class ExplorerCDI implements Serializable {
	private static final long serialVersionUID = 1L;

	private TreeNode root;
	
	private Entry rootEntry;
	
	private boolean fullTextShow = false;
	private TreeNode fullText;
	private String queryFulltext;
	
	@Inject
	ControleCDI controleCDI;

	@PostConstruct
	public void init() {
		try {
			rootEntry = controleCDI.rootDocumento();
			root = new DefaultTreeNode("root", null);
			TreeNode pastaReferencia = new DefaultTreeNode(rootEntry.getEntry(), root);
			BaseRest baseRest = controleCDI.filhosRoot();
			for (Entry entry : baseRest.getList().getEntries()) {
				if (entry.getEntry().getIsFile()) {
					if(entry.getEntry().getContent().getMimeType().equals("application/pdf")){
						new DefaultTreeNode(FileType.FILE_PDF.toString(), entry.getEntry(), pastaReferencia);
					}else {
						new DefaultTreeNode(FileType.FILE.toString(), entry.getEntry(), pastaReferencia);
					}
				} else {
					TreeNode folder = new DefaultTreeNode(entry.getEntry(), pastaReferencia);
					new DefaultTreeNode("expand", folder);
				}
			}
		} catch (IOException e) {
			adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Acesso ao documento/pasta recusado", null);
		}
	}

	public void onNodeExpand(NodeExpandEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expanded", event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
		if (((Entry_) event.getTreeNode().getData()).getId().equals(controleCDI.getPastaReferencia()) || event.getTreeNode().getChildren().isEmpty()) {
			return;
		}
		try {
			BaseRest baseRest = controleCDI.filhos(((Entry_) event.getTreeNode().getData()).getId());
			if (event.getTreeNode().getChildren().get(0).getData().toString().equals("expand")) {
				event.getTreeNode().getChildren().remove(0);
			}
			for (Entry entry : baseRest.getList().getEntries()) {
				if (entry.getEntry().getIsFile()) {
					if(entry.getEntry().getContent().getMimeType().equals("application/pdf")){
						new DefaultTreeNode(FileType.FILE_PDF.toString(), entry.getEntry(), event.getTreeNode());
					}else {
						new DefaultTreeNode(FileType.FILE.toString(), entry.getEntry(), event.getTreeNode());
					}
					
				} else {
					TreeNode folder = new DefaultTreeNode(entry.getEntry(), event.getTreeNode());
					new DefaultTreeNode("expand", folder);
				}
			}
		} catch (IOException e) {
			adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Acesso ao documento/pasta recusado", null);
		}
	}
	
	public StreamedContent downloadFile(Entry_ entry) {
		try {
			return controleCDI.downloadFile(entry);
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
    }
	
	public void consultaFullText() {
		try {
			fullText = new DefaultTreeNode("root", null);
			BaseRest baseRest = controleCDI.fullText(queryFulltext, controleCDI.getPastaReferencia());
			for (Entry entry : baseRest.getList().getEntries()) {
				if (entry.getEntry().getIsFile()) {
					if(entry.getEntry().getContent().getMimeType().equals("application/pdf")){
						new DefaultTreeNode(FileType.FILE_PDF.toString(), entry.getEntry(), fullText);
					}else {
						new DefaultTreeNode(FileType.FILE.toString(), entry.getEntry(), fullText);
					}
				}
			}			
			fullTextShow = true;
			if(baseRest.getList().getEntries().isEmpty()) {
				adicionarMensagem(":messages_result",FacesMessage.SEVERITY_WARN, "Nenhum documento encontrado", null);
			}			
		} catch (IOException e) {
			adicionarMensagem(FacesMessage.SEVERITY_ERROR, "Acesso ao documento/pasta recusado", null);
		}
	}
	
	public void limparConsulta() {
		queryFulltext = "";
		fullTextShow = false;
		fullText = null;
	}

	private void adicionarMensagem(Severity sev, String title, String content) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(sev, title, content));
	}
	
	private void adicionarMensagem(String clientId, Severity sev, String title, String content) {
		FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(sev, title, content));
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public boolean isFullTextShow() {
		return fullTextShow;
	}

	public void setFullTextShow(boolean fullTextShow) {
		this.fullTextShow = fullTextShow;
	}

	public TreeNode getFullText() {
		return fullText;
	}

	public void setFullText(TreeNode fullText) {
		this.fullText = fullText;
	}

	public String getQueryFulltext() {
		return queryFulltext;
	}

	public void setQueryFulltext(String queryFulltext) {
		this.queryFulltext = queryFulltext;
	}	
}
