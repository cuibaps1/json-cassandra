package com.example.jsoncassandra.controller;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.service.TableSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/table-schema")
public class TableSchemaController {

    @Autowired
    TableSchemaService tableSchemaService;

    @PostMapping
    public ResponseEntity createInvitation(@RequestBody TableSchemaRequest tableSchemaRequest) {

      TableSchemaResponse tableSchemaResponse = tableSchemaService.createTableSchema(tableSchemaRequest);

      if (null != tableSchemaResponse) {
        return new ResponseEntity(tableSchemaResponse, OK);
      } else {
        return new ResponseEntity("Issue while writing tableSchemaRequest message", BAD_REQUEST);
      }
    }

}
