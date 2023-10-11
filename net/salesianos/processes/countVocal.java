package net.salesianos.processes;

public class countVocal {
    public static void main(String[] args) {
        int contador = 0;
        char letra = args[0].charAt(0);
        String texto = args[1];


        for (int i = 0; i < texto.length(); i++) {
            if (texto.toUpperCase().charAt(i) == letra) {
                contador++;
            }
        }

        System.out.println(contador);

    }
}

