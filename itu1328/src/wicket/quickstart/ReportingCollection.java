package wicket.quickstart;

import java.util.LinkedList;
import java.util.List;

public class ReportingCollection implements IReportingCollection {
	private List<Reporting> _reportList;

	public ReportingCollection() {
		this._reportList = new LinkedList<Reporting>();
	}

	public List<Reporting> getReports() {
		return this._reportList;
	}

	public void addReport(Reporting item) {
		this._reportList.add(item);
	}

	public void deleteReport(Reporting item) {
		this._reportList.remove(item);
	}

	public void updateReport(Reporting item) {
	}
}
