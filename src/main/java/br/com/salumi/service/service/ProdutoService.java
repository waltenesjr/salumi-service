package br.com.salumi.service.service;

import br.com.salumi.service.bean.ProdutoBean;
import br.com.salumi.service.builder.ProdutoBuilder;
import br.com.salumi.service.hibernate.HibernateDAO;
import br.com.salumi.service.model.Produto;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("produtoService")
public class ProdutoService {

    @Autowired
    private HibernateDAO dao;

    @Transactional
    public List<ProdutoBean> getAll() {
        List<ProdutoBean> list = new ArrayList<>();
        for (Produto p : (List<Produto>) dao.createCriteria(Produto.class).addOrder(Order.desc("id")).list()) {
            list.add(ProdutoBuilder.modelToBean(p));
        }
        return list;
    }

    @Transactional
    public ProdutoBean get(int id) {
        return ProdutoBuilder.modelToBean((Produto) dao.get(Produto.class, id));
    }

    @Transactional
    public void add(ProdutoBean bean) {
        dao.persist(ProdutoBuilder.beanToModel(bean));
    }

    @Transactional
    public void update(ProdutoBean bean) {
        dao.update(ProdutoBuilder.beanToModel(bean));
    }

    @Transactional
    public void delete(int id) {
        dao.delete(Produto.class, id);
    }
}
