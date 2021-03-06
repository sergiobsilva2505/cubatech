<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-templates title="Nova Categoria">
    <form action="/admin/categories" method="post" >
        <h3>Nova Categoria</h3>
        <div class="form-group">
            <label for="name" >Nome</label>
            <input id="name" class="form-control" type="text" name="name"
                   placeholder="Digite aqui o nome da categoria" />
            <form:errors path="newCategoryForm.name" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="urlCode" >Código</label>
            <input id="urlCode" class="form-control" type="text" name="urlCode"
                   placeholder="por exemplo: desenvolvimento, mobile (não use letras maiúsculas, acentos ou caracteres especiais)"/>
            <form:errors path="newCategoryForm.urlCode" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="status">Categoria ativa?</label><br>
            <select id="status" class="form-control" name="status" >
                <option value="" >Selecione</option>
                <c:forEach items="${ statusValues }" var="status">
                    <option value="${ status }" ${ status.equals(category.status)
                    ? 'selected' : '' } >${ status.description }</option>
                </c:forEach>
            </select>
            <form:errors path="newCategoryForm.status" />
        </div>
        <div class="form-group">
            <label for="orderInSystem">Ordem da categoria</label>
            <input id="orderInSystem" class="form-control" type="number" name="orderInSystem"
                   placeholder="por exemplo: categoria de ordem 1 aparece antes de ordem 2"/>
            <form:errors path="newCategoryForm.orderInSystem" cssClass="alert-danger"/>
        </div>
        <div class="form-group">
            <label for="studyGuide">Guia de estudo</label>
            <textarea id="studyGuide" class="form-control"  name="studyGuide" rows="4" cols="50"
                      placeholder="Um texto apontando para formações para ajudar pessoas perdidas"></textarea>
        </div>
        <div class="form-group">
            <label for="iconPath">Caminho do ícone</label>
            <input id="iconPath" class="form-control" type="text" name="iconPath"
                   placeholder="por exemplo: /images/categorias/programação.svg"/>
        </div>
        <div class="form-group">
            <label for="colorCode">Cor</label>
            <input id="colorCode" class="form-control" type="text" name="colorCode"
                   placeholder="por exemplo: #fcc14a"/>
        </div>
        <div class="form-group">
            <label for="description">Descrição</label>
            <input id="description" class="form-control" type="text" name="description"
                   placeholder="por exemplo: iOS, Android, PhoneGap e mais."/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</templates:admin-templates>

