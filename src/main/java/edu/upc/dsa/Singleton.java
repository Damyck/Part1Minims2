package edu.upc.dsa;

import java.util.*;

import org.apache.log4j.Logger;

/**
 * Created by Marc on 21/12/2016.
 */public class Singleton implements UserCommands {



    private static Singleton instance=null;
    private List<User> users;
    private List<Etakemon> etaklist;
    private List<Etakemon> etaks;
    private int cont=1;
    private int sum=1;
    private Singleton(){

        users = new ArrayList<User>();
        etaklist = new ArrayList<Etakemon>();
        etaks = new ArrayList<Etakemon>();
        Etakemon pik = new Etakemon("pik", "hor");
        Etakemon puk = new Etakemon("puk", "hsfdsor");
        Etakemon pek = new Etakemon("pek", "hsdfsr");
        etaks.add(pik);
        etaks.add(puk);
        etaks.add(pek);

    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();

        }
        return instance;

    }

    public int getCont(){
        return cont-1;
    }

    public List<User> getUsers(){
        return users;
    }

    @Override
    public void insertUser(String name, String password) {

        User user = new User(name, password);
        users.add(user);
        cont++;


    }

    @Override
    public void modUser(String name, String password) {

    }

    @Override
    public Etakemon showEtakemon(String name) {
        Etakemon et=null;
        Iterator<Etakemon> it = etaks.iterator();
        int i = 0;
        while (it.hasNext()) {

            if (name == it.getClass().getName()){
                et = etaks.get(i);
            }
            i++;


        }
        return et;
    }

    @Override
    public User showUser(String name) {
        User us=null;
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {

            if (name == it.getClass().getName()){
                us = users.get(i);
            }
            i++;


        }
        return us;
    }

    @Override
    public  List<Etakemon> showuserEtakemon(String name) {
        List<Etakemon> etaklist = null;
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {

            if (name ==users.get(i).getName()) {
                etaklist = users.get(i).getEtak();
                sum++;
            }
            i++;


        }

        return  etaklist;


    }

    @Override
    public void addEtakemon(String name, Etakemon etakemon) {

        List<Etakemon> etaklist = null;
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {

            if (name ==users.get(i).getName()) {
                User us = users.get(i);
                us.addEtak(etakemon);
                users.set(i, us);
            }
            i++;


        }
    }
}
