package Singleton_pkg;

import java.io.*;

public class Singleton_Main  {
    public static void main(String args[])
    {
//        Singleton s = Singleton.getInstance();
//        System.out.println("Before Serilisation "+s.hashCode());
        Enum s = Enum.INSTANCE;
        System.out.println("Before Serilisation "+s.hashCode());

        try{
            FileOutputStream file = new FileOutputStream("E:\\JAVA\\serilisation.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("After serilisation "+s.hashCode());

        try{
            FileInputStream filein= new FileInputStream("E:\\JAVA\\serilisation.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            s = (Enum) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("After the deserilisation "+s.hashCode());


        Singleton s2 = Singleton.getInstance();
        System.out.println(s.hashCode());



    }
}
