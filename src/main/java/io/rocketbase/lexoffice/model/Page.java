package io.rocketbase.lexoffice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page<T> {

    @JsonProperty("content")
    private List<T> content;

    @JsonProperty("totalPages")
    private Long totalPages;

    @JsonProperty("totalElements")
    private Long totalElements;

    @Singular
    @JsonProperty("sort")
    private List<Sort> sorts;

    @JsonProperty("size")
    private Long size;

    @JsonProperty("number")
    private Long number;

    @JsonProperty("numberOfElements")
    private Long numberOfElements;

    @JsonProperty("last")
    private Boolean last;

    @JsonProperty("first")
    private Boolean first;
}
