package com.example.tp3ramiharoung122ia.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClientRest {

    private final GuideTouristique assistant;

    public LlmClientRest() {
        String apiKey = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.3)
                .build();

        this.assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }

    public GuideTouristique assistant() {
        return assistant;
    }
}
