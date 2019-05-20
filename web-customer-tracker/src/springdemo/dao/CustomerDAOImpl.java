package springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
	
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> allcustomers = session.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = allcustomers.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the hubernate sess
		Session session = sessionFactory.getCurrentSession();
		
		//read the object from db with theId
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
		
	}
	
}
