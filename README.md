
# TodoManager

TodoManager is a Java-based web application built using Spring Boot. It helps users manage to-do tasks efficiently and supports image uploads for enhanced task management. The project leverages Spring jdbc Template for robust database operations and provides a web interface for easy interaction.

## Features

- **Task Management:** Add, update, delete, and view to-do tasks.
- **Spring Boot Web:** Modern, RESTful web interface for managing tasks.
- **Spring Boot jdbc** Database integration for persistent storage of tasks.
- **File Upload:** Upload files (e.g., images).

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/hpradeep26/TodoManager.git
   cd TodoManager
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   Open your browser and go to [http://localhost:8080](http://localhost:8080)

### File Upload Configuration

- Files uploaded through the web interface are saved to a configurable directory (set in `application.properties`).
- Make sure the upload directory exists and is writable by the application.

## Usage

- **Add a Task:** Use the web form to enter task details and optionally upload a file.
- **View Tasks:** See a list of all tasks, with options to filter or search.
- **Edit/Delete Tasks:** Update task details or remove tasks as needed.
- **Download Attachments:** Download files attached to tasks directly from the web UI.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/YourFeature`)
5. Open a pull request

## License

This project is licensed under the MIT License.

---
