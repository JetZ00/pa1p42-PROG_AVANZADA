package cuentapalabras;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ContadorPalabras {
    private List<PalabraEnTexto> palabras;

    public ContadorPalabras() {
        palabras = new ArrayList<PalabraEnTexto>();
    }

    protected void incluye (String pal){
        PalabraEnTexto aux = new PalabraEnTexto(pal);
        boolean control = false;

        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).equals(aux)){
                palabras.get(palabras.indexOf(aux)).incrementa();
                control = true;
            }
        }

        if (!control){
            palabras.add(aux);
        }
    }

    private void incluyeTodas (String linea, String del){

        Scanner sc = new Scanner(linea);
        sc.useLocale(Locale.ENGLISH);
        sc.useDelimiter(del);
        while (sc.hasNext()){
            String palabra = sc.next();
            incluye(palabra);
        }
    }

    public void incluyeTodas (String[] linea, String del){

        for (int i = 0; i < linea.length; i++) {

            Scanner sc = new Scanner(linea[i]);
            sc.useLocale(Locale.ENGLISH);
            sc.useDelimiter(del);

            while (sc.hasNext()){
                String palabra = sc.next();
                incluye(palabra);
            }
        }
    }

    public void incluyeTodasFichero(String nomFich, String del) throws IOException {
        Path path = Path.of(nomFich);

        try (BufferedReader br = Files.newBufferedReader(path)){
            String linea;
            while ((linea = br.readLine()) != null) {
                incluyeTodas(linea, del);
            }
        } catch (IOException e){ }
    }

}
