package paularnold;

import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.elements.render.ColumnLayout;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;
import rst.pdfbox.layout.text.Alignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Main {

    public static void main(String[] args) {

        Customer donaldTrump = new Customer("Donald", "Trump", "SexShop24",
                "Street", "69", "NewYork", "12345",
                "3956972123", "afbk@web.de", "BankBank", "028765256");
        Customer batMan = new Customer("Bat", "Man", "Catching Bad guys",
                "WayneManor", "1", "Gotham", "02056",
                "685972542095", "bat@man.com", "BadBank", "269592456");
        Service cleaning = new Service("Cleaning", "Everything with a lot of water", 99.99);
        Service murder = new Service("Murder", "fast and dirty", 1000.00);
        Service handstuff = new Service("Handstuff", "Lots of creme", 1.00);


        try {

            Document document = new Document(40, 50, 40, 60);
            document.add(customerParagraph(donaldTrump), VerticalLayoutHint.RIGHT);
            document.add(customerParagraph(batMan), VerticalLayoutHint.LEFT);
            document.add(setHeadline("Services completed today:"), VerticalLayoutHint.LEFT);
            servicetable(document, cleaning, murder, handstuff);
            document.add(setHeadline("Thank you for doing business with us!"));
            final OutputStream outputStream = new FileOutputStream("hello.pdf");
            document.save(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Paragraph customerParagraph(Customer customer) throws IOException {
        Paragraph p = new Paragraph();
        p.setAlignment(Alignment.Left);
        addLineToParagraph(p, customer.getFirstName(), customer.getLastName());
        addLineToParagraph(p, customer.getBusinessName());
        addLineToParagraph(p, customer.getAddressStreetName(), customer.getAddressStreetNumber());
        addLineToParagraph(p, customer.getAddressCityZipCode(), customer.getAddressCity());
        addLineToParagraph(p, "Phone: ", customer.getPhoneNumber());
        addLineToParagraph(p, "Mail:  ", customer.getMail());
        addLineToParagraph(p, customer.getBankName(), " / ", customer.getBankNumber());
        return p;
    }

    public static Paragraph setHeadline(String text) throws IOException {
        Paragraph p = new Paragraph();
        p.setAlignment(Alignment.Left);
        newLineInParagaph(p);
        newLineInParagaph(p);
        addLineToParagraph(p, text);
        newLineInParagaph(p);
        return p;
    }

    public static void servicetable(Document document, Service... services) throws IOException {
        document.add(new ColumnLayout(3, 5));
        Paragraph names = new Paragraph();
        names.setAlignment(Alignment.Left);
        for (Service service : services) {
            addLineToParagraph(names, service.getName());
        }
        document.add(names);
        document.add(ColumnLayout.NEWCOLUMN);
        Paragraph descriptions = new Paragraph();
        descriptions.setAlignment(Alignment.Left);
        for (Service service : services) {
            addLineToParagraph(descriptions, service.getDescription());
        }
        document.add(descriptions);
        document.add(ColumnLayout.NEWCOLUMN);
        Paragraph prices = new Paragraph();
        prices.setAlignment(Alignment.Right);
        for (Service service : services) {
            addLineToParagraph(prices, service.getPriceAsString());
        }
        document.add(prices);
        document.add(ColumnLayout.NEWCOLUMN);

    }

    public static void addLineToParagraph(Paragraph paragraph, String... s) throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();
        for (String stringPart : s) {
            stringBuilder.append(stringPart);
            stringBuilder.append(" ");
        }
        paragraph.addText(stringBuilder.toString().trim() + "\n", 12, PDMMType1Font.HELVETICA);
    }

    public static void newLineInParagaph(Paragraph p) throws IOException {
        p.addText("\n", 12, PDMMType1Font.HELVETICA);
    }

}
