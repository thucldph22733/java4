package Repository;

import com.oracle.wls.shaded.org.apache.regexp.recompile;
import domain_model.ChiTietSP;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {
    private Session hSession;

    public ChiTietSanPhamRepository() {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSP ct) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(ct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

//    public ChiTietSP findById(String id) {
//        return this.hSession.find(ChiTietSP.class, id);
//    }

//    public List<ChiTietSP> findAll() {
//        String hql = "SELECT obj FROM ChiTietSP obj";
//        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
//        return query.getResultList();
//    }
    public List<ChiTietSP> findAll(){
        String hql="SELECT obj FROM ChiTietSP obj";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql,ChiTietSP.class);
        return query.getResultList();    }

    public ChiTietSP findByMa(String ma) {
        String hql = " SELECT obj FROM ChiTietSP obj where obj.id=?1";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, ma);
        return query.getSingleResult();
    }
//    public ChiTietSP findById(String id) {
//        String hql = " SELECT obj FROM ChiTietSP obj where obj.id=?1";
//        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
//        query.setParameter(1, id);
//        return query.getSingleResult();
//    }
    public ChiTietSP findById(String id) {
        String hql = "SELECT o FROM ChiTietSP o WHERE o.id =?1";
        TypedQuery<ChiTietSP> query = this.hSession.createQuery(hql, ChiTietSP.class);
        query.setParameter(1, id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

}
