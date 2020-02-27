/**
 * Create a class with a constructor that takes a String argument.During construction, print the argument.
 * Create an array of object references to this class, but don’t actually create objects to assign into the array.
 * When you run the program, notice whether the initialization messages from the constructor calls are printed.
 */

public class ConstructorExample {
    //constructor
    ConstructorExample(String name){
        //printing the argument while construction
        System.out.println(name);
    }

    public static void main(String args[]){

        // creating an array of object references
        ConstructorExample[] objectArray=new ConstructorExample[10];
        for(int i=0;i<objectArray.length;i++){
            objectArray[i]=new ConstructorExample((i+1)+" call to Constructor");
        }


    }
}
