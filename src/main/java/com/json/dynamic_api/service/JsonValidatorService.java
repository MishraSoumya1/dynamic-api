package com.json.dynamic_api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Set;

@Service
public class JsonValidatorService {

    private final JsonSchema schema;

    public JsonValidatorService() throws Exception {
        InputStream schemaStream = new ClassPathResource("schemas/user_signup_schema.json").getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode schemaNode = mapper.readTree(schemaStream);
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        this.schema = schemaFactory.getSchema(schemaNode);
    }

    public Set<ValidationMessage> validate(JsonNode jsonNode) {
        return schema.validate(jsonNode);
    }

}
