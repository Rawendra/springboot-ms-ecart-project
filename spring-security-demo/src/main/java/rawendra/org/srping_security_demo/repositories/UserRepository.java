package rawendra.org.srping_security_demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import rawendra.org.srping_security_demo.entities.UserInfoEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfoEntity, Long> {
  Optional<UserInfoEntity> findByName(String username);
}
