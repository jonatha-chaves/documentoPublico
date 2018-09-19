
package com.idip.alfresco52;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "aspectNames", "createdAt", "isFolder", "isFile", "createdByUser", "modifiedAt", "modifiedByUser",
		"name", "id", "nodeType", "content", "properties", "parentId" })
public class Entry_ {

	@JsonProperty("aspectNames")
	private java.util.List<String> aspectNames = null;
	@JsonProperty("createdAt")
	private String createdAt;
	@JsonProperty("isFolder")
	private Boolean isFolder;
	@JsonProperty("isFile")
	private Boolean isFile;
	@JsonProperty("createdByUser")
	private CreatedByUser createdByUser;
	@JsonProperty("modifiedAt")
	private String modifiedAt;
	@JsonProperty("modifiedByUser")
	private ModifiedByUser modifiedByUser;
	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private String id;
	@JsonProperty("nodeType")
	private String nodeType;
	@JsonProperty("content")
	private Content content;
	@JsonProperty("properties")
	private Properties properties;
	@JsonProperty("parentId")
	private String parentId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private String urlFile34;

	@JsonProperty("createdAt")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("createdAt")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("isFolder")
	public Boolean getIsFolder() {
		return isFolder;
	}

	@JsonProperty("isFolder")
	public void setIsFolder(Boolean isFolder) {
		this.isFolder = isFolder;
	}

	@JsonProperty("isFile")
	public Boolean getIsFile() {
		return isFile;
	}

	@JsonProperty("isFile")
	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}

	@JsonProperty("createdByUser")
	public CreatedByUser getCreatedByUser() {
		return createdByUser;
	}

	@JsonProperty("createdByUser")
	public void setCreatedByUser(CreatedByUser createdByUser) {
		this.createdByUser = createdByUser;
	}

	@JsonProperty("modifiedAt")
	public String getModifiedAt() {
		return modifiedAt;
	}

	@JsonProperty("modifiedAt")
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@JsonProperty("modifiedByUser")
	public ModifiedByUser getModifiedByUser() {
		return modifiedByUser;
	}

	@JsonProperty("modifiedByUser")
	public void setModifiedByUser(ModifiedByUser modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("nodeType")
	public String getNodeType() {
		return nodeType;
	}

	@JsonProperty("nodeType")
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	@JsonProperty("content")
	public Content getContent() {
		return content;
	}

	@JsonProperty("content")
	public void setContent(Content content) {
		this.content = content;
	}

	@JsonProperty("aspectNames")
	public java.util.List<String> getAspectNames() {
		return aspectNames;
	}
	@JsonProperty("aspectNames")
	public void setAspectNames(List<String> aspectNames) {
		this.aspectNames = aspectNames;
	}

	@JsonProperty("properties")
	public Properties getProperties() {
		return properties;
	}

	@JsonProperty("properties")
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@JsonProperty("parentId")
	public String getParentId() {
		return parentId;
	}

	@JsonProperty("parentId")
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getUrlFile34() {
		return urlFile34;
	}

	public void setUrlFile34(String urlFile34) {
		this.urlFile34 = urlFile34;
	}
	
	

}
