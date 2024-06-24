
package ru.testtask.task3.dto.structure;

import com.fasterxml.jackson.annotation.*;
import ru.testtask.task3.dto.results.ResultValueDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "value",
    "title"
})
public class StructureValueDto extends ResultValueDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("values")
    private List<StructureValueDto> values;

    @JsonProperty("values")
    public List<StructureValueDto> getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(List<StructureValueDto> values) {
        this.values = values;
    }


    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
