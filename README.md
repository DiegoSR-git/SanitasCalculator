# SanitasCalculator

Enunciado del ejercicio propuesto
=================

El objetivo de este ejercicio es implementar un microservicio "calculadora", usando maven + spring-boot

Este microservicio tiene que exponer un API que debe ser capaz, a partir de unos parámetros de entrada, de realizar operaciones aritméticas. Al ser una versión POC, sólo será capaz de realizar sumas y restas de dos elementos, aunque se prevé que en futuras versiones haya otros tipos de operaciones y de mayor complejidad. También se incluye con este enunciado un jar que contiene un API de traceo de operaciones que debe ser invocado por el microservicio para tracear el resultado de la operación.

El tiempo para hacer el ejercicio es de hasta cuatro horas a partir de la recepción del correo con este ejercicio, plazo máximo en el que debe referirse una URL de github (o similares) a la dirección de arquitecturacross@sanitas.es para su análisis. El objeto del ejercicio NO es entregar el microservicio, sino ver cómo se plantea la solución.

Analisis
=================

Crear un Api-Rest con la peticion en la fachada para calcular.
Según los parámetros que reciba, se realizará una operación u otra. 
Crear test en la capa del controlador y del servicio consiguiendo una alta cobertura.


Notas adicionales
=================

* Lo que se busca ver es la manera en que se afronta el problema, no la solución por si misma. En este sentido, no hay una solución correcta, es mucho más interesante el histórico de Git como hilo conductor de lo que se va haciendo. Tener un único commit con todas las actuaciones efectuadas no es aconsejable.

* Se puede usar cualquier librería / versión que se considere necesaria para llevar a cabo la tarea. Los únicos requisitos son:
  * debe ser un proyecto maven (cualquier versión de maven)
  * debe ser un microservicio spring-boot (cualquier versión de spring-boot)

* El entregable debe compilar en una instalación de maven totalmente limpia, debe indicarse en un fichero README tanto los pasos necesarios para generar el jar final como para ejecutarlo (no hace falta mucho detalle).

Requisitos
=================
* Maven
* Java

Arranque aplicacion
=================
Abrir una consola y ejecutar:

```
cd CalculatorApi
mvn validate
mvn verify
mvn clean install
```
Se habrá generado un jar en la carpeta target del proyecto. Abrir consola y ejecutar el siguiente comando:

```java -jar api.calculator-0.0.1-SNAPSHOT.jar```

Esto nos levantará la aplicación en el puerto 8080 y podemos lanzar las siguientes peticiones:

(GET)
http://localhost:8080/calculator?firstNumber=(firstNumber)&secondNumber=(secondNumber)&operation=(operation)


firstNumber y secondNumber pueden ser cualquier valor númerico con decimales. El resultado será un numero con dos decimales.
operation: (add o sub)


