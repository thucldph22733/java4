package Repository;

import domain_model.ChucVu;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChucVu;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    private Session hSession;
    public ChucVuRepository(){
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }
    public void insert(ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete (ChucVu cv){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(cv);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public ChucVu findById(UUID id){
        return this.hSession.find(ChucVu.class,id);

    }

    public List<ChucVu> findAll(){
        String hql ="SELECT obj FROM ChucVu obj";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        return query.getResultList();

    }


    public ChucVu findByMa(String ma){
        String hql ="SELECT obj FROM ChucVu obj WHERE obj.ma =?1";
        TypedQuery<ChucVu> query = this.hSession.createQuery(hql,ChucVu.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
}
