package paularnold;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {

        Customer donaldTrump = new Customer("Donald", "Trump", "SexShop24",
                "Street", "69", "NewYork", "12345",
                "3956972123", "afbk@web.de", "BankBank", "028765256");
        Customer batMan = new Customer("Bat", "Man", "Catching Bad guys",
                "WayneManor", "1", "Gotham", "02056",
                "685972542095", "bat@man.com", "BadBank", "269592456");
        Service cleaning = new Service("Cleaning", "Everything with a lot of water", 99.99);
        Service murder = new Service("Murder", "fast and dirty", 1000.00);
        Service handstuff = new Service("Handstuff", "Lots of creme", 1.00);

        ArrayList<Service> services = new ArrayList<>();
        services.add(cleaning);
        services.add(murder);
        services.add(handstuff);

        /*
        CreatePDF pdf;
        try {
            pdf = new CreatePDF(donaldTrump, batMan, services);
            pdf.createPDF();
        } catch (IOException e){
            e.printStackTrace();
        }

         */

        minWorking.main(new String[]{"hi"});

    }
}
