package com.hogwart.gradebook.service;

import com.hogwart.gradebook.entity.Spell;
import com.hogwart.gradebook.exception.SpellNotFoundException;
import com.hogwart.gradebook.repository.SpellRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SpellServiceImpl implements SpellService{

    SpellRepository spellRepository;

    @Override
    public Spell getSpell(Long id) {
        Optional<Spell> spell = spellRepository.findById(id);
        return unwrapSpell(spell, id);
    }

    @Override
    public Spell saveSpell(Spell spell) {
        return spellRepository.save(spell);
    }

    @Override
    public void deleteSpell(Long id) {
        spellRepository.deleteById(id);
    }

    @Override
    public List<Spell> getSpells() {
        return (List<Spell>) spellRepository.findAll();
    }

    static Spell unwrapSpell(Optional<Spell> spell, Long id){
        if (spell.isPresent()) return spell.get();
        else throw new SpellNotFoundException(id);
    }
}
