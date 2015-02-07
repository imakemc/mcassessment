package th.co.imake.missconsult.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import th.co.imake.missconsult.assessment.domain.User;

//public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends JpaRepository<User, Long> {
	
	//User findByUsername(String username);
	User findByUsername(String username);
}
