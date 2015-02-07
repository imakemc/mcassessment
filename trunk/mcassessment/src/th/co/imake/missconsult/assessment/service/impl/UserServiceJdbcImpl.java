package th.co.imake.missconsult.assessment.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import th.co.imake.missconsult.assessment.service.UserService;


/**
 * 
 */
@Repository
class UserServiceJdbcImp implements UserService {

	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*@Override
	public void insert( UserDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Aoe> fetchAllUsers() {
		// TODO Auto-generated method stub
		 String query = "delete from AOE where id=?";
	        int out = template.update(query, 10);
		return null;
	}*/
}
