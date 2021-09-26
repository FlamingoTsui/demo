package com.flamingo.tacocloudreactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author flamingo
 * @create 9/6/21 6:13 PM
 */
@Repository
public interface UserDao extends ReactiveCrudRepository<User, Long> {

    Flux<User> findByName(String name);
}
