/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author anuja dilrukshi
 */
@WebService(serviceName = "ICT2WebService")
public class ICT2WebService {

    private final ArrayList<String> strList = new ArrayList<>();
    /**
     * This is a sample web service operation
     * @param txt
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "testConnection")
    public Integer testConnection() {
        //TODO write your implementation code here:
      System.out.println("[server]- server connection started");
        return 0;
    }

    /**
     * Web service operation
     * @param d1
     * @param d2
     * @return 
     */
    @WebMethod(operationName = "sum")
    public Double sum(@WebParam(name = "d1") Double d1, @WebParam(name = "d2") Double d2) {
        //TODO write your implementation code here:
        System.out.println("[server]- adding " + d1 + " + " + d2 );
        return d1+d2;
    }
    
     @WebMethod(operationName = "safeSum")
    public Double safeSum(@WebParam(name = "d1") Double d1, @WebParam(name = "d2") Double d2)throws Exception {
        //TODO write your implementation code here:
        if (d1 == null || d2 == null){
            throw new Exception("Received null value");
        }
        System.out.println("[server]- adding " + d1 + " + " + d2 );
        return d1+d2;
    
    }

    /**
     * Web service operation
     * @param a
     * @throws java.lang.Exception
     */
    @WebMethod(operationName = "addStringOnServer")
    public void addStringOnServer(@WebParam(name = "a") String a) throws Exception {
            if(a==null){
                throw new Exception("Cannot add a null value");
            } 
        System.out.println("[Server] - Appending " + a + " to the list");
        strList.add(a);
        
    }

    /**
     * Web service operation
     * @return 
     * @throws java.lang.Exception
     */
    @WebMethod(operationName = "getLongestString")
    public String getLongestString() throws Exception {
        //TODO write your implementation code here:
        if(strList.size()==0){
            throw new Exception("There are no values in the list");
            
        }
        System.out.println("[Server] - returning the longest string....");
        String l = strList.get(0);
        for(String x: strList)    
        {
            if (x.length()>l.length())
            {
                l= x;
            }
        }
        return l;
    }

    /**
     * Web service operation
     * @param c
     * @return 
     */
    @WebMethod(operationName = "getAllStringsShorterThan")
    public ArrayList<String> getAllStringsShorterThan(@WebParam(name = "c") Integer c) {
        //TODO write your implementation code here:
        ArrayList<String> temp = new ArrayList<>();
        strList.stream().filter((x) -> (x.length()<=c)).forEachOrdered((x) -> {
            temp.add(x);
        });
        return temp;
    }
    
    
}