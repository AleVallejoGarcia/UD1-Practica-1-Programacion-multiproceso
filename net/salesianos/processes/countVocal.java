package net.salesianos.processes;

public class countVocal {
    public static void main(String[] args) {
        int contador = 0;
        String letra = args[0];
        String texto = args[1];

        Character vocal = letra.charAt(0);

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == vocal) {
                contador++;
            }
        }

        System.out.println("El numero de " + vocal + " es: " + contador);

    }
}