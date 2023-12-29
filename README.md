# Repositorio de Microservicios

Este repositorio contiene varios microservicios y una base de datos, cada uno con su propia funcionalidad específica.

## Estructura del Repositorio

El repositorio tiene la siguiente estructura:

├───balance-microservice
│   └───app
├───bd
├───information-microservice
│   ├───.mvn
│   │   └───wrapper
│   ├───.vscode
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───moovia
│   │   │   │           └───rickymicroservice
│   │   │   │               ├───context
│   │   │   │               ├───controller
│   │   │   │               ├───exception
│   │   │   │               ├───filter
│   │   │   │               ├───persistence
│   │   │   │               │   ├───entity
│   │   │   │               │   └───repository
│   │   │   │               ├───service
│   │   │   │               │   └───dto
│   │   │   │               └───util
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───moovia
│   │                   └───rickymicroservice
│   └───target
│       ├───classes
│       │   └───com
│       │       └───moovia
│       │           └───rickymicroservice
│       │               ├───context
│       │               ├───controller
│       │               ├───exception
│       │               ├───filter
│       │               ├───persistence
│       │               │   ├───entity
│       │               │   └───repository
│       │               ├───service
│       │               │   └───dto
│       │               └───util
│       └───test-classes
│           └───com
│               └───moovia
│                   └───rickymicroservice
└───valid-microservice
    ├───.mvn
    │   └───wrapper
    ├───.vscode
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───moovia
    │   │   │           └───rickymicroservice
    │   │   │               ├───context
    │   │   │               ├───controller
    │   │   │               ├───exception
    │   │   │               ├───filter
    │   │   │               ├───persistence
    │   │   │               │   ├───entity
    │   │   │               │   └───repository
    │   │   │               ├───service
    │   │   │               │   └───dto
    │   │   │               └───util
    │   │   └───resources
    │   │       ├───static
    │   │       └───templates
    │   └───test
    │       └───java
    │           └───com
    │               └───moovia
    │                   └───rickymicroservice
    └───target
        ├───classes
        │   └───com
        │       └───moovia
        │           └───rickymicroservice
        │               ├───context
        │               ├───controller
        │               ├───exception
        │               ├───filter
        │               ├───persistence
        │               │   ├───entity
        │               │   └───repository
        │               ├───service
        │               │   └───dto
        │               └───util
        └───test-classes
            └───com
                └───moovia
                    └───rickymicroservice

## Descripción de los Componentes

- `bd`: Esta es una carpeta para la base de datos.
- `balance-microservice`: Este es un microservicio hecho en Python que devuelve el balance de la tarjeta.
- `valid-microservice`: Este es un microservicio de Java que devuelve si una tarjeta es válida o no.
- `information-microservice`: Este es un microservicio de Java que devuelve la información de la tarjeta.

## Requisitos

Para usar los microservicios, necesitamos levantar la base de datos. Los microservicios de Java están con Java 17 y Spring 3.2.1. Necesitamos Docker para levantar la base de datos y el microservicio de Python.
