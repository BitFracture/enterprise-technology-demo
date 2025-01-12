package com.bitfracture.etd;

import com.bitfracture.etd.resources.DocumentResource;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final DocumentBusinessLogic logic;

    @GetMapping(path = "", produces = "Application/JSON")
    @ResponseStatus(HttpStatus.OK)
    public DocumentResource basicGetTest() {
        return logic.exampleRequest();
    }
}
