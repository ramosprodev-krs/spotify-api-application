<div align="center">

| &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Spotify_logo_without_text.svg/3840px-Spotify_logo_without_text.svg.png" width="180"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; | <br> <h1 align="center">spotify-api-application</h1> <br> |
| :--- | :--- |

<br>

**An efficient Spring Boot application featuring the use of Spotify Web API Java.**

</div>

---

## About the Project
This project was developed to integrate and explore the functionalities of the **Spotify API**, utilizing development best practices within the Java ecosystem.

---

### Prerequisites
Before running the application, ensure you have the following installed:
- Java JDK 17 or higher
- Maven 3.8+ (optional, as you can use the included Maven Wrapper)
- A Spotify Developer account to obtain API credentials

---
### Technologies Used
* **Language:** Java 21
* **Framework:** Spring Boot 4.0.6 (Web, DevTools)
* **API:** [Spotify Web API Java](https://github.com/thelinmichael/spotify-web-api-java)
* **Dependency Manager:** Maven
* **Productivity:** Lombok

---
### Quick guide
In order to run the application, please follow the next steps:

---
#### 1. Cloning the Repository
Open your terminal or command prompt and execute the following command:

```bash 
git clone https://github.com/ramosprodev-krs/spotify-api-application.git
```

---
#### 2. Accessing the Project Folder
After cloning, navigate into the project directory:  

```bash 
cd spotify-api-application
```

---
#### 3. Configuration (application.properties)
Now, you need to add your Spotify API credentials directly into the configuration file.  

1. Navigate to: src/main/resources/application.properties  
2. Fill in the following fields with your credentials:  

```env
spotify.client.id=YOUR_CLIENT_ID (replace with your client id)  
spotify.client.secret=YOUR_CLIENT_SECRET (replace with your client secret)  
spotify.redirect.uri=http://127.0.0.1:8080/spotify/api/callback
```

---
#### 4. Running the Application
Once the application.properties is updated, compile and run the Spring Boot application using the Maven Wrapper:  

On Linux/macOS:  
./mvnw spring-boot:run  

On Windows:
mvnw.cmd spring-boot:run  

The server will start at http://localhost:8080.  

---
#### 5. Authentication and Authorization
To interact with the Spotify API, you must first authorize the application to access your data.

1. Start Login: Open your browser and go to:
   http://localhost:8080/spotify/api/login

2. Spotify Authorization: You will be redirected to the official Spotify login page. Log in (if necessary) and click "Agree" to authorize the application.

3. Callback & Token: After clicking agree, Spotify will redirect you back to:
   http://127.0.0.1:8080/spotify/api/callback
   The application will automatically exchange the authorization code for an Access Token.

4. Success: Once you see the message "You are successfully authenticated!", the application is ready to fetch your data.

---
#### 6. Available Endpoints
After authentication, you can access the following data directly in your browser or via tools like Postman or Insomnia:

| Endpoint | Function |
| :--- | :--- |
| /spotify/api/current-user | Display the user logged in. |
| /spotify/api/my-saved-albums | List your saved albums in the library. |
| /spotify/api/my-saved-tracks | List your saved tracks in the library. |
| /spotify/api/my-top-tracks | Display your most listened tracks. |
| /spotify/api/my-top-artists | Display your most listened artists. |

##### Important Developer Notes
- Token Persistence: The Access Token is stored in memory. If you restart the Spring Boot application, you must go through the /login flow again.
- Redirect URI: Ensure that the 'spotify.redirect.uri' in your application.properties exactly matches the one registered in your Spotify Developer Dashboard (e.g., check for 127.0.0.1 vs localhost).
- Data Format: All endpoints (except login/callback) return data in JSON format using optimized DTOs.

---
## Contact me!
If you found this project helpful, please consider giving it a ⭐ to support its development!

### Here are a few ways to contact me:  
- <img width="20" height="20" alt="image" src="https://cdn-icons-png.flaticon.com/512/25/25231.png"> [More of my projects](https://github.com/ramosprodev-krs)
- <img width="20" height="20" alt="image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/LinkedIn_icon.svg/120px-LinkedIn_icon.svg.png?_=20210220164014"> [My LinkedIn profile](www.linkedin.com/in/ramosprodev)
- <img width="20" height="20" alt="image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Gmail_icon_%282020%29.svg/330px-Gmail_icon_%282020%29.svg.png"> [My G-mail](ramosprodev@gmail.com)   

### Thank you!

---

