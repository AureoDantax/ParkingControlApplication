package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.beans.Person;
import org.springframework.data.repository.CrudRepository;

public interface SavePersonRepository extends CrudRepository <Person, String> {

}
