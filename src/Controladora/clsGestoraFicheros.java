package Controladora;

import Modelo.clsCliente;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class clsGestoraFicheros {
    public static final String RUTA_TXT = "src/Ficheros/clientes_entrada.txt";
    public static final String RUTA_BINARIA_COMPLETO = "src/Ficheros/clientesCompleto.dat";
    public static void leerTxt(){
        clsCliente cliente;
        String[] partes;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(RUTA_TXT))){
            String linea = bufferedReader.readLine();
            while (linea != null){
                partes = linea.split(" ");
                cliente = new clsCliente(Integer.parseInt(partes[0]),partes[1],partes[2],partes[3],Integer.parseInt(partes[4]),Integer.parseInt(partes[5]),Integer.parseInt(partes[6]), partes[7], Integer.parseInt(partes[8]));
                escribirBinario(cliente,RUTA_BINARIA_COMPLETO);
                System.out.println(cliente);
                linea = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirBinario(clsCliente cliente, String ruta){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(ruta, true))){
            objectOutputStream.writeObject(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leerBinario(){
        boolean salir = false;
        ArrayList<clsCliente> lista;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(RUTA_BINARIA_COMPLETO))){
            lista = (ArrayList<clsCliente>) objectInputStream.readObject();
            for (clsCliente c: lista) {
                System.out.println(c);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
