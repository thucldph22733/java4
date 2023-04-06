package Repository;


import domain_model.NSX;
import domain_model.SanPham;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLSanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    private Session hSession;
    public SanPhamRepository(){
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }
    public void insert(SanPham s){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(s);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (SanPham s){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(s);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete (SanPham s){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(s);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public SanPham findById(UUID id){
        return this.hSession.find(SanPham.class,id);

    }

    public List<SanPham> findAll(){
        String hql ="SELECT obj FROM SanPham obj";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql,SanPham.class);
        return query.getResultList();

    }

    public SanPham findByMa(String ma){
        String hql ="SELECT obj FROM SanPham obj WHERE obj.ma =?1";
        TypedQuery<SanPham> query = this.hSession.createQuery(hql,SanPham.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
}
