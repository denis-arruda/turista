# Turista

# Project using Spring + [LangChain](https://www.langchain.com/) + OpenAI

## Requirements
* Java 22

## Configuration
* Environment variable named "OPENAI_API_KEY" with a secret API key registered in [OpenAI Platform](https://platform.openai.com/api-keys)

## Usage
* Send a POST request to http://localhost:8080/post with a string in the body and the response will determine if it a praise or a complaint.
* Send a GET request to http://localhost:8080/praises and the response will contain the main praises.
* Send a GET request to http://localhost:8080/complaints and the response will contain the main complaints.

## Reference
Project based on https://github.com/professorisidro/langchain-demo .
