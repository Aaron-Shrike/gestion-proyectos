package capa_Presentacion;

import capa_Logica.Proyecto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        ArrayList Proyectos;
        Proyectos = new ArrayList();
        int opcion;
        Scanner objEntrada = new Scanner(System.in);
          do{
            opcion = menu();
            switch (opcion)
            {
                case 1: Proyecto proyecto=new Proyecto(); 
                        System.out.print("Ingrese código: ");
                        String codigo=objEntrada.next();
                        proyecto.setCodigo(codigo);
                        
                        System.out.print("Ingrese nombre: ");
                        String titulo=objEntrada.next();
                        proyecto.setTituloDelProyecto(titulo);
                         
                        System.out.print("Ingrese costo: ");
                        double costo=objEntrada.nextDouble();
                        proyecto.setCosto(costo);
                        
                        System.out.print("Ingrese tiempo(meses): ");
                        int tiempo=objEntrada.nextInt();
                        proyecto.setMeses(tiempo);
                         
                        Proyectos.add(proyecto);
                        
                        System.out.println("\t* Proyecto Registrado *");
                        break;
                case 2: 
                        MostrarListadoProyectos(Proyectos);
                       break;
                case 3:  mayorYmenorCosto(Proyectos);
                         break;
                case 4:  System.out.print("Ingrese cantidad: ");
                         double cantidad=objEntrada.nextDouble();
                        ProyectosMayoraCantidadIngresada(Proyectos,cantidad);
                    break;
               case 5: System.out.print("Ingrese cantidad: ");
                         double cantidad1=objEntrada.nextDouble(); 
                       ProyectosMenoraCantidadIngresada(Proyectos,cantidad1);
                    break;
                case 6:ProyectoConMenorCostoYMenorTiempo(Proyectos); 
                    break;
                case 7:  CostoTotalDeLosProyectos(Proyectos);
                    break;
            }
        }while (opcion!=8 );
    
    }
    private static int menu ()
    {
        Scanner objEntrada = new Scanner(System.in);
        int opt;
        System .out.println("\n\n\nMenu de Opciones");
        System .out.println("[1] Registrar Proyecto");
        System .out.println("[2] Listado de Proyectos");
        System .out.println("[3] Mayor y Menor costo de Proyectos");
        System .out.println("[4] Proyectos que costaron más que cierta cantidad ingresada");
        System .out.println("[5] Proyectos que costaron menos que cierta cantidad ingresada");
        System .out.println("[6] Proyecto mas barato con menor tiempo para construirse");
        System .out.println("[7] Total de todos los proyectos");
        System .out.println("[8] Salir");
        
        
        do{
            System.out.print("Ingrese opcion: ");
            opt = objEntrada.nextInt();
        }while(opt<1|| opt>8);
        return opt;
    }  
    private static void MostrarListadoProyectos(ArrayList lista){
         System.out.println("\nLista de Proyectos");
         System.out.println("Codigo    \t\tTitulo\t\tCosto  \t\tTiempo");
        Iterator elemento = lista.iterator();
        while(elemento.hasNext()){
               Proyecto a=(Proyecto)elemento.next();
               System.out.println(a.getCodigo()+"\t\t"+a.getTituloDelProyecto()+"\t\t"+a.getCosto()+"\t\t"+a.getMeses());
        }
    }
     private static void mayorYmenorCosto(ArrayList lista){
        if(!lista.isEmpty()){
                    Iterator elemento;
                    Proyecto a=(Proyecto)lista.get(0);
                    double mayor=a.getCosto();
                    double menor = a.getCosto();
                    elemento=lista.iterator();
                    while(elemento.hasNext()){
                        Proyecto a1=(Proyecto) elemento.next();
                        if(a1.getCosto()>mayor)
                            mayor= a1.getCosto();
                        if (a1.getCosto()<menor)
                            menor=a1.getCosto();                   
                    }
            System.out.println("\nCosto mayor: "+mayor);
            System.out.println("Costo menor: "+menor);
        }
     }  
     
     private static void  ProyectosMayoraCantidadIngresada(ArrayList lista,double cantidad){
        if(! lista.isEmpty()){
            boolean band=false;
            Iterator elemento;
            elemento=lista.iterator();
            
            System.out.println("\nProyectos con un costo mayor a S/."+cantidad);
            System.out.println("Codigo    \t\tTitulo\t\tCosto  \t\tTiempo");
            
            while(elemento.hasNext()){
                Proyecto a=(Proyecto) elemento.next();
                if(a.getCosto()>cantidad){
                    System.out.println(a.getCodigo()+"\t\t"+a.getTituloDelProyecto()+"\t\t"+a.getCosto()+"\t\t"+a.getMeses());    
                    band=true;  
                }
            }
                        
            if(!band)
                System.out.println("* No hay Proyectos con costo mayor a la cantidad ingresada");
        } 
     }
      private static void  ProyectosMenoraCantidadIngresada(ArrayList lista,double cantidad){
         if(!lista.isEmpty()){
            boolean band=false;
            Iterator elemento;
            elemento=lista.iterator();
            
            System.out.println("\nProyectos con un costo menor a S/."+cantidad);
            System.out.println("Codigo    \t\tTitulo\t\tCosto  \t\tTiempo");
            
            while(elemento.hasNext()){
                Proyecto a=(Proyecto) elemento.next();
                if(a.getCosto()<cantidad){
                    System.out.println(a.getCodigo()+"\t\t"+a.getTituloDelProyecto()+"\t\t"+a.getCosto()+"\t\t"+a.getMeses());    
                    band=true;  
                }
            }
                        
            if(!band)
                System.out.println("* No hay Proyectos con costo menor a la cantidad ingresada");
         } 
     }
      private static void ProyectoConMenorCostoYMenorTiempo(ArrayList lista){
            Proyecto p=(Proyecto)lista.get(0);
            double costomenor=p.getCosto();
            int tiempomenor=p.getMeses();
            Iterator elemento;
            elemento=lista.iterator();
            while(elemento.hasNext()){
                Proyecto a=(Proyecto) elemento.next();
                if(a.getCosto()<=costomenor && a.getMeses()<tiempomenor){
                    tiempomenor=a.getMeses();
                    costomenor=a.getCosto();
                }
            }
            elemento=lista.iterator();  
            
            System.out.println("\nProyectos con menor costo y menor tiempo");
            System.out.println("Codigo    \t\tTitulo\t\tCosto  \t\tTiempo");
            
            while(elemento.hasNext()){
                Proyecto a=(Proyecto) elemento.next();
                if(a.getCosto()==costomenor && a.getMeses()==tiempomenor)
                    System.out.println(a.getCodigo()+"\t\t"+a.getTituloDelProyecto()+"\t\t"+a.getCosto()+"\t\t"+a.getMeses());   
            }
      }
       private static void  CostoTotalDeLosProyectos(ArrayList lista){
         if(!lista.isEmpty()){
            double total = 0;
            Iterator elemento;
            elemento=lista.iterator();
            while(elemento.hasNext()){
                Proyecto a=(Proyecto) elemento.next();
                total+=a.getCosto();
            }
            System.out.println("Total de costo por todos los proyecto: "+total); 
         }
         
      } 
     
}
