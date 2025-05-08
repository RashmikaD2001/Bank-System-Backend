from model.chatbot_model import model
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
import uvicorn
import logging
import requests

# Set up logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


app = FastAPI(
    title="Chatbot API",
    description="API for interacting with a chatbot model",
    version="1.0.0"
)


# Initialize your model
try:
    model = model() 
    logger.info("Model loaded successfully")
except Exception as e:
    logger.error(f"Failed to load model: {str(e)}")
    raise


# Define the request model
class ChatRequest(BaseModel):
    user_input: str
    conversation_id: str = None  # Optional, to maintain conversation context


# Define the response model
class ChatResponse(BaseModel):
    response: str
    conversation_id: str = None
    confidence: float = None  # Optional, if your model provides confidence scores


@app.post("/chat", response_model=ChatResponse)
async def chat_endpoint(request: ChatRequest):
    try:
        # Process the user input with your model
        response = model.run(request.user_input)
        
        # Create response object
        chat_response = ChatResponse(
            response=response,
            conversation_id=request.conversation_id
        )
        
        return chat_response
    
    except Exception as e:
        logger.error(f"Error processing request: {str(e)}")
        raise HTTPException(status_code=500, detail=f"Error processing chat request: {str(e)}")


@app.get("/health")
async def health_check():
    return {"status": "healthy", "model_loaded": model is not None}

# Main entry point to run the app directly
if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)
