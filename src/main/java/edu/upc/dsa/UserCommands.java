package edu.upc.dsa;


import java.util.List;

/**
 * Created by Marc on 21/12/2016.
 */
public interface UserCommands {

    public void insertUser(String name, String password);
    public void modUser(String name, String password);
    public User showUser(String name);
    public <Etakemon> List<Etakemon> showuserEtakemon(String name);
    public void addEtakemon(String user, Etakemon etakemon);
    public Etakemon showEtakemon(String name);
}

