package com.hogwart.gradebook.service;

import com.hogwart.gradebook.entity.Spell;

import java.util.List;


public interface SpellService {
    Spell getSpell(Long id);
    Spell saveSpell(Spell spell);
    void deleteSpell(Long id);
    List<Spell> getSpells();
}
