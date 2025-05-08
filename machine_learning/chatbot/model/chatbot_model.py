import os
from langchain_core.prompts import PromptTemplate
from langchain.chains import LLMChain
from langchain_community.llms import HuggingFaceHub
from langchain_huggingface import HuggingFaceEndpoint
from dotenv import load_dotenv
from langchain.memory import ConversationBufferMemory

# Load environment variables
load_dotenv()
HUGGINGFACEHUB_API_TOKEN = os.getenv("HUGGINGFACEHUB_API_TOKEN")
if not HUGGINGFACEHUB_API_TOKEN:
    raise EnvironmentError("HUGGINGFACEHUB_API_TOKEN is not set in environment.")

# Initialize the model
conv_model = HuggingFaceEndpoint(
    repo_id="AdaptLLM/finance-chatbot",
    temperature=0.5,
    max_new_tokens=2000
)



# Initialize template
template = "You are a helpful AI assistant at bank. You have to help users at bank to make efficient their work by completing the query provided by the user: {query}"
prompt = PromptTemplate(
    template=template,
    input_variables=["query"]  # Fixed: 'input_variables' instead of 'input_variable'
)

def get_model():
    # Initialize memory
    memory = ConversationBufferMemory(memory_key="chat_history")
    
    conv_chain = LLMChain(
        llm=conv_model,
        prompt=prompt,
        memory=memory,
        verbose=True
    )
    return conv_chain