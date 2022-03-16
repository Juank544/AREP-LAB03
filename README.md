# Aplicación web APP-LB-RoundRobin

![img.png](img/img_1.png)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

El software que vamos a necesitar para ejecutar es:

* Maven
* Java 8
* Entorno de desarrollo (Intellij- Visual Studio code - Netbeans)
* Docker

## Requeriments

1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2
2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

## Deployment

Empezamos con el servidor de spark, donde luego de implementarlo verificamos su funcionamiento:

* El metodo GET que nos devuleve las 10 ultimas cadenas de la base de datos
![img.png](img/img_2.png)


* El metodo POST que nos permite añadir más cadenas a la base de datos
![img.png](img/img_3.png)

## Built With

* [Spark](https://sparkjava.com/) - El framework web utilizado
* [Maven](https://maven.apache.org/) - Gestor de dependencias
* [Java](https://www.java.com/es/) - Lenguaje de programación

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Juan Camilo Gil Vargas** -  [Juank544](https://github.com/Juank544)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
