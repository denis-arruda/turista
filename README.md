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

## OpenAI API Configuration

This project integrates with OpenAI's API through LangChain4j. To use OpenAI's services, you must:

1. **Register for an API key** at [OpenAI's website](https://platform.openai.com/signup/).
2. Once you have your API key, you need to set it as an environment variable.

### Setting the API Key

For the application to connect to the OpenAI API, you must configure your environment with the following variable:

- **Environment Variable Name**: `OPENAI_API_KEY`
  
### Example Setup

On Unix/macOS:
```bash
export OPENAI_API_KEY=your_openai_api_key
```

## Usage
* Send a POST request to http://localhost:8080/post with a string in the body and the response will determine if it a praise or a complaint.
* Send a GET request to http://localhost:8080/praises and the response will contain the main praises.
* Send a GET request to http://localhost:8080/complaints and the response will contain the main complaints.

## Reference
Project based on https://github.com/professorisidro/langchain-demo .
