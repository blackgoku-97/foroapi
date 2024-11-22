# **Proyecto de Foro** 📘

## 1. **Introducción** 📖

El proyecto consiste en una api rest que permite un crud de tópicos de un foro y un token por seguridad a los tópicos.

## 2. **Requisitos** 📉

### 2.1. **Requisitos funcionales** 📈

* El sistema debe permitir la busqueda de todos los topicos por metodo GET.
* El sistema debe permitir la creacion de nuevos topicos por metodo POST.
* El sistema debe permitir la actualizacion de topicos por metodo PUT.
* El sistema debe permitir la eliminacion de topicos por metodo DELETE.
* El sistema debe permitir la busqueda de topicos por id por metodo GET.
* El sistema debe permitir la creacion del token por usuario usando el metodo POST.

### 2.2. **Requisitos Previos** ⚙️

Antes de proceder, asegurate de tener estos programas en el equipo:

* ☕ **JDK 21**
* 🖥️ **IntelliJ IDEA** (Puede usar cualquier IDE de Java o editor de programación)
* 🌐 **Insomnia** (Para obtener los datos de los tópicos)

### 2.3. **Herramientas** 🛠️

* Java: Lenguaje de programación utilizado para el desarrollo.
* Spring Boot: Framework de Java para el desarrollo.
* Spring Hateoas: Dependencia de Spring para la integración con APIs REST.
* Spring Security: Dependencia de Spring para la seguridad.
* Spring Web: Dependencia de Spring para la integración de servicios web.
* Spring Data JPA: Dependencia de Spring para la integración con bases de datos.
* Spring Boot DevTools: Herramienta de desarrollo (Opcional)
* Lombok: Anotaciones para mejorar la legibilidad del código.
* MySQL Driver: Driver de conexión con MySQL.
* MySQL: Sistema de gestión de bases de datos.
* Flyway migration: Herramienta para gestionar el esquema de la base de datos.
* Validation: Anotaciones para validación de datos.
* Auth0-jwt: Dependencia para la autenticación y autorización con un token.
* Maven: Gestor de dependencias.
* GitHub: Sistema de control de versiones.
* Intellij IDEA: IDE de programación.
* Insomnia: API REST de prueba.

### 2.4. **Función de la Aplicación** 🚀

Para ejecutar el proyecto es necesario seguir estos pasos:

1. Crear variables de entorno

* DB_HOST: Host de la base de datos.
* DB_PORT: Puerto de la base de datos.
* DB_NAME: Nombre de la base de datos.
* DB_USER: Nombre de usuario de la base de datos.
* DB_PASSWORD: Contraseña de la base de datos.
* JWT_SECRET: Clave secreta para la autenticación y autorización.
* JWT_EXPIRATION: Tiempo de expiración del token.

2. Verifica la configuración y ejecuta el proyecto:

* Asegúrate de que todas las configuraciones estén correctas.

* La dependencia  de Auth0-jwt esta aca: https://github.com/auth0/java-jwt

* Ejecuta el proyecto desde tu IDE.
* Ejecuta el programa **Insomnia**.

## 3. 🔄 **Funcionamiento**

* La aplicación solicita la creacion de endpoints. Utiliza el programa **Insomnia** para obtener los datos del topico y login del usuario, la aplicación brinda resultados precisos y rápidos.

* Recuerde que en el programa **Insomnia** en la pestaña **Body** que la informacion se envia en formato JSON.
* Recuerde que en el programa **Insomnia** en la pestaña **Auth** debe elegir la opcion **Bearer Token** poner el token creado en los endpoints de los tópicos para tener autorización.
* Recuerde que el token expira en 2 horas, hay que renovarlo constantemente.


## 4. **Licencia** 📝

Este proyecto está licenciado bajo los términos de la [MIT License](LICENSE).
