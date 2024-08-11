# Student Database

This is a simple student database that provides basic CRUD (Create, Read, Update, Delete) operations. It allows you to manage student records by performing GET, POST, PUT, and DELETE requests.


## Usage

### GET /api/v1/students

Retrieves a list of all students in the database.

### POST /api/v1/students/register

Adds a new student to the database. Provide the student details in the request body.

### PUT /api/v1/students/update/{studentId}

Updates the details of a specific student. Provide the student ID in the URL and the updated details in the request body.

### DELETE /api/v1/students/{studentId}

Deletes a specific student from the database. Provide the student ID in the URL.



