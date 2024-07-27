package teamPrj.diary.Entity;

public class Diary {
	int id;
	String title;
	String content;
	String imgName;
	
	public Diary() {
		this(0, "", "", "");
	}
	
	public Diary(int id, String title, String content, String imgName) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgName = imgName;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}


	@Override
	public String toString() {
		return "Diary [id=" + id + ", title=" + title + ", content=" + content + ", imgName=" + imgName + "]";
	}
}
