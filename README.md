<a name="readme-top"></a>

<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=43&pause=1000&color=D3D302&random=false&width=680&height=60&lines=API+REST+-+Bodega+BoraBora;APP+M%C3%B3vil+-+Kotlin" alt="Typing SVG" /></a>

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.8.6-red)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.1.0-green)
![JWT](https://img.shields.io/badge/JWT-4.2.1-yellow)
![Flyway Core](https://img.shields.io/badge/Flyway%20Core-9.16.3-blue)
![MySQL Connector](https://img.shields.io/badge/MySQL%20Connector-8.0.33-red)
![Lombok](https://img.shields.io/badge/Lombok-1.18.26-blue)

<br>

## 📌 Repositorios relacionados
Este proyecto consta de dos partes principales:
1. [API-REST-BoraBora-Kotlin](https://github.com/CarlosAcosta4/apirest-borabora-android-kotlin): Este es el repositorio de la API REST que proporciona los servicios backend para las aplicaciones.
2. [AppBoraBora-Kotlin](https://github.com/brigittev0/AppBoraMovil): Este es el repositorio de la aplicación móvil que consume los servicios proporcionados por la API REST.

Para más información, por favor visita cada uno de los repositorios mencionados.

<br>

## 💻 Requerimientos
| Requerimientos | Versión |
|-----------|---------|
| IDE Compatible | Spring Tool Suite, IntelliJ IDEA, Eclipse, entre otros |
| Java      | 17      |
| Maven     | 3.8.6   |
| MySQL     | 8.0     |

<br>

## 🚀 Pasos para la Ejecución
1. Clona el repositorio del proyecto:
```bash 
https://github.com/CarlosAcosta4/apirest-borabora-android-kotlin.git
```
2. Abre tu IDE (por ejemplo, Spring Tool Suite o IntelliJ IDEA) y navega hasta la carpeta del proyecto que has clonado.
3. Abre el archivo `application.properties` y realiza las siguientes acciones:
+ Verifica que el puerto especificado (por ejemplo, 8070) no esté siendo utilizado por otra aplicación. Puedes hacerlo ejecutando el siguiente comando en la terminal:
```bash
netstat -ano | findstr :8070
```
Si no ves ninguna salida después de ejecutar el comando, entonces el puerto 8070 está libre.
Si el puerto está siendo utilizado, cambia el número de puerto en el archivo `application.properties` a uno que esté libre.
```bash
server.port=tu_puerto_libre
```
+ Actualiza las siguientes líneas con tus credenciales de MySQL:
```java
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
4. Busca el archivo principal de la aplicación (por lo general, un archivo con el nombre Application.java o similar) y ejecútalo como una aplicación Spring Boot.
5. El proyecto debería comenzar a ejecutarse en el puerto especificado (8070 en este caso).

<br>

## ❗ Detalles Importantes del Proyecto
- **Algoritmo de Encriptación del Token**: Este proyecto utiliza el algoritmo HS256 para la encriptación del token. Es importante tener en cuenta esto al trabajar con la autenticación y la seguridad del proyecto.
- **Duración del Token**: El token generado tiene una duración de 30 minutos. Después de este tiempo, se requerirá un nuevo token para las solicitudes autenticadas.

<br>

<div align="center">
  
## 🔹 Arquitectura del Proyecto Bodega BoraBora
![Arquitectura](./src/main/img/Arquitectura.png)

<br>

## 🔸 Diagrama de Flujo de Autenticación y Autorización JWT con Spring Security
![DiagramaSecurityJWT](./src/main/img/DiagramaSecurityJWT.png)

<br>

## 🔹 Diagrama Conceptual de la Base de Datos
![Conceptual](./src/main/img/Conceptual.png)

<br>

## 🔸 Diagrama Físico de la Base de Datos
![Fisico](./src/main/img/Fisico.png)
</div>

<br>

## 💻 Autores
<a href="https://github.com/CarlosAcosta4/apirest-borabora-android-kotlin/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=CarlosAcosta4/apirest-borabora-android-kotlin" />
</a>

<p align="right">(<a href="#readme-top">volver arriba</a>)</p>


