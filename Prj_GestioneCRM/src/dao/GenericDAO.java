package dao;

import java.util.List;

public interface GenericDAO<T> {
	
	boolean create(T entity);
	T readByID(int id);
	List<T> readAll();
	boolean update(T entity);
	boolean deleteByID(int id);
	boolean assegnazioneByID(int id1, int id2);
	
	
}
