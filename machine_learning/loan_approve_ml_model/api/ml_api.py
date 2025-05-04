from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from ..model.ml_model import approve_loan

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
        return {"prediction": result}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
