package application;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class MetodosOrdenamiento {

	public static void metodoBurbuja(AtributosOrdenamiento burbuja) {
		for (int i = 0; i < burbuja.getLista().getLongitud(); i++) {
			for (int j = burbuja.getLista().getLongitud() - 1; j > i; j--) {
				if (burbuja.getLista().obtenerNodo(j - 1) > burbuja.getLista().obtenerNodo(j)) {
					Integer aux = burbuja.getLista().obtenerNodo(j - 1);
					burbuja.getLista().asignar(burbuja.getLista().obtenerNodo(j), j - 1);
					burbuja.getLista().asignar(aux, j);
					String tmpEstilo = burbuja.getSeries().getData().get(j).getNode().getStyle();
					String tmpEstiloDos = burbuja.getSeries().getData().get(j - 1).getNode().getStyle();
					burbuja.getSeries().getData().get(j).getNode().setStyle(tmpEstiloDos);
					burbuja.getSeries().getData().get(j - 1).getNode().setStyle(tmpEstilo);
					burbuja.getSeries().getData().get(j).setYValue(burbuja.getLista().obtenerNodo(j));
					burbuja.getSeries().getData().get(j - 1).setYValue(burbuja.getLista().obtenerNodo(j - 1));
					break;
				}

			}
		}
	}

	public static void metodoSeleccion(AtributosOrdenamiento seleccion) {
		for (int i = 0; i < seleccion.getLista().getLongitud(); i++) {
			Integer menor = seleccion.getLista().obtenerNodo(i);
			int k = i;
			for (int j = i + 1; j < seleccion.getLista().getLongitud(); j++) {
				if (seleccion.getLista().obtenerNodo(j) < menor) {
					menor = seleccion.getLista().obtenerNodo(j);
					k = j;
					break;
				}
			}
			seleccion.getLista().asignar(seleccion.getLista().obtenerNodo(i), k);
			seleccion.getLista().asignar(menor, i);

			String tmpEstilo = seleccion.getSeries().getData().get(k).getNode().getStyle();
			String tmpEstiloDos = seleccion.getSeries().getData().get(i).getNode().getStyle();
			seleccion.getSeries().getData().get(k).getNode().setStyle(tmpEstiloDos);
			seleccion.getSeries().getData().get(i).getNode().setStyle(tmpEstilo);
			seleccion.getSeries().getData().get(i).setYValue(menor);
			seleccion.getSeries().getData().get(k).setYValue(seleccion.getLista().obtenerNodo(i));

		}
	}

	public static void metodoInsercion(AtributosOrdenamiento insercion) {
		for (int i = 1; i < insercion.getLista().getLongitud(); i++) {
			Integer aux = insercion.getLista().obtenerNodo(i);
			Integer k = i - 1;

			while (k >= 0 && aux < insercion.getLista().obtenerNodo(k)) {
				insercion.getLista().asignar(insercion.getLista().obtenerNodo(k), k + 1);

				String tmpEstiloDos = insercion.getSeries().getData().get(k + 1).getNode().getStyle();
				String tmpEstilo = insercion.getSeries().getData().get(k).getNode().getStyle();
				insercion.getSeries().getData().get(k + 1).getNode().setStyle(tmpEstilo);
				insercion.getSeries().getData().get(k).getNode().setStyle(tmpEstiloDos);

				insercion.getSeries().getData().get(k + 1).setYValue(insercion.getLista().obtenerNodo(k + 1));
				k--;
				break;

			}
			insercion.getLista().asignar(aux, k + 1);
			insercion.getSeries().getData().get(k + 1).setYValue(insercion.getLista().obtenerNodo(k + 1));

		}
	}

	public static void metodoSacudida(AtributosOrdenamiento sacudida) {

		int izq = 1;
		Integer k = sacudida.getLista().getLongitud();
		Integer der = sacudida.getLista().getLongitud();
		while (der >= izq) {
			for (int i = sacudida.getLista().getLongitud() - 1; i > 0; i--) {
				if (sacudida.getLista().obtenerNodo(i - 1) > sacudida.getLista().obtenerNodo(i)) {
					Integer aux = sacudida.getLista().obtenerNodo(i - 1);
					sacudida.getLista().asignar(sacudida.getLista().obtenerNodo(i), i - 1);
					sacudida.getLista().asignar(aux, i);
					String tmpEstilo = sacudida.getSeries().getData().get(i).getNode().getStyle();
					String tmpEstiloDos = sacudida.getSeries().getData().get(i - 1).getNode().getStyle();
					sacudida.getSeries().getData().get(i).getNode().setStyle(tmpEstiloDos);
					sacudida.getSeries().getData().get(i - 1).getNode().setStyle(tmpEstilo);
					sacudida.getSeries().getData().get(i).setYValue(sacudida.getLista().obtenerNodo(i));
					sacudida.getSeries().getData().get(i - 1).setYValue(sacudida.getLista().obtenerNodo(i - 1));
					k = i;
					break;
				}

			}
			izq = k + 1;
			for (int i = 0; i < sacudida.getLista().getLongitud(); i++) {
				if (sacudida.getLista().obtenerNodo(i - 1) > sacudida.getLista().obtenerNodo(i)) {
					Integer aux = sacudida.getLista().obtenerNodo(i - 1);
					sacudida.getLista().asignar(sacudida.getLista().obtenerNodo(i), i - 1);
					sacudida.getLista().asignar(aux, i);

					String tmpEstilo = sacudida.getSeries().getData().get(i).getNode().getStyle();
					String tmpEstiloDos = sacudida.getSeries().getData().get(i - 1).getNode().getStyle();
					sacudida.getSeries().getData().get(i).getNode().setStyle(tmpEstiloDos);
					sacudida.getSeries().getData().get(i - 1).getNode().setStyle(tmpEstilo);
					sacudida.getSeries().getData().get(i).setYValue(sacudida.getLista().obtenerNodo(i));
					sacudida.getSeries().getData().get(i - 1).setYValue(sacudida.getLista().obtenerNodo(i - 1));
					k = i;
					break;
				}

			}
			der = k - 1;
		}
	}

	public static void reduceRecursivo(int ini, int fin, ListaSimple<Integer> lista, AtributosOrdenamiento quickR) {

		int izq = ini;
		int der = fin;
		int pos = ini;
		boolean band = true;
		while (band == true) {
			band = false;
			while (lista.obtenerNodo(pos) <= lista.obtenerNodo(der) && pos != der) {
				der--;
			}
			if (pos != der) {
				Integer aux = lista.obtenerNodo(pos);
				lista.asignar(lista.obtenerNodo(der), pos); // swap
				lista.asignar(aux, der);
				String tmpEstilo = quickR.getSeries().getData().get(pos).getNode().getStyle();
				String tmpEstiloDos = quickR.getSeries().getData().get(der).getNode().getStyle();
				quickR.getSeries().getData().get(pos).getNode().setStyle(tmpEstiloDos);
				quickR.getSeries().getData().get(der).getNode().setStyle(tmpEstilo);
				quickR.getSeries().getData().get(pos).setYValue(lista.obtenerNodo(pos));
				quickR.getSeries().getData().get(der).setYValue(lista.obtenerNodo(der));
				pos = der;
				
				while (lista.obtenerNodo(pos) >= lista.obtenerNodo(izq) && pos != izq) {
					izq++;
				}
				if (pos != izq) {
					band = true;
					aux = lista.obtenerNodo(pos);
					lista.asignar(lista.obtenerNodo(izq), pos); // swap
					lista.asignar(aux, izq);
					String tmpEstiloTres = quickR.getSeries().getData().get(pos).getNode().getStyle();
					String tmpEstiloCuatro = quickR.getSeries().getData().get(izq).getNode().getStyle();
					quickR.getSeries().getData().get(pos).getNode().setStyle(tmpEstiloCuatro);
					quickR.getSeries().getData().get(izq).getNode().setStyle(tmpEstiloTres);
					quickR.getSeries().getData().get(pos).setYValue(lista.obtenerNodo(pos));
					quickR.getSeries().getData().get(izq).setYValue(lista.obtenerNodo(izq));
					pos = izq;
					break;
				}
			}
		}
		if ((pos - 1) > ini) {
			reduceRecursivo(ini, pos - 1, lista, quickR);
		}
		if (fin > (pos + 1)) {
			reduceRecursivo(pos + 1, fin, lista, quickR);
		}

	}

	public static void metodoQuickIterativo(AtributosOrdenamiento quickI) {
		Pila<Integer> pilaMayor = new Pila<>();
		Pila<Integer> pilaMenor = new Pila<>();

		pilaMenor.insertar(0);
		pilaMayor.insertar(quickI.getLista().getLongitud() - 1);
		int pos = 0;

		while (!pilaMayor.estaVacia() && !pilaMenor.estaVacia()) {
			try {
				int ini = pilaMenor.extraer();
				int fin = pilaMayor.extraer();

				pos = reduceIterativo(ini, fin, quickI.getLista(), quickI);
				if (ini < (pos - 1)) {
					pilaMenor.insertar(ini);
					pilaMayor.insertar(pos - 1);
				}
				if (fin > (pos + 1)) {
					pilaMenor.insertar(pos + 1);
					pilaMayor.insertar(fin);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	private static int reduceIterativo(int ini, int fin, ListaSimple<Integer> lista, AtributosOrdenamiento quickI) {
		int izq = ini;
		int der = fin;
		int pos = ini;
		boolean band = true;

		while (band == true) {
			while (lista.obtenerNodo(pos) <= lista.obtenerNodo(der) && pos != der) {
				der--;
			}

			if (pos == der) {
				band = false;
			} else {
				Integer aux = lista.obtenerNodo(pos);
				lista.asignar(lista.obtenerNodo(der), pos);
				lista.asignar(aux, der);
				String tmpEstilo = quickI.getSeries().getData().get(pos).getNode().getStyle();
				String tmpEstiloDos = quickI.getSeries().getData().get(der).getNode().getStyle();
				quickI.getSeries().getData().get(pos).getNode().setStyle(tmpEstiloDos);
				quickI.getSeries().getData().get(der).getNode().setStyle(tmpEstilo);
				quickI.getSeries().getData().get(pos).setYValue(lista.obtenerNodo(pos));
				quickI.getSeries().getData().get(der).setYValue(lista.obtenerNodo(der));
				pos = der;
				
				while (lista.obtenerNodo(pos) >= lista.obtenerNodo(izq) && pos != izq) {
					izq++;
				}
				if (pos == izq) {
					band = false;
				} else {
					aux = lista.obtenerNodo(pos);
					lista.asignar(lista.obtenerNodo(izq), pos);
					lista.asignar(aux, izq);
					String tmpEstiloTres = quickI.getSeries().getData().get(pos).getNode().getStyle();
					String tmpEstiloCuatro = quickI.getSeries().getData().get(izq).getNode().getStyle();
					quickI.getSeries().getData().get(pos).getNode().setStyle(tmpEstiloCuatro);
					quickI.getSeries().getData().get(izq).getNode().setStyle(tmpEstiloTres);
					quickI.getSeries().getData().get(pos).setYValue(lista.obtenerNodo(pos));
					quickI.getSeries().getData().get(izq).setYValue(lista.obtenerNodo(izq));
					pos = izq;
					break;
				}
			}
		}
		return pos;
	}
}
