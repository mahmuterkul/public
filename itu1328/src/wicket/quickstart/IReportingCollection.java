package wicket.quickstart;

import java.util.List;

public interface IReportingCollection {
	public List<Reporting> getReports();

	public void addReport(Reporting item);

	public void deleteReport(Reporting item);

	public void updateReport(Reporting item);
}
