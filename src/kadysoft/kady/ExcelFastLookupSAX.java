package kadysoft.kady;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;

public class ExcelFastLookupSAX {

    public static void main(String[] args) throws Exception {
        String filePath = "D:\\Absent_2025.xlsx";     // Excel file path
        String targetCode = "20673";                  // Code to search for
        String targetSheetName = "Absent";            // Sheet to search in

        OPCPackage pkg = OPCPackage.open(filePath);
        XSSFReader reader = new XSSFReader(pkg);
        ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(pkg);
        SheetIterator sheets = (SheetIterator) reader.getSheetsData();

        boolean sheetFound = false;

        while (sheets.hasNext()) {
            InputStream sheetInputStream = sheets.next();
            String sheetName = sheets.getSheetName();

            if (sheetName.equalsIgnoreCase(targetSheetName)) {
                sheetFound = true;

                XMLReader parser = XMLReaderFactory.createXMLReader();
                SheetHandler handler = new SheetHandler(targetCode, strings);
                parser.setContentHandler(handler);
                parser.parse(new InputSource(sheetInputStream));

                if (handler.found) {
                    System.out.println("✅ Code found: " + targetCode);
                    System.out.println("👤 Name: " + handler.name);
                    System.out.println("🕒 Shift: " + handler.shift);
                } else {
                    System.out.println("❌ Code not found in sheet: " + targetSheetName);
                }
                break;
            }
        }

        if (!sheetFound) {
            System.out.println("❌ Sheet not found: " + targetSheetName);
        }
    }

    static class SheetHandler extends DefaultHandler {
        private final String targetCode;
        private final ReadOnlySharedStringsTable strings;

        private String lastContents = "";
        private String currentRef = "";
        private String cellType = "";
        private boolean isInlineStr = false;
        private boolean isValueOpen = false;

        public String code = null, name = null, shift = null;
        public boolean found = false;

        SheetHandler(String targetCode, ReadOnlySharedStringsTable strings) {
            this.targetCode = targetCode;
            this.strings = strings;
        }

        private int getColIndex(String colLetters) {
            int index = 0;
            for (char c : colLetters.toCharArray()) {
                index = index * 26 + (c - 'A' + 1);
            }
            return index - 1;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("c")) {
                currentRef = attributes.getValue("r"); // e.g., "E12"
                cellType = attributes.getValue("t");   // e.g., "s", "inlineStr"
                isInlineStr = "inlineStr".equals(cellType);
            } else if (qName.equals("v") || (isInlineStr && qName.equals("t"))) {
                isValueOpen = true;
                lastContents = "";
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (isValueOpen) {
                lastContents += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("v") || (isInlineStr && qName.equals("t"))) {
                String value = lastContents.trim();

                if ("s".equals(cellType)) {
                    int idx = Integer.parseInt(value);
                    value = strings.getItemAt(idx).getString();
                }

                String colLetters = currentRef.replaceAll("\\d", "");
                int colIndex = getColIndex(colLetters);

                switch (colIndex) {
                    case 4 : code = value;     // Column E
                    case 5 : name = value;     // Column F
                    case 13 : shift = value;   // Column N
                }

                isValueOpen = false;
            }

            if (qName.equals("row")) {
                if (code != null && code.equals(targetCode)) {
                    found = true;
                }

                if (!found) {
                    code = null;
                    name = null;
                    shift = null;
                }
            }
        }
    }
}
