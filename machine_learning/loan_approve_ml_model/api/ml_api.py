from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from model.ml_model import approve_loan

app = FastAPI()

class LoanInput(BaseModel):
    no_of_dependents: int
    education: int
    self_employed: int
    income_annum: float
    loan_amount: float
    loan_term: float
    cibil_score: float
    Assets: float

@app.post("/predict")
def predict_loan(data: LoanInput):
    try:
        result = approve_loan(data.dict())
        return {"prediction": result, "status": "success"}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@app.get("/health")
def health_check():
    return {"status": "healthy"}

# Add this to make the script runnable directly
if __name__ == "__main__":
    import uvicorn
    uvicorn.run("ml_api:app", host="0.0.0.0", port=8001, reload=True)