
package com.idip.json;

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
@JsonPropertyOrder({
    "name",
    "createdAt",
    "modifiedAt",
    "createdByUser",
    "modifiedByUser",
    "isFolder",
    "isFile",
    "aspectNames",
    "properties",
    "parentId",
    "nodeType",
    "id"
})
public class Source {

    @JsonProperty("name")
    private String name;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("modifiedAt")
    private String modifiedAt;
    @JsonProperty("createdByUser")
    private CreatedByUser_ createdByUser;
    @JsonProperty("modifiedByUser")
    private ModifiedByUser_ modifiedByUser;
    @JsonProperty("isFolder")
    private Boolean isFolder;
    @JsonProperty("isFile")
    private Boolean isFile;
    @JsonProperty("aspectNames")
    private List<String> aspectNames = null;
    @JsonProperty("properties")
    private Properties properties;
    @JsonProperty("parentId")
    private String parentId;
    @JsonProperty("nodeType")
    private String nodeType;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("modifiedAt")
    public String getModifiedAt() {
        return modifiedAt;
    }

    @JsonProperty("modifiedAt")
    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @JsonProperty("createdByUser")
    public CreatedByUser_ getCreatedByUser() {
        return createdByUser;
    }

    @JsonProperty("createdByUser")
    public void setCreatedByUser(CreatedByUser_ createdByUser) {
        this.createdByUser = createdByUser;
    }

    @JsonProperty("modifiedByUser")
    public ModifiedByUser_ getModifiedByUser() {
        return modifiedByUser;
    }

    @JsonProperty("modifiedByUser")
    public void setModifiedByUser(ModifiedByUser_ modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
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

    @JsonProperty("aspectNames")
    public List<String> getAspectNames() {
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

    @JsonProperty("nodeType")
    public String getNodeType() {
        return nodeType;
    }

    @JsonProperty("nodeType")
    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
