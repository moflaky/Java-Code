/**
 * Created by salam55 on 1/28/2020.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int size;
        int min;
        int max;
        try (Scanner input = new Scanner(System.in)) {
            //calls for user input to use for the array's size and min/max value.
                System.out.print("Please input array size (positive whole number): ");
                size = input.nextInt();

                System.out.print("Please input lower bound: ");
                min = input.nextInt();

                System.out.print("Please input upper bound (larger than lower bound): ");
                max = input.nextInt();
        }

       /*
        call setupinput to transfer the user values to the hw2sorting class variables.
         */
        hw2sorting.setupinput(size, min, max);
        hw2sorting.convertarraysize(); //calls convertarraysize to change negative value to positive array size
        hw2sorting.checkbounds(); //calls checkbounds to check the min and max values

        /*
        call comparesorting method from hw2sorting class which triggers all the five sorting algorithms and returns their
        execution time and swap count.
         */
        hw2sorting.comparesorting();
    }
}

class hw2sorting {
    static int[] randomdata; //array to hold the randomly generated numbers
    static int[] workingdata; //used to recopy randomdata so sort uses the same array
    static int size; //array size
    static int min; //array lower bound
    static int max; //array upper bound
    static long starttime, endtime, finaltime; //variables to time the function calls
    static long operations=0;

    final static int PRINTLIMIT = 100; //constant limit for displaying array data

    /*
    This method checks the users input to avoid a negative array size and will return the absolute value
    of the negative number to keep the program running.
     */
    static void convertarraysize() {
        if (size < 0) {
            System.out.println("You entered a negative number for array size. We will convert " +
                    "the whole number to positive to avoid error.");
            size = Math.abs(size);
        }
    }

    /*
    This method will make sure the min bound is not larger than the max bound. If this is true, then
    the program will terminate.
     */
    static void checkbounds() {
        if (min > max) {
            System.out.println("You entered a lower bound that is larger than the upper bound. " +
                    "Program will terminate to avoid error.");
            System.exit(0);
        }
    }

    /*
    This method will check if the array passed is sorted and will return true or false
     */
    static boolean issorted(int[] data) {
        if (size == 0 || size == 1)
            return true;
        for (int i = 1; i < size; i++) {
            if (data[i - 1] > data[i])
                return false;
        }
        return true;
    }

    /*
    This method will duplicate the random data into the working data to keep test results valid
     */
    static void duplicatearray() {
        for (int index = 0; index < size; index++)
            workingdata[index] = randomdata[index];
    }

    /*
    This functions simply assigns the user's input to the variables in the class for use with the class search
    and solve functions.
     */
    static void setupinput(int psize, int pmin, int pmax) {
        size = psize;
        min = pmin;
        max = pmax;
    }

    /*
    This method calls all of the test functions for each of the sorting methods.
    This method also calls the create, populate, and duplicate array functions.
    Pretty much the backbones of the operation so that the main method can be quick and simple.
     */
    static void comparesorting() {
        //create new array
        createarray();

        // initialize unsorted int array
        populatearray();

        //print array and whether it is sorted
        System.out.println("Is array 1 sorted?: " + issorted(randomdata));
        display(randomdata);

        //duplicate array, display workingdata array and check if it is sorted
        duplicatearray();
        System.out.println("We just duplicated array 1 into array 2 for sorting purposes. \nIs array 2 sorted?: " + issorted(workingdata));
        display(workingdata);

        //testbuiltintsort
        testbuiltinsort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);

        //testbubblesort
        testbubblesort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);

        //testselectionsort
        testselectionsort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);

        //testinsertionsort
        testinsertionsort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);

        //test merge sort
        testmergesort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);

        //test quick sort
        testquicksort();
        System.out.println("The sorted array looks like: ");
        display(workingdata);


    }

    /*
    this method simply allocates space for the two arrays
     */
    static void createarray() {
        randomdata = new int[size];
        workingdata = new int[size];
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

        if (data.length <= PRINTLIMIT) //check to make sure length of array is less than or equal to print limit
        {
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + ", ");
        } else {
            for (int pos = 0; pos < 20; pos++)
                System.out.print(data[pos] + ", ");
            System.out.print("............. ,");
            for (int currentpos = data.length - 20; currentpos < data.length; currentpos++)
                System.out.print(data[currentpos] + ", ");
        }
        System.out.println("\n************************************************************");
        //text formatting to make the output easier to read.
    }

    /*

     */
    static void testbuiltinsort() {
        duplicatearray();
        starttime = System.currentTimeMillis();
        Arrays.sort(workingdata);
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nBuilt in Sort " + size + " numbers takes " + finaltime / 1000.0 + " seconds");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
    tests bubble sort method and prints swaps and whether the array is sorted.
     */
    static void testbubblesort() {
        duplicatearray();
        operations=0; //reset operations variable to track just this algorithm.
        starttime = System.currentTimeMillis();
        operations = bubblesort();
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nBubble sorting " + size + " numbers takes " + finaltime / 1000.0 + " seconds and takes " + operations + " operations.");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
     * Function name: bubblesort
     * Purpose: Sort through each index in the array and repeatedly check if the the position is larger than the next. if it is then we use
            int temp to hold the data as we swap the two integers.
     * Precondition: workingdata array should be a copy of the original array.
     * static member variable randomdata has been created and populated. randomdata has been duplicated to workingdata
     * static member variable size contains the size of the array.
     * Postcondition: Returns the number of swaps used to sort the array
     * @return returns the number of swaps used
     */
    static long bubblesort() {
        if(size<=1)//trivial case
            return 0;

        for (int i = 0; i < size; i++) //loop through the array 'size' times
            for (int j = 1 ; j < size; j++) {
                if (workingdata[j-1] > workingdata[j]) {
                    int temp = workingdata[j - 1];
                    workingdata[j - 1] = workingdata[j];
                    workingdata[j] = temp;
                    operations= operations+2; //adding operation for comparison and a from workingdata to temp.
                }
            }
        return operations;
    }

    /*
    this method will time the selection sort function and print out the time and swaps used
    to sort the array and if the array is sorted.
     */
    static void testselectionsort() {
        duplicatearray(); //This is needed to reset the workingdata array to the random data used in the first sorting algorithm
        operations=0; //reset operations variable to track just this algorithm.
        starttime = System.currentTimeMillis();
        operations = selectionsort();
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nSelection sorting " + size + " numbers takes " + finaltime / 1000.0 + " seconds and takes " + operations + " operations.");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
     * Function name: selectionsort
     * Purpose: Sort the given data using selection sort
     * Precondition: original randomdata array must be copied into workingdata so answers are fair.
     * static member variable randomdata has been created and populated. randomdata has been duplicated to workingdata
     * static member variable size contains the size of the array.
     * Postcondition: Returns the swaps used to sort the array
     * @return returns the number of swaps taken to sort the array
     */
    static long selectionsort() {
        duplicatearray(); //This is needed to reset the workingdata array to the random data used in the first sorting algorithm

        if(size<=1)//trivial case
            return 0;

        for (int i = 0; i < size-1; i++)
        {
            int min=i;

            for (int j = i+1; j < size; j++)
            {
                if (workingdata[j] < workingdata[min])
                    min = j;
                operations++;
            }
            if(workingdata[min]!=workingdata[i]) { //this will stop the sort algorithm from swapping duplicate values.
                int temp = workingdata[min];
                workingdata[min] = workingdata[i];
                workingdata[i] = temp;
                operations = operations+2;
            }
        }
        return operations;
    }

    /*
    this will test insertion sort method and print the swaps and execution time.
     */
    static void testinsertionsort() {
        duplicatearray(); //keeps the data the same for each sorting test.
        operations=0; //reset operations variable to track just this algorithm.
        starttime = System.currentTimeMillis();
        operations = insertionsort();
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nInsertion sorting " + size + " numbers takes " + finaltime / 1000.0 + " seconds and takes " + operations + " operations.");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
     * Function name: insertionsort
     * Purpose: Sort the random data using insertionsort and track number of swaps.
     * Precondition: original randomdata array must be copied into workingdata so answers are fair.
     * static member variable randomdata has been created and populated. randomdata has been duplicated to workingdata
     * static member variable size contains the size of the array.
     * Postcondition: Returns the swaps used to sort the array
     * @return returns the number of swaps taken to sort the array
     */
    static long insertionsort() {
        if(size<=1)//trivial case
            return 0;

        for(int i=1;i<size;i++)
        {
            int temp=workingdata[i]; //this is what will be moved
            operations++; // for storing temp
            int j=i-1;
            while(j>=0 && workingdata[j]>temp)
            {
                workingdata[j+1] = workingdata[j];
                j--;
                operations = operations+2; //+2 for comparison and swap.
            }
            workingdata[j+1] = temp;
            operations++; // for storing temp again.
        }
        return operations;
    }

    /*
       this will trigger the quicksort method and print execution time and swap count.
     */
    static void testquicksort() {
        duplicatearray();
        starttime = System.currentTimeMillis();
        operations = quicksort(0,size-1);
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nQuick sorting " + size + " numbers takes " + finaltime / 1000.0 + " seconds and takes " + operations + " operations.");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
     * Function name: quicksort
     * Purpose: Quick sorts the workingdata array using a pivot index to compare data and swap them
     * Precondition: original randomdata array must be copied into workingdata so answers are fair.
     * static member variable randomdata has been created and populated. randomdata has been duplicated to working data
     * static member variable size contains the size of the array.
     * Postcondition: Returns the swaps used to sort the array
     * @return returns the number of swaps taken to sort the array
     */
    static long quicksort(int startpos, int endpos) {
        int counteroflessers=0;
        int ops=0;

        if (startpos>=endpos) return ++ops; // base case

        int pivotvalue=workingdata[startpos]; // avoid indexing in the loop, saving time

        //now scan the array to count how many values are smaller than the pivot value.
        int leftpointer=startpos+1;
        for(; leftpointer<=endpos; leftpointer++)
        {
            if(workingdata[leftpointer]<pivotvalue)
            {  counteroflessers++;
                ops++;
            }
            ops+=3; // very rough estimate

        } // this loop is extra linear overhead, but the rest of programming logic will be straightforward.
        //swap the value at the pivot with the value at its due pos
        int newpivotpos=counteroflessers+startpos;

        swap(startpos,newpivotpos);

        //now scan toward the new position of the pivot, pointed by counteroflessers
        // from both ends
        leftpointer=startpos;
        int rightpointer=endpos;

        while(leftpointer<newpivotpos)
        {
            while(leftpointer<newpivotpos)
            {
                if (workingdata[leftpointer]<pivotvalue)
                {
                    leftpointer++;
                    ops++;
                }
                else
                    break;
                ops+=2;
            }
            while(rightpointer>newpivotpos)
            {
                if (workingdata[rightpointer]>=pivotvalue)
                {
                    rightpointer--;
                    ops++;
                }
                else
                    break;
                ops+=2;
            }
            if (leftpointer==newpivotpos || rightpointer==newpivotpos)
                break;
            // need swap
            swap(leftpointer,rightpointer);

        }
        ops+=quicksort(startpos, newpivotpos-1);
        ops+=quicksort(newpivotpos+1, endpos);
        return ops;
    }

    /*
        this method is a helper function to help keep track of operations in the quicksort function.
     */
    static void swap(int a, int b) {
        int temp;
        temp=workingdata[a];
        workingdata[a]=workingdata[b];
        workingdata[b]=temp;
    }

    /*
   this method will test the merge sort and time its execution
   the method will also print out the swaps used
    */
    static void testmergesort() {
        operations=0; //reset operations variable to track just this algorithm.
        duplicatearray();
        starttime = System.currentTimeMillis();
        operations = mergeSort(0,workingdata.length-1);
        endtime = System.currentTimeMillis();
        finaltime = endtime - starttime;
        System.out.println("\nMerge sorting " + size + " numbers takes " + finaltime / 1000.0 + " seconds and takes "  + operations + " operations.");
        System.out.println("Is array 2 sorted?: " + issorted(workingdata));
        System.out.println("************************************************************");
    }

    /*
     * Function name: mergeSort
     * Purpose: sorts the working data array in two parts.
     * function is called recursively to sort the data
     * finds mid point, sorts first and second array, and then merges them
     * Postcondition: Returns the swaps used to sort the array and calls merge to sort and merge array together
     * @return returns the number of swaps taken to sort the array
     */
    static long mergeSort(int low, int high){
        if(high<=low)
            return 0;
        int mid = (low+high)/2;
        operations = mergeSort(low,mid);
        operations +=mergeSort(mid+1,high);
        operations += merge(low, mid, high);

        return operations;
    }

    /*
   Function Name: merge
   Purpose: merge the two temporary arrays that are used to sort the data in a divide and conquer method together to the working data array.
   declared and populated the temp array with workingdata
   postcondition: returns number of swaps used to sort the data and merges the two sorted half arrays into the one large array
   @return returns the swap used to sort data
    */
    static long merge(int low, int mid, int high){
        int[] leftarray = new int [mid-low+1];
        int[] rightarray = new int [high-mid];

        for (int i = 0; i < leftarray.length; i++)
            leftarray[i] = workingdata[low + i];
        for (int i = 0; i < rightarray.length; i++)
            rightarray[i] = workingdata[mid + i + 1];

        int leftindex=0;
        int rightindex=0;

        for(int i=low; i< high+1; i++){
            if(leftindex<leftarray.length && rightindex < rightarray.length) {
                if (leftarray[leftindex] < rightarray[rightindex]) {
                    workingdata[i] = leftarray[leftindex];
                    leftindex++;
                } else {
                    workingdata[i] = rightarray[rightindex];
                    rightindex++;
                    operations += (mid-i); //remaining elements to be swapped.
                }
            }
            else if(leftindex<leftarray.length){
                workingdata[i]=leftarray[leftindex];
                leftindex++;
            }else if(rightindex< rightarray.length){
                workingdata[i]=rightarray[rightindex];
                rightindex++;
            }
        }
        return operations;
    }
}


