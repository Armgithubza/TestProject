package th.ac.rmutsb.pro.test.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class RoomEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roomId;
	
	
	private String roomName;
	private String amount;
	private String roomPicture;
	private String roomDetail;

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getRoomPicture() {
		return roomPicture;
	}

	public void setRoomPicture(String roomPicture) {
		this.roomPicture = roomPicture;
	}

	public String getRoomDetail() {
		return roomDetail;
	}

	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}

}