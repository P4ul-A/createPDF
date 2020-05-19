package paularnold;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;

public class minWorking {
    public static void main(String[] args) throws IOException {

        try (PDDocument document = new PDDocument()) {
            final PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {


                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA,30);
                contentStream.moveTextPositionByAmount(250,800);
                contentStream.showText("import org.apache.pdfbox.pdmodel.PDDocument;" +
                        "import org.apache.pdfbox.pdmodel.PDPage;" +
                        "import org.apache.pdfbox.pdmodel.PDPageContentStream;" +
                        "import org.apache.pdfbox.pdmodel.common.PDRectangle;" +
                        "import org.vandeseer.easytable.TableDrawer;" +
                        "import org.vandeseer.easytable.settings.HorizontalAlignment;" +
                        "import org.vandeseer.easytable.structure.Row;" +
                        "import org.vandeseer.easytable.structure.Table;" +
                        "import org.vandeseer.easytable.structure.cell.TextCell;");
                contentStream.endText();



                // Build the table
                Table myTable = Table.builder()
                        .addColumnsOfWidth(60, 300,80)
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("One One").borderWidth(1).backgroundColor(Color.GRAY).build())
                                .add(TextCell.builder().text("One Two").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
                                .add(TextCell.builder().text("One Three").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
                                .build())
                        .addRow(Row.builder()
                                .add(TextCell.builder().text("Two One").borderWidth(1).textColor(Color.RED).build())
                                .add(TextCell.builder().text("Two Two").borderWidth(1).horizontalAlignment(HorizontalAlignment.RIGHT).build())
                                .add(TextCell.builder().text("Two Three").borderWidth(1).backgroundColor(Color.LIGHT_GRAY).build())
                                .build())
                        .borderColor(Color.WHITE)
                        .build();

                // Set up the drawer
                TableDrawer tableDrawer = TableDrawer.builder()
                        .contentStream(contentStream)
                        .startX(60)
                        .startY(page.getMediaBox().getUpperRightY() - 60)
                        .table(myTable)
                        .build();

                // And go for it!
                tableDrawer.draw();
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA,30);
                contentStream.showText("HI");
                contentStream.endText();
            }


            document.save("d"+  CreatePDF.timeOfCreation()+".pdf");
        }
    }

}

