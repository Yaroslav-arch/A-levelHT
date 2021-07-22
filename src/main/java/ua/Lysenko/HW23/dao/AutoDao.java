package ua.Lysenko.HW23.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.Lysenko.HW23.entity.Auto;
import ua.Lysenko.HW23.utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class AutoDao {
    public void createAuto(Auto auto) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Object object = session.save(auto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void insertAuto() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "INSERT INTO Auto (title, price, manufactureDate, sellDate, gearType, fuelVolume) "
                    + "SELECT title, price, manufactureDate, sellDate, gearType, fuelVolume FROM Auto";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateAuto(Auto auto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String hql = "UPDATE Auto set title = :title "
                    + "UPDATE Auto set price = :price"
                    + "UPDATE Auto set manufactureDate = :manufactureDate"
                    + "UPDATE Auto set sellDate = :sellDate"
                    + "UPDATE Auto set gearType = :gearType"
                    + "UPDATE Auto set fuelVolume = :fuelVolume"
                    + "WHERE id = :autoId";
            Query query = session.createQuery(hql);
            query.setParameter("autoId", 1);
            query.setParameter("title", auto.getTitle());
            query.setParameter("price", auto.getPrice());
            query.setParameter("manufactureDate", auto.getManufactureDate());
            query.setParameter("sellDate", auto.getSellDate());
            query.setParameter("gearType", auto.getGearType());
            query.setParameter("fuelVolume", auto.getFuelVolume());

            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAuto(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Auto auto = session.get(Auto.class, id);
            if (auto != null) {
                String hql = "DELETE FROM Auto " + "WHERE id = :autoId";
                Query query = session.createQuery(hql);
                query.setParameter("autoId", id);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAllAuto(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Auto auto = session.get(Auto.class, id);
            if (auto != null) {
                String hql = "DELETE FROM Auto ";
                Query query = session.createQuery(hql);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Auto getAutoById(int id) {

        Transaction transaction = null;
        Auto auto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM Auto A WHERE A.id = :autoId";
            Query query = session.createQuery(hql);
            query.setParameter("autoId", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                auto = (Auto) results.get(0);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }

    public Auto getAutoByName(String title) {

        Transaction transaction = null;
        Auto auto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM Auto A WHERE A.title = :autoTitle";
            Query query = session.createQuery(hql);
            query.setParameter("autoTitle", title);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                auto = (Auto) results.get(0);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }

    public Auto getAutoByPriceRange(int min, int max) {

        Transaction transaction = null;
        Auto auto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = " FROM Auto A WHERE A.price >= :min && FROM Auto A WHERE A.price <= :max ";
            Query query = session.createQuery(hql);
            query.setParameter("min", min);
            query.setParameter("max", max);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                auto = (Auto) results.get(0);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return auto;
    }


    public List<Auto> getAutos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Auto", Auto.class).list();
        }
    }
}

