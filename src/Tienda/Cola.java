/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda;

/**
 *
 * @author andree
 */
public class Cola {
       

    class Nodo {

        int dni;
        
        int nrotelef;
        
        String nombre;
        
        String mesa;
        
        String Direccion;
        
        float precio;

        Nodo sig;

    }


    private Nodo raiz,fondo;


    Cola() {

        raiz=null;

        fondo=null;

    }

    

    boolean vacia (){

        if (raiz == null)

            return true;

        else

            return false;

    }


    void insertar (int dni,int nrotelef,String nombre,String mesa,String Direccion,float precio)

    {

        Nodo nuevo;

        nuevo = new Nodo();

        nuevo.dni = dni;
        
        nuevo.nrotelef = nrotelef;
        
        nuevo.nombre = nombre;
        
        nuevo.mesa = mesa;
        
        nuevo.Direccion = Direccion;
        
        nuevo.precio = precio;

        nuevo.sig = null;

        if (vacia ()) {

            raiz = nuevo;

            fondo = nuevo;

        } else {

            fondo.sig = nuevo;

            fondo = nuevo;

        }

    }


    Integer extraer ()

    {

        if (!vacia ())

        {

            int documento = raiz.dni;

            if (raiz == fondo){

                raiz = null;

                fondo = null;

            } else {

                raiz = raiz.sig;

            }

            return documento;

        } else

            return null;

    }


    public void imprimir() {

        Nodo reco=raiz;

        System.out.println("Listado de todos los elementos de la cola.");

        while (reco!=null) {

            System.out.print(reco.dni+"-");

            reco=reco.sig;

        }

        System.out.println();

    }
    
    public int getdni(Cola cola,int index){
        Nodo temp;
            temp = cola.raiz;
        if(index==0){
            return temp.dni;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.dni;
    }
    
    public int gettelef(Cola cola,int index){
        Nodo temp;
        temp = cola.raiz;
        if(index==0){
            return temp.nrotelef;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.nrotelef;
       
    }
    
    public String getnombre(Cola cola,int index){
        Nodo temp;
        temp = cola.raiz;
        if(index==0){
            return temp.nombre;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.nombre;
    }
    
    public String getdirec(Cola cola,int index){
        Nodo temp;
        temp = cola.raiz;
        if(index==0){
            return temp.Direccion;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.Direccion;
    }
    
    public String getmesa(Cola cola,int index){
        Nodo temp;
        temp = cola.raiz;
        if(index==0){
            return temp.mesa;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.mesa;
    }
    
    public float getprecio(Cola cola,int index){
        Nodo temp;
        temp = cola.raiz;
        if(index==0){
            return temp.precio;
        }
        for (int i=0; i<index;i++){
            temp = temp.sig;
        }
        return temp.precio;
       
    }
}
