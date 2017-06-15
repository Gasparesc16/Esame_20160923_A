package it.polito.tdp.gestionale.model;

public class Nodo {
	
	private Studente student;
	private Corso corso;
	

		/**
		 * @return the student
		 */
		public Studente getStudent() {
			return student;
		}

		/**
		 * @return the corso
		 */
		public Corso getCorso() {
			return corso;
		}

		/**
		 * @param student the student to set
		 */
		public void setStudent(Studente student) {
			this.student = student;
		}

		/**
		 * @param corso the corso to set
		 */
		public void setCorso(Corso corso) {
			this.corso = corso;
		}
	

}
