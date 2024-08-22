# To-Do App Backend

This is the backend for the To-Do App, built using Spring Boot. The application manages tasks with functionalities such as creating, reading, updating, and deleting tasks. The backend interacts with a MySQL database to persist task data.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

## Features
- Create a new task
- Read all tasks
- Update an existing task
- Delete a task
- MySQL database integration
- Error handling

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
- Java 17 or later
- Maven 3.6+
- MySQL 8.0+
- Postman or any API testing tool (optional)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/todo-app-backend.git
   cd todo-app-backend

## API Documentation

This section provides details about the API endpoints available in the To-Do App backend.

### 1. Get All Tasks

- **Endpoint:** `GET /tasks`
- **Description:** Retrieves a list of all tasks.
- **Request:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/tasks`
- **Response:**
  - **Status Code:** 200 OK
  - **Content-Type:** application/json
  - **Body:**
    ```json
    [
      {
        "id": 1,
        "title": "Update website content",
        "description": "Revise the homepage content and update the blog section with recent posts."
      },
      {
        "id": 2,
        "title": "Prepare for meeting",
        "description": "Compile reports and create presentation slides."
      }
      // More tasks...
    ]
    ```

### 2. Create a New Task

- **Endpoint:** `POST /tasks`
- **Description:** Creates a new task.
- **Request:**
  - **Method:** POST
  - **URL:** `http://localhost:8080/tasks`
  - **Headers:**
    - `Content-Type: application/json`
  - **Body:**
    ```json
    {
      "title": "Complete documentation",
      "description": "Finish writing the API documentation."
    }
    ```
- **Response:**
  - **Status Code:** 201 Created
  - **Content-Type:** application/json
  - **Body:**
    ```json
    {
      "id": 3,
      "title": "Complete documentation",
      "description": "Finish writing the API documentation."
    }
    ```

### 3. Get Task by ID

- **Endpoint:** `GET /tasks/{id}`
- **Description:** Retrieves a specific task by ID.
- **Request:**
  - **Method:** GET
  - **URL:** `http://localhost:8080/tasks/{id}`
  - **URL Parameters:**
    - `id` (integer) - The ID of the task to retrieve.
- **Response:**
  - **Status Code:** 200 OK
  - **Content-Type:** application/json
  - **Body:**
    ```json
    {
      "id": 1,
      "title": "Update website content",
      "description": "Revise the homepage content and update the blog section with recent posts."
    }
    ```
  - **Error Response:**
    - **Status Code:** 404 Not Found
    - **Body:**
      ```json
      {
        "timestamp": "2024-08-20T10:51:22.759+00:00",
        "status": 404,
        "error": "Not Found",
        "message": "Task with ID 100 not found.",
        "path": "/tasks/100"
      }
      ```

### 4. Update a Task

- **Endpoint:** `PUT /tasks/{id}`
- **Description:** Updates an existing task by ID.
- **Request:**
  - **Method:** PUT
  - **URL:** `http://localhost:8080/tasks/{id}`
  - **Headers:**
    - `Content-Type: application/json`
  - **URL Parameters:**
    - `id` (integer) - The ID of the task to update.
  - **Body:**
    ```json
    {
      "title": "Update website content",
      "description": "Revise the homepage content and update the blog section with recent posts."
    }
    ```
- **Response:**
  - **Status Code:** 200 OK
  - **Content-Type:** application/json
  - **Body:**
    ```json
    {
      "id": 1,
      "title": "Update website content",
      "description": "Revise the homepage content and update the blog section with recent posts."
    }
    ```
  - **Error Response:**
    - **Status Code:** 404 Not Found
    - **Body:**
      ```json
      {
        "timestamp": "2024-08-20T10:51:22.759+00:00",
        "status": 404,
        "error": "Not Found",
        "message": "Task with ID 100 not found.",
        "path": "/tasks/100"
      }
      ```

### 5. Delete a Task

- **Endpoint:** `DELETE /tasks/{id}`
- **Description:** Deletes a specific task by ID.
- **Request:**
  - **Method:** DELETE
  - **URL:** `http://localhost:8080/tasks/{id}`
  - **URL Parameters:**
    - `id` (integer) - The ID of the task to delete.
- **Response:**
  - **Status Code:** 204 No Content
- **Error Response:**
  - **Status Code:** 404 Not Found
  - **Body:**
    ```json
    {
      "timestamp": "2024-08-20T10:51:22.759+00:00",
      "status": 404,
      "error": "Not Found",
      "message": "Task with ID 100 not found.",
      "path": "/tasks/100"
    }
    ```

## Error Handling

The application uses standard HTTP status codes to indicate the success or failure of API requests. Error responses are returned in JSON format with details about the error.

### Example Error Response

```json
{
    "timestamp": "2024-08-20T10:51:22.759+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "An unexpected error occurred.",
    "path": "/tasks/90"
}

