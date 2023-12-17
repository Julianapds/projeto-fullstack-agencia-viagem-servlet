package com.rotasdosol.dao;

import com.rotasdosol.config.HibernateConfig;
import com.rotasdosol.model.DestinoModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DestinoDAO {

    private final SessionFactory sessionFactory;

    public DestinoDAO() {
        sessionFactory = HibernateConfig.getSessionFactory();
    }

    public List<DestinoModel> listar() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM com.rotasdosol.model.DestinoModel", DestinoModel.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar destinos", e);
        }
    }

    public DestinoModel buscarPorId(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(DestinoModel.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar destino por ID", e);
        }
    }

    public void excluir(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            DestinoModel destino = session.get(DestinoModel.class, id);
            if (destino != null) {
                session.delete(destino);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao excluir destino", e);
        }
    }

    public void atualizar(DestinoModel destino) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(destino);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao atualizar destino", e);
        }
    }

    public void criar(DestinoModel destino) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(destino);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao criar destino", e);
        }
    }
}