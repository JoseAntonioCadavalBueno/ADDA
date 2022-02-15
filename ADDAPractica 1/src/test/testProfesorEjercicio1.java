package test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class testProfesorEjercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("########################################################");
		System.out.println("##          Test del ejercicio1 del profesor          ##");
		System.out.println("##         ficheros/Ejemplo1_DatosEntrada.txt         ##");
		System.out.println("########################################################");
		profesorEjercicio1_test("ficheros/Ejemplo1_DatosEntrada.txt");
		System.out.println("########################################################");
	}
	public static void profesorEjercicio1_test(String fichero) {
		// TODO Auto-generated method stub
		//Función
		Function<Integer, Integer> f = x -> x + 1;
		//Lectura de fichero
		Stream<String> lista = Files2.streamFromFile(fichero);
		
		//Crea lista y llama a la función
		lista.filter(linea -> !linea.startsWith("//"))
		.map(linea -> Arrays.stream(linea.split(","))
		.collect(Collectors.toList()))
		.forEach(ls -> System.out.println(
				"Entrada:                    "+
				ls+
				"\n1. Iterativa (while):       "+
				practicaProfesorEjercicio1.profesorEjercicio1.profesorEjercicio1_iterativo(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)),f, ls.get(4), ls.get(2), ls.get(3))+
				"\n2. Recursiva final:         "+
				practicaProfesorEjercicio1.profesorEjercicio1.profesorEjercicio1_recursivo(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)),f, ls.get(4), ls.get(2), ls.get(3))+
				"\n3. Funcional:               "+
				practicaProfesorEjercicio1.profesorEjercicio1.profesorEjercicio1_funcional(Integer.parseInt(ls.get(0)), Integer.parseInt(ls.get(1)),f, ls.get(4), ls.get(2), ls.get(3))+
				"\n"));
	}
}
