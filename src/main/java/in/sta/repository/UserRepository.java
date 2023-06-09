package in.sta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sta.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);
}
