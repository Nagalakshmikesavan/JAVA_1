package Serialisation_Deserialisation;

public class Swap_2_Str_without_using_3rd_Variable {

    public static void main(String[] args) {

        String a = "naga";
        String b = "Lakshu";

        System.out.println(a+" "+b);

        a = a+b;
        b = a.substring(0,a.length()-b.length());
        a = a.substring(b.length());

        System.out.println(a+" "+b);
    }
}
