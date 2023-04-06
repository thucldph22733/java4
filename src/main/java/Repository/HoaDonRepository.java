package Repository;

import view_model.QLHoaDon;

import java.util.ArrayList;

public class HoaDonRepository {
    private ArrayList<QLHoaDon> list = new ArrayList<QLHoaDon>();

    public void insert (QLHoaDon h){
        list.add(h);
    }

    public ArrayList<QLHoaDon> findAll(){
        return list;
    }

    public void update(QLHoaDon h){
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = list.get(i);
            if (item.getMa().equals(h.getMa())){
                this.list.set(i,h);
            }
        }
    }
    public void delete(QLHoaDon h){
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = list.get(i);
            if (item.getMa().equals(h.getMa())){
                this.list.remove(i);
            }
        }
    }
    public QLHoaDon getByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLHoaDon item = list.get(i);
            if (item.getMa().equals(ma)){
                return this.list.get(i);
            }

        }
        return null;
    }
}
