import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 
		System.out.println("Informe o nome do departamento");
		String departamento =sc.nextLine();
		System.out.println("Dados do trabalhador");
		System.out.println("Informe o nome do trabalhador");
		String trabalhador_nome = sc.nextLine();
		System.out.println("N�vel ");
		String nivel = sc.nextLine();
		System.out.println("Sal�rio: ");
		double salario = sc.nextDouble();		
	
		Trabalhador trabalhador= new Trabalhador(trabalhador_nome,NivelTrabalhador.valueOf(nivel),salario,new Departamento(departamento));

		System.out.println("Quantos contratos? ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			
			System.out.println("Entre com o "+1+" contrato");
			System.out.println("Data DD/MM/YYY");
			Date contratoData = sdf.parse(sc.next());
			System.out.println("Valor Por hora: ");
			double valor = sc.nextDouble();
			System.out.println("Dura��o de horas");
			int horas=sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(contratoData,valor,horas);
			trabalhador.addcontrato(contrato);
			
		}
		
		System.out.println();
		
		System.out.println("Informe o m�s e ano para calcular o sal�rio: MM/YYYY");
		String mesAno =sc.next();
		int mes=Integer.parseInt(mesAno.substring(0, 2));
		int ano =Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: "+trabalhador.getNome());
		System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
		System.out.println("N�vel: "+trabalhador.getNivel());
		System.out.println("Valor Total do sal�rio no m�s e ano: "+String.format("%.2f",trabalhador.calculo(ano, mes) ));
		
		sc.close();

	}

}
