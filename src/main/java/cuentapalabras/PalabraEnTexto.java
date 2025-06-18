package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {

    private String palabra;
    private int veces;

    public PalabraEnTexto(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.veces = 1;
    }

    public void incrementa(){
        veces++;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PalabraEnTexto that)) return false;
        return Objects.equals(palabra, that.palabra);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palabra);
    }

    @Override
    public String toString() {
        return palabra+": "+veces;
    }
}
