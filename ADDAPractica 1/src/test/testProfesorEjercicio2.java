package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;
import us.lsi.geometria.Punto2D;

public class testProfesorEjercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("########################################################");
		System.out.println("##          Test del ejercicio2 del profesor          ##");
		System.out.println("##         ficheros/Ejemplo2_DatosEntrada.txt         ##");
		System.out.println("########################################################");
		ProfesorEjercicio2_test("ficheros/Ejemplo2_DatosEntrada.txt");
		System.out.println("########################################################");

	}
	public static void ProfesorEjercicio2_test(String fichero) {
		// TODO Auto-generated method stub
		//lista
		List<Punto2D> puntos = new ArrayList<Punto2D>();
		//funciones para crear la lista
		Function<String, List<String>> separar = x -> Arrays.stream(x.split(",")).collect(Collectors.toList());
		Function<List<String>, Punto2D> convertir = x -> Punto2D.of(Double.parseDouble(x.get(0)), Double.parseDouble(x.get(1)));
		//Lectura de fichero
		Stream<String> lista = Files2.streamFromFile(fichero);
		//Crea lista y llama a la función
		lista.map(separar.andThen(convertir)).map(ls -> puntos.add(ls)).forEach(ls -> System.out.println(
																										"Entrada:                    "+
																										puntos+
																										"\n1. Iterativa (while):       "+
																										practicaProfesorEjercicio2.profesorEjercicio2.practicaProfesorEjercicio2_iterativo(puntos)+
																										"\n2. Recursiva final:         "+
																										practicaProfesorEjercicio2.profesorEjercicio2.practicaProfesorEjercicio2_recursivo(puntos)+
																										"\n3. Funcional:               "+
																										practicaProfesorEjercicio2.profesorEjercicio2.practicaProfesorEjercicio2_funcional(puntos)+
																										"\n"));
	}
}
