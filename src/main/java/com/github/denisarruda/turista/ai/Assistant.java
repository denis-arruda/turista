package com.github.denisarruda.turista.ai;

import dev.langchain4j.service.UserMessage;

public interface Assistant {
	
	@UserMessage("Generate a list of  the top {{it}} compliments.")
	String retrieveMainCompliments(int size);
	
	@UserMessage("Generate a list with of the top {{it}} complaints.")
	String retrieveMainComplaints(int size);
}