import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            ArrayList<carta> baralla = new ArrayList<carta>();
            File fitxer = new File("cartes.txt");
            ArrayList<carta> barallaMesclada = new ArrayList<carta>();
            carta k;
            ObjectInputStream fluxeLectura = new ObjectInputStream(new FileInputStream(fitxer));
            ObjectOutputStream fluxeEscriptura = new ObjectOutputStream(new FileOutputStream(fitxer));
            String pepe = null;
            for (int i = 1; i <= 12; i++) {
                carta o = new carta(i, "ORS");
                carta e = new carta(i, "ESPASES");
                carta b = new carta(i, "BASTOS");
                carta c = new carta(i, "COPES");

                baralla.add(o);
                baralla.add(e);
                baralla.add(c);
                baralla.add(b);
            }
            System.out.println("-------------------------no mesclat");
            for (int i = 0; i < baralla.size(); i++) {
                System.out.print(baralla.get(i).numero + baralla.get(i).pal + "\n");
            }


            for (int i = 0; i < 48; i++) {
                int numero = (int) (Math.random() * baralla.size() + 0);
                barallaMesclada.add(baralla.remove(numero));
            }

            int mida = barallaMesclada.size();
            for (int f = 0; f < mida; f++) {
                fluxeEscriptura.writeObject(barallaMesclada.remove(0));

            }

            System.out.println("------------------------------------------------------------fitxer");

            for (int j = 0; j < mida; j++) {

                barallaMesclada.add((carta) fluxeLectura.readObject());
                System.out.println(barallaMesclada.get(j).pal + barallaMesclada.get(j).pal);


            }
            System.out.println(barallaMesclada.size());
            fluxeLectura.close();

            System.out.println("digues el nom del jugador 1");
            String nomJugador1 = sc.nextLine();
            int punts1 = 0;
            System.out.println("digues el nom del jugador 2");
            String nomJugador2 = sc.nextLine();
            int punts2 = 0;
            mida = barallaMesclada.size();
            while (barallaMesclada.size() != 0) {
                System.out.println("carta del jugador 1");
                carta uno = barallaMesclada.remove(0);
                System.out.println(uno.numero + " " + uno.pal);
                pepe = sc.nextLine();
                System.out.println("carta del jugador 2");
                carta dos = barallaMesclada.remove(0);
                System.out.println(dos.numero + " " + dos.pal);
                pepe = sc.nextLine();


                if (uno.numero > dos.numero) {
                    punts1++;
                } else if (uno.numero < dos.numero) {
                    punts2++;
                } else {
                    punts1++;
                    punts2++;
                }
                System.out.println(nomJugador1 + ":" + punts1);
                System.out.println(nomJugador2 + ":" + punts2);

            }
            System.out.println(nomJugador1 + ":" + punts1);
            System.out.println(nomJugador2 + ":" + punts2);
            if (punts1 > punts2) {
                System.out.println("guanya " + nomJugador1);
            } else if (punts1 < punts2) {
                System.out.println("guanya " + nomJugador2);
            } else {
                System.out.println("empat");
            }
            System.out.println("digues 0 per sortir o qualsevol cosa per continuar");
            pepe=sc.nextLine();
            if (pepe=="0"){
             break;
            }


        }

}}