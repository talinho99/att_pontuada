package com.example.att_pontuada.controller;

import com.example.att_pontuada.model.ClienteModel;
import com.example.att_pontuada.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired

    private ClienteService service;
    @GetMapping
    public List<ClienteModel> listarClientes(){
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody ClienteModel cliente){
        service.salvar(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Cliente salvo com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteModel cliente){
        service.atualizarcliente(id,cliente);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> excluir(
            @PathVariable Long id){
        service.excluir(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Cliente deletado com sucesso"));
    }
}
