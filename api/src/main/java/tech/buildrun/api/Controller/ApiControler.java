package tech.buildrun.api.Controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

@RestController // definindo uma api dentro dessa classe
public class ApiControler {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiControler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @GetMapping(path = "/tasks") //rota get// caminho o path
    public ResponseEntity<String> helloWord() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<Void> createTasks(@RequestBody String task){//receber uma tarefa //mapear o corpo de acordo  {
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/tasks")
    public ResponseEntity<Void> cleartasks(){
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }

}
