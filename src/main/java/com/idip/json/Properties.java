
package com.idip.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cm:title",
    "cm:description"
})
public class Properties {

    @JsonProperty("cm:title")
    private String cmTitle;
    @JsonProperty("cm:description")
    private String cmDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cm:title")
    public String getCmTitle() {
        return cmTitle;
    }

    @JsonProperty("cm:title")
    public void setCmTitle(String cmTitle) {
        this.cmTitle = cmTitle;
    }

    @JsonProperty("cm:description")
    public String getCmDescription() {
        return cmDescription;
    }

    @JsonProperty("cm:description")
    public void setCmDescription(String cmDescription) {
        this.cmDescription = cmDescription;
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
