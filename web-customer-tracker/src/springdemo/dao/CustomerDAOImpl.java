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
		
		Query<Customer> allcustomers = session.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = allcustomers.getResultList();
		
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the hubernate sess
		Session session = sessionFactory.getCurrentSession();
		
		//read the object from db with theId
		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
		
	}

	@Override
	public void deleteCustomer(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Query theQuery = session.createQuery("delete from Customer where id = " + theId);
		theQuery.executeUpdate();
		
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		Session session = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		 if (theSearchName != null && theSearchName.trim().length() > 0) {

	            // search for firstName or lastName ... case insensitive
	            theQuery = session.createQuery("from Customer where lower(firstName) like '%"+theSearchName.toLowerCase()+"%' or lower(lastName) like '%"+theSearchName.toLowerCase()+"%'", Customer.class);
//	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery = session.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	      
	}
	
}
