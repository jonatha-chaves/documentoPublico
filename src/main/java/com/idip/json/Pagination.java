
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
    "count",
    "hasMoreItems",
    "totalItems",
    "skipCount",
    "maxItems"
})
public class Pagination {

    @JsonProperty("count")
    private Integer count;
    @JsonProperty("hasMoreItems")
    private Boolean hasMoreItems;
    @JsonProperty("totalItems")
    private Integer totalItems;
    @JsonProperty("skipCount")
    private Integer skipCount;
    @JsonProperty("maxItems")
    private Integer maxItems;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("hasMoreItems")
    public Boolean getHasMoreItems() {
        return hasMoreItems;
    }

    @JsonProperty("hasMoreItems")
    public void setHasMoreItems(Boolean hasMoreItems) {
        this.hasMoreItems = hasMoreItems;
    }

    @JsonProperty("totalItems")
    public Integer getTotalItems() {
        return totalItems;
    }

    @JsonProperty("totalItems")
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    @JsonProperty("skipCount")
    public Integer getSkipCount() {
        return skipCount;
    }

    @JsonProperty("skipCount")
    public void setSkipCount(Integer skipCount) {
        this.skipCount = skipCount;
    }

    @JsonProperty("maxItems")
    public Integer getMaxItems() {
        return maxItems;
    }

    @JsonProperty("maxItems")
    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
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
