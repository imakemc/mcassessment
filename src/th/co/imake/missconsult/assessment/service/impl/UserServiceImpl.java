package th.co.imake.missconsult.assessment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.imake.missconsult.assessment.repository.UserDaoRepository;
import th.co.imake.missconsult.assessment.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDaoRepository userDaoRepository;
	/*private UserDao userDao;
	 
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
	}
	 
	public void insert(co.th.imake.domain.Aoe aoe){
		getUserDao().insert(aoe);
	}
	public List<Aoe> fetchAllUsers() {
		return getUserDao().selectAll();
	}*/
	/*public void insert(co.th.imake.domain.Aoe aoe){
		userDao.insert(aoe);
	}
	public List<Aoe> fetchAllUsers() {
		return userDao.selectAll();
	}*/
}
