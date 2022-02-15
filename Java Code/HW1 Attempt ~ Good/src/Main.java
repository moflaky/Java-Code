/**
 * Created by salam55 on 1/28/2020.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// modular programming,
// break down into classes and member functions

public class Main
{
    public static void main(String[] args)
    {
        int size;
        int min;
        int max;
        int target;
        try (Scanner input = new Scanner(System.in)) {
            //calls for user input to use for the array's size, min and max value, and target value.
                System.out.print("Please input array size (positive whole number): ");
                size = input.nextInt();

                System.out.print("Please input lower bound: ");
                min = input.nextInt();

                System.out.print("Please input upper bound (larger than lower bound): ");
                max = input.nextInt();

                System.out.print("Please input the target value: ");
                target = input.nextInt();
        }

       /*
        call setupinput to transfer the user values to the hw1arraysearch class variables.
         */
        hw1arraysearch.setupinput(size, min, max, target);
        hw1arraysearch.convertarraysize(); //calls convertarraysize to change negative value to positive array size
        hw1arraysearch.checkbounds(); //calls checkbounds to check the min and max values-
        /*call solve method to create an array, populate the array, display the unsorted and sorted array,
            call each of the four search test functions, and print out all the necessary prompts to make the
            output easy to understand
         */
        hw1arraysearch.solve();
    }
}

class hw1arraysearch {
    static int[] randomdata;
    static int size; //array size
    static int min; //array lower bound
    static int max; //array upper bound
    static int target; //target value while searching array
    static int hitpos; //position that the target value is found in the array during search
    static long starttime, endtime,finaltime; //variables to time the function calls

    final static int PRINTLIMIT=100; //constant limit for displaying array data
    final static int LINEARRECURSIONLIMIT=5000; //constant limit so that recursion function is not called and induces stack overflow

    /*
    This method checks the users input to avoid a negative array size and will return the absolute value
    of the negative number to keep the program running.
     */
    static void convertarraysize()
    {
        if (size<0) {
            System.out.println("You entered a negative number for array size. We will convert " +
                    "the whole number to positive to avoid error.");
            size = Math.abs(size);
        }
    }

    /*
    This method will make sure the min bound is not larger than the max bound. If this is true, then
    the program will terminate.
     */
    static void checkbounds()
    {
        if(min>max){
            System.out.println("You entered a lower bound that is larger than the upper bound. " +
                    "Program will terminate to avoid error.");
            System.exit(0);
        }
    }

    /*
    This functions simply assigns the user's input to the variables in the class for use with the class search
    and solve functions.
     */
    static void setupinput(int psize, int pmin, int pmax, int ptarget)
    {
        size=psize;
        min=pmin;
        max=pmax;
        target=ptarget;
    }

    /*
    This method calls all of the test functions for each of the four search methods.
    This method also calls the create and populate array functions.
    Pretty much the backbones of the operation so that the main method can be quick and simple.
     */
    static void solve()
    {
        //create new array
        createarray();

        // initialize unsorted int array
        populatearray();

        //show the unsorted array
        System.out.println("\nThe random array has been displayed. (only first 20 and last 20 " +
                "will be printed if array size is greater than 100)");
        display(randomdata);

        //test linear recursion search method on random array
        System.out.println("\nLinear searching the random array recursively. (" + size + ")");
        testlinearsearchrecursive();

        //test linear iterative search method on random array
        System.out.println("\nLinear searching the random array iteratively. (" + size + ")");
        testlinearsearchiterative();

        //sort the array
        Arrays.sort(randomdata);
        //display the sorted array
        System.out.println("\nThe sorted array has been displayed. (only first 20 and last 20 " +
                "will be printed if array size is greater than 100)");
        display(randomdata);

        //test linear recursion search method on sorted array
        System.out.println("\nLinear searching the sorted array recursively. (" + size + ")");
        testlinearsearchrecursive();

        //test linear iterative search method on sorted array
        System.out.println("\nLinear searching the sorted array iteratively. (" + size + ")");
        testlinearsearchiterative();

        //test binary iterative search method on sorted array
        System.out.println("\nBinary searching the sorted array iteratively. (" + size + ")");
        testbinarysearchiterative();

        //test binary recursion search method on sorted array
        System.out.println("\nBinary searching the sorted array recursively. (" + size + ")");
        testbinarysearchrecursive();
    }

    /*
    this method simply allocates space for the array
     */
    static void createarray() {
        randomdata = new int[size];
    }

    /*
    This method creates random values to put into each index of the array based on the user's size input.
     */
    static void populatearray() {

        Random r = new Random();
        int randomValue;
        createarray();
        //dynamic memory allocation
        for (int pos = 0; pos < size; pos++) {
            randomValue = r.nextInt(max - min) + min;
            randomdata[pos] = randomValue;
        }

        System.out.println("\nWe have generated " + size + " numbers!");
        System.out.println("\nThe generated array is: ");
    }

    /*
    this method will print out the first 100 numbers in the array if the array is <=100 numbers long
    else, this method will print out the first and last 20 numbers in the array if the array is >100 numbers.
     */
    static void display(int[] data) {

        if(data.length<=PRINTLIMIT) //check to make sure length of array is less than or equal to print limit
       {
           for(int i=0; i<data.length; i++)
               System.out.print(data[i] + ", ");
       }
       else
       {
           for(int pos=0; pos<20;pos++)
               System.out.print(data[pos] + ", ");
           System.out.print("............. ,");
           for(int currentpos=data.length-20; currentpos<data.length; currentpos++)
               System.out.print(data[currentpos] + ", ");
       }
        System.out.println("\n************************************************************");
       //text formatting to make the output easier to read.
    }

    /* this method will time the linear iterative search and return the hitpos of the target in the array if it
        is present or no hit if it does not exist in the array
     */
    static void testlinearsearchiterative()
    {
        long starttime, endtime, finaltime;
        /*not sure why this is needed, but without this variable declaration in this function,
            I get negative decimal numbers for this time only.*/
        starttime=System.currentTimeMillis();
        hitpos=linearsearchiterative();
        endtime=System.currentTimeMillis();
        finaltime=endtime-starttime;
        System.out.println("\nLinear search (iterative version) takes "+finaltime/1000.0+" seconds");

        if (hitpos==-1)
            System.out.println("\nNo hit");
        else
            System.out.println("\nThe first hit is at "+hitpos+ " position.");
        System.out.println("************************************************************");
    }

    /*
     * Function name: linearsearchiterative
     * Purpose: Conduct linear search iteratively to find the target on a sub array of the data array starting from
        the beginning of the array and ending at the end.
     * Precondition: the array must be populated and currentpos should be a legal index of the array
     * static member variable target has been initialized.
     * static member variable randomdata has been created and populated.
     * static member variable size contains the size of the array.
     * Postcondition: Returns the first hit location of the target.
     * @return returns the the position of the first element matching the target; and -1 if no match can be found.
     */
    static int linearsearchiterative()
    {
        starttime=System.nanoTime();
        int currentpos;
       for(currentpos=0; currentpos< randomdata.length; currentpos++) {
           if (randomdata[currentpos] == target)
               return currentpos;
       }
       return -1;

    }

    /*this method will time the linear recursive search function and print out the time and hitpos of the target
    in the array or no hit if the target is not present.
    *Precondition: The size of the array must be smaller than the linearrecursionlimit of 5000.
     */
    static void testlinearsearchrecursive()
    {
        starttime=System.currentTimeMillis();
        // this condition only applies to recursive linear search
        if (size<LINEARRECURSIONLIMIT)
        {

            hitpos=linearsearchrecursive(0);
            // target is a member of class so no need to pass it
            endtime=System.currentTimeMillis();
            finaltime=endtime-starttime;
            System.out.println("\nLinear search (recursive version) takes "+finaltime/1000.0+" seconds");

            if (hitpos==-1){
                System.out.println("\nNo hit");
            }
            else
                System.out.println("\nThe first hit is at "+hitpos+ " position.");
        }
        else
            System.out.println("\nRecursive linear search is skipped to avoid stack overflow!");
        System.out.println("************************************************************");
    }

    /*
     * Function name: linearsearchrecursive
     * Purpose: Conduct linear search recursively to find the target on a sub array of the data array starting from a given position ending at the end.
     * Precondition:  indexpos should be a legal index of the array, indicating the first position of the remaining sub array to be recursively searched.
     * static member variable target has been initialized.
     * static member variable randomdata has been created and populated.
     * static member variable size contains the size of the array.
     * Postcondition: Returns the first hit location.
     * @param indexpos is the starting position of the current sub array
     * @return returns the the position of the first element matching the target; and -1 if no match can be found.
     */
    static int linearsearchrecursive(int indexpos)
    {
      if (indexpos == size) //trivial case
          return -1;
      if (randomdata[indexpos]==target)
          return indexpos;
      else
      {
          return linearsearchrecursive(indexpos+1); //recursion happens if the target is not hit
      }
    }

    /*
    this method will test the binary iterative search and time its execution.
    the method will also print out the position of the target if found or no hit if it is not found in the array
     */
    static void testbinarysearchiterative()
    {
        starttime=System.currentTimeMillis();
        hitpos=binarysearchiterative(0);
        endtime=System.currentTimeMillis();
        finaltime=endtime-starttime;
        System.out.println("\nBinary search (iterative version) takes "+finaltime/1000.0+" seconds");

        if (hitpos==-1)
            System.out.println("\nNo hit");
        else
            System.out.println("\nThe first hit is at "+hitpos+ " position.");
        System.out.println("************************************************************");
    }

    /*
     * Function name: binarysearchiterative
     * Purpose: Conduct binary search iteratively to find the target on a sub array of the data array starting from
         the mid point in the array and determining which side of the array the target is present on and then
         creating a new midpoint in that half of the array in a loop.
     * Precondition: the array must be sorted and startindex must be a legal index in the array
     * static member variable target has been initialized.
     * static member variable randomdata has been created and populated.
     * static member variable size contains the size of the array.
     * endindex holds the length of the array-1 which is the last possible index in the array
     * Postcondition: Returns the first hit location of the target.
     * @return returns the the position of mid where randomdata[mid] == target; and -1 if no match can be found.
     */
    static int binarysearchiterative(int startindex)
    {
        int endindex =randomdata.length-1;

        while (startindex <= endindex)
        {
            int mid = (startindex + endindex)/ 2;

            // Check if target is present at middle of array
            if (randomdata[mid] == target)
                return mid;

            // If target is greater than the value at the middle of the array , ignore left half of the array
            if (randomdata[mid] < target)
                startindex = mid + 1;

            // If target is smaller than the value at the middle of the array, ignore right half of the array.
            else
                 endindex = mid - 1;
        }
        // if we return -1 here, then element was not present anywhere in the array
        return -1;

    }

    /*
    this method will test the binary recursive search and time its execution
    the method will also print out the position of the target if found or no hit if it is not found in the array
     */
    static void testbinarysearchrecursive()
    {
        starttime=System.currentTimeMillis();
        hitpos=binarysearchrecursive(0, size-1);
        endtime=System.currentTimeMillis();
        finaltime=endtime-starttime;
        System.out.println("\nBinary search (recursive version) takes "+finaltime/1000.0+" seconds");

        if (hitpos==-1)
            System.out.println("\nNo hit");
        else
            System.out.println("\nThe first hit is at "+hitpos+ " position.");
        System.out.println("************************************************************");
    }

    /*
         * Function name: binarysearchrecursive
         * Purpose: Conduct binary search recursively to find the target on a sub array of the data array starting from
             the mid point in the array and determining which side of the array the target is present on and then creating
             new midpoints in the targets half of the array by calling the function again inside itself accordingly.
         * Precondition: the array must be sorted, startindex must passed and be a legal index in the array,
             endindex must be passed and be a legal index in the array.
         * static member variable target has been initialized.
         * static member variable randomdata has been created and populated.
         * static member variable size contains the size of the array.
         * endindex is passed with the length-1 for ease of recursion.
         * Postcondition: Returns the first hit location of the target.
         * @return returns the the position of mid where randomdata[mid] == target; and -1 if no match can be found.
         */
    static int binarysearchrecursive(int startindex, int endindex)
    {
        if (startindex>=endindex)
            return -1;

        int mid = (startindex + endindex)/ 2;

        // If the target is present at the middle index then return that middle index
        if (randomdata[mid] == target)
                return mid;

        // If the target is smaller than middle index, then it can only be present in left half of the array
        if (randomdata[mid] > target)
                return binarysearchrecursive(0, mid-1);

        // If we reach this return statement, then the target can only be on the right half of the array
        return binarysearchrecursive(mid+1, endindex);
        }
    }
