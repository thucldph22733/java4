package Repository;


import view_model.QLGioHang;

import java.util.ArrayList;

public class GioHangRepository {
    private ArrayList<QLGioHang> list  = new ArrayList<>();

    public void insert (QLGioHang g){

        this.list.add(g);
    }
    public void update(QLGioHang g){
        for (int i = 0; i < this.list.size(); i++) {
            QLGioHang item = this.list.get(i);
            if(item.getMa().equals(g.getMa())){
                this.list.set(i,g);
            }
        }
    }
    public void delete(QLGioHang g){
        for (int i = 0; i < this.list.size(); i++) {
            QLGioHang item = this.list.get(i);
            if(item.getMa().equals(g.getMa())){
                this.list.remove(i);
            }
        }
    }
    public ArrayList<QLGioHang> findAll(){

        return list;
    }

    public QLGioHang findByMa(String ma){
        for (int i = 0; i < this.list.size(); i++) {
            QLGioHang item = this.list.get(i);
            if(item.getMa().equals(ma)){
                return this.list.get(i);
            }
        }
        return null;
    }
}
