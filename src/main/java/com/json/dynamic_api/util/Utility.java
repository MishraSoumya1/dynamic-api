package com.json.dynamic_api.util;

import com.networknt.schema.ValidationMessage;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Utility {
    public static Set<String> format(Set<ValidationMessage> messages) {
        return messages.stream()
                .map(msg -> {
                    String path = msg.getMessage();
                    String[] args = Arrays.stream(msg.getArguments()).map(Object::toString).toList().toArray(new String[0]);
                    String expected = args.length > 1 ? args[1] : "unknown";
                    String found = args.length > 0 ? args[0] : "unknown";
                    return String.format("Invalid type at %s: expected %s but found %s.", path, expected, found);
                })
                .collect(Collectors.toSet());
    }
}
