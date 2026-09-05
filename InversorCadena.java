public class InversorCadena {
    String texto;
    
    public InversorCadena(String texto) {
        this.texto = texto;
    }

    public String invertir(){
        String resulto = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resulto += texto.charAt(i);
        }     
        return resulto;
    }
}

