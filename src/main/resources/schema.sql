
CREATE DATABASE IF NOT EXISTS cubatechDb;

USE cubatechDb;

CREATE TABLE IF NOT EXISTS categories(
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

CREATE TABLE IF NOT EXISTS subCategories(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    description LONGTEXT,
    studyGuide VARCHAR(255),
    orderInSystem INTEGER,
    status VARCHAR(7),
    category_id BIGINT NOT NULL
);

ALTER TABLE subCategories ADD CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories (id);

CREATE TABLE IF NOT EXISTS courses(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(70) NOT NULL,
    urlCode VARCHAR(60) NOT NULL,
    timeToFinishInHours INTEGER NOT NULL,
    targetAudience VARCHAR(255),
    courseVisibility VARCHAR(9),
    instructor VARCHAR(30),
    summary LONGTEXT,
    skillsDeveloped LONGTEXT,
    subCategory_id BIGINT
);

ALTER TABLE courses ADD CONSTRAINT fk_subCategory FOREIGN KEY (subCategory_id) REFERENCES subCategories (id);

CREATE TABLE IF NOT EXISTS lessons(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    orderInSystem INTEGER,
    active BOOLEAN,
    exam BOOLEAN,
    course_id BIGINT
);

ALTER TABLE lessons ADD CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES courses (id);

CREATE TABLE IF NOT EXISTS activities(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    urlCode VARCHAR(30) NOT NULL,
    orderInSystem INTEGER,
    active BOOLEAN,
    lesson_id BIGINT NOT NULL
);

ALTER TABLE activities ADD CONSTRAINT fk_lesson FOREIGN KEY (lesson_id) REFERENCES lessons (id);

CREATE TABLE IF NOT EXISTS explanations(
    description VARCHAR(20),
    activity_id BIGINT NOT NULL
);

ALTER TABLE explanations ADD CONSTRAINT fk_activity_explanations FOREIGN KEY (activity_id) REFERENCES activities(id);

CREATE TABLE IF NOT EXISTS videos(
    url VARCHAR(30) NOT NULL,
    durationInMinutes INTEGER,
    transcription LONGTEXT,
    activity_id BIGINT NOT NULL
);

ALTER TABLE videos ADD CONSTRAINT fk_activity_videos FOREIGN KEY (activity_id) REFERENCES activities(id);

CREATE TABLE IF NOT EXISTS questions(
    description LONGTEXT NOT NULL,
    questionType VARCHAR(20),
    activity_id BIGINT NOT NULL
);

ALTER TABLE questions ADD CONSTRAINT fk_activity_questions FOREIGN KEY (activity_id) REFERENCES activities(id);

CREATE TABLE IF NOT EXISTS alternatives(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    explanation VARCHAR(255) NOT NULL,
    orderInSystem INTEGER,
    correct BOOLEAN NOT NULL,
    justification VARCHAR(255),
    activity_id BIGINT NOT NULL
);

ALTER TABLE alternatives ADD CONSTRAINT fk_alternatives_activity FOREIGN KEY (activity_id) REFERENCES activities(id);