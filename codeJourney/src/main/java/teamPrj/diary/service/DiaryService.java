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

		if (startIndex >= fullList.size())
			endIndex = startIndex = fullList.size() - 1;
		else if (endIndex > fullList.size())
			endIndex = fullList.size();

		List<Diary> list = fullList.subList(startIndex, endIndex);

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

	public int uploadDiary(List<Part> parts, String realPath) throws IOException {
		int id = repository.getLatestId() + 1;
		repository.setLatestId(id);
		String uploadPath;
		String title = "";
		String content = "";
		String imgName = "";

		// 경로생성
		File pathFile = new File(realPath);
		if (!pathFile.exists())
			pathFile.mkdirs();

		for (Part part : parts) {
			
			if (part.getSize()==0)
				continue;
				
			String partName = part.getName();
			
			if (partName.equals("img")) {
				String fileName = part.getSubmittedFileName();
				imgName = id + "_" + fileName;
				uploadPath = realPath + File.separator + imgName;

				InputStream is = part.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath);

				byte[] buf = new byte[1024];
				for (int size = 0; (size = is.read(buf)) != -1;)
					fos.write(buf, 0, size);				

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
				while ((line = bf.readLine())!=null) {
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
		repository.save(new Diary(id, title, content, imgName));

		return id;
	}

	public int getLatestId() {		
		return repository.getLatestId();
	}

}
