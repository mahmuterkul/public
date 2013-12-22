package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

public class RoomCollection implements IRoomCollection {
	private List<Room> _roomList;
	private List<Room> _roomsWithBranchID;

	public RoomCollection() {
		this._roomList = new LinkedList<Room>();
	}

	public List<Room> getRooms() {
		return this._roomList;
	}
	
	public List<Room> getRoomsWithBranchID(Integer BranchID){
		return this._roomsWithBranchID;
	}

	public void addroom(Room item) {
		this._roomList.add(item);
	}

	public void deleteroom(Room item) {
		this._roomList.remove(item);
	}

	public void updateroom(Room item) {
	}
}