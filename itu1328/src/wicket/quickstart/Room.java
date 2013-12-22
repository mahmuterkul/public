package wicket.quickstart;

import java.io.Serializable;

public class Room implements Serializable{
	private Integer RoomId;
	private Integer RoomType;
	private Integer RoomNo;
	private Integer RoomStatus;
	private Integer RoomPrice;
	private Integer BranchId;

	public Room() {

	}

	public Room(Integer RoomId, Integer RoomType, Integer RoomNo,
			Integer RoomStatus, Integer RoomPrice, Integer BranchId) {
		this.RoomId = RoomId;
		this.RoomType = RoomType;
		this.RoomNo = RoomNo;
		this.RoomStatus = RoomStatus;
		this.RoomPrice = RoomPrice;
		this.BranchId = BranchId;
	}

	public Room(Integer ID, Integer roomType, Integer roomNo, Integer roomPrice) {
		this.RoomId = ID;
		this.RoomType = roomType;
		this.RoomNo = roomNo;
		this.RoomPrice = roomPrice;
	}

	// Setters
	public void setId(Integer id) {
		this.RoomId = id;
	}

	public void setType(Integer type) {
		this.RoomType = type;
	}

	public void setNo(Integer no) {
		this.RoomNo = no;
	}

	public void setStatus(Integer status) {
		this.RoomStatus = status;
	}

	public void setPrice(Integer price) {
		this.RoomPrice = price;
	}

	public void setBranch(Integer id) {
		this.BranchId = id;
	}

	// Setters
	// Getters
	public Integer getId() {
		return this.RoomId;
	}

	public Integer getType() {
		return this.RoomType;
	}

	public Integer getNo() {
		return this.RoomNo;
	}

	public Integer getStatus() {
		return this.RoomStatus;
	}

	public Integer getPrice() {
		return this.RoomPrice;
	}

	public Integer getBranch() {
		return this.BranchId;
	}
	// Getters
}
