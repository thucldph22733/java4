package Repository;

import domain_model.CuaHang;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {
    private Session hSession;
    public CuaHangRepository(){
        this.hSession= HibernateUtil.getFACTORY().openSession();
    }
    public void insert(CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.persist(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update (CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.merge(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete (CuaHang ch){
        Transaction transaction = this.hSession.getTransaction();
        try{
            transaction.begin();
            this.hSession.delete(ch);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public CuaHang findById(UUID id){
        return this.hSession.find(CuaHang.class,id);

    }

    public List<CuaHang> findAll(){
        String hql ="SELECT obj FROM CuaHang obj";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        return query.getResultList();

    }


    public CuaHang findByMa(String ma){
        String hql ="SELECT obj FROM CuaHang obj WHERE obj.ma =?1";
        TypedQuery<CuaHang> query = this.hSession.createQuery(hql,CuaHang.class);
        query.setParameter(1,ma);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }

}
