# Prueba tecnica para lite thinking
# By Richard Blacker


Aplicacion en base de React y springboot Java para la organizacion de Empresas y productos


## Caracteristicas

- Autenticacion de usuarios (admin o user)
- Visualizacion de tablas de productos y empresas
- habilidad de descargar las tablas antes mencionadas en PDF
- ingresar y editar productos y empresas
- contrasena encriptada



## Dependencias



    Axios: 1.6.5
    Bootstrap 5.3.2
    React 18.2.0
    React-bootstrap 2.9.2
    react-dom 18.2.0
    react-router-dom 6.21.2
    mysql 8.0.26
    apache.commons 
    github.librepdf 1.3.26
    spring-boot-starter-security 
    jsonwebtoken 0.11.3


## Installation
todas las versiones las puede encontrar en el segmento de tech.
Para la navegacion se usa la libreria React Router por su facil uso y rapida implementacion, para los estilos de hizo uso de bootstrap y react-bootstrap, se hizo uso de un sistema de autenticacion basado en jwt lo cual permite que las peticiones se consuman de manera segura mediante la utilizacion del Bearer token. Mi back end consta de springboot conectado a Mysql.


```sh
cd proyecto-prueba
npm i
npm run start
```

Para el backend

```sh
mvn clean install
mvn spring-boot:run
```
