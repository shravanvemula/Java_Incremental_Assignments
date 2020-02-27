import java.io.*;
import java.util.*;

/**
 * This class HostPinger pings a host and stores the result in an arraylist
 */
public class HostPinger {
    private String host;
    private int packets;
    public HostPinger(){

        host="";
        packets=0;
    }

    public void setHost(String host){
        this.host=host;
    }
    public String getHost(){
        return host;
    }

    public void setPackets(int packets){
        this.packets=packets;
    }
    public int getPackets(){
        return packets;
    }
    /**
     * pingHost() executes the ping command through the method executePing() and
     * it extracts ping values through the method extractPingTimeValues()
     * and finally prints median value of pings through the method computeMedianOfPings()
     */
    public void pingHost(){

        Median median=new Median();
        try {
            ArrayList<String> executionResults = executePing();
            if(executionResults.size()==1){
                System.out.println(host+" does not exist.");
                return;
            }
            ArrayList<Double> pingTimeValues=median.extractPingTimeValues(executionResults);

            Double medianOfPingValues=median.computeMedianOfPings(pingTimeValues,packets);
            System.out.println("Median of time taken to ping "+host+" is "+medianOfPingValues+" ms");

        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(host+" does not exist");
        }

    }

    /**
     * This method executes the command ping command and returns an arraylist of strings
     * that contains all lines of command result.
     * @return
     * @throws IOException
     */

    public ArrayList<String> executePing() throws IOException{
        ArrayList<String> executionResults=new ArrayList<String>();

        Process process=Runtime.getRuntime().exec("ping -c "+packets+" "+host);
        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
        String currentLine="";
        while((currentLine=reader.readLine())!=null){
            executionResults.add(currentLine);
        }
        return executionResults;
    }


    /**
     * In main(),I have taken user input of Host name or Host's IP address and Number of packets to be transmitted.
     * @param args
     */
    public static void main(String args[]){
        HostPinger pinger=new HostPinger();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter Host Name or Host IP address:");
        String host=scanner.next();
        pinger.setHost(host);
        System.out.print("Enter number of packets to transmit:");
        int packets=scanner.nextInt();
        pinger.setPackets(packets);
        pinger.pingHost();


    }

}