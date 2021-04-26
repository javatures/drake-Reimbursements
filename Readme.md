# Reimbursements

A Java 8 backend web API and ES6+ HTML/JS web interface with a PostgreSQL database. Submit a README.md with a proposal that matches as many requirements as manageable below. You may use the example proposal below for reference, or as your project itself.

### Tools & APIs
- [x] Agile User Stories
- [x] Java SE 8
- [x] Gradle
- [x] JDBC
- [x] PostgreSQL
- [x] JavaEE Servlet
- [x] HTML/JS/CSS
- [x] AJAX/Fetch

### Architecture
- [x] Anemic/DDD OR n-tier package & class structure
- Design Patterns:
    - [x] Dependency Injection
    - [x] Data Access Object
- [x] SQL Normalization (3rd form)
- [x] PL/pgSQL

### Functionality
- [x] CRUD - Create, Read, Update, Delete
- [x] Web App dashboard interface
- [x] Asynchronous interface updates
- [x] Login - Authentication & Authorization
- [x] Database persistance
- [x] Session management

### Presentation
- [x] Prepare a demonstration of functionality requirements through a browser
- [x] Prepare visual aides (slides) introducing the project requirements and features

### User stories
- An Employee...
    - [x] can login
    - [x] can view the Employee Homepage
    - [x] can logout
    - [x] can submit a reimbursement request
    - [x] can upload an image of his/her receipt as part of the reimbursement request
    - [x] can view their pending reimbursement requests
    - [x] can view their resolved reimbursement requests
    - [x] can view their information
    - [x] can update their information

- A Manager...
    - [x] can login
    - [x] can view the Manager Homepage
    - [x] can logout
    - [x] can approve/deny pending reimbursement requests
    - [x] can view all pending requests from all employees
    - [x] can view images of the receipts from reimbursement requests
    - [x] can view all resolved requests from all employees and see which manager resolved it
    - [x] can view all Employees
    - [x] can view reimbursement requests from a single Employee

### Setup Instructions

- Download Gradle and Docker from their official websites.
- Clone the repository to your PC.
- In RequestServlet.java, line 26 creates a File object using a full filepath. The start of that filepath, "C:\\\\Users\\\\drake\\\\OneDrive\\\\Desktop\\\\Github", must be changed to the filepath on your PC leading to the folder where you cloned this repository.
- Open a terminal in the reimbursements folder.
- Build the docker database image using `docker build -t reimbursements lib/src/main/resources`.
- In a separate terminal, run the database using `docker run -it -v {PATH_TO_REPOSITORY}/reimbursements/pgdata:/var/lib/postgresql/data -p 5432:5432 reimbursements`.
    - NOTE: This command cannot be run in a bash terminal. It adds strange characters to the filepath which cause the volume mapping to not work. I was able to run the command correctly in a powershell terminal.
- The terminal from the previous step will be unusable while the database is running, so in a new terminal (or the one used to build the docker image), run the web server using `gradle apprun`.
- Once the server is started, the web application can be accessed at http://localhost:5656.