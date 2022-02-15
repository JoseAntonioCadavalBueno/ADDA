package practicaAlumnoEjercicio3;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class alumnoEjercicio3 {
	//método funcional
	public static String alumnoEjercicio3_funcional(int a, int limit) {
		return Stream.iterate(Par.of(0, a),t -> t.v1() < limit,t -> Par.of(t.v1()+1, t.v1() % 3 == 1 ? t.v2() : t.v1()+t.v2())).collect(Collectors.toList()).toString();
	}
	//método iterativo
	public static String alumnoEjercicio3_iterativo(int a, int limit) {
		List<String> res = new ArrayList<String>();
		int v1 = 0;
		int v2 = a;
		while(v1 < limit) {
			if(v1==0)res.add(Par.of(0, a).toString());
			v2 = v1 % 3 == 1 ? v2 : v1 + v2;
			v1++;
			if(v1!=limit) res.add(Par.of(v1, v2).toString());
		}
		return res.toString();
	}
	//método recursivo
	public static String alumnoEjercicio3_recursivo(int a, int limit) {
		List<String> res = new ArrayList<String>();
		int v1 = 0;
		int v2 = a;
		return alumnoEjercicio3_recursivo_aux(a, limit, res, v1, v2);
	}
	//método recursivo auxiliar
		public static String alumnoEjercicio3_recursivo_aux(int a, int limit, List<String> res, int v1, int v2) {
			if(v1 < limit) {
				if(v1==0)res.add(Par.of(0, a).toString());
				v2 = v1 % 3 == 1 ? v2 : v1 + v2;
				v1++;
				if(v1!=limit) res.add(Par.of(v1, v2).toString());
				alumnoEjercicio3_recursivo_aux(a, limit, res, v1, v2);
			}
			return res.toString();
		}
}
