FROM python:3.12-slim
WORKDIR /app

# Copy all required files: model, API, and optional data
COPY model/ ./model/
COPY api/ ./api/
COPY data/ ./data/

# Install dependencies
RUN pip install --upgrade pip && pip install -r api/requirements.txt

# Expose the port
EXPOSE 8001

# Run the Loan Approval API
CMD ["python", "api/ml_api.py"]
