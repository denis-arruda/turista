package com.github.denisarruda.turista.ai;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

@Component
public class ChatModelBuilder {

	@Value("${OPENAI_API_KEY}")
	private String apiKey;

	public SentimentAnalyzer buildSentimentAnalyzer() {
		return AiServices.builder(SentimentAnalyzer.class).chatLanguageModel(OpenAiChatModel.withApiKey(apiKey)).build();
	}
	
	public Assistant buildAssistant() {
		// começamos recuperando os documentos da pasta
		List<Document> docs = FileSystemDocumentLoader.loadDocuments(DocUtil.toPath("documents/"),
				DocUtil.glob("*.txt"));
		// usamos o AIServices para criar a instancia do Assistant
		Assistant assistant = AiServices.builder(Assistant.class).chatLanguageModel(OpenAiChatModel.withApiKey(apiKey))
				.chatMemory(MessageWindowChatMemory.withMaxMessages(10)).contentRetriever(createContentRetriever(docs))
				.build();
		return assistant;
	}

	private ContentRetriever createContentRetriever(List<Document> documents) {
		// Paso 1 Aqui criamos uma estrutura em memoria
		// para armazenar os Embeddings
		InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
		// Aqui fazemos a "ingestao" dos documentos.
		// Neste metodo ingest que ocorre a conversao dos tokens
		// em distancias semanticas
		EmbeddingStoreIngestor.ingest(documents, embeddingStore);
		// aqui criamos nosso mecanismo de recuperacao a
		// partir do componente de armazenamento.
		return EmbeddingStoreContentRetriever.from(embeddingStore);
	}
}