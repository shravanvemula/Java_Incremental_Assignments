public class Singleton
{
    String memberVariable3;

    /**
     * The following method gives a compile-time error at the commented line (line 12)
     * because a non static variable memberVariable3 cannot be referenced from a
     * static context(initializeMembers()).The reason is static fields and methods are
     * are specific to the class and not to a specific instance and they are shared to all
     * the instances of the class.
     * To solve the error,you need to instantiate an object to the class in a static method and
     * should access class member variables with that object.
     *
     * If the commented line is replaced with singleton.memberVariable3 ,it will solve the error
     * @param parameter1
     * @return
     */
    public static Singleton initializeMembers(String parameter1){

       //memberVariable3=parameter1;
        Singleton singleton=new Singleton();
       return singleton;

    }

    public void printMembers(){
        System.out.println("Member Variable in the class Singleton:"+memberVariable3);
    }


}
