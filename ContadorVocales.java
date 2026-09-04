public class ContadorVocales {
    String Palabra;

    public ContadorVocales(String Palabra){
        this.Palabra = Palabra;
    }

    public int contarVocales() {
        int vocales = 0;
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                vocales++;
            }
        }
        return vocales;
    }

}
