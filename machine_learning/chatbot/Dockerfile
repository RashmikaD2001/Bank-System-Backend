FROM python:3.12-slim
WORKDIR /app

# Accept API token as build arg and set env variable
ARG HUGGINGFACEHUB_API_TOKEN
ENV HUGGINGFACEHUB_API_TOKEN=${HUGGINGFACEHUB_API_TOKEN}

# Copy chatbot model and API code
COPY model/ ./model/
COPY api/ ./api/

# Install dependencies
RUN pip install --upgrade pip && pip install -r api/requirement.txt

# Expose the port your API runs on (assuming 8000)
EXPOSE 8000

# Run the API server
CMD ["python", "api/chatbot_api.py"]