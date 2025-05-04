import os
from langchain_core.prompts import PromptTemplate
from langchain.chains import LLMChain
from langchain_community.llms import HuggingFaceHub
from dotenv import load_dotenv
from langchain.memory import ConversationBufferMemory

# Load environment variables
load_dotenv()
HUGGINGFACEHUB_API_TOKEN = os.getenv("HUGGINGFACEHUB_API_TOKEN")
os.environ['HUGGINGFACEHUB_API_TOKEN'] = HUGGINGFACEHUB_API_TOKEN

# Initialize the model
conv_model = HuggingFaceHub(
    repo_id="AdaptLLM/finance-LLM",
    model_kwargs={"temperature": 0.6, "max_new_tokens": 2000}
)

# Initialize memory
memory = ConversationBufferMemory()

template = "You are a helpful AI assistant at bank. You have to help users at bank to make efficient their work by completing the query provided by the user: {query}"

prompt = PromptTemplate(
    template = template,
    input_variable = ['query']
)

def model():
    
    conv_chain = LLMChain(
        llm = conv_model,
        prompt = prompt,
        memory=memory,
        verbose = True
    )

    return conv_chain
