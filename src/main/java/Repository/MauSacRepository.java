package Repository;

import domain_model.KhachHang;
import domain_model.MauSac;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLMauSac;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    private Session hSession;
    public MauSacRepository(){
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }
    public void insert(MauSac m){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(m);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (MauSac m){

        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(m);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete (MauSac m){

        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(m);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public MauSac findByID(UUID id){
        return this.hSession.find(MauSac.class,id);

    }

    public List<MauSac> findAll(){
        String hql = "SELECT obj FROM MauSac obj";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        return query.getResultList();

    }


    public MauSac findByMa(String ma){
        String hql = "SELECT obj FROM MauSac obj WHERE obj.ma = ?1";
        TypedQuery<MauSac> query = this.hSession.createQuery(hql, MauSac.class);
        query.setParameter(1, ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
}
