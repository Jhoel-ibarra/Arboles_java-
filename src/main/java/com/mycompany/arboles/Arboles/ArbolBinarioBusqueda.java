/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles.Arboles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author JHOEL
 */
public class ArbolBinarioBusqueda <k extends Comparable<k>, v> implements 
        IArbolBusqueda<k, v>{
    
    protected NodoBinario <k,v> raiz;

    @Override
    public void vaciar() {
       this.raiz = (NodoBinario<k ,v>)NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
      return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public int size() {
      if(this.esArbolVacio()){
       return 0; }
      int cantidadDeNodos =0;
      Stack<NodoBinario<k,v>> pilaDeNodos =new Stack<>();
      pilaDeNodos.push(this.raiz);
      while(!pilaDeNodos.isEmpty()){
        NodoBinario<k,v> nodoActual = pilaDeNodos.pop();
          cantidadDeNodos++;
         if(!nodoActual.esVacioHijoDerecho()){
         pilaDeNodos.push(nodoActual.getHijoDerecho()); }
         if(!nodoActual.esVacioHijoIzquierdo()){
         pilaDeNodos.push(nodoActual.getHijoIzquierdo()); }
      }
        return cantidadDeNodos; }
    
    @Override
    public int sizeRecursivo(){
      if(this.esArbolVacio()){
        return 0;
      }
      int cantidadDeNodos = 0;
      return sizeRecursivo(this.raiz, cantidadDeNodos);
        
    }
    
    public int sizeRecursivo(NodoBinario nodoActual, int cantidadDeNodos){

        if(!nodoActual.esVacioHijoIzquierdo()){
        cantidadDeNodos = sizeRecursivo(nodoActual.getHijoIzquierdo(), cantidadDeNodos);
        }
        if(!nodoActual.esVacioHijoDerecho()){
        cantidadDeNodos =   sizeRecursivo(nodoActual.getHijoDerecho(), cantidadDeNodos);
        }
        
    return cantidadDeNodos+1;
    }
    @Override
    public k elPadreMasCercano(k claveActual , k claveHermano){
       if(this.esArbolVacio()){
       return null;
       }
       // estamos buscando si el codigo existe
       if(buscar(claveActual) == null || buscar(claveHermano)== null  ){
          throw new IllegalArgumentException("los nodos no se encuentra en el arbol");
       }
       if(claveActual == claveHermano){
           return claveActual;
       }
       return elPadreMasCercano(claveActual, claveHermano, this.raiz);
    
    }
            
   public k elPadreMasCercano(k claveActual, k claveHermano , NodoBinario<k ,v> nodoPadre ){
    if(claveActual.compareTo(nodoPadre.getClave()) <= 0 && claveHermano.compareTo(nodoPadre.getClave()) > 0){
       return nodoPadre.getClave();
    }
    if(claveActual.compareTo(nodoPadre.getClave()) >= 0 && claveHermano.compareTo(nodoPadre.getClave()) < 0){
       return nodoPadre.getClave();
    }
     if (claveActual.compareTo(nodoPadre.getClave()) < 0 ){
       return elPadreMasCercano(claveActual, claveHermano, nodoPadre.getHijoIzquierdo());
       } else {
        return elPadreMasCercano(claveActual, claveHermano, nodoPadre.getHijoDerecho()); 
    }
    
   }
   
   
   // codigo incompleto 
    @Override
     public int contarNodosConAmbosHijosDadoUnNivel(int nivel){///este codigo no funciona bien 
      if(this.esArbolVacio()){
       throw new IllegalArgumentException("los nodos no se encuentra en el arbol");
       } 
      if(this.nivel() < nivel){
        throw new IllegalArgumentException("el arbol no tiene ese nivel intente con otro nivel");
      }
      Queue<NodoBinario<k , v>> colaDeNodos = new LinkedList<>();

      colaDeNodos.add(this.raiz);
      int contadorDeNivel = 0;
      int contadorNodosCompletos = 0;
    
      while( !colaDeNodos.isEmpty()){
         
         NodoBinario<k,v> nodoActual = colaDeNodos.poll();
         
         if( contadorDeNivel >= nivel && !NodoBinario.esNodoVacio(nodoActual.getHijoDerecho()) && !NodoBinario.esNodoVacio(nodoActual.getHijoIzquierdo())){
             contadorNodosCompletos++;
             contadorDeNivel--;
             
         } 
         if(contadorDeNivel == nivel) {contadorDeNivel++; } 
         else{
        if(!NodoBinario.esNodoVacio(nodoActual.getHijoIzquierdo())){
          colaDeNodos.add(nodoActual.getHijoIzquierdo());
          }
        
        if(!NodoBinario.esNodoVacio(nodoActual.getHijoDerecho())){
          colaDeNodos.add(nodoActual.getHijoDerecho()); 
           }
        contadorDeNivel++;
           }
      }
      return contadorNodosCompletos;
     }
     
   // 
   
   
    @Override
    public int cantidaDeHijosDerechos(){
    return cantidaDeHijosDerechos(this.raiz.getHijoDerecho());
    }
    
    public int cantidaDeHijosDerechos(NodoBinario<k ,v> nodoActual){
     if(NodoBinario.esNodoVacio(nodoActual)){
     return 0;
       }
     int hdPorRamaIzquierda = cantidaDeHijosDerechos(nodoActual.getHijoIzquierdo());
     int hdPorRamaderecho = cantidaDeHijosDerechos(nodoActual.getHijoDerecho());
     return hdPorRamaIzquierda+ hdPorRamaderecho+1;
    }
    @Override
     public int cantidaDeHijosIzquierdos(){
         return cantidadHijosIzquierdos(this.raiz.getHijoIzquierdo());
     }
     
     public int cantidadHijosIzquierdos(NodoBinario< k ,v> nodoActual){
          return cantidaDeHijosDerechos(nodoActual);
     }

    @Override
    public int altura() {
      return altura(this.raiz);
    }
    
    public int altura(NodoBinario<k,v> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
         return 0;
        }
        int alturaPorIzquierda = altura(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha = altura(nodoActual.getHijoDerecho());
        /*if(alturaPorIzquierda > alturaPorDerecha){
          return alturaPorIzquierda+1;
        }
        return alturaPorDerecha+1;*/
        return alturaPorIzquierda > alturaPorDerecha ? alturaPorIzquierda+1:alturaPorDerecha+1;
    }

    @Override
    public int nivel() {
    return nivel(this.raiz);

    }
    public int nivel(NodoBinario<k,v> nodoActual){
        if(NodoBinario.esNodoVacio(nodoActual)){
         return -1;
        }
        int alturaPorIzquierda = nivel(nodoActual.getHijoIzquierdo());
        int alturaPorDerecha = nivel(nodoActual.getHijoDerecho());
        /*if(alturaPorIzquierda > alturaPorDerecha){
          return alturaPorIzquierda+1;
        }
        return alturaPorDerecha+1;*/
        return alturaPorIzquierda > alturaPorDerecha ? alturaPorIzquierda+1:alturaPorDerecha+1;
    }

    @Override
    public k minimo() {
      if(this.esArbolVacio()){ 
       return null;
     }  
        
    NodoBinario<k,v> nodoActual = this.raiz;
    NodoBinario<k,v>  nodoAnterior = (NodoBinario<k ,v>)NodoBinario.nodoVacio();
      while(!NodoBinario.esNodoVacio(nodoActual)){
         nodoAnterior =nodoActual;
        nodoActual = nodoActual.getHijoIzquierdo();
      }
         
    return nodoAnterior.getClave();
    }

    @Override
    public k maximo() {
       if(this.esArbolVacio()){ 
       return null;
     }  
       NodoBinario<k ,v> nodoActual = this.raiz;
       NodoBinario<k ,v> nodoAnterior = (NodoBinario<k ,v>)NodoBinario.nodoVacio();
      while(!NodoBinario.esNodoVacio(nodoActual)){
          nodoAnterior = nodoActual;
          nodoActual = nodoActual.getHijoDerecho();
          
      }
      return nodoAnterior.getClave();
    }

    @Override
    public void insertar(k claveInsertar, v valorInsertar) {
     if(claveInsertar == null){
      throw new IllegalArgumentException("la clave no puede ser nula");
     }
     if(valorInsertar == null){
      throw new IllegalArgumentException("el valor no puede ser nula");
     }
     
     if(this.esArbolVacio()){
       this.raiz= new NodoBinario(claveInsertar , valorInsertar);
       return;
     }
     
     NodoBinario<k, v> nodoActual = this.raiz;
     NodoBinario<k, v>  nodoAnterior = (NodoBinario<k ,v>)NodoBinario.nodoVacio();
     
     while(!NodoBinario.esNodoVacio(nodoActual)){
       k claveActual = nodoActual.getClave();
       nodoAnterior = nodoActual;
       if(claveInsertar.compareTo(claveActual) < 0 ){
         nodoActual= nodoActual.getHijoIzquierdo();
       } else if(claveInsertar.compareTo(claveActual) > 0){
            nodoActual = nodoActual.getHijoDerecho();
       } else{//la clave existe entonces reemplazmos su valor 
          nodoActual.setValor(valorInsertar);
          return;
       }
     }
     
     // en este punto el nodo no existe en el arbol 
     //la clave debe crear un nodo con la clave y valor a insertar
     // y el nodoAnterior es el padre de ese nuevo nodo
     
     
     NodoBinario<k,v> nuevoNodo = new NodoBinario(claveInsertar , valorInsertar);
     k clavePadre = nodoAnterior.getClave();
     if(claveInsertar.compareTo(clavePadre) < 0){
      nodoAnterior.setHijoIzquierdo(nuevoNodo);
     }else {
       nodoAnterior.setHijoDerecho(nuevoNodo);
     }
     
    }

    @Override
    public v eliminar( k claveEliminar ){
      if(claveEliminar == null){
      throw new IllegalArgumentException("la clave a eliminar no puede ser nula");
      }
      
      v valorAretornar = this.buscar(claveEliminar);
      
      if(valorAretornar == null){
        throw new IllegalArgumentException("la clave que desea eliminar no se encuentra en el arbol");
      }
      
      this.raiz = eliminar(this.raiz, claveEliminar);
      
     return null;
    }
    
    NodoBinario<k,v> eliminar(NodoBinario<k ,v> nodoActual, k claveElinar){
        
       k ClaveActual = nodoActual.getClave(); 
       
       if(claveElinar.compareTo(ClaveActual) > 0){
       NodoBinario<k,v> posibleNuevoHijoDrecho = eliminar(nodoActual.getHijoDerecho() , claveElinar);
       nodoActual.setHijoDerecho(posibleNuevoHijoDrecho);
       return nodoActual;
       }
       if(claveElinar.compareTo(ClaveActual) < 0){
       NodoBinario<k,v> posibleNuevoIzquierdo = eliminar(nodoActual.getHijoIzquierdo(), claveElinar);
       nodoActual.setHijoIzquierdo(posibleNuevoIzquierdo);
       return nodoActual;
       }
       /*si la ejecucion llego a este punto quiere decir que ya
       encontro el nodo con la cleve a eliminar 
      
       */
       //caso 1
       if(nodoActual.esHoja()){
         return (NodoBinario<k,v>)NodoBinario.nodoVacio();
       }
       //caso 2
       // caso 2.2 este tiene solo tiene hijo izquierdo
       if( !nodoActual.esVacioHijoIzquierdo() && nodoActual.esVacioHijoDerecho()){
         return nodoActual.getHijoIzquierdo();
       }
       
       // caso 2.2 este tiene solo tiene hijo derecho
       if(nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()){
         return nodoActual.getHijoDerecho();
       }
       
       // caso 3 
       
       NodoBinario<k,v> nodoReemplazo = this.buscarNodoSucesor(nodoActual.getHijoDerecho());
       
       NodoBinario<k,v> posibleNuevoHijoDerecho= eliminar(nodoActual.getHijoDerecho(),
                                                        nodoReemplazo.getClave());
       nodoActual.setHijoDerecho(posibleNuevoHijoDerecho);
       
       nodoActual.setClave(nodoReemplazo.getClave());
       nodoActual.setValor(nodoReemplazo.getValor());
       return nodoActual;
    }
    
    protected NodoBinario<k,v> buscarNodoSucesor(NodoBinario<k,v> nodoActual){
      NodoBinario<k ,v> nodoAnterior;
      do{ 
          nodoAnterior=nodoActual;
          nodoActual= nodoActual.getHijoIzquierdo();
      }while(!NodoBinario.esNodoVacio(nodoActual));
      return nodoAnterior;
    }
    
    /*vamos a implementar  un metodo que retorne si un arbol binario tiene nodos completos
    es decir nodos que tengan sus dos hijos diferente de vacio en el nivel */
    
    public boolean tieneNodosCompletosEnNivel(int nivelObjetivo){
        if(nivel() < nivelObjetivo){
        return false ;
        }
        return tieneNodosCompletosEnNivel(this.raiz, nivelObjetivo, 0);
    }
    
    public boolean tieneNodosCompletosEnNivel(NodoBinario<k, v> nodoActual,int nivelObjetivos, int nivelActual){
      if(NodoBinario.esNodoVacio(nodoActual)){
       return false;
      }
      if(nivelActual ==  nivelObjetivos){
       return !nodoActual.esHoja();
      }
      boolean completoPorIzq = this.tieneNodosCompletosEnNivel(nodoActual.getHijoIzquierdo(), nivelObjetivos, nivelActual + 1);
      boolean completoPorDer = this.tieneNodosCompletosEnNivel(nodoActual.getHijoDerecho(), nivelObjetivos, nivelActual +1 );
       return completoPorDer && completoPorIzq;
    }  
    
    @Override
    public boolean contiene(k clave) {
       return this.buscar(clave) != null;
    }

    @Override
    public v buscar(k claveABuscar) {
      if(claveABuscar == null){
      throw new IllegalArgumentException("la clave no puede ser nula");
      }
     if(this.esArbolVacio()){
        return null;
     }
     
     NodoBinario<k,v> nodoActual =this.raiz;
     while(!NodoBinario.esNodoVacio(nodoActual)){
         k claveActual = nodoActual.getClave();
         if(claveABuscar.compareTo(claveActual) == 0){
           return nodoActual.getValor();
         } else if(claveABuscar.compareTo(claveActual) <0 ){
            nodoActual = nodoActual.getHijoIzquierdo();
         }else {
           nodoActual =nodoActual.getHijoDerecho();
         }              
     }
     // si llego a este punto significa q no se encuentra en el arbol
     
     return null;
    }
    @Override
    public List<k> recorridoEnInOrden() {
        
     List<k> recorrido = new ArrayList();
         if(this.esArbolVacio()){
           return recorrido;
           }
        Stack<NodoBinario<k, v>> pilaDeNodos = new Stack<>(); 
        this.AplicarEnInOrden(pilaDeNodos, this.raiz);
        
        while(!pilaDeNodos.isEmpty()){
        NodoBinario<k,v> nodoActual = pilaDeNodos.pop();
        recorrido.add(nodoActual.getClave());
        AplicarEnInOrden(pilaDeNodos,nodoActual.getHijoDerecho());  
      }
      return recorrido;
    }
    
    public void AplicarEnInOrden(Stack< NodoBinario<k, v>> pilaDeNodos, NodoBinario<k, v> nodoActual){
         while(!NodoBinario.esNodoVacio(nodoActual)){
           pilaDeNodos.push(nodoActual);
           nodoActual = nodoActual.getHijoIzquierdo();
         } 
    } 

    @Override
    public List<k> recorridoPreOrden() {     
     List<k> recorrido = new ArrayList();
      if(this.esArbolVacio()){
       return recorrido;
      }     
      Stack<NodoBinario<k,v>> pilaDeNodos =new Stack<>();
      pilaDeNodos.push(this.raiz);
      while(!pilaDeNodos.isEmpty()){
        NodoBinario<k,v> nodoActual = pilaDeNodos.pop();
        recorrido.add(nodoActual.getClave()); 
        
         if(!nodoActual.esVacioHijoDerecho()){
         pilaDeNodos.push(nodoActual.getHijoDerecho());
         } 
         if(!nodoActual.esVacioHijoIzquierdo()){
         pilaDeNodos.push(nodoActual.getHijoIzquierdo());
         }
      }
        return recorrido;
    }
    
   

    @Override
    public List<k> recorridoEnPostOrden() {
       List<k> recorrido = new ArrayList();
       if(this.esArbolVacio()){
         return recorrido;
       }
      Stack<NodoBinario<k,v>> pilaDeNodos= new Stack();
      NodoBinario<k ,v> nodoActual= this.raiz;
        meterPilaParaPostOrden(pilaDeNodos, nodoActual);
       /*empezamos a interar sobre la pila */
       while(!pilaDeNodos.isEmpty()){
       nodoActual= pilaDeNodos.pop();
       recorrido.add(nodoActual.getClave());
       if(!pilaDeNodos.isEmpty()){
           NodoBinario<k,v> nodoDelTope = pilaDeNodos.peek();
           if(!nodoDelTope.esVacioHijoDerecho() && 
                   nodoDelTope.getHijoDerecho() != nodoActual){
               /*volver a hacer el mismo bucle inicial*/
               meterPilaParaPostOrden(pilaDeNodos, nodoDelTope.getHijoDerecho());
           }     
         }
       }    
    return recorrido;
    }
    private void meterPilaParaPostOrden(Stack<NodoBinario<k , v>> pilaDeNodos ,NodoBinario<k,v> nodoActual){ 
     while(!NodoBinario.esNodoVacio(nodoActual)){
           pilaDeNodos.push(nodoActual);
           if(!nodoActual.esVacioHijoIzquierdo()){
           nodoActual = nodoActual.getHijoIzquierdo();
           }else {
           nodoActual= nodoActual.getHijoDerecho();
           }   
       }
      }
    @Override
      public boolean buscarNodo( k claveEliminar){
       return buscarNodo(claveEliminar, raiz);
      }
      
    @Override
    // esta funcion devuelve true si existe y si es hoja 
      public boolean buscarNodo( k claveBuscar, NodoBinario<k,v> actual){
          
          if( NodoBinario.esNodoVacio(actual)){
          return false;
          }

         if(actual.getClave() == claveBuscar ){
             if(actual.esHoja()){
              return true ;
             }
          return false;
          }
         
        if( actual.getClave().compareTo(claveBuscar) < 0){
          return buscarNodo(claveBuscar, actual.getHijoDerecho());
        }
       
          return buscarNodo(claveBuscar, actual.getHijoIzquierdo());
        
    }

    @Override
    public List<k> recorridoPorNiveles() {
      List<k> recorrido = new ArrayList();
      if(this.esArbolVacio()){
       return recorrido;
      }
      
      Queue<NodoBinario<k,v>> colaDeNodos =new LinkedList<>();
      colaDeNodos.offer(this.raiz);
      while(!colaDeNodos.isEmpty()){
        NodoBinario<k,v> nodoActual = colaDeNodos.poll();
        
        recorrido.add(nodoActual.getClave());
         if(!nodoActual.esVacioHijoIzquierdo()){
         colaDeNodos.offer(nodoActual.getHijoIzquierdo());
         }
         if(!nodoActual.esVacioHijoDerecho()){
         colaDeNodos.offer(nodoActual.getHijoDerecho());
         }
      
      }
      
        return recorrido;
    } 
    
    
     public List<k> recorridoEnPreOrdenV2() {
        List<k> recorrido = new ArrayList<>();
        recorridoEnPreOrdenV2(recorrido, this.raiz);
        return recorrido;
    }

    private void recorridoEnPreOrdenV2(List<k> lista, NodoBinario<k, v> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        lista.add(nodoActual.getClave());
        recorridoEnPreOrdenV2(lista, nodoActual.getHijoIzquierdo());
        recorridoEnPreOrdenV2(lista, nodoActual.getHijoDerecho());
    }
    
    @Override
    public int cantidadEscalera(){
        int cantidad = 0;
     return cantidadEscalera(raiz, cantidad);
    }
    
    @Override
    public int cantidadEscalera(NodoBinario<k , v> nodoActual, int cantidad){
        
        if(nodoActual == null){
          return cantidad;
        }
        if(  nodoActual.getHijoIzquierdo()!= null && nodoActual.getHijoDerecho()!= null ){
         
        k izquierdo = nodoActual.getHijoIzquierdo().getClave();
        k Derecha =  nodoActual.getHijoDerecho().getClave();
        if( Derecha.compareTo(izquierdo) == 2 ){
         cantidad++;
        }
        }
       cantidad =  cantidadEscalera(nodoActual.getHijoIzquierdo(), cantidad); 
       cantidad =  cantidadEscalera(nodoActual.getHijoDerecho(), cantidad);
   
        return cantidad;
        
    }

    
}
