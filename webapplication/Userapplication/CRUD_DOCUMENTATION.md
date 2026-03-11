# User Management CRUD System - Complete Documentation

## Overview
This is a complete CRUD (Create, Read, Update, Delete) web application built with Java Servlets and JSP. The system manages user records with a professional navbar interface.

## Project Structure

```
Userapplication/
├── src/main/
│   ├── java/com/coforge/
│   │   ├── User.java                 (User model class)
│   │   ├── Userdb.java               (Database utility class)
│   │   ├── UserListServlet.java       (Read operation)
│   │   ├── AddUserServlet.java        (Create operation)
│   │   ├── EditUserServlet.java       (Update operation)
│   │   ├── DeleteUserServlet.java     (Delete operation)
│   │   ├── LogoutServlet.java         (Logout handler)
│   │   ├── loginservlet.java          (Login handler - updated)
│   │   └── Signupservlet.java         (User registration)
│   │
│   └── webapp/
│       ├── welcome.jsp                (Dashboard with navbar)
│       ├── userList.jsp               (Read all users)
│       ├── addUser.jsp                (Create user form)
│       ├── editUser.jsp               (Update user form)
│       ├── deleteUser.jsp             (Delete confirmation)
│       ├── login.jsp                  (Login page)
│       └── WEB-INF/
│           └── web.xml                (Servler routing)
```

## Core Components

### 1. User.java (Model Class)
- Represents a user with properties: username, fullName, email, password
- Includes getters and setters for all properties
- Provides toString() method for user display

### 2. Userdb.java (Database Layer)
- In-memory data storage using ConcurrentHashMap
- Provides CRUD operations:
  - **Create**: `addUser(username, fullName, email, password)` - Adds new user
  - **Read**: `getAllUsers()` - Gets all users
  - **Read**: `getUserByUsername(username)` - Gets specific user
  - **Update**: `updateUser(username, fullName, email, password)` - Updates user
  - **Delete**: `deleteUser(username)` - Removes user
- Helper methods:
  - `userExists(username)` - Checks if user exists
  - `authenticate(username, password)` - Validates login credentials

### 3. Servlets (Request Handlers)

#### LogoutServlet.java
- **URL Mapping**: `/logout`
- **Methods**: POST, GET
- **Function**: Invalidates user session and redirects to login page

#### UserListServlet.java
- **URL Mapping**: `/userList`
- **Methods**: GET
- **Function**: Fetches all users from database and forwards to userList.jsp
- **Security**: Requires active session

#### AddUserServlet.java
- **URL Mapping**: `/addUser`
- **Methods**: GET, POST
- **GET**: Displays add user form
- **POST**: Processes new user creation with validation
- **Validation**: Checks for duplicate username and required fields
- **Security**: Requires active session

#### EditUserServlet.java
- **URL Mapping**: `/editUser`
- **Methods**: GET, POST
- **GET**: Displays edit form with current user data
- **POST**: Updates user information with validation
- **Parameters**: username (required)
- **Security**: Requires active session

#### DeleteUserServlet.java
- **URL Mapping**: `/deleteUser`
- **Methods**: GET, POST
- **GET**: Displays delete confirmation page
- **POST**: Removes user after confirmation
- **Parameters**: username, confirm="yes"
- **Security**: Requires confirmation flag and active session

### 4. JSP Pages (User Interface)

#### welcome.jsp (Dashboard)
- **Features**:
  - Professional styled navbar with gradient background
  - Quick navigation links (View Users, Add User, Logout)
  - Displays current logged-in user
  - Welcome message and feature overview
  - CRUD operations introduction
- **Security**: Redirects unauthenticated users to login

#### userList.jsp (Read Operation)
- **Features**:
  - Displays all users in a professional table
  - Edit button for each user
  - Delete button for each user
  - Responsive design
  - Empty state message if no users exist
- **Table Columns**: Username, Full Name, Email, Actions

#### addUser.jsp (Create Operation)
- **Features**:
  - Form to add new user
  - Form fields: Username, Full Name, Email, Password
  - Real-time validation feedback
  - Submit and Cancel buttons
  - Error handling for duplicate usernames
- **Validation**: All fields required

#### editUser.jsp (Update Operation)
- **Features**:
  - Pre-populated form with current user data
  - Username field is read-only
  - Optional password field (leave blank to keep current)
  - Edit and Cancel buttons
  - Shows which user is being edited
- **Validation**: Name and Email required

#### deleteUser.jsp (Delete Operation)
- **Features**:
  - Shows user details for confirmation
  - Warning message about permanent deletion
  - Confirmation checkbox (must be checked)
  - Delete button disabled until checkbox is confirmed
  - JavaScript validation
- **Safety Features**: Double confirmation prevents accidental deletion

#### login.jsp & signup.jsp
- User authentication pages
- Already present in your project

## CRUD Operations Summary

### CREATE (Add User)
1. User clicks "Add User" button in navbar
2. Form displayed with fields: Username, Full Name, Email, Password
3. AddUserServlet validates input
4. User added to database if username doesn't exist
5. Redirects to user list on success

### READ (View Users)
1. User clicks "View Users" button in navbar
2. UserListServlet retrieves all users from database
3. userList.jsp displays users in a table
4. Each user shows: Username, Full Name, Email, Action buttons

### UPDATE (Edit User)
1. User clicks Edit button next to any user
2. EditUserServlet retrieves user data and displays form
3. User modifies Full Name, Email, or Password
4. Form submitted to EditUserServlet
5. Database updated and user returned to list

### DELETE (Remove User)
1. User clicks Delete button next to any user
2. DeleteUserServlet shows confirmation page with user details
3. User must check confirmation checkbox
4. Upon confirmation, DeleteUserServlet removes user from database
5. Redirects to user list

## Security Features

1. **Session Authentication**: All pages except login/signup require valid session
2. **Authorization Checks**: Servlets verify user is logged in before processing
3. **Input Validation**: Forms validate required fields and data types
4. **Duplicate Prevention**: Username uniqueness checked during user creation
5. **Confirmation for Deletion**: Extra confirmation step prevents accidental deletion
6. **Password Protection**: Passwords stored in User objects (in production, should be hashed)
7. **Logout Functionality**: Clears session on logout

## Styling Features

- **Gradient Purple Theme**: Professional appearance with purple gradients
- **Sticky Navbar**: Navigation always accessible while scrolling
- **Responsive Design**: Works on desktop and mobile devices
- **Color-Coded Buttons**: 
  - Blue for View/Home
  - Green for Add
  - Red for Delete/Logout
  - Gray for Cancel
- **Hover Effects**: Buttons have smooth transitions and shadows
- **Error/Success Messages**: Color-coded feedback to users
- **Icons**: Emojis for quick visual identification

## URL Mapping

| Servlet/Page | URL | Method | Purpose |
|---|---|---|---|
| loginservlet | /login | POST | Authenticate user |
| LogoutServlet | /logout | POST/GET | End session |
| UserListServlet | /userList | GET | Display all users |
| AddUserServlet | /addUser | GET/POST | Add new user |
| EditUserServlet | /editUser | GET/POST | Modify user |
| DeleteUserServlet | /deleteUser | GET/POST | Remove user |
| welcome.jsp | /welcome.jsp | GET | Dashboard |

## How to Test

1. **Login**: Use default credentials: admin/admin123 or john/john123 or jane/jane123
2. **View Users**: Click "View Users" to see all users in the system
3. **Add User**: Enter new user details and submit
4. **Edit User**: Click "Edit" next to any user and modify details
5. **Delete User**: Click "Delete", confirm, and user is removed
6. **Logout**: Click "Logout" to end session

## Demo Users (Pre-populated)

- **Username**: admin, **Password**: admin123, **Email**: admin@example.com
- **Username**: john, **Password**: john123, **Email**: john@example.com
- **Username**: jane, **Password**: jane123, **Email**: jane@example.com

## Production Deployment Considerations

1. **Database**: Replace in-memory map with actual database (MySQL, PostgreSQL, etc.)
2. **Password Hashing**: Use BCrypt or similar library for password security
3. **SQL Injection Prevention**: Use prepared statements if implementing database
4. **HTTPS**: Ensure all communications are encrypted
5. **Input Sanitization**: Validate and sanitize all user inputs
6. **Error Handling**: Implement comprehensive error logging
7. **Session Management**: Configure session timeout and security properties

## Dependencies Required

- Jakarta Servlet API 6.1.0 (Already in pom.xml)
- Java 8 or higher

## Notes

- The system uses an in-memory ConcurrentHashMap for data storage
- All data is lost when the application restarts
- No database persistence in the current version
- Users must be logged in to access any CRUD operations
- Usernames must be unique
