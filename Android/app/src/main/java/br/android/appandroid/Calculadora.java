package br.android.appandroid;

public class Calculadora {
    public static String calcula(double gasolina, double etanol) {
        String saida = " ";
        double quociente = etanol / gasolina;

        if (quociente <= 0.7) {
            saida = "Etanol está mais viável.";
        } else {
            saida = "Gasolina está mais viável.";
        }
        return saida;
    }
}
