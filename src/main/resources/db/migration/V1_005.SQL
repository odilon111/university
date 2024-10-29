CREATE TABLE IF NOT EXISTS university (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    teacher_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);