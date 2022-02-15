package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import us.lsi.common.Files2;

public class testAlumnoEjercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("########################################");
		System.out.println("##            Ejercicio 2             ##");
		System.out.println("##  ficheros/PI1E2_DatosEntrada1.txt  ##");
		System.out.println("########################################");
		alumnoEjercicio2_test("ficheros/PI1E2_DatosEntrada1.txt");
		System.out.println("########################################");
		System.out.println("##            Ejercicio 2             ##");
		System.out.println("##  ficheros/PI1E2_DatosEntrada2.txt  ##");
		System.out.println("########################################");
		alumnoEjercicio2_test("ficheros/PI1E2_DatosEntrada2.txt");
		System.out.println("########################################");
	}
	public static void alumnoEjercicio2_test(String fichero1) {
		// TODO Auto-generated method stub
		
		//Declaración de la lista de listas
		List<List<String>> listas = new ArrayList<List<String>>();
		
		//Lectura del fichero
		Stream<String> lista = Files2.streamFromFile(fichero1);
			
		//Añade las listas a la lista de listas
		lista.map(linea -> Arrays.stream(linea.split(","))
			.collect(Collectors.toList()))
			.forEach(ls -> listas.add(ls));
		
		//Ejecuta los metodos y muestra por consola
		System.out.println(
				"Entrada:                       "+
				listas+
				"\n1. Iterativa (while):          "+
				practicaAlumnoEjercicio2.alumnoEjercicio2.alumnoEjercicio2_iterativo(listas)+
				"\n2. Recursiva final:            "+
				practicaAlumnoEjercicio2.alumnoEjercicio2.alumnoEjercicio2_recursivo(listas)+
				"\n3. Funcional:                  "+
				practicaAlumnoEjercicio2.alumnoEjercicio2.alumnoEjercicio2_funcional(listas)+
				"\n");
	}
}
