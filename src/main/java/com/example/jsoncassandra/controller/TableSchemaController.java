package com.example.jsoncassandra.controller;

import com.example.jsoncassandra.model.dto.TableSchemaRequest;
import com.example.jsoncassandra.model.dto.TableSchemaResponse;
import com.example.jsoncassandra.model.graph.TableSchema;
import com.example.jsoncassandra.service.TableSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/table-schema")
public class TableSchemaController {

  @Autowired
  TableSchemaService tableSchemaService;

  @PostMapping
  public TableSchemaResponse createInvitation(@RequestBody TableSchemaRequest tableSchemaRequest) {
    return tableSchemaService.createTableSchema(tableSchemaRequest);
  }

  @GetMapping
  public List<TableSchemaResponse> getTableSchema() {
      return tableSchemaService.getTableSchema();
  }
}
