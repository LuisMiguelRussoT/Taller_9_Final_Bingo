package com.sofka.repository;
/**
 * imports
 */

import com.sofka.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository
 *
 * @author luis miguel russo tinjaca
 * @version 1.0.0 2022/08/01
 * @since 1.0.0
 */

public interface UserRepository extends CrudRepository<User,Integer> {
}
