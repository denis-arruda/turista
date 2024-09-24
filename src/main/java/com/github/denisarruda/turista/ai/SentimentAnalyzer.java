package com.github.denisarruda.turista.ai;

import dev.langchain4j.service.UserMessage;

public interface SentimentAnalyzer {

	enum Sentiment {
		POSITIVE, NEUTRAL, NEGATIVE;
	}

	@UserMessage("Analyze sentiment of {{it}}")
	Sentiment analyzeSentimentOf(String text);
}