package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String body;
    List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    public String toString() {
        StringBuilder output = new StringBuilder().append("<").append(name).append(" ");
        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            output.append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\" ");
        }
        output.setLength(output.length() - 1);
        output.append(">").append(body);

        for (Tag child: children) {
           output.append(child.toString());
        }
        output.append("</").append(name).append(">");
        return output.toString();
    }
}
// END
