package practicaProfesorEjercicio3;

import java.util.List;
import java.util.stream.Collectors;

import us.lsi.streams.Stream2;


public class profesorEjercicio3 {
	//método funcional
	public static int profesorEjercicio3_funcional(List<String> a, List<String> b) {
		return Stream2.zip(a.stream(), b.stream(), (x,y) -> x.equals(y)).collect(Collectors.toList()).size();
	}
	//método iterativo
	public static int profesorEjercicio3_iterativo(List<String> a, List<String> b) {
		int i = 0;
		while(a.get(i).equals(b.get(i))) {
			i++;
		}
		return i;
	}
	//método recursivo
	public static int profesorEjercicio3_recursivo(List<String> a, List<String> b) {
		int i = 0;
		i = profesorEjercicio3_recursivo_aux(a,b,i);
		return i;
	}
	//método recursivo
	public static int profesorEjercicio3_recursivo_aux(List<String> a, List<String> b, int i) {
		if(b.get(i).equals(a.get(i))) {
			i++;
			return profesorEjercicio3_recursivo_aux(a,b,i);
		}
		return i;
		}
}
