package com.rotasdosol.dao;

import com.rotasdosol.config.HibernateConfig;
import com.rotasdosol.model.ClienteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAO {

    public void salvar(ClienteModel cliente) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(cliente);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ClienteModel buscarPorEmailESenha(String email, String senhaHash) {
        Transaction transaction = null;
        ClienteModel cliente = null;
        try  {

            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            String hql = "FROM com.rotasdosol.model.ClienteModel WHERE email = :email AND senhaHash = :senha";
            Query<ClienteModel> query = session.createQuery(hql, ClienteModel.class);
            query.setParameter("email", email);
            query.setParameter("senha", senhaHash);

            cliente = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cliente;
    }

    public boolean existePorCpf(String cpf) {
        Transaction transaction = null;
        boolean existe = false;
        try  {

            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            String hql = "SELECT count(*) FROM com.rotasdosol.model.ClienteModel WHERE cpf = :cpf";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("cpf", cpf);

            existe = query.uniqueResult() > 0;

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return existe;
    }

    public List<ClienteModel> buscar() {
        Transaction transaction = null;
        List<ClienteModel> clientes = null;
        try {
            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            Query<ClienteModel> query = session.createQuery("FROM com.rotasdosol.model.ClienteModel", ClienteModel.class);
            clientes = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return clientes;
    }


    public void excluir(int id) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            ClienteModel cliente = session.get(ClienteModel.class, id);
            if (cliente != null) {
                session.delete(cliente);
            } else {
                throw new Exception("Cliente não encontrado com ID: " + id);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Erro ao excluir cliente: " + e.getMessage(), e);
        }
    }

    public ClienteModel buscarPorId(int id) {
        Transaction transaction = null;
        ClienteModel cliente = null;
        try {
            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            cliente = session.get(ClienteModel.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cliente;
    }

    public void atualizar(ClienteModel cliente) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao atualizar cliente", e);
        }
    }

}
