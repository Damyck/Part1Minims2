package edu.upc.dsa;

import edu.upc.dsa.Etakemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marc on 21/12/2016.
 */
public class User  {

    String name;
    String password;
    List<Etakemon> etak = new ArrayList<Etakemon>();

    public User(String name, String password){

        this.name = name;
        this.password = password;

    }

    public void addEtak(Etakemon etake){
        etak.add(etake);
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public List<Etakemon> getEtak(){
        return etak;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String pass) {
        this.password = pass;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", password=" + password + "]";
    }

}
