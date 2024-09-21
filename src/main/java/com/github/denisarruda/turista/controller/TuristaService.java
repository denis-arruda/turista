package com.github.denisarruda.turista.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.denisarruda.turista.ai.Assistant;
import com.github.denisarruda.turista.ai.ChatModelBuilder;
import com.github.denisarruda.turista.ai.ChatWithFunction;
import com.github.denisarruda.turista.ai.SentimentAnalyzer;
import com.github.denisarruda.turista.ai.SentimentAnalyzer.Sentiment;

@Service
public class TuristaService {

	private ChatModelBuilder chatModel;

	TuristaService(ChatModelBuilder chatModel) {
		this.chatModel = chatModel;
	}

	public String getMainCompliments(int size) {
		Assistant assistant = chatModel.buildAssistant();
		return assistant.retrieveMainCompliments(size);
	}

	public String getMainComplaints(int size) {
		Assistant assistant = chatModel.buildAssistant();
		return assistant.retrieveMainComplaints(size);

	}

	public Sentiment analyzeSentiment(String content) {
		SentimentAnalyzer sentimentAnalyzer = chatModel.buildSentimentAnalyzer();
		return sentimentAnalyzer.analyzeSentimentOf(content);
	}

	public String chat(String request) {
		ChatWithFunction sentimentAnalyzer = chatModel.buildChat();
		return sentimentAnalyzer.generate(request);
	}
}