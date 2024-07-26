package teamPrj.diary.service;

import java.util.List;

import teamPrj.diary.Entity.Diary;
import teamPrj.diary.repository.FileDiaryRepository;
import teamPrj.diary.repository.Repository;

public class DiaryService {

	private Repository<Diary> repository;

	public DiaryService() {
		repository = new FileDiaryRepository();
	}

	public List<Diary> getList() {

		repository.findAll();

		return null;
	}

}
