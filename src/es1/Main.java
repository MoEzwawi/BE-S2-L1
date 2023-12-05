package es1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Random rndm = new Random();
        int[] arrayOfIntegers = new int[5];
        for(int i=0;i<arrayOfIntegers.length;i++){
            arrayOfIntegers[i] = rndm.nextInt(1,11);
        }
        log.info(Arrays.toString(arrayOfIntegers));
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                log.info("Scegli l'elemento da modificare (da 1 a 5) o premi 0 per uscire");
                int position = Integer.parseInt(input.nextLine());
                if(position==0)break;
                log.info("Attualmente l'elemento " + position + " ha un valore di " + arrayOfIntegers[position - 1]);
                log.info("Inserisci il nuovo valore");
                int newInt = Integer.parseInt(input.nextLine());
                arrayOfIntegers[position - 1] = newInt;
                log.info("Risultato: " + Arrays.toString(arrayOfIntegers));
            } catch (ArrayIndexOutOfBoundsException ex){
                log.error("Elemento inesistente");
            } catch (NumberFormatException ex){
                log.error("Inserisci solo caratteri numerici");
            }
        }
        input.close();
    }
}