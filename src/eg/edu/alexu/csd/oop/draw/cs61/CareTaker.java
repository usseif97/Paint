package eg.edu.alexu.csd.oop.draw.cs61;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

	private List<Memento> mementoListUndo = new ArrayList<>();
	private List<Memento> mementoListRedo = new ArrayList<>();

	public void add(Memento state) {
		mementoListUndo.add(state);
	}
	
	public void addRedo(Memento state) {
		mementoListRedo.add(state);
	} 

	public Memento getUndo(int index) {
		Memento temp = mementoListUndo.remove(index + 1);
		mementoListRedo.add(temp);
		return mementoListUndo.get(index);
	}

	public Memento getRedo(int index) {
		Memento temp = mementoListRedo.remove(index);
		mementoListUndo.add(temp);
		return temp;
	}

	public int getSizeUndo() {
		return mementoListUndo.size();
	}
	
	public int getSizeRedo() {
		return mementoListRedo.size();
	}
	
	public void clearRedo() {
		mementoListRedo.clear();
	}

}
