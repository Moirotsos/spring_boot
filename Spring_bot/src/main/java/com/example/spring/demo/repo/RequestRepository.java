package com.example.spring.demo.repo;

import com.example.spring.demo.entity.Request;
import com.example.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    //find request by validated
    @Query("SELECT d FROM Request d where d.validated = :validated")
    List<Request> findByValidated(@Param("validated") boolean validated);

    //Update request State by ID
    @Query("Update Request d SET d.state=':state' Where d.id=:id")
    void UpdateRequestState(@Param("state") String state,@Param("id") int id);

    //find by username
    @Query("SELECT d FROM Request d where d.user=:user")
    List<Request> findByUsername(@Param("user") User user);

//    @Query("SELECT d FROM Request d where d.user.id =: user")
//    List<Request> findByFk(@Param("user") User user);

//    @Query("SELECT d FROM Request d where d.user =:userid")
//    List<Request> findByUser(@Param("userid") Long id);

    List<Request> findByUser(User user);


}
