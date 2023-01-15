package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Admindao;
import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Admin;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Users;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public Admindao admindao;

	@Autowired
	public UserDao userdao;

	@Autowired
	public DealsDao dealsDao;

	@Override
	public Admin add(Admin admin) {
		// TODO Auto-generated method stub
		admindao.save(admin);
		return admin;
	}

	@Override
	public List<Admin> getall() {
		// TODO Auto-generated method stub
		return admindao.findAll();
	}

	@Override
	public Admin verify(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> admin1 = admindao.findByEmailAndPassword(admin.email, admin.password);
		if (admin1.isPresent()) {
			return admin1.get();
		}
		return null;
	}

	@Override
	public long totaluser() {
		// TODO Auto-generated method stub
		List<Users> users = userdao.findAll();
		return users.size();
	}

	@Override
	public long activeusers() {
		long count = 0;

		List<Users> user = userdao.findAll();
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).orders.size() != 0) {
				count++;
			}
		}
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public long activedeals() {
		// TODO Auto-generated method stub
		List<Deals> deals = dealsDao.findByActive(true);
		return deals.size();
	}

	@Override
	public long earning() {
		// TODO Auto-generated method stub
		Optional<Admin> admin = admindao.findById((long) 1);
		if (admin.isPresent()) {
			Admin admin2 = admin.get();
			return admin2.getEarning();
		}
		return 0;
	}

	@Override
	public long completeddeals() {
		// TODO Auto-generated method stub
		List<Deals> deals = dealsDao.findByActive(false);
		return deals.size();
	}

	@Override
	public long updateearning(long amount) {
		// TODO Auto-generated method stub
		Optional<Admin> admin = admindao.findById((long) 1);
		if (admin.isPresent()) {
			Admin admin2 = admin.get();
			admin2.setEarning(admin2.getEarning() + amount);
			admindao.save(admin2);
			return admin2.getEarning();
		}

		return 0;
	}

	@Override
	public Admin delete(long id) {
		// TODO Auto-generated method stub
		Optional<Admin> admin = admindao.findById(id);
		if (admin.isPresent()) {
			Admin admin2 = admin.get();
			admindao.delete(admin2);
			return admin2;
		}
		return null;
	}

}
