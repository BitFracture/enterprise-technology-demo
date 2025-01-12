package com.bitfracture.etd;

import ai.djl.Application;
import ai.djl.Device;
import ai.djl.Model;
import ai.djl.engine.Engine;
import ai.djl.inference.Predictor;
import ai.djl.modality.nlp.TextPrompt;
import ai.djl.modality.nlp.generate.CausalLMOutput;
import ai.djl.modality.nlp.qa.QAInput;
import ai.djl.modality.nlp.translator.QATranslator;
import ai.djl.modality.nlp.translator.QaServingTranslator;
import ai.djl.ndarray.NDList;
import ai.djl.repository.Artifact;
import ai.djl.repository.zoo.Criteria;
import ai.djl.translate.BasicTranslator;
import ai.djl.translate.NoopTranslator;
import ai.djl.translate.TranslateException;
import ai.djl.translate.Translator;
import ai.djl.translate.TranslatorContext;
import org.springframework.stereotype.Component;

import java.util.Comparator;

/**
 * Abstracts capabilities of the embedded LLM from the rest of the implementation. Currently powered by a Java wrapper
 * for Meta LLaMa. An LLM provides natural language inference and indexing capabilities, commonly described as AI.
 */
@Component
public class LlmAdapter {
    private Predictor<QAInput, String> llmPredictor;

    public LlmAdapter() throws Exception {
        //Executed without error:
//        var engine = LlamaEngine.getInstance();
//        var model = engine.newModel("Q5_0", Device.cpu());
//        llmPredictor = model.newPredictor(new LlamaTranslator<>(), Device.cpu());

        //Todo: Temporary code
//        LlamaModelZoo.listModels().forEach((app, artifacts) -> {
//            System.out.println("Application: " + app.getPath());
//            artifacts.stream()
//                    .sorted(Comparator.comparing(Artifact::getName))
//                    .forEach(artifact -> {
//                System.out.printf(" - Artifact %s | %s\n", artifact.getName(), artifact.getVersion());
//            });
//        });
        //LlamaModelZoo.getModelZoo("Q5").getModelLoader()
//        var zooModel = LlamaModelZoo.loadModel(criteria);

//        Criteria<QAInput, String> criteria = Criteria.builder()
//                .optApplication(Application.NLP.QUESTION_ANSWER)
//                .optTranslatorFactory(new QuestionAnsweringTranslatorFactory())
//                .setTypes(QAInput.class, String.class)
//                .build();
    }

    public String summarizeText(String originalText) {
        QAInput input = new QAInput("Summarize the content", originalText);
        String output;
        try {
            output = llmPredictor.predict(input);
        } catch (TranslateException ex) {
            throw new RuntimeException(ex);
        }
        return output;
    }
}
