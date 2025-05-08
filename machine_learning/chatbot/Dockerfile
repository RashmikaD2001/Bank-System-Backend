FROM python:3.12-slim
WORKDIR /app

ENV PYTHONPATH=/app

# Copy app files
COPY model/ ./model/
COPY api/ ./api/
COPY api/requirements.txt .

# Install dependencies
RUN pip install --no-cache-dir -r requirements.txt

# Expose port
EXPOSE 8000

# Start the API
CMD ["python", "api/chatbot_api.py"]
