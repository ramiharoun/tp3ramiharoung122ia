package com.example.tp3ramiharoung122ia.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClientRest {

    private final GuideTouristique assistant;

    public LlmClientRest() {
        String key = System.getenv("GEMINI_KEY");
        if (key == null || key.isBlank()) {
            throw new IllegalStateException("Clé API GEMINI_KEY introuvable");
        }

        ChatModel modele = GoogleAiGeminiChatModel.builder()
                .apiKey(key)
                .modelName("gemini-2.0-flash-exp")
                .temperature(0.25)
                .build();

        this.assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(modele)
                .build();
    }

    public GuideTouristique assistant() {
        return assistant;
    }
}