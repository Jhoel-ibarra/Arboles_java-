/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles.Arboles.ui;

import com.mycompany.arboles.Arboles.ArbolBinarioBusqueda;
import com.mycompany.arboles.Arboles.IArbolBusqueda;

/**
 *
 * @author JHOEL
 */
public class testArbol {
    public static void main(String[] argumentos) {
        IArbolBusqueda<Integer, String> arbolPrueba = new ArbolBinarioBusqueda<>();
        
        
        arbolPrueba.insertar(10, "azul");
        arbolPrueba.insertar(5, "cafe");
        arbolPrueba.insertar(15, "blanco");
        arbolPrueba.insertar(2, "verde");
        arbolPrueba.insertar(8, "lila");
        arbolPrueba.insertar(13, "naranja");  
        arbolPrueba.insertar(18, "negro");
        arbolPrueba.insertar(3, "negro");
        arbolPrueba.insertar(11, "negro");
        arbolPrueba.insertar(14, "negro");
        arbolPrueba.insertar(16, "negro");
        arbolPrueba.insertar(20, "negro");
  
        
       // System.out.println(arbolPrueba);
       // System.out.println("hola " + arbolPrueba.cantidaDeHijosIzquierdos());
       // System.out.println("hola  assxas " + arbolPrueba.cantidaDeHijosDerechos());
         System.out.println("recorrido en preOrden " + arbolPrueba.recorridoPreOrden());
       // System.out.println("recorrido en posOrden " + arbolPrueba.recorridoEnPostOrden());
       // System.out.println("recorrido en intOrden " + arbolPrueba.recorridoEnInOrden());
       // System.out.println("recorrido por nivel" + arbolPrueba.recorridoPorNiveles());
       // System.out.println("altura " + arbolPrueba.altura());
       // System.out.println("cantidad De hijos Derechos " + arbolPrueba.cantidaDeHijosDerechos());
       // System.out.println("cantidad de hijos izquierdo "+ arbolPrueba.cantidaDeHijosIzquierdos());
       // System.out.println("cantidad de nodos de un arbol " + arbolPrueba.size());
       // System.out.println("cantidad de nodos de un arbol " + arbolPrueba.altura());
       // System.out.println("nivel de un arbol " + arbolPrueba.nivel());
       // System.out.println("tiene nodo completos  " + arbolPrueba.tieneNodosCompletosEnNivel(2));
       // System.out.println( "sdadadasd "+ arbolPrueba.contarNodosConAmbosHijosDadoUnNivel(0)); //codigo imcompleto 
       // System.out.println("daasdadadada " + arbolPrueba.buscarNodo(2));
       // System.out.println("asdadaaaaaaaaaaaaaa "+arbolPrueba.sizeRecursivo() );
       // System.out.println("asdadaaaaaaaaaaaaaa "+arbolPrueba.elPadreMasCercano(10, 2));
       
        System.out.println( "asdads " + arbolPrueba.eliminar(15));
        System.out.println("recorrido en preOrden " + arbolPrueba.recorridoPreOrden());
        
    }
    
    
}
