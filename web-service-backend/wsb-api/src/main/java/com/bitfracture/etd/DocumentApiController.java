package com.bitfracture.etd;

import com.bitfracture.etd.resources.DocumentResource;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Primary entry point for HTTP API requests interacting with document resources.
 */
@RestController
@RequestMapping("/api/document/v1")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentApiController {
    private static final String MIME_JSON = "Application/Json";

    private final DocumentBusinessLogic logic;

    @GetMapping(path = "/{id}", produces = MIME_JSON)
    @ResponseStatus(HttpStatus.OK)
    public DocumentResource retrieveById(String id) {
        return logic.exampleRequest();
    }

    @PostMapping(path = "", produces = MIME_JSON, consumes = MIME_JSON)
    @ResponseStatus(HttpStatus.OK)
    public DocumentResource create(@RequestBody DocumentResource newResource) {
        return logic.createAndSummarize(newResource);
    }
}
