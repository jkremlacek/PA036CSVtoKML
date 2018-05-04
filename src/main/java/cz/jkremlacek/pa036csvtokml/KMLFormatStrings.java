package cz.jkremlacek.pa036csvtokml;

/**
 * @author Jakub Kremláček
 */
public class KMLFormatStrings {
    public static final String HEADER =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n" +
            "<Document>" +
            "<name>DB map</name>" +
            "%s\n" +
            "</Document>" +
            "</kml>";

    public static final String PLACEMARK =
            "   <Placemark>\n" +
            "       <name>%s</name>\n" +
            "       <description>%s</description>\n" +
            "       <Point>\n" +
            "           <coordinates>%s,%s,0</coordinates>\n" +
            "       </Point>\n" +
            "   </Placemark>\n";

    public static String addHeader(StringBuilder sb) {
        return String.format(HEADER, sb.toString());
    }

    public static void addPlacemark(StringBuilder sb, String name, String description, String x, String y) {
        sb.append(String.format(PLACEMARK, name, description, x, y));
    }
}
