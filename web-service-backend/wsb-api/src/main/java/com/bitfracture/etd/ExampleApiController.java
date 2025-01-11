package com.bitfracture.etd;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Primary entry point for HTTP API requests interacting with document resources.
 */
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExampleApiController {
    private final ExampleBusinessLogic logic;

    @GetMapping(path = "/test")
    public String basicGetTest() {
        return logic.exampleRequest();
    }
}
