package teamPrj.diary.repository;

import java.util.List;

public interface Repository<T> {

	List<T> findAll();

}
