package br.com.salumi.service.controller;

import br.com.salumi.service.bean.ProdutoBean;
import br.com.salumi.service.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @RequestMapping(value = "all", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody ResponseEntity<?> get(@PathVariable int id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "add", method = RequestMethod.POST, headers = "Accept=application/json")
    public void add(@RequestBody ProdutoBean bean) {
        service.add(bean);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void update(@RequestBody ProdutoBean bean) {
        service.update(bean);
    }
}
