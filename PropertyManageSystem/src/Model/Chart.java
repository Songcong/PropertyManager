package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * Chart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "chart", catalog = "wygl")
public class Chart implements java.io.Serializable {

	// Fields

	@Label("内部编号")
	private Integer chartId;
	@Label("交谈对象ID")
	private Integer convobjid;
	@Label("交谈人姓名")
	private String convobjname;
	@Label("标题")
	private String title;
	@Label("交谈内容")
	private String content;
	@Label("交谈人员")
	private String conversation;
	@Label("删除标记")
	private Integer deleted;

	// Constructors

	/** default constructor */
	public Chart() {
	}

	/** full constructor */
	public Chart(Integer convobjid, String convobjname, String title,
			String content, String conversation, Integer deleted) {
		this.convobjid = convobjid;
		this.convobjname = convobjname;
		this.title = title;
		this.content = content;
		this.conversation = conversation;
		this.deleted = deleted;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "chart_id", unique = true, nullable = false)
	public Integer getChartId() {
		return this.chartId;
	}

	public void setChartId(Integer chartId) {
		this.chartId = chartId;
	}

	@Column(name = "convobjid")
	public Integer getConvobjid() {
		return this.convobjid;
	}

	public void setConvobjid(Integer convobjid) {
		this.convobjid = convobjid;
	}

	@Column(name = "convobjname", length = 50)
	public String getConvobjname() {
		return this.convobjname;
	}

	public void setConvobjname(String convobjname) {
		this.convobjname = convobjname;
	}

	@Column(name = "title", length = 10)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 400)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "conversation", length = 50)
	public String getConversation() {
		return this.conversation;
	}

	public void setConversation(String conversation) {
		this.conversation = conversation;
	}

	@Column(name = "deleted")
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

}