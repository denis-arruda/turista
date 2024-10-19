# Turista 

## Overview

This project is a **Spring Boot** application integrated with **LangChain4j**. It uses the **Maven Wrapper** to simplify the build process, ensuring consistent Maven versioning across different environments. The application leverages LangChain4j to build language model applications in Java, with Spring Boot handling the backend services.

## Requirements

- **Java 22**: Ensure that Java 22 is installed.
- **Maven Wrapper**: This project comes with a Maven wrapper (`mvnw`), so you don’t need to install Maven globally.
- **Spring Boot 3+**: The project uses Spring Boot to build the web services.
- **LangChain4j**: Integrated for working with large language models (LLM).

## Features

- **LangChain4j** integration for natural language processing.
- REST APIs built with **Spring Boot** to expose LangChain capabilities.
- Ready-to-use Maven wrapper for easy build and execution.

## Configuration
* Environment variable named "OPENAI_API_KEY" with a secret API key registered in [OpenAI Platform](https://platform.openai.com/api-keys)

## Usage
* Send a POST request to http://localhost:8080/post with a string in the body and the response will determine if it a praise or a complaint.
* Send a GET request to http://localhost:8080/praises and the response will contain the main praises.
* Send a GET request to http://localhost:8080/complaints and the response will contain the main complaints.

## Reference
Project based on https://github.com/professorisidro/langchain-demo .
