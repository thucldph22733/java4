package Repository;

import domain_model.ChucVu;
import domain_model.NSX;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLNsx;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NsxRepository {
    private Session hSession;
    public NsxRepository(){
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }
    public void insert(NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete (NSX n){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(n);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public NSX findById(UUID id){
        return this.hSession.find(NSX.class,id);

    }

    public List<NSX> findAll(){
        String hql ="SELECT obj FROM NSX obj";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        return query.getResultList();

    }


    public NSX findByMa(String ma){
        String hql ="SELECT obj FROM NSX obj WHERE obj.ma =?1";
        TypedQuery<NSX> query = this.hSession.createQuery(hql,NSX.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
