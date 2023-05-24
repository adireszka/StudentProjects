package com.hogwart.gradebook.web;

import com.hogwart.gradebook.entity.Spell;
import com.hogwart.gradebook.service.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/spell")
public class SpellController {

    SpellService spellService;

    @GetMapping("/{id}")
    public ResponseEntity<Spell> getSpell(@PathVariable Long id){
        return new ResponseEntity<>(spellService.getSpell(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Spell> saveSpell(@RequestBody Spell spell){
        return new ResponseEntity<>(spellService.saveSpell(spell), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteSpell(@PathVariable Long id){
        spellService.deleteSpell(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Spell>> getSpells(){
        return new ResponseEntity<>(spellService.getSpells(), HttpStatus.OK);
    }
}
