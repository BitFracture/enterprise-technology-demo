# A Demonstration of Enterprise Technology
This project provides a demonstration of some familiar enterprise technology where my applicable industry experience is hidden due to intellectual property rights. The work shown in this group of projects is a greatly simplified application of the technology used by my industry experience. The design choices made within these projects will make more sense with the added context provided by this document.

# Project Context

This section will be amended as this project progresses to give context to what is being built and why. 

## Core Tenets

In order for this project to be successful, the following tenets have been outlined from the start, and will be amended only when necessary. 

This project will...
1. **Demonstrate a modern Spring Boot web service.** Spring Boot is a critcal component of my industry experience and will act as the glue for this project. 
2. **Feature an HTTP API.** These are a popular way to integrate and decouple components and are an important part of most industry projects at scale.
3. **Demonstrate asynchronus communication.** Async APIs are crucial to modern scalable systems to ensure reliable operation and to decouple responsibilities.
4. **Feature a persistence layer.** This system will operate against persisted data like with any industry standard service. 
5. **Feature at least one integration with another service, system, or library.** Integrations are everything in the industry. They are how we move quickly and build on the hard work of others. 
6. **Be entirely runnable on a local machine.** While in the industry, this system would be depoyable to a compute cloud (AWS, Azure, GCP, etc.) using multiple cloud components (containers, queues, load balancers, persistence resources) this demo intentionally removes that layer of complexity in order to remove barriers for easy access of this project by anyone.

## Capabilities

The capabilities of this project will be expanded upon through several implementation phases.

### Phase 1

A basic summarization API with an LLM integration.

 - Runnable Spring application (web service)
 - API exists to accept text content
 - Web service integrates with an LLM to summarize the text
 - Text summary is returned to the API caller

### Phase 2

Containerization followed by persistence and retrieval of documents via API.

 - Existing web service is containerized and launches to a container host
 - A containerized database is added to the container network
 - The web service communicates with the containerized database
 - Summarized documents, their original content, and status are stored, retrievable, and can be enumerated via API

### Phase 3

To be detailed later



