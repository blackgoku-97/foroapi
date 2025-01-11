# **Proyecto de Foro**

## 1. **Introducción**

El proyecto consiste en una api rest que permite un crud de tópicos y un crud de usuarios, con el usuario obtener un token para la seguridad de los tópicos.

## 2. **Requisitos**

### 2.1. **Requisitos funcionales**
* Usuarios:

  * El sistema debe permitir la busqueda de todos los usuarios por metodo GET.
  * El sistema debe permitir la creacion de nuevos usuarios por metodo POST.
  * El sistema debe permitir la actualizacion de usuarios por metodo PUT.
  * El sistema debe permitir la eliminacion de usuarios por metodo DELETE.
  * El sistema debe permitir la busqueda de usuarios por id por metodo GET.
  * El sistema debe permitir la creacion de un token con el usuario creado por metodo POST.

* Topicos:

  * El sistema debe permitir la busqueda de todos los topicos por metodo GET.
  * El sistema debe permitir la creacion de nuevos topicos por metodo POST.
  * El sistema debe permitir la actualizacion de topicos por metodo PUT.
  * El sistema debe permitir la eliminacion de topicos por metodo DELETE.
  * El sistema debe permitir la busqueda de topicos por id por metodo GET.

### 2.2. **Requisitos Previos**

Antes de proceder, asegurate de tener estos programas en el equipo:

* **JDK 21**
* **IntelliJ IDEA** (Puede usar cualquier IDE de Java o editor de programación)
* **Insomnia** (Para obtener los datos de los endpoints del proyecto)

### 2.3. **Herramientas**

* Java: Lenguaje de programación utilizado para el desarrollo.
* Spring Doc: Dependencia de Spring para la documentación.
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

### 2.4. **Función de la Aplicación**

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

* La dependencia de Auth0-jwt esta aca: https://github.com/auth0/java-jwt
* La dependencia de Spring Doc esta aca: https://springdoc.org/

* Para importar los endpoints de insomnia, debe abrir insomnia y importar el archivo de insomnia que se encuentra en la carpeta **foroapi**.
  en import -> seleccionar el archivo.

* Ejecuta el programa **Insomnia**.
* Ejecuta el proyecto desde tu IDE.

## 3. **Funcionamiento**

* La aplicación solicita la creacion de endpoints. Utiliza el programa **Insomnia** para obtener los datos de los tópicos y usuarios, la aplicación brinda resultados precisos y rápidos
* Recuerde que en el programa **Insomnia** en la pestaña **Body** que la informacion se envia en formato JSON.
* Recuerde que en el programa **Insomnia** en la pestaña **Auth** debe elegir la opcion **Bearer Token** poner el token
  creado en los endpoints de los tópicos para tener autorización.
* Recuerde que el token expira en 2 horas, hay que renovarlo constantemente-
* Recuerde que en el programa **Insomnia** debe importar el archivo de insomnia para tener los endpoints del proyecto.
* Recuerde entrar a esta url: http://localhost:8080/swagger-ui/index.html para ver la interfaz de swagger.
* Recuerde en swagger para obtener todos los topicos y usuarios debe borrar el body y pegar esto en su respectivo endpoint.:

{
"paginacion": {
"type": "object",
"properties": {
"page": {
"type": "integer"
},
"size": {
"type": "integer"
},
"sort": {
"type": "array",
"items": {
"type": "string"
}
}
}
}
}

## 4. **Licencia**

Este proyecto está licenciado bajo los términos de la [MIT License](LICENSE).
