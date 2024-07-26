package teamPrj.diary.repository;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import teamPrj.diary.Entity.Diary;

public class FileDiaryRepository implements Repository<Diary> {

	@Override
	public List<Diary> findAll() {
		List<Exam> list = new ArrayList<>();

		FileInputStream fis = new FileInputStream("C:/8th/Work/myCode/res/diaryList.csv");
		Scanner scan = new Scanner(fis);

		return null;
	}

}
