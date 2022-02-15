package practicaAlumnoEjercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class alumnoEjercicio2 {
	//metodo funcional
	public static Map<Integer,List<String>> alumnoEjercicio2_funcional (List<List<String>> listas) {
		return listas.stream().flatMap(lista -> lista.stream()).collect(Collectors.groupingBy(String::length));
	}
	//metodo iterativo
	public static Map<Integer,List<String>> alumnoEjercicio2_iterativo (List<List<String>> listas) {
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();
		List<String> listaAux = new ArrayList<String>();
		ArrayList<String> agrupa = new ArrayList<String>();
		int i = 0;
		//listas.stream()
		while(i!=listas.size()) {
			//.flatMap(lista -> lista.stream())
			listaAux = listas.get(i);
			for(int c = 0; c!=listaAux.size();c++) {
				//.collect(Collectors.groupingBy(String::length))
				if(res.containsKey(listaAux.get(c).length())) {
					res.get(listaAux.get(c).length()).add(listaAux.get(c));
				}else {
					agrupa.add(listaAux.get(c));
					res.put(listaAux.get(c).length(),((ArrayList<String>) agrupa.clone()));
					agrupa.clear();
				}
			}
			i++;
		}
		return res;
	}
	//metodo recursivo
	public static Map<Integer,List<String>> alumnoEjercicio2_recursivo (List<List<String>> listas) {
		Map<Integer, List<String>> res = new HashMap<Integer, List<String>>();
		List<String> listaAux = new ArrayList<String>();
		ArrayList<String> agrupa = new ArrayList<String>();
		int i = 0;
		//listas.stream()
		alumnoEjercicio2_recursivo_aux(listas, res, listaAux, agrupa, i);
		return res;
	}
	//metodo recursivo auxiliar
	public static Map<Integer,List<String>> alumnoEjercicio2_recursivo_aux (List<List<String>> listas, Map<Integer, 
			List<String>> res, List<String> listaAux, ArrayList<String> agrupa, int i) {
		if(i<listas.size()) {
			listaAux = listas.get(i);
			for(int c = 0; c!=listaAux.size();c++) {
				//.collect(Collectors.groupingBy(String::length))
				if(res.containsKey(listaAux.get(c).length())) {
					res.get(listaAux.get(c).length()).add(listaAux.get(c));
				}else {
					agrupa.add(listaAux.get(c));
					res.put(listaAux.get(c).length(),((ArrayList<String>) agrupa.clone()));
					agrupa.clear();
				}
			}
			i++;
			alumnoEjercicio2_recursivo_aux(listas, res, listaAux, agrupa, i);
		}
		return res;
	}
}
