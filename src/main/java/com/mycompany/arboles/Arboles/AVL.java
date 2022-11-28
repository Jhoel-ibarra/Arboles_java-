/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles.Arboles;

/**
 *
 * @author JHOEL
 */
public class AVL< k extends Comparable<k>, v> extends ArbolBinarioBusqueda<k,v> {
    private static final byte Diferencia_Maxima =1;
    
    public void insertar(k claveInsertar, v valorInsertar) {
     if(claveInsertar == null){
      throw new IllegalArgumentException("la clave no puede ser nula");
     }
     if(valorInsertar == null){
      throw new IllegalArgumentException("el valor no puede ser nula");
     }
     super.raiz = this.insertar(this.raiz,claveInsertar,valorInsertar);
     
    }
    
    private NodoBinario<k, v> insertar(NodoBinario<k, v> nodoActual, 
            k claveInsertar, v valorInsertar){
      
        if(NodoBinario.esNodoVacio(nodoActual)){
          NodoBinario<k, v> nuevoNodo= new NodoBinario(claveInsertar, valorInsertar);
          return nuevoNodo;
        }
        k claveActual = nodoActual.getClave();
        if( claveInsertar.compareTo(claveActual) > 0){
          NodoBinario<k ,v> supuestoNuevoHijoDerecho = insertar(nodoActual.getHijoDerecho(),
                  claveInsertar,valorInsertar);
          nodoActual.setHijoDerecho(supuestoNuevoHijoDerecho);
          return this.balancear(nodoActual);
        }
        if( claveInsertar.compareTo(claveActual) < 0){
          NodoBinario<k ,v> supuestoNuevoHijoIzquierdo = insertar(nodoActual.getHijoIzquierdo(),
                  claveInsertar,valorInsertar);
          nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzquierdo);
          return this.balancear(nodoActual);
        }
        /// si llega aka es decir q es la misma clave 
        nodoActual.setValor(valorInsertar);
        return this.balancear(nodoActual);
    }
    
    private NodoBinario<k,v> balancear(NodoBinario<k ,v> nodoActual){
        int alturaRamaIzquierda = altura(nodoActual.getHijoIzquierdo());
        int alturaRamaDerecho = altura(nodoActual.getHijoDerecho());
        int diferencia = alturaRamaIzquierda - alturaRamaDerecho;
        if( diferencia > Diferencia_Maxima){
          /// si hay q balancear
          NodoBinario<k ,v> hijoIzquierdo = nodoActual.getHijoIzquierdo();
          alturaRamaDerecho   = altura(hijoIzquierdo.getHijoDerecho());
          alturaRamaIzquierda = altura(hijoIzquierdo.getHijoIzquierdo());
          if(alturaRamaDerecho > alturaRamaIzquierda){
          return  rotacionDobleDerecho(nodoActual);
          } else {
            return rotacionSimpleIzquierdo(nodoActual);
          }  
        }  else if (diferencia < -Diferencia_Maxima  ){
            /// completar
          NodoBinario<k ,v> hijoDerecho = nodoActual.getHijoDerecho();
          alturaRamaDerecho   = altura(hijoDerecho.getHijoDerecho());
          alturaRamaIzquierda = altura(hijoDerecho.getHijoIzquierdo());
            if( alturaRamaIzquierda > alturaRamaDerecho ){
              return rotacionDobleIzquierdo(nodoActual);
            }else {
             return rotacionSimpleDerecha(nodoActual);
            }
        }
       
        return nodoActual;
    }
    
    private NodoBinario<k, v> rotacionSimpleIzquierdo(NodoBinario<k,v> nodoActual){
      NodoBinario<k, v> nodoQueRota = nodoActual.getHijoIzquierdo();
      nodoActual.setHijoIzquierdo(nodoQueRota.getHijoDerecho());
      nodoQueRota.setHijoDerecho(nodoActual);
      return nodoQueRota;
    }
    
     private NodoBinario<k, v> rotacionDobleIzquierdo(NodoBinario<k,v> nodoActual){
      //NodoBinario<k ,v> nodoQueRotaIzquierda =rotacionSimpleIzquierdo(nodoActual);
      nodoActual.setHijoIzquierdo(rotacionSimpleDerecha(nodoActual.getHijoIzquierdo()));
      return this.rotacionSimpleIzquierdo(nodoActual);
     }
     private NodoBinario<k, v> rotacionSimpleDerecha(NodoBinario<k,v> nodoActual){
         NodoBinario<k, v> nodoQueRota = nodoActual.getHijoDerecho();
         nodoActual.setHijoDerecho(nodoQueRota.getHijoIzquierdo());
         nodoQueRota.setHijoIzquierdo(nodoActual);
      return nodoQueRota;
     }
     
     private NodoBinario<k, v> rotacionDobleDerecho(NodoBinario<k,v> nodoActual){
         nodoActual.setHijoDerecho(rotacionDobleIzquierdo(nodoActual.getHijoDerecho()));
         return this.rotacionSimpleDerecha(nodoActual);
     }
     
   
   public v eliminar( k claveEliminar ){
       
       if( claveEliminar == null){
       throw new IllegalArgumentException("la clave a eliminar no puede ser nula");
       }
       v  valorBuscar = buscar(claveEliminar);
       
       if( valorBuscar == null){
          throw new IllegalArgumentException("la clave que desea eliminar no se encuentra en el arbol");
       }
       raiz = eliminar( raiz , claveEliminar);
   return null;
   }
   
 
    @Override
    NodoBinario<k,v> eliminar(NodoBinario<k ,v> nodoActual, k claveElinar){
        
        k claveActual = nodoActual.getClave();
        
        if( claveActual.compareTo(claveElinar) > 0 ){
        NodoBinario<k,v> posibleHermano = eliminar(nodoActual.getHijoIzquierdo(), claveElinar);
        nodoActual.setHijoIzquierdo(posibleHermano);
         return this.balancear(nodoActual);
        }
        if( claveActual.compareTo(claveElinar) < 0 ){
        NodoBinario<k,v> posibleHermano = eliminar(nodoActual.getHijoDerecho(), claveElinar);
         nodoActual.setHijoDerecho(posibleHermano);
         return this.balancear(nodoActual);
        }
        
        // caso 1 
        if( nodoActual.esHoja()){
           return (NodoBinario<k,v>)NodoBinario.nodoVacio();
        }
        // caso 2 si tiene dos hijos 
        // 2.1 si solo tiene hijo izquierdo
        if( nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()){
          return nodoActual.getHijoIzquierdo();
        }
        // 2.2 si solo tiene hijo derecho
        if( nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
          return nodoActual.getHijoDerecho();
        }
        
        NodoBinario<k ,v> nodoSustituto = sustituto(nodoActual);
        NodoBinario<k , v> posibleHijoDereche = eliminar(nodoActual.getHijoDerecho() , nodoSustituto.getClave()); 
        
        nodoActual.setClave(nodoSustituto.getClave());
        nodoActual.setValor(nodoSustituto.getValor());
        
        nodoActual.setHijoDerecho(posibleHijoDereche);
     return  this.balancear(nodoActual);
      
    } 
    
    protected NodoBinario<k ,v > sustituto(NodoBinario<k ,v> nodoActual){
      while(!nodoActual.esVacioHijoIzquierdo()){
        nodoActual = nodoActual.getHijoIzquierdo();
      }
      return nodoActual;
    }
    
}
