import java.util.ArrayList;
import java.util.Collections;

/**
 * This class extracts pinging time values and computes of the median of time taken to ping.
 */
public class Median {

    /**
     * This method extractPingTimeValues() takes in parameter named executionResults.
     * Result of packet transmission looks like
     * "64 bytes from maa05s02-in-f4.1e100.net (172.217.163.68): icmp_seq=1 ttl=56 time=15.7 ms" .
     * This method extracts ping time values for each packet transmission by finding index of "time=" and
     * "ms" and time value is extracted using substring(),converted to double and added to pingTimeValues arraylist
     * @param executionResults
     * @return
     */
    public ArrayList<Double> extractPingTimeValues(ArrayList<String> executionResults){
        ArrayList<Double> pingTimeValues=new ArrayList<Double>();
        for(String currentLine:executionResults){
            int indexOfTime=currentLine.indexOf("time=");
            int indexOfMilliSeconds=currentLine.indexOf(" ms");
            if(indexOfTime!=-1&&indexOfMilliSeconds!=-1){
                String currentPingTime=currentLine.substring(indexOfTime+5,indexOfMilliSeconds);
                double currentPingTimeValue=Double.parseDouble(currentPingTime);
                pingTimeValues.add(currentPingTimeValue);
            }
        }
        return pingTimeValues;

    }

    /**
     * This method computes the median of pingTimeValues. If the number of packets is even,median will be (midvalue1+midvalue2)/2
     * If the number of packets is odd,median will be mid value.
     * @param pingTimeValues
     * @return
     */
    public double computeMedianOfPings(ArrayList<Double> pingTimeValues,int packets){
        double median=0.0;
        Collections.sort(pingTimeValues);
        if(packets%2==0){
            int midValueIndex1=(packets/2)-1;
            int midValueIndex2=packets/2;
            median = (pingTimeValues.get(midValueIndex1)+pingTimeValues.get(midValueIndex2))/2;
        }
        else{
            int midValueIndex=pingTimeValues.size()/2;
            median=pingTimeValues.get(midValueIndex);
        }
        return median;
    }

}
