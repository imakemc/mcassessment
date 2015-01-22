package th.co.imake.missconsult.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import th.co.imake.missconsult.assessment.domain.UserContact;

//public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends JpaRepository<UserContact, Long> {
	
	//User findByUsername(String username);
	UserContact findByUsername(String username);
}
