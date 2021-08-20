<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Programação | Cursos online de tecnologia</title>
    <style>
        *, :after, :before {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background-color: #f9fbfd;
        }
        body, input, select, textarea {
            font: normal 14px sans-serif;
        }
        a {
            outline: none;
        }
        ul {
            list-style: none;
        }
        .container {
            margin: 0 auto;
            max-width: 1200px;
            width: 96%;
        }
        .category-banner__wrapper {
            background-color: #a1b0c0;
        }
        .category-banner {
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: flex-start;
        }
        .category-banner__icon img {
            max-height: 32px;
        }
        .category-banner__title {
            margin-left: 10px;
            display: inline-block;
            font-size: 2.4em;
            padding: 1em 0;
            letter-spacing: -1.2px;
            font-weight: 900;
            text-transform: uppercase;
            color: #fff;
        }
        .subcategories {
            margin-top: 24px;
        }
        .subcategories__label {
            font-size: 0.938em;
            line-height: 1.4;
            color: #4a535a;
            margin-bottom: 10px;
        }
        .subcategories__list {
            display: flex;
            flex-wrap: wrap;
            list-style: none;
            margin-top: 5px;
        }
        .subcategories__item {
            margin: 0 5px 16px 0;
            transition: all .2s ease;
        }
        .subcategories__link {
            text-decoration: none;
            padding: 4px 20px 8px;
            border-radius: 4px;
            background-color: #e2e6ee;
        }
        .subcategories__name {
            font-size: 0.813em;
            color: #4a535a;
            opacity: .8;
        }
        .subcategory__name {
            color: #6e767b;
            font-size: 1.313em;
            text-align: left;
            margin-top: 50px;
        }
        .courses__list {
            margin-top: 20px;
        }
        .course-card {
            display: flex;
            flex-direction: column;
            box-shadow: 4px 4px 20px 0 rgb(120 135 182 / 10%);
            background-color: #fff;
            border: 1px solid #eff1f9;
            border-radius: 4px;
            color: #747c81;
            transition: all.3s ease;
            padding: 15px;
            margin: 5px;
        }
        .course-card__name {
            font-weight: 600;
            opacity: .7;
            line-height: 1.29;
            font-size: 1em;
        }
        .course-card__hours {
            margin-top: 5px;
            font-size: 0.8750em;
        }

        @media (min-width: 540px) {
            .subcategories {
                padding: 15px 20px;
                border-radius: 4px;
                border: 1px solid #eff3fb;
            }
            .courses__list {
                display: flex;
                flex-wrap: wrap;
            }
            .course-card {
                width: calc(49% - 7.5px);
            }
        }
        @media (min-width: 940px) {
            .subcategories {
                display: flex;
                justify-content: flex-start;
                padding: 20px 20px 10px;
                margin-top: 20px;
            }
            .subcategories__label {
                margin-right: 10px;
                margin-bottom: 0;
            }
            .subcategories__list {
                display: flex;
                flex-wrap: wrap;
                list-style: none;
                margin-top: 5px;
            }
            .subcategories__item {
                margin: 0 10px 20px 0;
            }
            .course-card {
                width: calc(33.33333% - 10px);
            }
        }
        @media (min-width: 1024px) {
            .course-card {
                width: calc(25% - 15px);
            }
            .course-card__name {
                line-height: 1.36;
            }
        }
    </style>
</head>
<body>
<section class="category-banner__wrapper">
    <div class="container category-banner">
            <span class="category-banner__icon">
                <img src="${ categoryDetailsDto.iconPath }">
            </span>
        <h1 class="category-banner__title">${ categoryDetailsDto.name }</h1>
    </div>
</section>
<main class="container">
    <div class="subcategories">
        <p class="subcategories__label">O que você quer aprender?</p>
        <ul class="subcategories__list">
            <c:forEach items="${ categoryDetailsDto.subCategoryDetailsDtos }" var="subCategory">
                <li class="subcategories__item">
                    <a href="#${ subCategory.urlCode }" class="subcategories__link">
                        <span class="subcategories__name">${ subCategory.name }</span>
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="subcategory">
        <c:forEach items="${ categoryDetailsDto.subCategoryDetailsDtos }" var="subCategory">
            <h2 id="${ subCategory.urlCode }" class="subcategory__name">${ subCategory.name }</h2>
            <ul class="courses__list">
                <c:forEach items="${ subCategory.coursesDetails }" var="course">
                    <li class="course-card">
                        <h3 class="course-card__name">${ course.name}</h3>
                        <p class="course-card__hours">${ course.timeToFinishInHours }hs</p>
                    </li>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
</main>
</body>
</html>