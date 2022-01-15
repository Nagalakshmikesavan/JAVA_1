package Singleton_pkg;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static Singleton singleton=null;                  //Lazy Loading
   // private static Singleton singleton= new Singleton();    //Eager loading

    private Singleton(){

    }

    public static Singleton getInstance()
    {
        if(singleton==null){
            synchronized (Singleton.class) {          //double check singleton
                if (singleton == null) {
                    singleton = new Singleton();
                    return singleton;
                }
            }
        }

        return singleton;
    }

    public Object readResove(){
        return Singleton.singleton;           //to avoid creating 2 instance while deserilising
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
