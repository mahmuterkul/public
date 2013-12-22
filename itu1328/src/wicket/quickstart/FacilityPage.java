package wicket.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class FacilityPage extends BasePage {
	public FacilityPage(PageParameters param) {
		String a = param.get(1).toString();
		double id = Double.parseDouble(a);

		WicketApplication app = (WicketApplication) this.getApplication();
		IFacilityCollection collection = app.getFacilityCollection();
		List<Facility> facilities = collection.getFacilities();
		List<Facility> _temp = new ArrayList<Facility>();

		for (int i = 0; i < facilities.size(); i++) {
			if (facilities.get(i).getBranchID().intValue() == (int) id) {
				try {
					Facility _temp2 = new Facility(null, "", null);
					_temp2.setBranchId(facilities.get(i).getBranchID()
							.intValue());
					_temp2.setFacilityId(facilities.get(i).getFacilityID()
							.intValue());
					_temp2.setFacilityInfo(facilities.get(i).getFacilityInfo()
							.toString());
					// _temp.set(0, facilities.get(i));
					_temp.add(_temp2);
					break;
				} catch (Exception e) {
					System.out.print(e.toString());
				}

			}
		}

		PropertyListView facilityListView = new PropertyListView(
				"facility_list", _temp) {
			@Override
			protected void populateItem(ListItem item) {
				item.add(new Label("FacilityInfo"));
			}
		};
		this.add(facilityListView);

	}
}
