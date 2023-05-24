package com.hogwart.gradebook.repository;

import com.hogwart.gradebook.entity.Spell;
import org.springframework.data.repository.CrudRepository;

public interface SpellRepository extends CrudRepository<Spell, Long> {
}
