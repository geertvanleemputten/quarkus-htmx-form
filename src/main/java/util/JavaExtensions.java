package util;

import io.quarkus.qute.TemplateExtension;

@TemplateExtension
public class JavaExtensions {

    public static String capitalise(final String string) {
        final StringBuilder sb = new StringBuilder();
        for (String part : string.split("\\s+")) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            if (!part.isEmpty()) {
                sb.append(part.substring(0, 1).toUpperCase());
                sb.append(part.substring(1));
            }
        }
        return sb.toString();
    }
}
