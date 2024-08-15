package com.github.denisarruda.turista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.denisarruda.turista.ai.Assistant;
import com.github.denisarruda.turista.ai.RAGConfiguration;

@RestController
public class TuristaController {

	@Autowired
	private RAGConfiguration ragConfig;
	
	private Assistant assistant;

	@GetMapping("/praises")
	public String praises() {
		try {
			if (assistant == null) {
				assistant = ragConfig.configure();
			}
			return assistant.classify("what are the main praises?");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@GetMapping("/complaints")
	public String complaint() {
		try {
			if (assistant == null) {
				assistant = ragConfig.configure();
			}
			return assistant.classify("what are the main complaints?");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@PostMapping("/post")
	public String chatWithRag(@RequestBody String content) {
		try {
			if (assistant == null) {
				assistant = ragConfig.configure();
			}
			return assistant.classify("Give me type value for the following content value: " + content);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
