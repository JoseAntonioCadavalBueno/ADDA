package test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import us.lsi.common.Files2;

public class testAlumnoEjercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("#######################################");
		System.out.println("##            Ejercicio 1            ##");
		System.out.println("##  ficheros/PI1E1_DatosEntrada.txt  ##");
		System.out.println("#######################################");
		alumnoEjercicio1_test("ficheros/PI1E1_DatosEntrada.txt");
		System.out.println("#######################################");
	}
	public static void alumnoEjercicio1_test(String fichero) {
		// TODO Auto-generated method stub
		//Función
		 Function<String, Integer> f = x -> x.length();
		 //Predicados
		 Predicate<String> pS = x -> x.contains("o") || x.contains("a") || x.contains("e");
		 Predicate<Integer> pI = x -> x%2==0;
		//Lectura de fichero
		Stream<String> lista = Files2.streamFromFile(fichero);
			
		//Crea lista y llama a la función
		lista.filter(linea -> !linea.startsWith("//"))
			.map(linea -> Arrays.stream(linea.split(","))
			.collect(Collectors.toList()))
			.forEach(ls -> System.out.println(
					"Entrada:                       "+
					ls+
					"\n1. Iterativa (while):          "+
					practicaAlumnoEjercicio1.alumnoEjercicio1.alumnoEjercicio1_iterativo(ls, pS, pI, f)+
					"\n2. Recursiva final:            "+
					practicaAlumnoEjercicio1.alumnoEjercicio1.alumnoEjercicio1_recursivo(ls, pS, pI, f)+
					"\n3. Funcional:                  "+
					practicaAlumnoEjercicio1.alumnoEjercicio1.alumnoEjercicio1_funcional(ls, pS, pI, f)+
					"\n"));
	}
}
