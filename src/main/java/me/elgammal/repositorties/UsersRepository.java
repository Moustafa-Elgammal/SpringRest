package me.elgammal.repositorties;

import  me.elgammal.models.User;
import org.springframework.data.repository.CrudRepository;

public interface  UsersRepository  extends CrudRepository<User, Integer> {
}
