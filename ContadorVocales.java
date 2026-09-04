public class ContadorVocales {
    String Palabra;

    public ContadorVocales(String Palabra){
        this.Palabra = Palabra;
    }

    public int contarVocales() {
        int vocales = 0;
        for (int i = 0; i < Palabra.length(); i++) {
            char letra = Palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                vocales++;
            }
        }
        return vocales;
    }

    public int contarConsonantes() {
        int consonantes = 0;
        for (int i = 0; i < Palabra.length(); i++) {
            char letra = Palabra.charAt(i);
            if (letra >= 'a' && letra <= 'z') {
                if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                    consonantes++;
                }
            }
        }
        return consonantes;
    }

}
