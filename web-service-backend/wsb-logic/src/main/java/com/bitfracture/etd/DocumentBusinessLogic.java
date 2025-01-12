package com.bitfracture.etd;

import com.bitfracture.etd.resources.DateType;
import com.bitfracture.etd.resources.DocumentResource;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DocumentBusinessLogic {
    private final LlmAdapter llmAdapter;

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

    public DocumentResource createAndSummarize(DocumentResource newResource) {
        //Enhance with a summary
        summarizeIfNeeded(newResource);

        //Todo: Validate constraints
        return newResource;
    }

    private void summarizeIfNeeded(DocumentResource newResource) {
        if (StringUtils.isBlank(newResource.getSummary()) && StringUtils.isNotBlank(newResource.getContent())) {
            System.out.println("Preparing summary");
            newResource.setSummary(llmAdapter.summarizeText(newResource.getContent()));
        }
    }
}
