package Repository;


import domain_model.ChucVu;
import domain_model.DongSP;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLDongSp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    private Session hSession;
    public DongSPRepository(){
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }
    public void insert(DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete (DongSP d){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(d);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public DongSP findById(UUID id){
        return this.hSession.find(DongSP.class,id);

    }

    public List<DongSP> findAll(){
        String hql ="SELECT obj FROM DongSP obj";
        TypedQuery<DongSP> query = this.hSession.createQuery(hql,DongSP.class);
        return query.getResultList();

    }

    public DongSP findByMa(String ma){
        String hql ="SELECT obj FROM DongSP obj WHERE obj.ma =?1";
        TypedQuery<DongSP> query = this.hSession.createQuery(hql,DongSP.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
}
