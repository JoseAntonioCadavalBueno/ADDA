package practicaProfesorEjercicio1;

import java.util.function.Function;
import java.util.stream.Stream;


import java.util.stream.Collectors;

public class profesorEjercicio1 {
	//Método funcional
	public static String profesorEjercicio1_funcional(int a, int b, Function<Integer,Integer> f, String sp, String pf, String sf){
			return Stream.iterate(a, x->x<=b, x -> f.apply(x))
			.map(x->x*x)
			.map(x->x.toString())
			.collect(Collectors.joining(sp,pf,sf));
			}
	//Método iterativo
	public static String profesorEjercicio1_iterativo(int a, int b, Function<Integer,Integer> f, String sp, String pf, String sf){
		String res = "";
		Integer x = 0;
		while(a<=b) {
			x = a;
			a = f.apply(a);
			x = x*x;
			if(res == "") {
				res =pf + x.toString();
			}else {
				if(a-1==b) {
					res = res + sp + x.toString() + sf;
				}else {
					res = res + sp + x.toString();
				}
			}
		}
		return res;
	}
	//Método recursivo
	public static String profesorEjercicio1_recursivo(int a, int b, Function<Integer,Integer> f, String sp, String pf, String sf){
		String res = "";
		Integer x = 0;
		res = profesorEjercicio1_recursivo_aux(a, b, f, sp, pf, sf, x, res);
		return res;
	}
	//Método recursivo auxiliar
		public static String profesorEjercicio1_recursivo_aux(int a, int b, Function<Integer,Integer> f, String sp, String pf, String sf, Integer x, String res){
			while(a<=b) {
				x = a;
				a = f.apply(a);
				x = x*x;
				if(res == "") {
					res =pf + x.toString();
				}else {
					if(a-1==b) {
						res = res + sp + x.toString() + sf;
					}else {
						res = res + sp + x.toString();
					}
				}
			}
			return res;
		}
}
