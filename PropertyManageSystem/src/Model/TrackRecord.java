package Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import Anno.Label;

/**
 * TrackRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "track_record", catalog = "wygl")
public class TrackRecord implements java.io.Serializable {

	// Fields

	@Label("记录号")
	private Integer recordId;
	@Label("业绩名称")
	private String trackname;
	@Label("参与人员")
	private String participant;
	@Label("参与时间")
	private Timestamp time;
	@Label("参与地点")
	private String site;
	@Label("详细说明")
	private String detail;

	// Constructors

	/** default constructor */
	public TrackRecord() {
	}

	/** full constructor */
	public TrackRecord(String trackname, String participant, Timestamp time,
			String site, String detail) {
		this.trackname = trackname;
		this.participant = participant;
		this.time = time;
		this.site = site;
		this.detail = detail;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "record_id", unique = true, nullable = false)
	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@Column(name = "trackname", length = 100)
	public String getTrackname() {
		return this.trackname;
	}

	public void setTrackname(String trackname) {
		this.trackname = trackname;
	}

	@Column(name = "participant", length = 200)
	public String getParticipant() {
		return this.participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	@Column(name = "time", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "site", length = 100)
	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "detail", length = 600)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}