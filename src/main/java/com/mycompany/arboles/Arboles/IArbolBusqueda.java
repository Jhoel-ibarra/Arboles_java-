/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.arboles.Arboles;

import java.util.List;

/**
 *
 * @author JHOEL
 */
public interface IArbolBusqueda <k extends Comparable <k>,v> {
    void vaciar();
    boolean esArbolVacio();
    int size();
    int sizeRecursivo();
    int cantidaDeHijosDerechos();
    int cantidaDeHijosIzquierdos();
    int altura();
    int nivel();
    k minimo();
    k maximo();
    k elPadreMasCercano(k claveActual,k claveHermano);
    int contarNodosConAmbosHijosDadoUnNivel(int nivel);
   void insertar(k clave, v valor);
   public boolean buscarNodo( k claveEliminar);
   boolean buscarNodo( k claveEliminar, NodoBinario<k,v> actual);
   v eliminar (k clave);
   boolean tieneNodosCompletosEnNivel(int nivelObjetivo);
   boolean tieneNodosCompletosEnNivel(NodoBinario<k, v> nodoActual,int nivelObjetivos, int nivelActual);
   boolean contiene(k clave);
   int cantidadEscalera();
   int cantidadEscalera(NodoBinario<k , v> nodoActual, int cantidad);
   v buscar(k clave);
   List<k> recorridoEnInOrden();
   List<k> recorridoPreOrden();
   List<k> recorridoEnPostOrden();
   List<k> recorridoPorNiveles();
    
}
