package com.fady.hotel.Repository;

import com.fady.hotel.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

   public UserInfo findByUsername(String username);

   UserInfo findFirstById(Long id);

}
