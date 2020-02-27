/**
 * Create a class with two (overloaded) constructors.
 * Using this, call the second constructor inside the first one.
 */
public class ConstructorExample
{
    int value1,value2;

    //constructor1
    ConstructorExample(int val1){
        this(val1,10);   //calling the second constructor inside the first one
    }
    //construtor2
    ConstructorExample(int val1,int val2){
        this.value1=val1;
        this.value2=val2;
    }

    public static void main(String args[]){
        ConstructorExample example=new ConstructorExample(9);
        System.out.println("Value1 is "+example.value1);
        System.out.println("Value2 is "+example.value2);

    }

}
