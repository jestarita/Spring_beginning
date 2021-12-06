package com.example.data_external.h2database.repository;

import com.example.data_external.h2database.models.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository  extends PagingAndSortingRepository<User, Long> {
    List<User> findByRole(String role);

}
