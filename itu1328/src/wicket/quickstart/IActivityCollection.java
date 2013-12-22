package wicket.quickstart;
import java.util.List;

public interface IActivityCollection {
	public List<Activity> getActivities();
	public void addActivity(Activity activity);
	public void deleteActivity(Activity activity);
	public void updateActivity(Activity activity);
}