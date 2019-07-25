package br.com.salumi.service.builder;

import br.com.salumi.service.bean.ProdutoBean;
import br.com.salumi.service.model.Produto;

public class ProdutoBuilder {

    public static Produto beanToModel(ProdutoBean bean) {
        return new Produto(bean.getId(), bean.getNome(), bean.getLink(), bean.getValor(), bean.getCategoria());
    }

    public static ProdutoBean modelToBean(Produto model) {
        return new ProdutoBean(model.getId(), model.getNome(), model.getLink(), model.getValor(), model.getCategoria());
    }
}
