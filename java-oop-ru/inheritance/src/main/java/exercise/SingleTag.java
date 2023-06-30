package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    public String toString() {
        StringBuilder output = new StringBuilder().append("<").append(name).append(" ");
        for (Map.Entry<String, String> attribute: attributes.entrySet()) {
            output.append(attribute.getKey()).append("=\"").append(attribute.getValue()).append("\" ");
        }
        output.setLength(output.length() - 1);
        output.append(">");
        return output.toString();
    }
}
// END
