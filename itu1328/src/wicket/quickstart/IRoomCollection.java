package wicket.quickstart;

import java.util.List;

public interface IRoomCollection {
	public List<Room> getRooms();
	
	public List<Room> getRoomsWithBranchID(Integer BranchID);

	public void addroom(Room item);

	public void deleteroom(Room item);

	public void updateroom(Room item);
}