import java.util.Scanner;

interface Correcion{
	Scanner input = new Scanner(System.in);
	
	public static int validacion() {
		int r = 0;
		boolean e = false;
		do {
			try {
				r = input.nextInt();
			} catch (java.util.InputMismatchException h) {
				System.out.println("Ups... Solo numeros porfavor, intenta de nuevo:");
				input.nextLine();
				e=true;
			}
			if (r>0) {
				e=false;
			}else {
				System.out.println("Solo numeros mayores a 0 por favor, intenta de nuevo:");
				e=true;
			}
		}while(e);
		return r;
	}
}




class Nodo{
	
	private Nodo nodoAnterior;
	private int dato;
	private Nodo nodoSiguiente;
	
	public Nodo(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoAnterior() {
		return nodoAnterior;
	}

	public void setNodoAnterior(Nodo nodoAnterior) {
		this.nodoAnterior = nodoAnterior;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	@Override
	public String toString() {
		return "Nodo [nodoAnterior=" + nodoAnterior + ", dato=" + dato + ", nodoSiguiente=" + nodoSiguiente + "]";
	}
	
}



class ListaDoblementeEnlazada{
	
	Nodo nodoInicio;
	Nodo nodoFin;
	
	
	public ListaDoblementeEnlazada() {}
	
	public boolean verificarListaVacia() {
			if(nodoInicio == null) {
				return true;
			}else {
				return false;
			}
		
	}
	
	
	public void agregarAlInicio(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		
		if(nodoInicio == null) {
			nodoInicio = nodoFin = nuevoNodo;
			
		}else {
			nuevoNodo.setNodoSiguiente(nodoInicio);
			nodoInicio.setNodoAnterior(nuevoNodo);
			nodoInicio = nuevoNodo;
		}
	}
	

	public void agregarAlFinal(int dato) {
		Nodo nodoNuevo = new Nodo(dato);
		
		if(verificarListaVacia()) {
			nodoInicio = nodoFin = nodoNuevo;
		}else {
			nodoFin.setNodoSiguiente(nodoNuevo);
			nodoFin = nodoNuevo;
		}
		
	}
	

	public void eliminarElementoInicio() {
		if(verificarListaVacia()) {
			System.out.println("La lista esta vacia, no se puede eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else{
			nodoInicio = nodoInicio.getNodoSiguiente();
			nodoInicio.getNodoAnterior();
		}
	}
	
	
	public void eliminarElementoFinal() {
		Nodo nodoActual = nodoInicio;
		
		if(verificarListaVacia()) {
			System.out.println("La lista esta vacia, no se puede eliminar");
		}else if(nodoInicio == nodoFin) {
			nodoInicio = nodoFin = null;
		}else {
			while(nodoActual.getNodoSiguiente() != nodoFin) {
				nodoActual = nodoActual.getNodoSiguiente();
			}
			nodoActual.setNodoSiguiente(null);
			nodoFin = nodoActual;
		}
	}
	
	
	public int eliminarDatoEspecifico(int dato) {
		if(nodoInicio == null) {
			return -1;
		}else if(nodoInicio == nodoFin && nodoInicio.getDato() == dato) { 
			System.out.println("encontrado en el primero NODO");
			int n = nodoInicio.getDato();
			nodoInicio = nodoFin = null;
			return n;
		}else {
			Nodo nodoAnterior, nodoSiguiente;
			nodoAnterior = nodoInicio;
			nodoSiguiente = nodoInicio.getNodoSiguiente();
			
			while(nodoSiguiente != null && nodoSiguiente.getDato() != dato) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
			}
			
			if(nodoSiguiente != null && nodoSiguiente.getDato() == dato) {
				int n = nodoSiguiente.getDato();
				nodoAnterior.setNodoSiguiente(nodoSiguiente.getNodoSiguiente());
				nodoSiguiente = nodoSiguiente.getNodoSiguiente();
				
				return n;
			}else {
				return -2;
			}
		}
		
	}
	
	
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		
		while(nodoActual != null) {
			System.out.print("<--- [" + nodoActual.getDato() + "]---> " );
			nodoActual = nodoActual.getNodoSiguiente();
		}
		System.out.println();
	}
}











public class PruebaListasDoblementeEnlazadas {

	public static void main(String[] args) {
ListaDoblementeEnlazada lde = new ListaDoblementeEnlazada();
		
		int opcion;
		int dato = 0;
		do {
			System.out.println("=============== MENU ===============");
			System.out.println("Digite 1 para añadir dato al inicio");
			System.out.println("Digite 2 para añadir dato al final");
			System.out.println("Digite 3 para eliminar dato al inicio");
			System.out.println("Digite 4 para eliminar dato al final");
			System.out.println("Digite 5 para eliminar dato especifico");
			System.out.println("Digite 6 para mostrar la lista");
			System.out.println("Digite 7 para ***SALIR***");
			opcion = Correcion.validacion();
			
			switch (opcion) {
				
			
			case 1:
				System.out.println("Ingresa el dato a insertar:");
				dato = Correcion.validacion();
				lde.agregarAlInicio(dato);
				break;
			case 2: 
				System.out.println("Ingresa el dato a insertar:");
				dato = Correcion.validacion();
				lde.agregarAlFinal(dato);
				break;
			case 3:
				lde.eliminarElementoInicio();
				break;
			case 4:
				lde.eliminarElementoFinal();
				break;
			case 5: 
				System.out.println("Ingrese el dato a eliminar");
				dato = Correcion.validacion();	
				int num = lde.eliminarDatoEspecifico(dato);
				
				if(num == -1)
					System.out.println("Lista vacia");
				else if(num == -2)
					System.out.println("No se encontró el dato");
				else
					System.out.println("Se eliminó el " + num + " correctamente");
				break;
			case 6: 
				lde.mostrarElementos();
				break;
			case 7:
				System.out.println("Gracias por usar el progrma");
				break;
			}
		
		}while(opcion!=7);

	}

}
