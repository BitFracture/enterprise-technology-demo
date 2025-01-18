#
# Initializes and abstracts a language model for use by other systems.
# Current model is the 1 billion variant of Meta LLaMA 3.2 via Ollama Service.
#

import ollama
from ollama import Message


class LanguageModel:
    model_name = 'llama3.2:1b'

    def __init__(self):
        print('Connecting to OLlama service and fetching the language model. This may take a while...')
        connection = ollama.pull(self.model_name)

        if connection.status == 'success':
            self.is_model_loaded = True
            print('Model loaded successfully')
        else:
            self.is_model_loaded = False
            print('Model failed to load. Service will be unavailable')


    def summarize_text(self, initial_text: str, sentence_length: int, char_length: int) -> str:
        if not self.is_model_loaded:
            raise Exception('Unable to summarize as model is not loaded!')

        prompt = Message(role='system', content='Your goal is to summarize the text in less than 5 sentences. '
                + 'Do not respond with anything besides the summary itself. Identify any critical agreements, '
                + 'decisions, or topics from the text.')
        message = Message(role='user', content=initial_text)
        response = ollama.chat(self.model_name, messages = [prompt, message])

        return response.message.content


    def inquire(self, question: str, context: str) -> str:
        if not self.is_model_loaded:
            raise Exception('Unable to inquire as model is not loaded!')

        message = Message(role='user', content='Answer "{}" in two sentences or less given the following context: {}'
                .format(question, context))
        response = ollama.chat(self.model_name, messages = [message])

        return response.message.content
