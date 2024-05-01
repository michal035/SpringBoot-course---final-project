# URL Shortener Service

## Overview
Url shortener, made for my Spring Boot univeristy backend course. Could be self-hosted for homeLab kind of enviroment. 

## Features
- URL shortening: Converts long URLs into short, manageable links
- While logged-in url are associated with a user, which then can be manged  by the user
- Self-hosting: Can be easily deployed on any server using Docker.

## Getting Started
1. Clone the repository:


```
git clone https://github.com/your-username/url-shortener.git
cd url-shortener
```

2. Customize `application.properties`:
- Modify the properties 
- save it in `project/src/main/resources/`

3. Build and build Docker-compose:

```
docker-compose build
docker-compose up
```

4. Access the application:
Open your web browser and navigate to `http://localhost:8080`.


## Contributing
Contributions are welcome! Feel free to open issues or submit pull requests.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
