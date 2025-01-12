package com.bitfracture.etd.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data type representing a document within the service, true to form with the JSON contract used by the API.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DocumentResource extends Resource {
    private Long id;
    private String originalName;
    private String summary;
    private String content;
    private DateType whenCreated;
    private DateType whenUpdated;
}
