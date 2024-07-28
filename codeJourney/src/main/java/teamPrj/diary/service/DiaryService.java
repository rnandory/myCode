package teamPrj.diary.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;

import jakarta.servlet.http.Part;
import teamPrj.diary.Entity.Diary;
import teamPrj.diary.repository.FileDiaryRepository;
import teamPrj.diary.repository.Repository;

public class DiaryService {

	private Repository<Diary> repository;

	public DiaryService() {
		repository = new FileDiaryRepository();
	}

	public List<Diary> getList() throws FileNotFoundException, IOException {

		List<Diary> list = repository.findAll();

		return list;
	}

	public List<Diary> getList(int page) throws FileNotFoundException, IOException {

		int postPerPage = 6;
		List<Diary> fullList = repository.findAll();

		int startIndex = postPerPage * (page - 1);
		int endIndex = startIndex + postPerPage;

		List<Diary> list;
		if (startIndex >= fullList.size())
			list = new ArrayList<Diary>();
		else if (endIndex > fullList.size()) {
			endIndex = fullList.size();
			list = fullList.subList(startIndex, endIndex);
		}
		else
			list = fullList.subList(startIndex, endIndex);
			
		

		return list;
	}

	public List<Integer> getPages(int current) throws FileNotFoundException, IOException {
		// index=0:첫페이지 index=pages.size()-1:마지막페이지
		List<Integer> pages = new ArrayList<Integer>();

		int firstPage = 1;
		pages.add(firstPage);
		int lastPage = Math.ceilDiv(repository.findAll().size(), 6);

		for (int i = 0, j = -2; pages.size() < 6; i++, j++) {
			int page = current + j;

			if (page < 1)
				continue;

			if (page > lastPage)
				break;

			pages.add(page);
		}

		pages.add(lastPage);

		return pages;
	}

	public Diary getDiary(int id) throws IOException {
		Diary diary = repository.findById(id);
		return diary;
	}

	public int uploadDiary(List<Part> parts, String imgRealPath) throws IOException {
		int id = repository.getLatestId() + 1;
		repository.setLatestId(id);

		repository.save(this.parseMultipartToDiary(id, parts, imgRealPath));

		return id;
	}

	private Diary parseMultipartToDiary(int id, List<Part> parts, String imgRealPath) throws IOException {
		String uploadPath;
		String title = "";
		String content = "";
		String imgName = "";

		// 경로생성
		File pathFile = new File(imgRealPath);
		if (!pathFile.exists())
			pathFile.mkdirs();

		// title, content, img part꺼내서 처리
		for (Part part : parts) {

			if (part.getSize() == 0)
				continue;

			String partName = part.getName();

			if (partName.equals("img")) {
				String fileName = part.getSubmittedFileName();
				imgName = id + "_" + fileName;
				uploadPath = imgRealPath + File.separator + imgName;

				InputStream is = part.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath);

				byte[] buf = new byte[1024];
				for (int size = 0; (size = is.read(buf)) != -1;)
					fos.write(buf, 0, size);
				is.close();
				fos.close();

			} else if (partName.equals("title")) {
				InputStream is = part.getInputStream();
				BufferedReader bf = new BufferedReader(new InputStreamReader(is));
				title = bf.readLine();
				bf.close();
				is.close();

			} else {
				InputStream is = part.getInputStream();
				BufferedReader bf = new BufferedReader(new InputStreamReader(is));

				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}

				if (sb.length() > 0) {
					sb.setLength(sb.length() - 1);
				}

				bf.close();
				is.close();

				content = sb.toString();
			}
		}
		return new Diary(id, title, content, imgName);
	}

	public int getLatestId() {
		return repository.getLatestId();
	}

	public void editDiary(int id, List<Part> parts, String imgRealPath) throws IOException {
		// diaryList.csv에서 id로 게시물 찾아서 수정
		// 1. 구 이미지파일 삭제
		// 2. 수정될 작성글 id, title, content, imgName확보
		// 3. getList로 모든 작성글 list로 가져옴
		// 4. diaryList.csv덮어쓰기

		// /codeJourney/diary/imgUpload에서 구 이미지파일 삭제
		repository.deleteImgById(id, imgRealPath);
		
		Diary editedDiary = this.parseMultipartToDiary(id, parts, imgRealPath);

		List<Diary> list = this.getList();
		// 덮어쓰기 위한 diaryList.csv리셋
		repository.clear();

		for (Diary diary : list) {
			if (diary.getId() == id) {
				repository.save(editedDiary);
			}
			else
				repository.save(diary);
		}

	}

	public void deleteDiary(int id, String imgRealPath) throws FileNotFoundException, IOException {

		// 1. 이미지파일 삭제
		// 2. service.getList()로 리스트 불러옴
		// 3. id로 체크하면서 덮어쓰기

		// /codeJourney/diary/imgUpload에서 이미지파일 삭제
		repository.deleteImgById(id, imgRealPath);
		
		List<Diary> list = this.getList();
		// 덮어쓰기 위한 diaryList.csv리셋
		repository.clear();
		
		
		for (Diary diary : list) {
			if (diary.getId() == id) {
				continue;
			}
			repository.save(diary);
		}
	}

}
