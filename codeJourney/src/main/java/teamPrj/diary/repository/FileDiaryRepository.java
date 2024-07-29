package teamPrj.diary.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import teamPrj.diary.Entity.Diary;

public class FileDiaryRepository implements Repository<Diary> {

	static int latestId;

//	static String diaryListPath = "C:\\8th\\Work\\myCode\\res\\diaryList.csv";
	static String diaryListPath = "D:/again/myCode/myCode/res/diaryList.csv";

	static {
		FileInputStream fis;
		try {
			// "D:/again/myCode/myCode/res/diaryList.csv"
			fis = new FileInputStream(diaryListPath);
			Scanner scan = new Scanner(fis);

			int latestId = 0; // 글이 하나도 없으면 0

			scan.nextLine();

			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");

				int id = Integer.parseInt(tokens[0]);

				if (latestId < id)
					latestId = id;
			}
			scan.close();
			fis.close();

			FileDiaryRepository.latestId = latestId;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Diary> findAll() throws IOException {
		List<Diary> list = new ArrayList<>();
//		"D:/again/myCode/myCode/res/diaryList.csv"
		FileInputStream fis = new FileInputStream(diaryListPath);
		Scanner scan = new Scanner(fis);

		scan.nextLine();

		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",", -1);

			int id = Integer.parseInt(tokens[0]);
			String title = tokens[1];
			String content = tokens[2];
			String imgName = tokens[3];

			Diary post = new Diary(id, title, content, imgName);
			list.add(post);
		}
		scan.close();
		fis.close();

		// 최신순 정렬 id내림차순
		Collections.sort(list, (d1, d2) -> Integer.compare(d2.getId(), d1.getId()));

		return list;
	}

	@Override
	public Diary findById(int id) throws IOException {
		List<Diary> fullList = this.findAll();

		int index = Collections.binarySearch(fullList, new Diary(id, "", "", ""),
				(d1, d2) -> Integer.compare(d2.getId(), d1.getId()));
		// 만약 해당 id의 글이 없으면? -1
		if (index == -1)
			return null;
		Diary diary = fullList.get(index);
		return diary;
	}

	@Override
	public int getLatestId() {
		return latestId;
	}

	@Override
	public int setLatestId(int id) {
		latestId = id;
		return latestId;
	}

	@Override
	public void save(Diary entity) throws IOException {
		FileOutputStream fos = new FileOutputStream(diaryListPath, true);
		PrintStream ps = new PrintStream(fos);

		ps.printf("\n%d,%s,%s,%s", entity.getId(), entity.getTitle(), entity.getContent(), entity.getImgName());
		ps.close();
		fos.close();
	}

	@Override
	public void clear() throws IOException {
		FileOutputStream fos = new FileOutputStream(diaryListPath);
		PrintStream ps = new PrintStream(fos);

		ps.print("id,title,content,imgName");
		ps.close();
		fos.close();
	}

	@Override
	public void deleteImgById(int id, String imgRealPath) throws IOException {
		Diary diary = this.findById(id);

		String path = imgRealPath;
		if (!diary.getImgName().equals("placeholder.jpg"))
			path += File.separator + diary.getImgName();

		System.out.println(path);
		File file = new File(path);
		if (file.exists()) {
			if (file.delete())
				System.out.println("파일삭제 성공");
			else
				System.out.println("파일삭제 실패");
		} else
			System.out.println("파일이 존재하지 않습니다.");
	}

}
