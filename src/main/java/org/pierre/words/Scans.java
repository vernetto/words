package org.pierre.words;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Scans {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String filename;
	private String scandate;
	
	public Long getId() {
		return id;
	}
	public String getFileName() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getScandate() {
		return scandate;
	}
	public void setScandate(String scandate) {
		this.scandate = scandate;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
		return this.filename.equals(((Scans) obj).filename);
	}	

}
