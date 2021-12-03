package com.begginning.classes;

import com.begginning.classes.Users;
import org.springframework.data.repository.CrudRepository;

public interface Daouser extends CrudRepository<Users, Long> {
}
