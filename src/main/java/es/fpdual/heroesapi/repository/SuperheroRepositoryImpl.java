package es.fpdual.heroesapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import es.fpdual.heroesapi.model.SuperheroBean;

@Repository
public class SuperheroRepositoryImpl implements SuperheroRepository {

	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public List<SuperheroBean> selectAll() {
		try {
			return this.template.query("SELECT * FROM HEROES", new SuperheroeMapper());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public SuperheroBean selectById(long id) {
		try {
			return this.template.queryForObject("SELECT * FROM HEROES WHERE ID = ?", new SuperheroeMapper(), id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(SuperheroBean superhero) {
				
			// 1. Define transaction
			TransactionDefinition def = new DefaultTransactionDefinition();
			TransactionStatus status = transactionManager.getTransaction(def);
			
			// 2. Open transaction
			try {
			this.template.update("INSERT INTO HEROES VALUES (?, ?, ?, ?)", 
					superhero.getId(), 
					superhero.getName(),
					superhero.getAlterego(),
					superhero.getImage());
		
			// 3. Commit or Rollback
			transactionManager.commit(status);
			
		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(SuperheroBean superhero) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			this.template.update("UPDATE HEROES SET NAME = ?, ALTEREGO = ?, IMG = ? WHERE ID = ?",
					superhero.getName(),
					superhero.getAlterego(),
					superhero.getImage(),
					superhero.getId());
			
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(long id) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			this.template.update("DELETE FROM HEROES WHERE ID = ?", id);
			
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw e;
		}
	}

}
