package thiGK.ntu65130417.nguyentandat_fitCMS.models;

public class Post {
	public String id, title, content, categoryID;

	public Post(String id, String title, String content, String categoryID) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.categoryID = categoryID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	
}
