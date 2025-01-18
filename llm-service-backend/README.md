# LLM Service - Demonstration of Enterprise Technology

The LLM service is responsible for providing asynchronous content generation capabilities. Primarily, it will be used 
to summarize content. Since language models are relatively expensive to operate, this system will interact using
asynchronous channels only. It will respond to events requesting summarization on an inbound message channel, and 
it will send results through an outbound message channel. This enables the service to slowly process large amounts of 
data without slowing down other systems which must operate more quickly. 
