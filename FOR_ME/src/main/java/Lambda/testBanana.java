package Lambda;

import java.util.ArrayList;
import java.util.List;

public class testBanana {
    public static void main(String[] args) {
        List<Banana> exelBanana = new ArrayList<>();
        exelBanana.add(new Banana("Green", 500.00));
        exelBanana.add(new Banana("Yellow", 20.00));
        exelBanana.add(new Banana("Green", 800.00));
        exelBanana.add(new Banana("yellow", 40.00));
//========================================================================================
        // using Lambda
        InterfaceBanana interfaceBananaLambda = Banana -> "An Banana of " + Banana.getWeight() + "g";
        printBananaMethod(exelBanana, interfaceBananaLambda);
        printBananaMethod(exelBanana, Banana -> " Color " + Banana.getColor());

//===========================================================================================
        // using if with Lambda
        InterfaceBanana interfaceBananaLambda1 = Banana -> {
            String ch = Banana.getWeight() > 200 ? " Heavy " : " light ";
            /*
            if (Banana.getWeight() > 200 ?){
            System.out.print("Heavy")
            }else{
            System.out.print("light")
            }
             */

            return "A" + ch + " " + Banana.getColor();

        };
//============================================================================================
        //Calling method
        printBananaMethod(exelBanana, interfaceBananaLambda1);
//============================================================================================
        // another method

        printBananaMethod(exelBanana, Banana -> {

            String output = null;
            for (int i = 0; i < exelBanana.size(); i++) {
                output =exelBanana.get(i)+" "+interfaceBananaLambda1.collingMethod(exelBanana.get(i));
            }
                    return output;
                }
        );


    }

    //=================================================================================================
    public static void printBananaMethod(List<Banana> bananaList, InterfaceBanana interfaceBanana) {
        for (Banana each : bananaList) {
            String output = interfaceBanana.collingMethod(each);
            System.out.println(output);
        }
    }

}
