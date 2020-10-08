package com.view;

import javax.swing.AbstractListModel;
import com.model.MyList;


public class ListModel extends AbstractListModel<String>{

    public void setList(MyList<String> list) {
        this.list = list;
    }
    MyList<String> list;
    public ListModel(MyList list) {
        this.list = list;
    }
    public ListModel() {}

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String getElementAt(int index) {
        return list.getIndex(index);
    }
    void addElement(String k) {
        list.add(k);
        fireIntervalAdded(this, 0, list.getSize());
    }
    public String pop() {
        String res = (String) this.list.pop();
        fireIntervalAdded(this, 0, list.getSize());
        return res;
    }
    public void fireIntervalAdded(){
        fireIntervalAdded(this, 0, list.getSize());
    }
}
