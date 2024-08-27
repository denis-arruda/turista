package com.github.denisarruda.turista.ai;

import dev.langchain4j.service.UserMessage;

public interface Assistant {
	
	@UserMessage("Generate a list of  the top 5 compliments.")
	String retrieveMainCompliments();
	
	@UserMessage("Generate a list with of the top 5 complaints.")
	String retrieveMainComplaints();
}