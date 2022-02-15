/**
 * Spring 2020 for CSCI 203
 * Matthew Salamack
 * 2 March 2020
 */
import java.util.Arrays;
import java.util.Comparator;

class planet{

    private String planetName;
    private double gravity;

    //constructor to create instances of objects with different names and gravity values
    planet(String planetName, double gravity) {
        // this refers to the object on behalf of which the function is triggered.
        this.planetName=planetName;
        this.gravity=gravity;
    }
    
    /**
     * Function name: whoami
     * This function simply prints out the planets name and gravity value
     */
    public void whoami()
    {
        System.out.println("Planet Name: " + planetName + " ------ Gravity: "+ gravity);
    }

    /**
     * Function Name:getgravity
     * @return gravity value of object
     */
    public double getgravity()
    {
        return gravity;
    }

    /**
     * Function Name:getplanetname
     * @return planet name of object
     */
    public String getplanetname()
    {
        return planetName;
    }
}

/**
 * Function name: bygravityComparator
 * This function will compare the given objects and sort them by their gravity component
 * Very useful for sorting the array of objects
 * @return will return an integer based on the gravity component and compare it with the other objects
 **/
class bygravityComparator implements Comparator<planet>{
    @Override
    public int compare(planet lo, planet ro) {
        return (int) (lo.getgravity()-ro.getgravity());
    }
}

/**
 * Function name: bynameComparator
 * This function will compare the given objects and sort them by their name
 * Very useful for sorting the array of objects
 * @return will return an integer based on the name component and compare it with the other object names;
 **/
class bynameComparator implements Comparator<planet>{
    @Override
    public int compare(planet lo, planet ro) {
        return lo.getplanetname().compareTo(ro.getplanetname());
    }
}

public class Main {

    public static void main(String[] args) {

        //this is the index of the array where the target string or value is found.
        int hitpos;

        //Creating the 9 planets in order on the given website as objects of planet class.
        planet p1 = new planet("Mercury", 3.7);
        planet p2 = new planet("Venus", 8.9);
        planet p3 = new planet("Earth", 9.8);
        planet p4 = new planet("Mars", 3.7);
        planet p5 = new planet("Jupiter", 23.1);
        planet p6 = new planet("Saturn", 9.0);
        planet p7 = new planet("Uranus", 8.7);
        planet p8 = new planet("Neptune", 11.0);
        planet p9 = new planet("Pluto", 0.7);

        //an array of the 9 objects which each have a name and gravity value.
        items=new planet[]{p1, p2, p3, p4, p5, p6, p7, p8, p9};

        System.out.println("******* ORIGINAL UNSORTED ARRAY OF OBJECTS *******");
        printItems();

        planet target=new planet("Mars",23.1); //This is the target values stated in the midterm handout sheet

        Arrays.sort(items, new bygravityComparator()); //Sorts objects in array by gravity value
        System.out.println("******* SORTED BY GRAVITY ARRAY OF OBJECTS *******");
        printItems();
        hitpos=Arrays.binarySearch(items, target, new bygravityComparator()); //returns the value of which the target was found
        System.out.println("Array index where \'23.1\' is found: " + hitpos);
        System.out.println("Target gravity value: " + items[hitpos].getgravity());

        Arrays.sort(items, new bynameComparator()); //Sorts objects in array by name
        System.out.println("******* SORTED BY NAME ARRAY OF OBJECTS *******");
        printItems();
        hitpos=Arrays.binarySearch(items, target, new bynameComparator()); //returns the value of which the target was found
        System.out.println("Array index where \'Mars\' is found: " + hitpos);
        System.out.println("Target name: " + items[hitpos].getplanetname());

    }

    //static array of the object array
    static planet[] items;

    //simple print function to print out the name and gravity of each object in the array.
    static void printItems(){
        for(planet p: items)
            p.whoami();
        System.out.println();
    }
}
