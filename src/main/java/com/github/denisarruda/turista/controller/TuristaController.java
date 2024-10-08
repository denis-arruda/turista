package com.github.denisarruda.turista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.denisarruda.turista.ai.SentimentAnalyzer.Sentiment;

@RestController
public class TuristaController {

	private TuristaService turistaService;

	TuristaController(TuristaService chatModel) {
		this.turistaService = chatModel;
	}
	
	@GetMapping("/compliments")
	public String praises(@RequestParam(required = true, defaultValue = "5") int size) {
		return turistaService.getMainCompliments(size);
	}

	@GetMapping("/complaints")
	public String complaint(@RequestParam(required = true, defaultValue = "5") int size) {
		return turistaService.getMainComplaints(size);
	}

	@PostMapping("/post")
	public Sentiment analyzeSentiment(@RequestBody String content) {
		return turistaService.analyzeSentiment(content);
	}
	
	@PostMapping("/chat")
	public String chat(@RequestBody String content) {
		return turistaService.chat(content);
	}
}