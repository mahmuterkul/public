package wicket.quickstart;

import java.util.List;
import java.util.LinkedList;

public class BranchCollection {
	private List<Branch>_branchList;
	
	public BranchCollection(){
		this._branchList = new LinkedList<Branch>();
	}
	public List<Branch> getBranchs(){
		return this._branchList;		
	}
	public void addBranch(Branch item){
		this._branchList.add(item);
	}
	public void deleteBranch(Branch item) {
		this._branchList.remove(item);
	}
	public void updateBranch(Branch item) {
		//this._empList.update(item);
	}
 
}
