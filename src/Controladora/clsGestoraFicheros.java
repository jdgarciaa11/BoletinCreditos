package Controladora;

import Modelo.clsCliente;

import java.io.*;
import java.util.Scanner;

public class clsGestoraFicheros {
    public static void leerTxt(){
        clsCliente cliente;
        String[] partes;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Ficheros/clientes_entrada.txt"))){
            String linea = bufferedReader.readLine();
            while (linea != null){
                partes = linea.split(" ");
                cliente = new clsCliente(Integer.parseInt(partes[0]),partes[1],partes[2],partes[3],Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),Integer.parseInt(partes[6]));
                linea = bufferedReader.readLine()
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirBinario(){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/Ficheros/clientes_entrada.txt", true))){

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
