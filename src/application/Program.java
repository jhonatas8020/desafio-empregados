package application;

import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String nameDp = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int dayPg = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Department department = new Department(nameDp, dayPg, new Address(email, phone));
		
		System.out.print("Quantos funcion�rios tem o departamento? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Dados do funcion�rio " + (i + 1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Sal�rio: ");
			double salary = sc.nextDouble();
			
			department.addEmployee(new Employee(name, salary));
		}
		
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		showReport(department);
		
		sc.close();
	}
	
	private static void showReport(Department department) {
		System.out.printf("Departamento %s = R$ %.2f%n", department.getName(), department.payroll());
		System.out.println("Pagamento realizado no dia " + department.getPayDay());
		System.out.println("Funcion�rios:");
		for(Employee e : department.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.println("Para d�vidas favor entrar em contato: " + department.getAddress().getEmail());
	}

}
