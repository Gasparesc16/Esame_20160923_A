package it.polito.tdp.gestionale.model;

import java.util.HashMap;
import java.util.Map;

public class StudenteIdMap {
	
	private Map<Integer,Studente> mappa;

	public StudenteIdMap() {
		
		this.mappa = new HashMap<Integer,Studente>();
	}
	
	public Studente getStudente(Integer matricola){
		
		return mappa.get(matricola);
		
		
	}
	
	public Studente putStudente(Studente studente){
		
		Studente vecchio = mappa.get(studente.getMatricola());
		
		if(vecchio == null){
			
			mappa.put(studente.getMatricola(), studente);
			return studente;
		} else {
			
			return vecchio;
		}
		
		
		
	}

	/**
	 * @return the mappa
	 */
	public Map<Integer, Studente> getMappa() {
		return mappa;
	}
	
	

}
