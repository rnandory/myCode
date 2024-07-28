package teamPrj.diary.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import teamPrj.diary.Entity.Diary;

public interface Repository<T> {	

	List<T> findAll() throws FileNotFoundException, IOException;

	Diary findById(int id) throws IOException;
	
	void save(T entity) throws FileNotFoundException, IOException;
	
	int getLatestId();
	
	int setLatestId(int id);

	void clear() throws FileNotFoundException, IOException;

	void deleteImgById(int id, String imgRealPath) throws IOException;
	
}
