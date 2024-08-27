package com.github.denisarruda.turista.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.denisarruda.turista.ai.Assistant;
import com.github.denisarruda.turista.ai.ChatModelBuilder;
import com.github.denisarruda.turista.ai.SentimentAnalyzer;
import com.github.denisarruda.turista.ai.SentimentAnalyzer.Sentiment;

@Service
public class TuristaService {

	private ChatModelBuilder chatModel;

	TuristaService(ChatModelBuilder chatModel) {
		this.chatModel = chatModel;
	}

	public String getMainCompliments() {
		Assistant assistant = chatModel.buildAssistant();
		return assistant.retrieveMainCompliments();
	}

	public String getMainComplaints() {
		Assistant assistant = chatModel.buildAssistant();
		return assistant.retrieveMainComplaints();

	}

	public Sentiment analyzeSentiment(@RequestBody String content) {
		SentimentAnalyzer sentimentAnalyzer = chatModel.buildSentimentAnalyzer();
		return sentimentAnalyzer.analyzeSentimentOf(content);
	}
}