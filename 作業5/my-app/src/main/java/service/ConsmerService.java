package service;

import model.Consmer;

public interface ConsmerService{
		//create
	void addConsmer(Consmer consmer);
		//read
	Consmer Login(String username,String password);
	boolean isUsernameBeenUse(String username);
		//update
		//delete
}
