# Pre-Aceleracion-Alejandro-Toloza

Alkemy_Challenge_Java

_Personajes:

POST
http://localhost:8080/characters
http://localhost:8080/characters
add character

Bodyraw (json)
json
{
  "imagen": "JUAN",
  "nombre": "JUAN",
  "edad": 70,
  "peso": 90,
  "historia": "JUAN"
}

GET
http://localhost:8080/personajes
http://localhost:8080/characters
bring characters

DEL
http://localhost:8080/personajes/delete/5
http://localhost:8080/characters/66
delete character

GET
http://localhost:8080/personajes/1
http://localhost:8080/characters/1
fetch by character id

PUT
http://localhost:8080/personajes/9
http://localhost:8080/characters/67
update character

Bodyraw (json)
json
{
  "imagen": "EDITADO",
  "nombre": "EDITADO",
  "edad": 70,
  "peso": 90.2,
  "historia": "COBRA AKAI"
}

GET
http://localhost:8080/characters?nombre=COBRA&edad=70&peliculasSeries=3
http://localhost:8080/characters?nombre=COBRA&edad=70&peliculasSeries=3
filter characters

Query Params
nombre
COBRA
edad
70
peliculasSeries
3


_Peliculas:

POST
http://localhost:8080/peliculas
http://localhost:8080/movies
update movies

Bodyraw (json)
json
{
  "imagen": "EL RITO",
  "titulo": "EL RITO",
  "fechaCreacion": "2010-10-10",
  "calificacion": 4
}

GET
http://localhost:8080/peliculas
http://localhost:8080/movies
bring movies

Bodyraw (json)
json
{
  "imagen": "MAGIK",
  "titulo": "URL/MAGIK",
  "fechaCreacion": "2000-07-07",
  "calificacion": 5,
  "personajes": [
    {
      "id": 1,
      "imagen": "ROCA",
      "nombre": "ROCA",
      "edad": 39,
      "peso": 98.5,
      "historia": "ROCA"
    }
  ]
}

DEL
http://localhost:8080/peliculas/6
http://localhost:8080/movies/6
delete movie

PUT
http://localhost:8080/peliculas/4
http://localhost:8080/movies/4
update movie

Bodyraw (json)
json
{
  "imagen": "ACTUALIZADO",
  "titulo": "ACTUALIZADO",
  "fechaCreacion": "2010-09-17",
  "calificacion": 7
}

GET
Filters http://localhost:8080/movies?titulo=HARRY POTHER&genero=2
http://localhost:8080/movies?titulo=HARRY POTHER&genero=2
filter movies

Query Params
titulo
HARRY POTHER
genero
2

GET
http://localhost:8080/peliculas/3
http://localhost:8080/movies/3
fetch by character id

_Login:


POST
http://localhost:8080/auth/login
http://localhost:8080/auth/login
user authentication

Bodyurlencoded
username
user900
password
1234

GET
http://localhost:8080/auth/users
http://localhost:8080/auth/users
fetch users

_Genero:

POST
http://localhost:8080/generos
http://localhost:8080/generos
add gendere

Bodyraw (json)
json
{
  "nombre": "CIENCIA FICCION",
  "imagen": "URL/CF"
}
