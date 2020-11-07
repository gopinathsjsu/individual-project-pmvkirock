package com.company;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLReader implements AdapterFileReader{
    public ArrayList<String> readCSV(String fileName){
        return null;
    }
    public ArrayList<String> readJSON(String fileName){
        return null;
    }

    public ArrayList<String> readXML(String fileName){
        try
        {
            File file = new File(fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("row");
            ArrayList<String> cardNo = new ArrayList<String>();
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    cardNo.add(eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
                }
            }
            return cardNo;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void writeCSV(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){

    }

    public void writeJSON(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){

    }

    public void writeXML(String readerType, ArrayList<String> cardNo, ArrayList<String> cardType){
        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("root");
            document.appendChild(root);
            for(int i = 0; i < cardNo.size(); i++) {
                // employee element
                Element employee = document.createElement("row");

                root.appendChild(employee);


                // firstname element
                Element cardNumber = document.createElement("CardNumber");
                cardNumber.appendChild(document.createTextNode(cardNo.get(i)));
                employee.appendChild(cardNumber);

                // lastname element
                Element cardT = document.createElement("CardType");
                cardT.appendChild(document.createTextNode(cardType.get(i)));
                employee.appendChild(cardT);
            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("/Users/haackpad/Desktop/Desktop - MacBook Pro/CMPE 202/individual-project-pmvkirock/src/com/company/Output.xml"));

            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
