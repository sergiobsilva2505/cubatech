package br.com.sbs.cubatech.builder;

import br.com.sbs.cubatech.category.Category;
import br.com.sbs.cubatech.category.Status;
import br.com.sbs.cubatech.category.SubCategory;

public class SubCategoryBuilder {

    private final SubCategory subCategory;

    public SubCategoryBuilder(String name, String urlCode, Category category){
        this.subCategory = new SubCategory(name, urlCode, category);
    }

    public SubCategoryBuilder withDescription(String description){
        this.subCategory.setDescription(description);
        return this;
    }

    public SubCategoryBuilder active(){
        this.subCategory.setStatus(Status.ACTIVE);
        return this;
    }

    public SubCategoryBuilder inactive(){
        this.subCategory.setStatus(Status.INACTIVE);
        return this;
    }

    public SubCategory build(){
        return this.subCategory;
    }



}
