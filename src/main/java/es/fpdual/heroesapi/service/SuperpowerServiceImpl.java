//package es.fpdual.heroesapi.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import es.fpdual.heroesapi.model.SuperheroBean;
//import es.fpdual.heroesapi.model.SuperpowerBean;
//import es.fpdual.heroesapi.repository.SuperheroRepository;
//
//@Service
//@Transactional
//public class SuperpowerServiceImpl implements SuperpowerService {
//
//	@Autowired
//	private SuperheroRepository repository;
//	
//	@Autowired
//	private SuperpowerService superpowerService;
//
//	
//	public List<SuperheroBean> selectAll() {
//		List<SuperheroBean> superheros = this.repository.selectAll();
//		
//		if (superheros.isEmpty()) {
//			return superheros;
//		}
//		
//		superheros.forEach(superhero -> {
//			List<SuperpowerBean> superpoderes = this.superpowerService.selectAll(superhero.getId());
//			superhero.setSuperpowers(superpoderes);
//		});
//		
//		return superheros;
//
//	}
//
//	
//	public SuperheroBean select(long idHero) {
//		SuperheroBean superhero = this.repository.selectById(idHero);
//	}
//
//	@Override
//	public void delete(long idHero) {
//		//
//	}
//
//}
