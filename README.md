<a name="readme-top"></a>

<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=43&pause=1000&color=D3D302&random=false&width=680&height=60&lines=API+REST+-+Bodega+BoraBora;APP+M%C3%B3vil+-+Kotlin" alt="Typing SVG" /></a>


![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.0-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![JDK](https://img.shields.io/badge/JDK-17-orange)
![Maven](https://img.shields.io/badge/Maven-3.8.6-red)
![java-jwt](https://img.shields.io/badge/java--jwt-4.2.1-green)

<br>

## 📌 Repositorios relacionados

[API-REST-BoraBora-Kotlin](https://github.com/CarlosAcosta4/apirest-borabora-android-kotlin) &nbsp;| &nbsp; [AppBoraBora-Kotlin](https://github.com/brigittev0/AppBoraMovil) &nbsp;| &nbsp; [Scripts SQL-API](https://github.com/CarlosAcosta4/resources-apis-borabora) &nbsp;

Por favor, consulta los repositorios correspondientes para obtener sus instrucciones.

<br>

## 📑 Pre-requisitos

Antes de ejecutar este proyecto, debes asegurarte de que:

1. Tienes instalado Maven en tu sistema. Puedes verificarlo ejecutando `mvn -v` en la terminal.
2. Tienes instalado Spring Tool Suite (STS) u otro IDE compatible con proyectos Maven.
3. Tienes instalado MySQL y está corriendo en tu sistema.
4. No tienes una base de datos con el nombre especificado en el archivo `application.properties` (`bd_borabora` en este caso).
5. El puerto especificado en el archivo `application.properties` (`8070` en este caso) no está siendo utilizado por otra aplicación.
6. Los valores de `username` y `password` en el archivo `application.properties` coinciden con tus credenciales de MySQL.

<br>

## 🔢 Ejecución

Para ejecutar este proyecto en Spring Tool Suite (STS), sigue estos pasos:

1. Importa el proyecto en STS: File -> Import -> Maven -> Existing Maven Projects.
2. Navega y selecciona el directorio del proyecto.
3. Haz clic en Finish para importar el proyecto.
4. Una vez importado, haz clic derecho en el proyecto en el explorador de proyectos.
5. Selecciona Run As -> Spring Boot App.
6. El proyecto debería comenzar a ejecutarse en el puerto especificado (8070 en este caso).

<br>

## ❗ Detalles Importantes del Proyecto
- **Algoritmo de Encriptación del Token**: Este proyecto utiliza el algoritmo HS256 para la encriptación del token.
- **Duración del Token**: El token generado tiene una duración de 30 minutos.

<br>

## 📋 Inserción de datos
Una vez que las tablas se han creado en la base de datos, puedes utilizar los scripts SQL disponibles en este [repositorio](https://github.com/CarlosAcosta4/resources-apis-borabora) para insertar datos.

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


