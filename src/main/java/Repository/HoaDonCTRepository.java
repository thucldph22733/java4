package Repository;


import view_model.QlHoaDonCT;

import java.util.ArrayList;

public class HoaDonCTRepository {
    private ArrayList<QlHoaDonCT> list = new ArrayList<>();
    public void insert(QlHoaDonCT hdct ){
        list.add(hdct);
    }
    public ArrayList<QlHoaDonCT> findAll(){
        return list;
    }
}
