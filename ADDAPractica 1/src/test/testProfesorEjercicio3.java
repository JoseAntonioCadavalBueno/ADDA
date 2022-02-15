package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import us.lsi.common.Files2;

public class testProfesorEjercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("########################################################");
		System.out.println("##          Test del ejercicio3 del profesor          ##");
		System.out.println("##         ficheros/Ejemplo3_DatosEntrada.txt         ##");
		System.out.println("########################################################");
		profesorEjercicio3_test("ficheros/Ejemplo3_DatosEntrada.txt");
		System.out.println("########################################################");
	}
	//método iterativo
	public static void profesorEjercicio3_test(String fichero) {
		// TODO Auto-generated method stub
		//Función separar
		Function<String, List<String>> separar = linea -> Arrays.stream(linea.split("#")).collect(Collectors.toList());
		//Lectura de fichero
		Stream<String> lista = Files2.streamFromFile(fichero);
			
		//Crea lista y llama a la función
		lista.map(separar)
		.forEach(ls -> System.out.println(
				"Entrada:                    "+
				ls+
				"\n1. Iterativa (while):       "+
				practicaProfesorEjercicio3.profesorEjercicio3.profesorEjercicio3_iterativo(Arrays.stream(ls.get(0).split("")).collect(Collectors.toList()), Arrays.stream(ls.get(1).split("")).collect(Collectors.toList()))+
				"\n2. Recursiva final:         "+
				practicaProfesorEjercicio3.profesorEjercicio3.profesorEjercicio3_recursivo(Arrays.stream(ls.get(0).split("")).collect(Collectors.toList()), Arrays.stream(ls.get(1).split("")).collect(Collectors.toList()))+
				"\n3. Funcional:               "+
				practicaProfesorEjercicio3.profesorEjercicio3.profesorEjercicio3_funcional(Arrays.stream(ls.get(0).split("")).collect(Collectors.toList()), Arrays.stream(ls.get(1).split("")).collect(Collectors.toList()))+
				"\n"));
	}

}
