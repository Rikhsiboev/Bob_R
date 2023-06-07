
package com.Bob_r.dto.country;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fin",
    "swe"
})
@Generated("jsonschema2pojo")
public class NativeName {

    @JsonProperty("fin")
    private Fin fin;
    @JsonProperty("swe")
    private Swe swe;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("fin")
    public Fin getFin() {
        return fin;
    }

    @JsonProperty("fin")
    public void setFin(Fin fin) {
        this.fin = fin;
    }

    @JsonProperty("swe")
    public Swe getSwe() {
        return swe;
    }

    @JsonProperty("swe")
    public void setSwe(Swe swe) {
        this.swe = swe;
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
