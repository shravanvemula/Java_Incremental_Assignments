public class Main {

    public static void main(String args[]){
        Data dataObj=new Data();
        dataObj.printMembers();
        //dataObj.printLocalVariables();

        Singleton singletonObj=Singleton.initializeMembers("hello");
        singletonObj.printMembers();


    }




}
