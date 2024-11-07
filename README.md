<p align="center">
  <img src="https://github.com/user-attachments/assets/47053d25-6e26-4077-8375-7c321a6a39f2" alt="enigmate logo">
</p>
  <br>

Enigmate is a web application that lets users create and manage encrypted messages using custom ciphers. Users can generate unique encryption keys, share them with others, and revoke them when needed, ensuring that only intended recipients can read the messages. Without access to the correct cipher, messages remain encrypted and unreadable, providing secure communication.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Deployment](#deployment)

## Features

- **Custom Cipher Creation**: Users can create unique encryption keys.
- **Share and Revoke Keys**: Users can securely share their encryption keys with others and revoke them as needed.
- **Encrypted Messaging**: Messages are encrypted and can only be decrypted with the correct cipher.
- **User Authentication**: Secure login and user management system.
- **Message History**: View a history of sent and received messages (in encrypted form).
  
## Tech Stack

- **Backend**: Spring Boot REST API
- **Frontend**: React with Vite
- **Database**: PostgreSQL
- **Deployment**: Render

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 17 or later
- Node.js 14 or later with npm/yarn
- PostgreSQL (for local development)

## Installation

### Backend (Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/username/enigmate.git
   cd enigmate
   ```

2. Navigate to the backend directory:
   ```bash
   cd backend
   ```

3. Set up your database in `application.properties` (or `application.yml`) with the following parameters:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/enigmate
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build and start the Spring Boot application:
   ```bash
   ./mvnw spring-boot:run
   ```

### Frontend (Vite + React)

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the Vite development server:
   ```bash
   npm run dev
   ```

The frontend should now be accessible at `http://localhost:5173`.

## Running the Application

To run the application locally, start both the backend and frontend servers.

- The backend will be running on `http://localhost:8080`
- The frontend will be running on `http://localhost:5173`

Ensure the frontend is configured to communicate with the backend by updating the base URL in the frontend code if necessary.


Some key API endpoints:

- **/api/auth**: For user authentication (login, registration).
- **/api/users**: Create, delete, and manage users.
- **/api/ciphers**: Create, share, revoke ciphers.
- **/api/messages**: Send and retrieve encrypted messages.

## Usage

1. **Sign Up**: Create a new account on the Enigmate platform.
2. **Create a Cipher**: Go to the ciphers section to create your custom encryption key.
3. **Add Codebreakers**: Share the encryption key with another user, allowing them to decrypt messages you send.
4. **Send Messages**: Use your custom cipher to send encrypted messages to other users who have access to the key.
5. **Remove Codebreakers**: Remove access to the cipher key from users when no longer needed. ~~ v3

## Deployment

The application is deployed on [Render](https://render.com/). To deploy your own instance:

1. Set up PostgreSQL on Render and note the database credentials.
2. Deploy the Spring Boot API:
   - Create a new Render service and connect the repository.
   - Configure environment variables for database credentials.
3. Deploy the React frontend:
   - Create a static site on Render.
   - Set the build command to `npm run build` and the publish directory to `dist`.

---

Enjoy using **Enigmate** for secure and private messaging!
