package practicaAlumnoEjercicio1;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class alumnoEjercicio1 {
	//Método funcional
	public static boolean alumnoEjercicio1_funcional(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		return ls.stream().filter(pS).map(f).anyMatch(pI);
	}
	//Método iterativo con while
	public static boolean alumnoEjercicio1_iterativo(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		boolean res = false;
		int i = 0;
		while(i !=ls.size()) {
			if(pS.test(ls.get(i))) {
				res = pI.test(f.apply(ls.get(i)));
			}
			if(res ==true) break;
			i++;
		}
		return res;
	}
	//Método recursivo final
	public static boolean alumnoEjercicio1_recursivo(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f){
		return alumnoEjercicio1_recursivo_aux(ls, pS, pI, f, 0);

	}
	public static boolean alumnoEjercicio1_recursivo_aux(List<String> ls, Predicate<String> pS,Predicate<Integer> pI, Function<String,Integer> f, int i){
		if(i<ls.size()) {	
			if(pS.test(ls.get(i))) {
				if(pI.test(f.apply(ls.get(i)))) return true;
			}
			i++;
			if(alumnoEjercicio1_recursivo_aux(ls, pS, pI, f, i)) return true;
		}
		return false;
	}
}