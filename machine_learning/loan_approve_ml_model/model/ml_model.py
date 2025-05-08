import pickle as pk
import pandas as pd
import os

base_path = os.path.dirname(__file__)
model_path = os.path.join(base_path, 'model.pkl')
scaler_path = os.path.join(base_path, 'scaler.pkl')

# Load model and scaler once
try:
    model = pk.load(open(model_path, 'rb'))
    scaler = pk.load(open(scaler_path, 'rb'))
except FileNotFoundError as e:
    print(f"Error loading model or scaler: {e}")
    print(f"Looking for files at: {model_path} and {scaler_path}")
    raise

def approve_loan(raw_data: dict):
    columns = ["no_of_dependents", "education", "self_employed", "income_annum",
               "loan_amount", "loan_term", "cibil_score", "Assets"]
    
    df_input = pd.DataFrame([raw_data], columns=columns)
    scaled_input = scaler.transform(df_input)
    prediction = model.predict(scaled_input)
    return int(prediction[0])

# For testing
if __name__ == "__main__":
    raw_input = {
        "no_of_dependents": 2,
        "education": 1,
        "self_employed": 0,
        "income_annum": 9600000,
        "loan_amount": 29900000,
        "loan_term": 12,
        "cibil_score": 778,
        "Assets": 50700000
    }
    print(approve_loan(raw_input))