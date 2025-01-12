package com.bitfracture.etd;

import com.bitfracture.etd.resources.DateType;
import com.bitfracture.etd.resources.DocumentResource;

import org.springframework.stereotype.Service;

@Service
public class DocumentBusinessLogic {

    public DocumentResource exampleRequest() {
        return DocumentResource.builder()
                .id(12L)
                .content("Example long text content from the original document")
                .originalName("somefilename12.txt")
                .summary("This is an AI summary of the text")
                .whenCreated(DateType.now())
                .whenUpdated(DateType.now())
                .build();
    }
}
