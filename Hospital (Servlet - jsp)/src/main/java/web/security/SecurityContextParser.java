package web.security;

import bean.enums.UserRole;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Egor on 15.11.2016.
 */
public class SecurityContextParser {
    private final static Logger LOG = Logger
            .getLogger(SecurityContextParser.class);

    private Map<UserRole, List<String>> permissions = new HashMap<>();

    private static DocumentBuilderFactory documentBuilderFactory;
    private static DocumentBuilder builder;

    public SecurityContextParser() throws ParserConfigurationException {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        builder = documentBuilderFactory.newDocumentBuilder();
    }

    public Map<UserRole, List<String>> parseSecurityContext(String path) {
        try {
            Document document = builder.parse(new File(path));
            NodeList permissionsNodeList = document.getElementsByTagName("permissions");
            for (int i = 0; i < permissionsNodeList.getLength(); i++) {
                Element element = (Element) permissionsNodeList.item(i);
                parsePermission(element);
            }
        } catch (SAXException |
                IOException e) {
            LOG.error("Can't parse security file ", e);
        }
        return permissions;
    }

    private void parsePermission(Element element) {
        UserRole role = UserRole.getValue(element.getAttributes().getNamedItem("role").getTextContent());
        List<String> path = new ArrayList<>();
        NodeList nodelist = element.getElementsByTagName("path");
        for (int i = 0; i < nodelist.getLength(); i++) {
            path.add(nodelist.item(i).getTextContent());
        }
        permissions.put(role, path);
    }
}