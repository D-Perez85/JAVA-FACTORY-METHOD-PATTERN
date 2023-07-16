### Objetivo: Modelar y programar en Java la implementación del Patrón de Diseño Factory.

## Enunciado
Dada la siguiente familia de clases, se te encomienda el desafío de optimizar el diseño, teniendo en cuenta que necesitamos construir objetos de estas clases a partir de diferentes
parámetros establecidos. 

![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/3447ea5b-744f-448d-8d44-eb1b2f340450)


- Si recibimos como parámetro “EMP-RD” deberás poder construir un objeto de la clase EmpleadoRelacionDependencia con un sueldo de 1000 dolares 
- Si el parámetro es “EMPPH” deberás poder construir un objeto de la clase EmpleadoContratado con un importe por hora de 7 dólares y una retención impuesto de 14%.

## Con base en el enunciado:
:heavy_check_mark: Modificar el diagrama de clases con la implementación del Patrón Factory.

:heavy_check_mark: El método calcularSueldo que devuelva (no muestre por consola) el sueldo para la cantidad de días que recibe como parámetro. 
Tener en cuanta que en el caso de los empleados en relación de dependencia se deberá calcular el proporcional a los días trabajados.

:pushpin: Consideraciones: Considerar que los meses tienen 30 días y trabajan 8 hs diarias.
