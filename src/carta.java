import java.io.*;
import java.util.ArrayList;

public class carta extends ArrayList<carta> implements Serializable {
    enum pals{
        ORS,
        COPES,
        ESPASES,
        BASTOS
    }
    int numero;
    String pal;

    public int getNumero() {
        return numero;
    }
    public String getPal(){
        return pal;
    }
    public carta(){}
    public carta(int n, String p){
        this.numero = n;
        this.pal = String.valueOf(pals.valueOf(p));
    }
}
