package paularnold;

import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;


public class Main {

    public static void main(String[] args) {

        Customer donaldTrump = new Customer("Donald", "Trump", "SexShop24",
                "Street", "69", "NEwYork", "12345",
                "3956972123", "afbk@web.de", "BankBank", "028765256");

        String xml = "";

        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(donaldTrump,stringWriter);
             xml = stringWriter.toString();
            System.out.println(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            FopFactory fopFactory = FopFactory.newInstance(new File("C:/Speicher/Clouds/OneDrive - hochschule-stralsund.de/4_Semester/Mobile Systeme/Aufgaben/Code/creatingAPdf/src/paularnold/fop.xconf"));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(("C:/Users/paulz/Downloads/test.pdf"))));

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF,out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();

            Source src = new StreamSource( new ByteArrayInputStream(xml.getBytes()));

            Result result = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src,result);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
