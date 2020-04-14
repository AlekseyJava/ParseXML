
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CreateNewXML {
    public void create(List<KPP> kpps, List<BillAccounts> billAccounts, String fileName) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element transmission = document.createElement("Transmission");
        Element transmissionBody = document.createElement("TransmissionBody");
        Element gLogXMLElement = document.createElement("GLogXMLElement");
        Element location = document.createElement("Location");

        document.appendChild(transmission);
        transmission.appendChild(transmissionBody);
        transmissionBody.appendChild(gLogXMLElement);
        gLogXMLElement.appendChild(location);

        for(int i = 0; i < kpps.size(); i++){
            Element locationRefnum = document.createElement("LocationRefnum");
            Element locationRefnumQualifierGid = document.createElement("LocationRefnumQualifierGid");
            Element locationRefnumValue = document.createElement("LocationRefnumValue");
            Element gid = document.createElement("Gid");
            Element xid = document.createElement("Xid");
            Element kpp = document.createElement("КПП");
            Element value = document.createElement("value");
            location.appendChild(locationRefnum);
            locationRefnum.appendChild(locationRefnumQualifierGid);
            locationRefnumQualifierGid.appendChild(gid);
            gid.appendChild(xid);
            xid.appendChild(kpp);
            kpp.setAttribute("КПП", "КПП_" + (i + 1));
            location.appendChild(locationRefnumValue);
            locationRefnumValue.appendChild(value);
            value.setAttribute("value", String.valueOf(kpps.get(i).getKpp()));
        }

        for(int i = 0; i < billAccounts.size(); i++){
            Element locationRefnum = document.createElement("LocationRefnum");
            Element locationRefnumQualifierGid = document.createElement("LocationRefnumQualifierGid");
            Element locationRefnumValue = document.createElement("LocationRefnumValue");
            Element gid = document.createElement("Gid");
            Element xid = document.createElement("Xid");
            Element schet = document.createElement("Счет");
            Element value = document.createElement("AccountNumber");
            location.appendChild(locationRefnum);
            locationRefnum.appendChild(locationRefnumQualifierGid);
            locationRefnumQualifierGid.appendChild(gid);
            gid.appendChild(xid);
            xid.appendChild(schet);
            schet.setAttribute("Счет", "Счет_" + (i + 1));
            location.appendChild(locationRefnumValue);
            locationRefnumValue.appendChild(value);
            //value.setAttribute("AccountNumber", String.valueOf(kpps.get(i).getKpp()));
            value.setAttribute("AccountNumber", billAccounts.get(i).getAccountNumber());
        }

//        Transformer t = TransformerFactory.newInstance().newTransformer();
//        t.setOutputProperty(OutputKeys.INDENT, "yes");
//        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("C://parse//Partner_" + fileName + ".xml")));
//        try {


        DOMImplementation impl = document.getImplementation();
        DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        LSSerializer ser = implLS.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
        //String str = ser.writeToString(document);
        //System.out.println(str);

        LSOutput out = implLS.createLSOutput();
        out.setEncoding("UTF-8");
        try {
            out.setByteStream(Files.newOutputStream(Paths.get("C://parse//Partner_"+fileName + ".xml")));
            ser.write(document, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
