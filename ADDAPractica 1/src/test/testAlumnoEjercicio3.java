package test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class testAlumnoEjercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("#######################################");
		System.out.println("##            Ejercicio 3            ##");
		System.out.println("##  ficheros/PI1E3_DatosEntrada.txt  ##");
		System.out.println("#######################################");
		alumnoEjercicio3_test("ficheros/PI1E3_DatosEntrada.txt");
		System.out.println("#######################################");
	}
	public static void alumnoEjercicio3_test(String fichero) {
		// TODO Auto-generated method stub
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
					practicaAlumnoEjercicio3.alumnoEjercicio3.alumnoEjercicio3_iterativo(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)))+
					"\n2. Recursiva final:            "+
					practicaAlumnoEjercicio3.alumnoEjercicio3.alumnoEjercicio3_recursivo(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)))+
					"\n3. Funcional:                  "+
					practicaAlumnoEjercicio3.alumnoEjercicio3.alumnoEjercicio3_funcional(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)))+
					"\n"));
	}
}
