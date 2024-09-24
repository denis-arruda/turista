package com.github.denisarruda.turista.ai;

import static dev.langchain4j.data.message.UserMessage.userMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolExecutionRequest;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.agent.tool.ToolSpecifications;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.tool.DefaultToolExecutor;
import dev.langchain4j.service.tool.ToolExecutor;

public class ChatWithFunction {

	private final ChatLanguageModel chatModel;

	public ChatWithFunction(ChatLanguageModel chatModel) {
		this.chatModel = chatModel;
	}

	public String generate(String chatMessage) {
		WeatherTools weatherTools = new WeatherTools();
        List<ToolSpecification> toolSpecifications = ToolSpecifications.toolSpecificationsFrom(weatherTools);
		
		List<ChatMessage> chatMessages = new ArrayList<>();
        UserMessage userMessage = userMessage(chatMessage);
        chatMessages.add(userMessage);


        // STEP 2: Model generate function arguments
        AiMessage aiMessage = chatModel.generate(chatMessages, toolSpecifications).content();
        List<ToolExecutionRequest> toolExecutionRequests = aiMessage.toolExecutionRequests();
        //System.out.println("Out of the " + toolSpecifications.size() + " functions declared in WeatherTools, " + toolExecutionRequests.size() + " will be invoked:");
        chatMessages.add(aiMessage);


        // STEP 3: User execute function to obtain tool results
        if (toolExecutionRequests != null) {
            toolExecutionRequests.forEach(toolExecutionRequest -> {
                ToolExecutor toolExecutor = new DefaultToolExecutor(weatherTools, toolExecutionRequest);
                String result = toolExecutor.execute(toolExecutionRequest, UUID.randomUUID().toString());
                ToolExecutionResultMessage toolExecutionResultMessages = ToolExecutionResultMessage.from(toolExecutionRequest, result);
                chatMessages.add(toolExecutionResultMessages);
            });
        }


        // STEP 4: Model generate final response
        AiMessage finalResponse = chatModel.generate(chatMessages).content();
        return finalResponse.text(); //According to the payment data, the payment status of transaction T1005 is Pending.
	}
	
	static class WeatherTools {

		@Tool("Returns the weather forecast")
		String getWeather() {
			return "The weather is sunny and 26°C";
		}
	}
}