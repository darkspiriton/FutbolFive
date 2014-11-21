
package futbol.five.com.singleton;

import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.UsuarioIF;
import java.util.List;


public class SingletonUsuario {
    
    private static UsuarioIF u=new  UsuarioDAO();
    
    private static final SingletonUsuario a= new SingletonUsuario();

    public SingletonUsuario() {
    }
    
    public static SingletonUsuario getUsuario(){
        return a;
    }
    
     
}
