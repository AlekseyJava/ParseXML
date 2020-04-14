import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkWithBase {
    public void extractData() {
        List<String> listIdXML = new ArrayList<String>();
        String sb = "";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C://parse//Base.accdb");
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM ASUXML";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                listIdXML.add(rs.getString(1));
                try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
                        ("//C://parse//Partner(input)_" + rs.getString(1) + ".xml"),
                        "UTF-8"))) {

                    sb = rs.getString(2);
                    bw.write(sb);
                    bw.flush();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //пробираемся по файлам XML
        //и в каждом файле делаем преобразования
        for (int i = 0; i < listIdXML.size(); i++) {
            Parser parser = new Parser();
            try {
                parser.parse(listIdXML.get(i));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }



    }
}
