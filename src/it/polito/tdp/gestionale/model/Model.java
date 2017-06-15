package it.polito.tdp.gestionale.model;


import java.util.ArrayList;
import java.util.List;


import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.gestionale.db.DidatticaDAO;

public class Model {

	private List<Corso> corsi;
	private List<Studente> studenti;
	
	private DidatticaDAO didatticaDAO;
	private SimpleGraph<Nodo, DefaultEdge> grafo;
	
	//private Map<Integer, Studente> mappaStudenti;
	private StudenteIdMap mappaStudenti;

	public Model() {
		
		this.didatticaDAO = new DidatticaDAO();
		
		//mappaStudenti = new HashMap<Integer,Studente>();
		mappaStudenti = new StudenteIdMap();

	}
	
	public void creaGrafo() {
		
		// Collect info
		corsi = this.getTuttiCorsi();
		studenti = this.getTuttiStudenti();
		
		
		// Inizializzazione
		grafo = new SimpleGraph<Nodo, DefaultEdge>(DefaultEdge.class);
		
		
		// Aggiungo i vertici al grafo
		Graphs.addAllVertices(grafo, corsi);
		Graphs.addAllVertices(grafo, studenti);
	
		
		// Aggiungo gli archi al grafo
		for(Corso c: corsi){
			
			for(Studente s: c.getStudenti())
				grafo.addEdge(c, s);
		}
		
		
		
	}
	
	public SimpleGraph<Nodo, DefaultEdge> getGrafo() {
		
		if(grafo == null)
			this.creaGrafo();
		
		return grafo;
	}

	/**
	 * @return the corsi
	 */
	public List<Corso> getTuttiCorsi() {
		
		if(this.corsi == null){
			this.corsi = didatticaDAO.getTuttiICorsi();
			
			// Trick!
						getTuttiStudenti();
						for (Corso corso : corsi) {
							didatticaDAO.setStudentiIscrittiAlCorso(corso, mappaStudenti.getMappa());
						}
		}
			
		return corsi;
	}

	/**
	 * @return the studenti
	 */
	public List<Studente> getTuttiStudenti() {
		
		if(this.studenti == null){
			this.studenti = didatticaDAO.getTuttiStudenti();
			
			for(Studente s: studenti)
				mappaStudenti.putStudente(s);
		}
		
		return studenti;
	}
	
	public List<String> getCorsiFrequentati() {

		List<String> frequenze = new ArrayList<String>();
/*
		// Inizializzo la struttura dati dove salvare le statistiche
		for (int i = 0; i < corsi.size() + 1; i++) {
			frequenza.add(0);
		}

		// Aggiorno le statistiche
		for (Studente studente : studenti) {
			int ncorsi = Graphs.neighborListOf(grafo, studente).size();
			int counter = frequenza.get(ncorsi);
			counter++;
			frequenza.set(ncorsi, counter);
		}*/
		
		
		for(Corso c: corsi){
			
			String ris = "Il corso " + c.getNome() + " é frequentato da: " + c.getStudenti().size() + " studenti";
			frequenze.add(ris);
		}

		return frequenze;
		
	}
	
	
	
	
	
	
	
	
	
	
}
