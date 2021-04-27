package conversorfx.model;

public class Temperatura {
	//Atributos (Caracteristicas)
	private float grado;

	//Metodos (Comportamiento)

	//Constructor de clase:
	//Por defecto
	public Temperatura() {}

	//Constructor de parametros
	public Temperatura(float grado) {
		this.grado = grado;
	}

	//Metodos que definen una interfaz publica al atributo:
	//ENCAPSULAMIENTO !!!

	public void asignarGrado(float grado) {
		this.grado = grado;
	}
		
	public float obtenerGrado () {
		return grado;
	}


	/* Celsius a Fahrenheit */
	public float convertirCelsiusToFahrenheit() {
		return 9.0f/5.0f * grado + 32;
	}

	//método sobrecargado:
	public float convertirCelsiusToFahrenheit(float grado) {
		asignarGrado(grado);
		return 9.0f/5.0f * grado + 32;
	}

	/* Fahrenheit a Celsius*/
	public float convertirFahrenheitToCelsius() {
		return 5.0f/9.0f * (grado - 32);
	}

	//método sobrecargado:
	public float convertirFahrenheitToCelsius(float grado) {
		asignarGrado(grado);
		return 5.0f/9.0f * (grado - 32);
	
	}
}
