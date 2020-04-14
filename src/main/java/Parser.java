import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<KPP> kppList = new ArrayList<>();
    private List<BillAccounts> billAccountsList= new ArrayList<>();
    private List<String> letterCodeList = new ArrayList<>();

    public void parse(String fileName) throws IOException, SAXException, ParserConfigurationException {
        File file = new File("C://parse//Partner(input)_" + fileName + ".xml"); //передадим сюда fileName

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        NodeList kppNodeList = document.getElementsByTagName("KPP");
        NodeList billAccountsNodeList = document.getElementsByTagName("BillAccounts");
        NodeList letterCodeNodeList = document.getElementsByTagName("Currency");

        for (int i = 0; i < kppNodeList.getLength(); i++) {
            if (kppNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) kppNodeList.item(i);
                i = i + 1;

                KPP kpp = new KPP();

                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()) {
                            case "KPP": {
                                kpp.setKpp(Integer.valueOf(childElement.getTextContent()));
                            }
                            break;

//                            case "Note": {
//                                kpp.setNote(childElement.getTextContent());
//                            }
//                            break;
//
//                            case "CreateDate": {
//                                kpp.setCreateDate(childElement.getTextContent());
//                            }
//                            break;
//
//                            case "LastUpdateDate": {
//                                kpp.setLastUpdateDate(childElement.getTextContent());
//                            }
                        }
                    }
                }

                kppList.add(kpp);

            }
        }

        for (int i = 0; i < billAccountsNodeList.getLength(); i++) {
            if (billAccountsNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) billAccountsNodeList.item(i);
                BillAccounts billAccounts = new BillAccounts();

                NodeList childNodes = element.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);

                        switch (childElement.getNodeName()) {
                            case "AccountNumber": {
                                billAccounts.setAccountNumber(childElement.getTextContent());
                            }
                            break;

                            case "Currency": {
                                billAccounts.setCurrency(childElement.getTextContent());
                            }
                            break;

                        }
                    }
                }

                billAccountsList.add(billAccounts);

            }
        }

 //печатаем kpp
        for (int i = 0; i < kppList.size(); i++) {
            System.out.println(kppList.get(i).getKpp());
        }

        for (int i = 0; i < billAccountsList.size(); i++) {
            System.out.println(billAccountsList.get(i).getAccountNumber());
            System.out.println(billAccountsList.get(i).getCurrency());
        }


        CreateNewXML outputXml = new CreateNewXML();
        try {
            outputXml.create(kppList, billAccountsList, fileName);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}

