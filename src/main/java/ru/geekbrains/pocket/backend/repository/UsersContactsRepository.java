package ru.geekbrains.pocket.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.pocket.backend.domain.UsersContacts;

import java.util.List;
import java.util.Optional;
@Repository

public interface UsersContactsRepository extends MongoRepository<UsersContacts, ObjectId> {

    UsersContacts findFirstById(ObjectId id);
    //@Cacheable()
    Optional<UsersContacts> findByUsername(ObjectId id);

    // Supports native JSON query string
    @Query("{<users:_id>:'?0'}")
    List<UsersContacts> findCustomByUser_id(String user_id);
    @Query("{byname:'?0'}")
    List<UsersContacts> FindByName(String byname);





}
