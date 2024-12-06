# Api Creacion de usuarios
Este es un proyecto de una API RESTful desarrollada en Java utilizando Spring Boot.
La API permite registrar usuarios y sus teléfonos, validando los datos enviados.

Las caracteristicas de esta api son las siguientes:
- Registrar usuarios con nombre, correo, contraseña y telefono, que pueden ser mas de 1.
- Realiza validaciones como: Correo unico y con el formato correspondiente, contraseñas seguras(deben cumplir cierto criterio) y los telefonos deben ser numeros validos. 
- Las respeusta que generan son en formato en JSON.
- Los datos se encuentran almacenados en H2 y el script de la BD tambien se encuentran en el proyecto.

Las tecnologias usadas fueron las siguientes:
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Lombok
- Maven

Para una correcta implementacion del proyecto hay que tener instalado java 17 y un IDE de tu preferencia, en mi caso utilice IntelliJ para una mejor implementacion y creacion del proyecto.

Una vez que este listo el java y el IDE de tu preferencia debes clonar el repositorio en tu local y podras probar el proyecto, cuando corras el proyecto tambien se va a generar las tablas para La base de datos en H2.

Cualquier duda me puedes contactar a diego_villegas@outlook.com.
