package dao;

import java.util.List;

import model.Consmer;

public interface ConsmerDao {
	//create
		void add(Consmer consmer);
	//read
		List<Consmer>selectAll();
		List<Consmer>selectUsernameAndPassword(String username,String password);
		List<Consmer>selectByUsername(String username);
	//update
		
	//delete
		
		
}
