package mx.com.ilusion.dos.clientes.anfexi;
/*********************************************************************************************************
 * *
 * *
 * * Ejercicio Para GNP  Gustavo Vargas. 
 * * De acuerdo con la entrevistase solicito:
 * * Hacer un Metodo que regrese el nivel de un arbol (Tree), el cual puede ser a consideracion del Programador.
 * * Se Utilizo un Arbol Binario para ejemplizar el Ejercicio.
 * * Se creo el Metodo GeneraNiverlArbol el cual su salida en Int nos proporciona el nivel final del arbol.
 * * Para generar hacer el ejemplo, se creo un objeto de tipo arbol el cual genera despues de estar lleno, hace el conteo de sus niveles. 
 * * Al final el objeto ArbolPrincipal contiene tanto los niveles, como las funciones para agregar y contarlos.
 * *
 * *
 * *
 * *    Creado por : Jose Miguel Rodriguez Solano.
 *********************************************************************************************************/


import java.util.Scanner;

public class ArbolPrincipal {
		    	  
	// Se declaran las variables para completar la funcionalidad de Conteo de Niveles de Arbol.
	
    private Nivel raiz;
    int cant;
    int altura;

    public ArbolPrincipal() {
        this.raiz = null;
    }
    
    public void agregar(int dato) {
        Nivel nuevo = new Nivel(dato, null, null);
        insertar(nuevo, raiz);
    }

    public void insertar(Nivel nuevo, Nivel pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {
                    pivote.setIzq(nuevo);
                } else {
                    insertar(nuevo, pivote.getIzq());
                }
            } else {
                if (pivote.getDer() == null) {
                    pivote.setDer(nuevo);
                } else {
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    //metodos nuevos
    public boolean existe(int info) {
        Nivel reco = raiz;
        while (reco != null) {
            if (info == reco.getDato()) {
                return true;
            } else if (info > reco.getDato()) {
                reco = reco.getDer();
            } else {
                reco = reco.getIzq();
            }
        }
        return false;
    }

    public int cantidad() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }

    private void cantidad(Nivel reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.getIzq());
            cantidad(reco.getDer());
        }
    }

    private void cantidadNivelsHoja(Nivel reco) {
        if (reco != null) {
            if (reco.getIzq() == null && reco.getDer() == null) {
                cant++;
            }
            cantidadNivelsHoja(reco.getIzq());
            cantidadNivelsHoja(reco.getDer());
        }
    }

    public int cantidadNivelsHoja() {
        cant = 0;
        cantidadNivelsHoja(raiz);
        return cant;
    }

    public int retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    private void retornarAltura(Nivel reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDer(), nivel + 1);
        }
    }

    public void menorValor() {
        if (raiz != null) {
            Nivel reco = raiz;
            while (reco.getIzq() != null) {
                reco = reco.getIzq();
            }
            System.out.println("Menor valor del árbol:" + reco.getDato());
        }
    }

    public void mayorValor() {
        if (raiz != null) {
            Nivel reco = raiz;
            while (reco.getDer() != null) {
                reco = reco.getDer();
            }
            System.out.println("Mayor valor del árbol:" + reco.getDato());
        }
    }

    int subizq = 0;
    int subder = 0;


    //Niveles del arbol
    String[] niveles;

    //* Se creo el Metodo GeneraNiverlArbol el cual su salida en Int nos proporciona el nivel final del arbol.
    
    public int GeneraNiverlArbol() {
        altura = 0;
        GeneraNiverlArbol(raiz, 0);
        return altura;
    }

    private void GeneraNiverlArbol(Nivel pivote, int nivel) {
        if (pivote != null) {
        	GeneraNiverlArbol(pivote.getIzq(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            GeneraNiverlArbol(pivote.getDer(), nivel + 1);
        }
    }
    //* * * * * * * * * *
 
    //Se crea el objeto Nivel, el cual contendra la informacion del nivel del arbol.
		public class Nivel {

		    private int dato;
		    private Nivel izq, der;

		    public Nivel(int dato, Nivel izq, Nivel der) {
		        this.dato = dato;
		        this.izq = izq;
		        this.der = der;
		    }

		    public int getDato() {
		        return dato;
		    }

		    public void setDato(int dato) {
		        this.dato = dato;
		    }

		    public Nivel getIzq() {
		        return izq;
		    }

		    public void setIzq(Nivel izq) {
		        this.izq = izq;
		    }

		    public Nivel getDer() {
		        return der;
		    }

		    public void setDer(Nivel der) {
		        this.der = der;
		    }
 }
		
		
		// Se crea un Metodo main para Ejecutar la creacion del Arbol y el conteo de Niveles.
		
		public static void main(String[] arg) {
			ArbolPrincipal abo = new ArbolPrincipal();
	        int var;
	        int valor;
	        Scanner texto = new Scanner(System.in);
	        
	        System.out.println(" Insertando Valores Ramdom : ");
	        for (int i = 1; i <= 10; i++) {
	            valor = (int) (Math.random() * 100);
	            System.out.print(valor + " ");
	            abo.agregar(valor);
	        
	        }	        
	       
	        do {	        
	            System.out.println(" ");
	            System.out.println(" ");
	            System.out.println("1.- Cantidad de niveles del arbol");
	            System.out.println("0.- Salir");
	            var = texto.nextInt();
	            switch (var) {
	                case 1:
	                    System.out.println("Cantidad de niveles del árbol:" + abo.GeneraNiverlArbol());
	                    break;	                	                
	            }
	        } while (var != 0);

	    }

}
