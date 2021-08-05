package br.com.sbs.cubatech.builder;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

public class CategoryBuilder {

    private final Category category;

    public CategoryBuilder(String name, String urlCode){
        this.category = new Category(name, urlCode);
    }

    public CategoryBuilder withOrderInSystem(Integer orderInSystem){
        this.category.setOrderInSystem(orderInSystem);
        return  this;
    }

    public CategoryBuilder active(){
        this.category.setStatus(Status.ATIVA);
        return this;
    }

    public CategoryBuilder inactive(){
        this.category.setStatus(Status.INATIVA);
        return this;
    }

    public Category build(){
        return this.category;
    }



}
