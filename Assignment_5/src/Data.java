

public class Data {

    int memberVariable1;
    char memberVariable2;

    public void printMembers() {
        System.out.println("MemberVariable1 in the class Data:" + memberVariable1);
        System.out.println("MemberVariable2 in the class Data:" + memberVariable2);
    }


    /**
     * The following method gives compile-time errors ,because localVariable1 and
     * localVariable2 are not initialized.Local variables have to be initialized in java
     * because local variables do not get default values but member variables get default
     * values when they are not initialized.
     * If you declare a field at class level they get default values according to their type.
     * If you declare a variable at method level or as a block,they do not get any values
     * and remain undefined untill they are assined to some value.
     * int localVariable1=0;
     * char localVariable2='\0';
     * If we replace with above two statements,error will be solved.
     */

    /*
    public void printLocalVariables() {
        int localVariable1;
        char localVariable2;
        System.out.println("LocalVariable1 in the class Data:" + localVariable1);
        System.out.println("LocalVariable2 in the class Data:" + localVariable2);
    }

     */

}
