package com.cursoceat.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cursoceat.main.Contactos;

public class Menu extends Contactos {
   static ArrayList <Contactos> agenda=new ArrayList<Contactos>();
	
	static public void miMenu() {
		int opcion;
		do {
			System.out.println("\tAgenda Electronica");
			System.out.println("\t_________________");
			System.out.println("\t1- Alta");
			System.out.println("\t2- Buscar");
			System.out.println("\t3- Mostrar");
			System.out.println("\t4- Salir");
			System.out.println("\t_________________");
			System.out.print("\tSeleccion:");
			opcion=new Scanner(System.in).nextInt();
			switch(opcion) {
			case 1:
				alta();
				break;
			case 2:
				buscar();
				break;
			case 3:
				mostrar();	
				break;
			default:
				System.out.println("ERROR. Tu selección es incorrecta..");
				break;
			}
						
		}while(opcion!=4);
	}
		
		
		static void alta() {
			String nombre;
			String telefono;
			do {
				System.out.println("\tIndique el nombre del Contacto: ");
				nombre=new Scanner(System.in).nextLine();
			}while(nombre.isEmpty());
			nombre=pasarMayuscula(nombre);
			do {
				System.out.println("\tIndique el teléfono del Contacto: ");
				telefono=new Scanner(System.in).nextLine();
			}while(ValidarTelefono(telefono));
			//Aqui tenemos que crear un objeto y guardar los datos que hemos capturado
			Contactos unCtto=new Contactos(nombre,telefono);
			agenda.add(unCtto);

     }
		
		static void buscar() {
	     String nombre;
	     boolean encontrado=false;
	     do {
				System.out.println("\tIndique el nombre a buscar: ");
				nombre=new Scanner(System.in).nextLine();
			}while(nombre.isEmpty());
			nombre=pasarMayuscula(nombre);
			for(Contactos c:agenda) {
				String nombreAgenda=c.getNombre();
				if(nombreAgenda.startsWith(nombre)) {
				System.out.println("\t"+c.getNombre() + "\t("+c.getTelefono()+")");
				encontrado=true;
			}
			}
			if (!encontrado) {
				System.out.println("\tEl contacto buscado no existe");
				
			}
     }
      
		static void mostrar() {
			for(Contactos c:agenda) {
				System.out.println("\t"+c.getNombre() + "\t("+c.getTelefono()+")");
				
			}
	}
		
		//metodo que pasa Capitaliza las Cadenas
		static String pasarMayuscula(String cadena) {
			String[] arrayCadena=cadena.split(" ");
			String temporal="";
			for(int i=0;i<arrayCadena.length;i++) {
				arrayCadena[i]=arrayCadena[i].substring(0,1).toUpperCase()+arrayCadena[i].substring(i).toLowerCase();
				temporal+=arrayCadena[i]+" ";	
			}
			return temporal;	
		}
		
		static boolean ValidarTelefono(String telefono) {
			boolean correcto=false;
			if((!telefono.startsWith("9") && !telefono.startsWith("6") && !telefono.startsWith("7")) || telefono.length()!=9) {
				correcto=true;
			}
			return correcto;
		}
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
