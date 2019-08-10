package com.example.jackson.annotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

public class NodeToYaml {

    public static void main(String[] args) throws IOException {

        InputStream input = NodeToYaml.class.getResourceAsStream("/json-node-test.json");

        ObjectMapper obj = new ObjectMapper();

        JsonNode jsonNode =  obj.readTree(input);

        StringBuilder yaml = new StringBuilder();
        processNode(jsonNode, yaml, 0);

        String yml =   yaml.toString();

        System.out.println("the yaml is [\n"+ yml+"\n]");
    }

    private static void processNode(JsonNode jsonNode, StringBuilder yaml, int depth) {
        if (jsonNode.isValueNode()) {
            yaml.append(jsonNode.asText());
        }
        else if (jsonNode.isArray()) {
            for (JsonNode arrayItem : jsonNode) {
                appendNodeToYaml(arrayItem, yaml, depth, true);
            }
        }
        else if (jsonNode.isObject()) {
            appendNodeToYaml(jsonNode, yaml, depth, false);
        }
    }

    private static void appendNodeToYaml(JsonNode node, StringBuilder yaml, int depth, boolean isArrayItem) {
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        boolean isFirst = true;
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> jsonField = fields.next();
            addFieldNameToYaml(yaml, jsonField.getKey(), depth, isArrayItem && isFirst);
            processNode(jsonField.getValue(), yaml, depth+1);
            isFirst = false;
        }

    }

    private static  void addFieldNameToYaml(
            StringBuilder yaml, String fieldName, int depth, boolean isFirstInArray) {
        if (yaml.length()>0) {
            yaml.append("\n");
            int requiredDepth = (isFirstInArray) ? depth-1 : depth;
            for(int i = 0; i < requiredDepth; i++) {
                yaml.append("  ");
            }
            if (isFirstInArray) {
                yaml.append("- ");
            }
        }
        yaml.append(fieldName);
        yaml.append(": ");
    }
}
