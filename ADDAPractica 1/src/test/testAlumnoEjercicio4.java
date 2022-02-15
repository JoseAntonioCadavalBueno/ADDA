package test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class testAlumnoEjercicio4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("#######################################");
		System.out.println("##            Ejercicio 4            ##");
		System.out.println("##  ficheros/PI1E4_DatosEntrada.txt  ##");
		System.out.println("#######################################");
		alumnoEjercicio4_test("ficheros/PI1E4_DatosEntrada.txt");
		System.out.println("#######################################");
	}
	public static void alumnoEjercicio4_test(String fichero) {
		// TODO Auto-generated method stub
		//Lectura de fichero
		Stream<String> lista = Files2.streamFromFile(fichero);
			
		//Crea lista y llama a la función
		lista.map(linea -> Arrays.stream(linea.split(","))
			.collect(Collectors.toList()))
			.forEach(ls -> System.out.println(
					"Entrada:                       "+
					ls+
					"\n1. Iterativa (while):          "+
					practicaAlumnoEjercicio4.alumnoEjercicio4.alumnoEjercicio4_iterativo(Double.valueOf(ls.get(0)),Double.valueOf(ls.get(1)))+
					"\n2. Recursiva final:            "+
					practicaAlumnoEjercicio4.alumnoEjercicio4.alumnoEjercicio4_recursivo(Double.valueOf(ls.get(0)),Double.valueOf(ls.get(1)))+
					"\n3. Funcional:                  "+
					practicaAlumnoEjercicio4.alumnoEjercicio4.alumnoEjercicio4_funcional(Double.valueOf(ls.get(0)),Double.valueOf(ls.get(1)))+
					"\n"));
	}
}
