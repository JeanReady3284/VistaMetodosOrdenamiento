package application;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class AtributosOrdenamiento {

	private ListaSimple<Integer> lista = new ListaSimple<>();

	private XYChart.Series<String, Number> series;
	private final CategoryAxis xAxis = new CategoryAxis();
	private final NumberAxis yAxis = new NumberAxis();
	private final String[] color = { "-fx-bar-fill: green", "-fx-bar-fill: red", "-fx-bar-fill: blue", "-fx-bar-fill: yellow" };
	private ScheduledExecutorService scheduledExecutorService;
	
	public ListaSimple<Integer> getLista() {
		return lista;
	}
	public void setLista(ListaSimple<Integer> lista) {
		this.lista = lista;
	}
	public XYChart.Series<String, Number> getSeries() {
		return series;
	}
	public void setSeries(XYChart.Series<String, Number> series) {
		this.series = series;
	}
	public ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}
	public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}
	public CategoryAxis getxAxis() {
		return xAxis;
	}
	public NumberAxis getyAxis() {
		return yAxis;
	}
	public String[] getColor() {
		return color;
	}
	public String devuelveColorA() {
		return color[new Random().nextInt(4)];
	}
	
}
