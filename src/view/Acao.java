package view;

import util.exceptions.HashMapInvalidoException;

import java.util.Map;

/**
 *
 * @author lhfba
 */
public abstract class Acao {
    
    public Map agir() throws HashMapInvalidoException, Exception{
        return this.__realizarAcao();
        
    }
   
    /**
     * Metodo que será sobrescrita dependendo da acao 
     * @return 
     * @throws HashMapInvalidoException
     * @throws util.exceptions.LoginException 
     */
    public abstract Map __realizarAcao() throws Exception;


    
}
