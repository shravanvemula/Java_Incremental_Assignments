/**
 * 3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class,
 * but don’t actually create objects to assign into the array.
 * When you run the program, notice whether the initialization messages from the constructor calls are printed.
 *
 * 4. Complete the previous exercise by creating objects to attach to the array of references.
 * This is the code for 4th question
 */

public class ConstructorExample2 {

    ConstructorExample2(String name){
        System.out.println(name);
    }

    void printInfo(String info){
        System.out.println(info);
    }
    public static void main(String args[]){

        //I am creating objects to attach to the array references.
        ConstructorExample2 object1=new ConstructorExample2("My First call to Constructor");
        ConstructorExample2 object2=new ConstructorExample2("My Second call to Constructor");
        ConstructorExample2 object3=new ConstructorExample2("My third call to Constructor");
        ConstructorExample2 object4=new ConstructorExample2("My Fourth call to Constructor");

        //creating an array for references
        ConstructorExample2[] objectArray=new ConstructorExample2[4];

        //attaching objects to the array references
        objectArray[0]=object1;
        objectArray[1]=object2;
        objectArray[2]=object3;
        objectArray[3]=object4;

        //calling class's method using array references.
        for(int i=0;i<4;i++){
            objectArray[i].printInfo("This is "+(i+1)+" call using objectArray's Reference");
        }

    }
}
