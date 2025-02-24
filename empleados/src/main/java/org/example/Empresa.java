package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
//dtdtydgrfg
public class Empresa {
    private static ArrayList<Empleados> LEmpleados = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Introduce los datos del empleado:");
        Empleados empleado = new Empleados();
        LEmpleados.add(empleado);
        guardarEmpleados();
        System.out.println("\nIntroduce los datos del contable:");
        Contable contable = new Contable();
        LEmpleados.add(contable);
        System.out.println("\nIntroduce los datos del director:");
        Director director = new Director();
        LEmpleados.add(director);

        for (Empleados e: LEmpleados) {
            System.out.println(e);
        }

        System.out.println("\nDatos y sueldo de los empleados:");
        System.out.println(empleado);
        System.out.println("Sueldo: " + empleado.calcularSueldo() + "€");

        System.out.println(contable);
        System.out.println("Sueldo: " + contable.calcularSueldo() + "€");

        System.out.println(director);
        System.out.println("Sueldo: " + director.calcularSueldo() + "€");

        System.out.println("\nActividades:");
        contable.contabilizar();
        director.analizarDatos();

    }

    public static void guardarEmpleados(){
        //filewriter crea el empleados.json
        // la estructura try catch, captura la excepcion en caso de que haya un error al crear el fichero
        //borra el fichero y lo vuelve a crear desdee el principio, lo machaca
        //el writer es el manejador del fichero json que crea
        try (FileWriter writer = new FileWriter("empleados.json")) {
            //crea un objeto de tipo Json
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            //el toJson esta transformando el objeto de java a un objeto de Json
            gson.toJson(LEmpleados, writer);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}



