package thiGK.ntu65130417.nguyentandat_fitCMS.models;

public class Page {
	public String id;
	public String pageName;
	public String keyword;
	public String content;
	public String parentPageId;
	public Page(String id, String pageName, String keyword, String content, String parentPageId) {
		super();
		this.id = id;
		this.pageName = pageName;
		this.keyword = keyword;
		this.content = content;
		this.parentPageId = parentPageId;
	}
	public Page () {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getParentPageId() {
		return parentPageId;
	}
	public void setParentPageId(String parentPageId) {
		this.parentPageId = parentPageId;
	}
	
	
}
