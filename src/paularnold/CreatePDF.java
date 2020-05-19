package paularnold;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.elements.render.ColumnLayout;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;
import rst.pdfbox.layout.text.Alignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;

public class CreatePDF {

    Customer owner;
    Customer customer;
    ArrayList<Service> services;
    String outputPath;

    public CreatePDF(Customer owner, Customer customer, ArrayList<Service> services) throws FileNotFoundException, IOException {
        this.owner = owner;
        this.customer = customer;
        this.services = services;
        this.outputPath = "Invoice for " + customer.getFirstName() + " " + customer.getLastName() + " " + timeOfCreation() + ".pdf";
    }

    public Document createPDF() throws IOException {
        Document document = new Document(40, 50, 40, 60);
        document.add(customerParagraph(owner), VerticalLayoutHint.RIGHT);
        document.add(customerParagraph(customer), VerticalLayoutHint.LEFT);
        document.add(addLineAsNewParagraph("\n"));
        document.add(addLineAsNewParagraph("\n"));
        document.add(addLineAsNewParagraph("\n"));
        document.add(addLineAsNewParagraph("Services completed today:"), VerticalLayoutHint.LEFT);
        //servicetable(document, services);
        document.add(fakeServiceTable(services));
        document.add(addLineAsNewParagraph("Thank you for doing business with us!"));
        final OutputStream outputStream = new FileOutputStream(outputPath);
        document.save(outputStream);
        return document;
/*
        File file = new File(outputPath);
        PDDocument doc = PDDocument.load(file);
        PDPage page = doc.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(doc,page);
        contentStream.beginText();
        //contentStream.setFont(PDType1Font.HELVETICA,30);
        contentStream.showText("HI");
        contentStream.endText();
        contentStream.close();
        doc.save(outputPath+".pdf");
        doc.close();
 */

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

    public static Paragraph addLineAsNewParagraph(String text) throws IOException {
        Paragraph p = new Paragraph();
        p.setAlignment(Alignment.Left);
        addLineToParagraph(p, text);
        return p;
    }

    public static Paragraph fakeServiceTable(ArrayList<Service> services) throws IOException {
        Paragraph servicetable = new Paragraph();
        PDDocument doc = new PDDocument();
        PDAcroForm form = doc.getDocumentCatalog().getAcroForm();

        for (Service service : services) {
            //addLineToParagraph(servicetable,stringofLenghtOf(30,service.getName()),stringofLenghtOf(85,service.getDescription()),service.getPriceAsString());
            //addLineToParagraph(servicetable, service.getName(), form.getField("pdfbox-tab"), service.getDescription());
        }
        addLineToParagraph(servicetable, "\n\n");

        return servicetable;
    }


    public static void servicetable(Document document, ArrayList<Service> services) throws IOException {
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

    public static String timeOfCreation() {
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

    public static String spacer(int amount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static String stringofLenghtOf(int length, String s) {
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.append(spacer(length - s.length()));
        return builder.toString();
    }


}
