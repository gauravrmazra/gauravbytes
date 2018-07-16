package in.lineofcode.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class XmlBuilder {

	private static final String DOUBLE_QUOTE = "\"";
	private static final String EQUALS = "=";
	private static final String SPACE = " ";
	private static final String SLASH = "/";
	private static final String END_NODE = ">";
	private static final String START_NODE = "<";
	
	private final String nodeName;
	private final List<XmlBuilder> childrens = new ArrayList<>();
	private final Map<String, String> attributes = new HashMap<>();

	public XmlBuilder(String nodeName) {
		this.nodeName = nodeName;
	}

	public String toXml() {
		StringBuilder sb = new StringBuilder();
		appendStartNodeAndAttributesTo(sb);
		addChildrenTo(sb);
		appendEndNodeTo(sb);
		return sb.toString();
	}

	private StringBuilder appendEndNodeTo(StringBuilder sb) {
		return sb.append(START_NODE).append(SLASH).append(nodeName).append(END_NODE);
	}

	private void appendStartNodeAndAttributesTo(StringBuilder sb) {
		sb.append(START_NODE).append(nodeName);

		addAttributesTo(sb);

		sb.append(END_NODE);
	}

	private void addAttributesTo(StringBuilder sb) {
		for (Map.Entry<String, String> attribute : attributes.entrySet()) {
			sb.append(SPACE).append(attribute.getKey()).append(EQUALS).append(DOUBLE_QUOTE).append(attribute.getValue())
					.append(DOUBLE_QUOTE);
		}
	}

	private void addChildrenTo(StringBuilder sb) {
		for (XmlBuilder children : childrens) {
			sb.append(children.toXml());
		}
	}

	public void addChildren(XmlBuilder child) {
		this.childrens.add(child);
	}

	public void addAttribute(String name, String value) {
		this.attributes.put(name, value);
	}
}
