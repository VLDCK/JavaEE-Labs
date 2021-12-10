
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
@WebService(targetNamespace = "java.SoapInterface")
public class SoapClass implements SoapInterface{
@WebResult(name = "SoapTest")

    @WebServiceRef
    private static String testString= "test";


    @Override
    public String SoapTestFun() {
        return "Its Soap";
    }
    
    @WebMethod(operationName = "setTextParam")
    public String setTextParam(@WebParam(name = "name", mode = IN) String txt)
    {
        return txt ;
    }
    
}
