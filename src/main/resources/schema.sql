DROP DATABASE cubatechDb;
CREATE DATABASE IF NOT EXISTS cubatechDb;

USE cubatechDb;

CREATE TABLE IF NOT EXISTS category(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    description LONGTEXT,
    studyGuide VARCHAR(255),
    status VARCHAR(7),
    orderInSystem INTEGER,
    iconPath VARCHAR(255),
    colorCode VARCHAR(7)
);

CREATE TABLE IF NOT EXISTS subCategory(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    description LONGTEXT,
    studyGuide VARCHAR(255),
    orderInSystem INTEGER,
    status VARCHAR(7),
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_subCategory_category FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE IF NOT EXISTS course(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(70) NOT NULL,
    urlCode VARCHAR(60) NOT NULL,
    timeToFinishInHours INTEGER NOT NULL,
    targetAudience VARCHAR(255),
    courseVisibility VARCHAR(9),
    instructor VARCHAR(30),
    summary LONGTEXT,
    skillsDeveloped LONGTEXT,
    subCategory_id BIGINT,
    CONSTRAINT fk_course_subCategory FOREIGN KEY (subCategory_id) REFERENCES subCategory (id)
);

CREATE TABLE IF NOT EXISTS lesson(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    orderInSystem INTEGER,
    active BOOLEAN,
    exam BOOLEAN,
    course_id BIGINT,
    CONSTRAINT fk_lesson_course FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE IF NOT EXISTS activity(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    orderInSystem INTEGER,
    active BOOLEAN,
    lesson_id BIGINT NOT NULL,
    CONSTRAINT fk_activity_lesson FOREIGN KEY (lesson_id) REFERENCES lesson (id)
);

CREATE TABLE IF NOT EXISTS explanation(
    description VARCHAR(20),
    activity_id BIGINT NOT NULL,
    CONSTRAINT fk_explanation_activity FOREIGN KEY (activity_id) REFERENCES activity(id)
);

CREATE TABLE IF NOT EXISTS video(
    url VARCHAR(30) NOT NULL,
    durationInMinutes INTEGER,
    transcription LONGTEXT,
    activity_id BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS question(
    description LONGTEXT NOT NULL,
    questionType VARCHAR(20),
    activity_id BIGINT NOT NULL,
    CONSTRAINT fk_questions_activity FOREIGN KEY (activity_id) REFERENCES activity(id)
);

CREATE TABLE IF NOT EXISTS alternative(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    explanation VARCHAR(255) NOT NULL,
    orderInSystem INTEGER,
    correct BOOLEAN NOT NULL,
    justification VARCHAR(255),
    activity_id BIGINT NOT NULL,
    CONSTRAINT fk_alternative_activity FOREIGN KEY (activity_id) REFERENCES activity(id)
);