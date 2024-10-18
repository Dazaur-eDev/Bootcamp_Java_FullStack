package com.daza.m5_sesion2_evaluation.repository;

import com.daza.m5_sesion2_evaluation.configuration.HibernateUtil;
import com.daza.m5_sesion2_evaluation.model.Producto;
import org.hibernate.Session;

import java.util.List;

public class ProductoRepositoryImplementation implements ProductoRepository{
    @Override
    public List<Producto> listarProductos() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Producto", Producto.class).list();
        }
    }
}
