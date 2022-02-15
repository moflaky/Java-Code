/**
 *Spring 2020 CSCI 203
 * Midterm Problem 2
 * Matthew Salamack
 * 2 March 2020
 */
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int [] counters;
    static letterfreqpair [] wfps;
    static final int SIZEOFASCIITABLE=256;

    public static void main(String[] args)throws Exception {

        initalizefrequencies();

        File file = new File("ProteinData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            for (int pos = 0; pos < st.length(); pos++) {
                counters[(int)(st.charAt(pos))]++; //increments the frequency of each character that is found in the text
            }
        }
        displayfrequencies();
        sortbyfrequencies();
        displaybyfrequencies();
    }

    //This is a large switch to give each character in the text data a corresponding protein name
    static String getname(char acl)
    {
        String name="";
        switch(acl)
        {
            case 'a':
            case 'A':
                name="Alanine";
                break;
            case 'c':
            case 'C':
                name="Cysteine";
                break;
            case 'd':
            case 'D':
                name="Aspartic Acid";
                break;
            case 'e':
            case 'E':
                name="Glutamic Acid";
                break;
            case 'f':
            case 'F':
                name="Phenylalanine";
                break;
            case 'g':
            case 'G':
                name="Glycine";
                break;
            case 'h':
            case 'H':
                name="Histidine";
                break;
            case 'i':
            case 'I':
                name="Isoleucine";
                break;
            case 'k':
            case 'K':
                name="Lysine";
                break;
            case 'l':
            case 'L':
                name="Leucine";
                break;
            case 'm':
            case 'M':
                name="Methionine";
                break;
            case 'n':
            case 'N':
                name="Asparagine";
                break;
            case 'p':
            case 'P':
                name="Proline";
                break;
            case 'q':
            case 'Q':
                name="Glutamine";
                break;
            case 'r':
            case 'R':
                name="Arginine";
                break;
            case 's':
            case 'S':
                name="Serine";
                break;
            case 't':
            case 'T':
                name="Threonine";
                break;
            case 'v':
            case 'V':
                name="Valine";
                break;
            case 'w':
            case 'W':
                name="Tryptophan";
                break;
            case 'y':
            case 'Y':
                name="Tyrosine";
                break;



            default:
                name="NULL";

        }
        return name;
    }

    //This function will create an object array and then initialize each object with a letter, protein name, and frequency
    //then sort the objects using a comparator function to sort by frequency
    static void sortbyfrequencies() {
        //build object list
        wfps=new letterfreqpair[SIZEOFASCIITABLE];
        for(int pos=0; pos<SIZEOFASCIITABLE;pos++)
        {
                wfps[pos]=new letterfreqpair((char)pos, counters[pos], getname((char)pos));
        }

        Arrays.sort(wfps, new byfreqComparator());
    }

    // precondition, wfps has been sorted by frequencies
    //This function displays the objects protein name, letter, and frequency count sorted by frequencies
    static void displaybyfrequencies() {
        System.out.println("\n**********OBJECTS SORTED BY THEIR FREQUENCY IN ProteinData.txt**********");
        for(int pos=0; pos<SIZEOFASCIITABLE;pos++)
        {
            if(wfps[pos].getfreq()>0)
                wfps[pos].whoami();
        }
    }

    //Function to allocate memory for the frequency counter
    static void initalizefrequencies()
    {
        counters=new int[SIZEOFASCIITABLE];
    }

    //Displays objects protein name, letter, and frequency unsorted
    static void displayfrequencies() {
        System.out.println("**********UNSORTED OBJECTS**********");
        for(int pos=0; pos<SIZEOFASCIITABLE;pos++)
        {
            // out of SIZEOFASCIITABLE possible letters,only show those that appear at least once.
            if (counters[pos]>0)
                System.out.println(getname((char)pos)+ " - "+ (char)pos+" - "+ counters[pos] );
        }
    }
}

//This is a class that holds each objects letter, name, and frequency
//getfreq() returns the frequency of the character
//whoami() will prin the name, letter, and frequency of the object.
class letterfreqpair {
    char letter;
    int freq;
    String name;

    letterfreqpair(char letter, int freq, String name) {
        this.name = name;
        this.letter = letter;
        this.freq = freq;
    }

    public int getfreq() {
        return freq;
    }

    public void whoami()
    {
        System.out.println(name + " - " +letter+" - "+freq);
    }
}

// inner class comparator function that is used to compare each object by their frequency and help sort them.
class byfreqComparator implements Comparator<letterfreqpair>{
    @Override
    public int compare(letterfreqpair lo, letterfreqpair ro) {
        return lo.freq - ro.freq;
    }
}