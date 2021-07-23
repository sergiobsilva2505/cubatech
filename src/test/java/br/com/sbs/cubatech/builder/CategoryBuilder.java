package br.com.sbs.cubatech.builder;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;

public class CategoryBuilder {

    private final Category category;

    public CategoryBuilder(String name, String urlcode){
        this.category = new Category(name, urlcode);
    }

    public CategoryBuilder withOrderInSystem(Integer orderInSystem){
        this.category.setOrderInSystem(orderInSystem);
        return  this;
    }

    public CategoryBuilder active(){
        this.category.setStatus(Status.ACTIVE);
        return this;
    }

    public CategoryBuilder inactive(){
        this.category.setStatus(Status.INACTIVE);
        return this;
    }

    public Category build(){
        return this.category;
    }



}
