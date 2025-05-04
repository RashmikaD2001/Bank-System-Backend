import pickle as pk
import pandas as pd
import os

base_path = os.path.dirname(__file__)
model_path = os.path.join(base_path, 'model.pkl')
scaler_path = os.path.join(base_path, 'scaler.pkl')

# Load model and scaler once
model = pk.load(open(model_path, 'rb'))
scaler = pk.load(open(scaler_path, 'rb'))

def approve_loan(raw_data: dict):
    columns = ["no_of_dependents", "education", "self_employed", "income_annum",
               "loan_amount", "loan_term", "cibil_score", "Assets"]
    
    df_input = pd.DataFrame([raw_data], columns=columns)
    scaled_input = scaler.transform(df_input)
    prediction = model.predict(scaled_input)
    return int(prediction[0])



# raw_input = [[2, 1, 0, 9600000, 29900000, 12, 778, 50700000]]

# print(approve_loan(raw_input))


    
