<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="templates" tagdir="/WEB-INF/tags/templates" %>

<templates:admin-templates title="Edita Curso">
    <form action="/admin/courses/${ categoryCode }/${ subCategoryCode }/${ courseCode }" method="post" >
        <input type="hidden" name="id" value="${ course.id }">
        <h3>Edita Curso</h3>
        <div class="form-group">
            <label for="name" >Nome</label>
            <input id="name" class="form-control" type="text" name="name" value="${ course.name }" placeholder="digite aqui o nome do curso" />
            <form:errors path="updateCourseForm.name" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="urlCode" >Código</label>
            <input id="urlCode" class="form-control" type="text" name="urlCode" value="${ course.urlCode }" placeholder="por exemplo: java, python (não use letras maiúsculas, acentos ou caracteres especiais)"/>
            <form:errors path="updateCourseForm.urlCode" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="timeToFinishInHours">Duração</label>
            <input id="timeToFinishInHours" class="form-control" type="number" name="timeToFinishInHours" min="1" max="20" value="${ course.timeToFinishInHours }" placeholder="duração do curso em horas: entre 1 a 20 horas"/>
            <form:errors path="updateCourseForm.timeToFinishInHours" cssClass="alert-danger"/>
        </div>
        <div class="form-group">
            <label for="courseVisibility">Visibilidade</label>
            <select id="courseVisibility" class="form-control" name="courseVisibility" >
                <option value="" >Selecione</option>
                <c:forEach items="${ courseVisibilityValues }" var="courseVisibility">
                    <option value="${ courseVisibility }" ${ courseVisibility.equals(course.courseVisibility)? 'selected' : '' } >${ courseVisibility.description }</option>
                </c:forEach>
            </select>
            <form:errors path="updateCourseForm.courseVisibility" />
        </div>
        <div class="form-group">
            <label for="targetAudience">Público alvo</label>
            <input id="targetAudience" class="form-control" type="text" name="targetAudience" value="${ course.targetAudience }" placeholder="uma descrição de pra quem é o curso"/>
            <form:errors path="updateCourseForm.courseVisibility" cssClass="alert-danger"/>
        </div>
        <div class="form-group">
            <label for="instructor" >Instrutor</label>
            <input id="instructor" class="form-control" type="text" name="instructor" value="${ course.instructor }" placeholder="digite aqui o nome do instrutor do curso" />
            <form:errors path="updateCourseForm.instructor" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <label for="summary">Ementa</label>
            <textarea id="summary" class="form-control"  name="summary" rows="4" cols="50" placeholder="uma descrição detalhada do que será abordado no curso">${ course.summary }</textarea>
        </div>
        <div class="form-group">
            <label for="skillsDeveloped">Habilidades desenvolvidas</label>
            <textarea id="skillsDeveloped" class="form-control"  name="skillsDeveloped" rows="4" cols="50" placeholder="um texto sobre quais capacidades a pessoa que faz o curso terá exercitado">${ course.skillsDeveloped }</textarea>
        </div>
        <div class="form-group">
            <label for="subCategory">Subcategoria</label>
            <select id="subCategory" class="form-control" name="subCategoryId" >
                <option value="" >Selecione</option>
                <c:forEach items="${ subCategories }" var="subCategory" >
                    <option value="${ subCategory.id }" ${subCategory.id == course.subCategory.id ? "selected= 'selected'" : ""}>${ subCategory.name }</option>
                </c:forEach>
            </select>
            <form:errors path="updateCourseForm.subCategoryId" cssClass="alert-danger" />
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</templates:admin-templates>