package xiu.dao;

import java.util.List;

import xiu.entity.Lexique;
import xiu.entity.PageLexique;

public interface LexiqueDAO {
//	select un mot selon id
	Lexique findById(Lexique lexique) throws Exception;
	Lexique findByName(Lexique lexique)throws Exception;
	// modify
	void modify(Lexique lexique) throws Exception;
	//ajouter un mot
	void add(Lexique lexique) throws Exception;
	
	// select tous les pages
	List<Lexique> findAll() throws Exception;
	// select tous selon page
	int countAll(String user) throws Exception;
	List<Lexique> findByPage(PageLexique pageLexique) throws Exception; 
	
	//select par limit
	int countLimit(PageLexique pageLexique)throws Exception;
	List<Lexique> findByLimit(PageLexique pageLexique) throws Exception; 
	
	void delete (Integer id) throws Exception;
	void remettre (Integer id) throws Exception;
}
