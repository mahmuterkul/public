package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

public class ActivityCollection implements IActivityCollection {
	private List<Activity> _activities;
	
	public ActivityCollection() {
        this._activities = new LinkedList<Activity>();
    }

    public List<Activity> getActivities() {
        return this._activities;
    }

    public void addActivity(Activity activity) {
        this._activities.add(activity);
    }

    public void deleteActivity(Activity activity) {
        this._activities.remove(activity);
    }

    public void updateActivity(Activity activity) {
    	
    }
	

}
