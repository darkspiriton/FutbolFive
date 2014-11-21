/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.singleton;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Cesar
 */
public class Sms {
    private static final Sms s = new Sms() ;
    private static final String ACCOUNT_SID = "ACc051e3d54be084971874b29f3686637e"; 
    private static final String AUTH_TOKEN = "b42b25209e0cc8d9ac2aa81d181d4bcb"; 
        
    private Sms(){
     
    }
    
    public static Sms getSms(){
        return s;
    }
    
    public void enviarMensaje(List numbers,String body) throws TwilioRestException{
        String number;
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
        if(numbers.size()>0){
            for(int i=0;i<numbers.size();i++){
                number=numbers.get(i).toString();
                
                 // Build the parameters 
                List<NameValuePair> params = new ArrayList<NameValuePair>(); 
                params.add(new BasicNameValuePair("To", "+51"+number)); 
                params.add(new BasicNameValuePair("From", "+15005550006")); 
                params.add(new BasicNameValuePair("Body", body));   

                MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
                Message message = messageFactory.create(params); 
                System.out.println(message.getSid()+" N°:"+number+" Mennsaje: "+body);                
            }   
        }else{
            System.out.println("La lista de numeros esta vacio"); 
        }	  
 }

    public void enviarMensaje(List obtenerNumTL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
