/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arboles.Arboles;

/**
 *
 * @author JHOEL
 */
public class NodoBinario<k, v> {
    private k clave;
    private v valor;
    private NodoBinario<k ,v>hijoIzquierdo;
    private NodoBinario<k , v>hijoDerecho;

    public NodoBinario() {
    }

    public NodoBinario(k clave, v valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public k getClave() {
        return clave;
    }

    public void setClave(k clave) {
        this.clave = clave;
    }

    public v getValor() {
        return valor;
    }

    public void setValor(v valor) {
        this.valor = valor;
    }

    public NodoBinario<k, v> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario<k, v> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario<k, v> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario<k, v> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esVacioHijoIzquierdo(){
        return NodoBinario.esNodoVacio(this.getHijoIzquierdo());
    }
    public boolean esVacioHijoDerecho(){
      return NodoBinario.esNodoVacio(this.getHijoDerecho());
    }
    
    public boolean esHoja(){
     return this.esVacioHijoIzquierdo() && this.esVacioHijoDerecho();
    }
    
    public boolean esNodoCompleto(){
       return !this.esVacioHijoDerecho()  &&
               !this.esVacioHijoIzquierdo();
    }

    public static boolean esNodoVacio(NodoBinario nodo ){
      return nodo == NodoBinario.nodoVacio();
    }
    
   public static NodoBinario<?, ?>nodoVacio(){
   return null;
   }
   
   
}
