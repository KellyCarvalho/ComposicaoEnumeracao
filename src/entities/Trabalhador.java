package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalhador;

public class Trabalhador {

	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salario;
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>(); 
	
	public Trabalhador() {
		
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salario, Departamento departamento) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
		this.departamento = departamento;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}


	

public List<ContratoPorHora> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoPorHora> contratos) {
		this.contratos = contratos;
	}

public void addcontrato(ContratoPorHora contrato) {
	
	contratos.add(contrato);
}

public void removeContrato(ContratoPorHora contrato) {
	contratos.remove(contrato);
}

public double calculo(int ano,int mes) {
	double sum = salario;
	Calendar cal =  Calendar.getInstance();
	
	
	for(ContratoPorHora h:contratos) {
		cal.setTime(h.getData());
		int h_ano=cal.get(Calendar.YEAR);
		int h_mes=1+cal.get(Calendar.MONTH);
		if(ano ==h_ano&&mes==h_mes) {
			sum+=h.valorTotal();
			
		}
	
	
	}
	return sum;
}
	
}
