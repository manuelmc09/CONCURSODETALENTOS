package com.dawjava.servicios;

import java.util.ArrayList;

import com.dawjava.entidades.Candidatos;
import com.dawjava.entidades.Individual;
import com.dawjava.entidades.Persona;

public interface ServiciosCandidatos {

	public boolean inscripcionCandidato(Candidatos c);

	public int asignarIdcandidato(Candidatos c);

}
