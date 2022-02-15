package practicaProfesorEjercicio2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;


public class profesorEjercicio2 {
	//método funcional
	public static Map<Punto2D.Cuadrante, Double> practicaProfesorEjercicio2_funcional(List<Punto2D> l){
		return l.stream()
		.collect(Collectors.groupingBy(Punto2D::getCuadrante,
		Collectors.<Punto2D,Double>reducing(0.,x->x.x(),(x,y)->x+y)));
		}
	//método iterativo
	public static Map<Punto2D.Cuadrante, Double> practicaProfesorEjercicio2_iterativo(List<Punto2D> l){
		int i = 0;
		Map<Punto2D.Cuadrante, Double> res = new HashMap<Cuadrante, Double>();
		while(i != l.size()) {
			if(res.containsKey(l.get(i).getCuadrante())) {
				res.replace(l.get(i).getCuadrante(), res.get(l.get(i).getCuadrante())+l.get(i).x());
			}else {
				res.put(l.get(i).getCuadrante(), l.get(i).x());
			}
			i++;
		}
		return res;
	}
	//método recursivo
	public static Map<Punto2D.Cuadrante, Double> practicaProfesorEjercicio2_recursivo(List<Punto2D> l){
		int i = 0;
		Map<Punto2D.Cuadrante, Double> res = new HashMap<Cuadrante, Double>();
			res = practicaProfesorEjercicio2_aux(l, i, res);
		return res;
	}
	//método recursivo auxiliar
	public static Map<Punto2D.Cuadrante,Double> practicaProfesorEjercicio2_aux(List<Punto2D> l, int i, Map<Punto2D.Cuadrante, Double> res){
		if(i != l.size()) {
			if(res.containsKey(l.get(i).getCuadrante())) {
				res.replace(l.get(i).getCuadrante(), res.get(l.get(i).getCuadrante())+l.get(i).x());
			}else {
				res.put(l.get(i).getCuadrante(), l.get(i).x());
			}
			i++;
			return practicaProfesorEjercicio2_aux(l, i, res);
		}else
		return res;
	}
}	
