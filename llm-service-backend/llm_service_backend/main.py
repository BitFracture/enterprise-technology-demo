# Temporary main entry point for LLM project

from llm_service_backend import language_model


def main():
    print('Hello Mundo!')

    model = language_model.LanguageModel()
    with open("tempfile", "r") as file:
        text = file.read()
    print('LLM summary response: {}'.format(model.summarize_text(text, 4, 255)))


if __name__ == '__main__':
    main()
