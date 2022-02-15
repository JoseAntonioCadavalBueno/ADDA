package practicaAlumnoEjercicio4;

import java.util.Optional;
import java.util.stream.Stream;

public class alumnoEjercicio4 {
	//metodo funcional
	public static double alumnoEjercicio4_funcional(double n, double e) {
		estado seed = estado.first(n, e);
		Optional<estado> res = Stream.iterate(seed, estado::next)
									.dropWhile(estado::condicion)
									.findFirst();
		return res.isPresent() ? res.get().middy() : -1;
	}
	//metodo iterativo
		public static double alumnoEjercicio4_iterativo(double n, double e) {
			double middy = n/2;
			double ini = 1.0;
			double fin = n;
			
			while(Math.abs(Math.pow(middy, 3)-n)>e) {
				if(Math.pow(middy, 3)>n) {
					fin = middy;
				}else {
					ini = middy;
				}
				middy = (ini+fin)/2;
			}
			return middy;
		}
	//metodo recursivo auxiliar
	public static double alumnoEjercicio4_recursivo(double n, double e) {
			double middy = n/2;
			double ini = 1.0;
			double fin = n;
			
			return alumnoEjercicio4_recursivo_aux(n, e, middy, ini, fin);
		}
	//metodo recursivo auxiliar
	private static double alumnoEjercicio4_recursivo_aux(double n, double e, double middy, double ini, double fin) {
			
		if(Math.abs(Math.pow(middy, 3)-n)>e) {
			if(Math.pow(middy, 3)>n) {
				fin = middy;
			}else {
				ini = middy;
			}
			middy = (ini+fin)/2;
			return alumnoEjercicio4_recursivo_aux(n, e, middy, ini, fin);
		}
		return middy;
	}
}
