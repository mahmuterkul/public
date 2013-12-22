package wicket.quickstart;

import java.util.List;

public interface IBranchCollection {
	public List<Branch> getBranchs();
	
	public void addBranch (Branch item);
	
	public void deleteBranch(Branch item);

	public void updateBranch(Branch item);
}
