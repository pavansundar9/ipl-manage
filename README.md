# IPL Management Application

This application is designed to manage various aspects of the Indian Premier League (IPL), including teams, players, and organizers. It consists of a front-end Angular application and a back-end Spring Boot application, which work together to provide a comprehensive IPL management system.

## Features

- **User Interface**: Responsive and interactive user interface for managing IPL data.
- **Routing**: Navigation between different views or pages within the application.
- **HTTP Requests**: Communication with the back-end Spring Boot application to fetch or send IPL-related data.
- **Form Handling**: Managing user input through forms and validating the input.
- **State Management**: Managing the state of the application.
- **RESTful APIs**: Providing endpoints for interacting with IPL data.
- **Business Logic**: Implementing the core business logic of the IPL management system.
- **Data Persistence**: Managing data storage and retrieval in a MySQL database named `ipl`.
- **Security**: Handling authentication and authorization to secure the application.

## Technologies Used

- **Front-end**: Angular
- **Back-end**: Spring Boot
- **Database**: MySQL

## Prerequisites

- Node.js and npm
- Angular CLI
- Java Development Kit (JDK)
- Maven
- MySQL

## Getting Started

### Setting Up the Database

1. Install MySQL and create a database named `ipl`.
2. Update the database configuration in the `springapp/src/main/resources/application.properties` file:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ipl
   spring.datasource.username=root
   spring.datasource.password=root
   ```

### Running the Spring Boot Application

1. Navigate to the `springapp` directory:

   ```sh
   cd springapp
   ```

2. Build the application using Maven:

   ```sh
   mvn clean install
   ```

3. Run the application:

   ```sh
   mvn spring-boot:run
   ```

### Running the Angular Application

1. Navigate to the `angularapp` directory:

   ```sh
   cd angularapp
   ```

2. Install the dependencies:

   ```sh
   npm install
   ```

3. Run the application:

   ```sh
   ng serve
   ```

4. Open your browser and navigate to `http://localhost:4200`.

## API Endpoints

The Spring Boot application provides several API endpoints for managing IPL data. Some of the key endpoints include:

- `/api/team`: Manage teams
- `/api/player`: Manage players
- `/api/organizer/assign-player`: Assign players to teams
- `/api/organizer/unsold-players`: List unsold players
- `/api/organizer/sold-players`: List sold players
- `/api/organizer/release-player`: Release players from teams
- `/api/user/register`: User registration
- `/api/user/login`: User login

## Security

The application uses JWT for authentication and authorization. The security configuration is defined in the `SecurityConfig` class in the Spring Boot application.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License.

## Contact

For any questions or inquiries, please contact [your-email@example.com].
