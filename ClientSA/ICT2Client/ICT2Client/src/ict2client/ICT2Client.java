/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICT2Client;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anuja dilrukshi
 */
public class ICT2Client {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
       ICT2Client client = new ICT2Client();
       client.execute();
    }
    private void execute(){
        System.out.println("[client]-Start testing");
        if (testConnection() ==0)
        {
            System.out.println("[client]- server connected");
         Double d1 ;
         Double d2;
         Double z;
         
         d1= 5.0;
         d2 =2.0;
            System.out.println("[client] - sending  "+ d1 + " and " + d2  +"calling sum method");
         z= sum(d1,d2);
            System.out.println("[client] - received " + z + " from server as an output");
            
            
         d1= 6.0;
         d2 =4.0;
            System.out.println("[client] - sending  "+ d1 + " and " + d2  +"calling sum method");
         z= sum(d1,d2);
            System.out.println("[client] - received " + z + " from server as an output");
            
         d1= null;
         d2= null;
            try {
            System.out.println("[client] - sending  "+ d1 + " and " + d2  +"calling safesum method (testing with exception)");
   
                z= safeSum(d1, d2);
              System.out.println("[client] - received  "+ z  +" from server as an output");
  
            } catch (Exception_Exception ex) {
                //Logger.getLogger(ICT3.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println( ex.getMessage());
            }
        String a ="Hi ";
            System.out.println("[Client] - sending " + a + " to append...");
            try {
                addStringOnServer(a);
            } catch (Exception_Exception ex) {
               // Logger.getLogger(ICT3.class.getName()).log(Level.SEVERE, null, ex);
            }
             a ="Anu ";
            System.out.println("[Client] - sending " + a + " to append...");
            try {
                addStringOnServer(a);
            } catch (Exception_Exception ex) {
               // Logger.getLogger(ICT3.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer r = 6;
            
            System.out.println("Getting all the Streings shorter than " + r);
           List<String> k = getAllStringsShorterThan(r);
            System.out.println("Received the folling strings as the results");
           for(String o : k){
               
               System.out.println(o);
           }
        System.out.println("[Client] - data added successfully.....");
        }
        else{
            System.out.println("[client]- server Not connected... testing failed");
        }
        System.out.println("[client]-test completed....");
    }
    

    private static Integer testConnection() {
       ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        return port.testConnection();
    }

    private static Double sum(java.lang.Double d1, java.lang.Double d2) {
        ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        return port.sum(d1, d2);
    }

    private static Double safeSum(java.lang.Double d1, java.lang.Double d2) throws Exception_Exception {
        ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        return port.safeSum(d1, d2);
    }

  

    private static java.util.List<java.lang.String> getAllStringsShorterThan(java.lang.Integer c) {
        ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        return port.getAllStringsShorterThan(c);
    }

    private static void addStringOnServer(java.lang.String a) throws Exception_Exception {
        ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        port.addStringOnServer(a);
    }

    private static String getLongestString() throws Exception_Exception {
        ICT2Client.ICT2WebService_Service service = new ICT2Client.ICT2WebService_Service();
        ICT2Client.ICT2WebService port = service.getICT2WebServicePort();
        return port.getLongestString();
    }

   
    
    
}