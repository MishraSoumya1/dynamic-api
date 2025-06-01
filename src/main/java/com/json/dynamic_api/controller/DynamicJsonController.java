package com.json.dynamic_api.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.json.dynamic_api.service.JsonValidatorService;
import com.json.dynamic_api.util.Utility;
import com.networknt.schema.ValidationMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/webhooks")
@Tag(name = "Webhooks", description = "Dynamic Webhook Receiver")
public class DynamicJsonController {

    private final JsonValidatorService validatorService;

    private static final Logger logger = LoggerFactory.getLogger(DynamicJsonController.class);

    public DynamicJsonController(JsonValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @GetMapping
    public ResponseEntity<String> helloWebHook() {
        return ResponseEntity.ok("Hello Web");
    }

    @Operation(summary = "Receive dynamic JSON payload")
    @PostMapping
    public ResponseEntity<?> webJsonVerify(@RequestBody JsonNode jsonNode) throws Exception {

        Set<ValidationMessage> errors = validatorService.validate(jsonNode);

        logger.info("Processing event: {}", errors);

        if(errors.isEmpty()) {
            return ResponseEntity.ok("JSON verified");
        }

        Set<String> userMessages = Utility.format(errors);
        return ResponseEntity.badRequest().body(userMessages);
    }
}
