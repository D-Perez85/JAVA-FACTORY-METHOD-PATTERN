### JAVA-FACTORY-METHOD-PATTERN!  🚀
--------------------- 


![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/ed22828a-241f-4e7f-8125-bc296d7398dc)


Factory Method es un patrón de diseño creacional que proporciona una interfaz para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.

## Problema
Imagina que estás creando una aplicación de gestión logística donde la primera versión de tu aplicación sólo es capaz de manejar el transporte en camión, por lo que la mayor parte de tu código se encuentra dentro de la clase Camión.

Al cabo de un tiempo, tu aplicación se vuelve bastante popular y cada día recibes decenas de peticiones de empresas de transporte marítimo para que incorpores la logística por mar a la aplicación


![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/e6553f05-4dd1-417a-a784-009287dddf23)


En este momento, la mayor parte de tu código está acoplado a la clase Camión y para añadir barcos a la aplicación habría que hacer cambios en toda la base del código. 

Si más tarde decides añadir otro tipo de transporte a la aplicación, probablemente tendrás que volver a hacer todos estos cambios y al final acabarás con un código bastante sucio, plagado de condicionales que cambian el comportamiento de la aplicación dependiendo de la clase de los objetos de transporte.


## Solución
El patrón Factory Method sugiere que, en lugar de llamar al operador new para construir objetos directamente, se invoque a un método fábrica especial. 

No te preocupes: los objetos se siguen creando a través del operador new, pero se invocan desde el método fábrica, (los objetos devueltos por el método fábrica a menudo se denominan productos).


A simple vista, puede parecer que este cambio no tiene sentido, ya que tan solo hemos cambiado el lugar desde donde invocamos al constructor pero piensa en esto: ahora puedes sobrescribir el método fábrica en una subclase y cambiar la clase de los productos creados por el método.


No obstante, hay una pequeña limitación: las subclases sólo pueden devolver productos de distintos tipos si dichos productos tienen una clase base o interfaz común. Además, el método fábrica en la clase base debe tener su tipo de retorno declarado como dicha interfaz.


![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/94a1f391-b0a0-4d98-b2c7-8828077d4c97)


Por ejemplo, tanto la clase Camión como la clase Barco deben implementar la interfaz Transporte, que declara un método llamado entrega. 

Cada clase implementa este método de forma diferente: los camiones entregan su carga por tierra, mientras que los barcos lo hacen por mar. 

El método fábrica dentro de la clase LogísticaTerrestre devuelve objetos de tipo camión, mientras que el método fábrica de la clase LogísticaMarítima devuelve barcos.

![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/45cc4823-a43e-432d-a53b-f8eb940ebb4b)


El código que utiliza el método fábrica (a menudo denominado código cliente) no encuentra diferencias entre los productos devueltos por varias subclases, y trata a todos los productos como la clase abstracta Transporte. El cliente sabe que todos los objetos de transporte deben tener el método entrega, pero no necesita saber cómo funciona exactamente.

![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/f7618d7b-99ed-4713-bc02-803b324b64b1)




## Aplicabilidad

:pushpin: cuando no conozcas de antemano las dependencias y los tipos exactos de objetos de tu código: Factory Method separa el código de construcción de producto del código que hace uso del producto, siendo más fácil extender el código de construcción de producto de forma independiente al resto del código.

Por ejemplo, para añadir un nuevo tipo de producto, sólo tendrás que crear una nueva subclase creadora y sobrescribir el Factory Method que contiene.


:pushpin: cuando quieras ofrecer a los usuarios de tu biblioteca o framework, una forma de extender sus componentes internos: La herencia es probablemente la forma más sencilla de extender el comportamiento por defecto de una biblioteca o un framework... ¿pero cómo reconoce el framework si debe utilizar tu subclase en lugar de un componente estándar?

La solución es reducir el código que construye componentes en todo el framework a Factory Method y permitir que cualquiera sobrescriba este método además de extender el propio componente.


:pushpin: cuando quieras ahorrar recursos del sistema mediante la reutilización de objetos existentes en lugar de reconstruirlos cada vez.

A menudo experimentas esta necesidad cuando trabajas con objetos grandes y que consumen muchos recursos, como conexiones de bases de datos, sistemas de archivos y recursos de red. 

Pensemos en lo que hay que hacer para reutilizar un objeto existente:
- Primero, debemos crear un almacenamiento para llevar un registro de todos los objetos creados.
- Cuando alguien necesite un objeto, el programa deberá buscar un objeto disponible dentro de ese agrupamiento y devolverlo al código cliente.
- Si no hay objetos disponibles, el programa deberá crear uno nuevo (y añadirlo al agrupamiento).


¡Eso es mucho código! Y hay que ponerlo todo en un mismo sitio para no contaminar el programa con código duplicado.
Es probable que el lugar más evidente y cómodo para colocar este código sea el constructor de la clase cuyos objetos intentamos reutilizar, sin embargo, un constructor siempre debe devolver nuevos objetos por definición. No puede devolver instancias existentes.

Por lo tanto, necesitas un método regular capaz de crear nuevos objetos, además de reutilizar los existentes, (suena bastante a lo que hace un patrón Factory Method).






## Cómo implementarlo
- Haz que todos los productos sigan la misma interfaz. Esta interfaz deberá declarar métodos que tengan sentido en todos los productos.
- Añade un patrón Factory Method vacío dentro de la clase creadora. El tipo de retorno del método deberá coincidir con la interfaz común de los productos.
- Encuentra todas las referencias a constructores de producto en el código de la clase creadora. Una a una, sustitúyelas por invocaciones al Factory Method, mientras extraes el código de creación de productos para colocarlo dentro del Factory Method.
Puede ser que tengas que añadir un parámetro temporal al Factory Method para controlar el tipo de producto devuelto.
A estas alturas, es posible que el aspecto del código del Factory Method luzca bastante desagradable. Puede ser que tenga un operador switch largo que elige qué clase de producto instanciar. Pero, no te preocupes, lo arreglaremos enseguida.
- Ahora, crea un grupo de subclases creadoras para cada tipo de producto enumerado en el Factory Method. Sobrescribe el Factory Method en las subclases y extrae las partes adecuadas de código constructor del método base.
- Si hay demasiados tipos de producto y no tiene sentido crear subclases para todos ellos, puedes reutilizar el parámetro de control de la clase base en las subclases.
Por ejemplo, imagina que tienes la siguiente jerarquía de clases: la clase base Correo con las subclases CorreoAéreo y CorreoTerrestre y la clase Transporte con Avión, Camión y Tren. La clase CorreoAéreo sólo utiliza objetos Avión, pero CorreoTerrestre puede funcionar tanto con objetos Camión, como con objetos Tren. Puedes crear una nueva subclase (digamos, CorreoFerroviario) que gestione ambos casos, pero hay otra opción. El código cliente puede pasar un argumento al Factory Method de la clase CorreoTerrestre para controlar el producto que quiere recibir.
- Si, tras todas las extracciones, el Factory Method base queda vacío, puedes hacerlo abstracto. Si queda algo dentro, puedes convertirlo en un comportamiento por defecto del método.



>#### Pros y contras:              
       ○ Evitas un acoplamiento fuerte entre el creador y los productos concretos.
       ○ Principio SRP. Puedes mover el código de creación de producto a un lugar del programa, haciendo que el código sea más fácil de mantener.
       ○ Principio OCP. Puedes incorporar nuevos tipos de productos en el programa sin descomponer el código cliente existente.
       ○ Debes incorporar una multitud de nuevas subclases para implementar el patrón. Lo ideal sería introducir el patrón en una jerarquía existente de clases creadoras.



## Relaciones con otros patrones
:heavy_check_mark: Muchos diseños empiezan utilizando el Factory Method (menos complicado y más personalizable mediante las subclases) y evolucionan hacia Abstract Factory, Prototype, o Builder (más flexibles, pero más complicados). 

:heavy_check_mark: Las clases del Abstract Factory a menudo se basan en un grupo de métodos de fábrica, pero también puedes utilizar Prototype para escribir los métodos de estas clases.

:heavy_check_mark: Puedes utilizar el patrón Factory Method junto con el Iterator para permitir que las subclases de la colección devuelvan distintos tipos de iteradores que sean compatibles con las colecciones.

:heavy_check_mark: Prototype no se basa en la herencia, por lo que no presenta sus inconvenientes. No obstante, Prototype requiere de una inicialización complicada del objeto clonado. Factory Method se basa en la herencia, pero no requiere de un paso de inicialización.

:heavy_check_mark: Factory Method es una especialización del Template Method. Al mismo tiempo, un Factory Method puede servir como paso de un gran Template Method.





## Comenzando 🚀

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.


### Instalación 🔧

### `Clonar` 
Clonar el proyecto utilizando git clone  dentro de tu entorno local para poder obtener el codigo fuente. 
```
git clone https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN.git

```
### `Instalar Intellij IDE`
Necesitas este framework para poder compilar los archivos de prueba
```
https://www.jetbrains.com/es-es/idea/download/?section=windows
```
### `Run`
Una vez instalado el frame podras correr la App para ver este patron en funcionamiento.  

![image](https://github.com/D-Perez85/JAVA-FACTORY-METHOD-PATTERN/assets/77124855/f5a74b9c-e7d1-47ab-b837-d15d5f4c61df)




Made with ❤️ by [Damian Perez](https://github.com/D-Perez85) 😊




