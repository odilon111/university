CREATE TABLE IF NOT EXISTS lecture (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    teacher_id INTEGER NOT NULL,
    credit_point ENUM('5', '10'),
    semester ENUM('SEMESTER1', 'SEMESTER2', 'SEMESTER3', 'SEMESTER4', 'SEMESTER5', 'SEMESTER6', 'SEMESTER7', 'SEMESTER8'),
    description_module VARCHAR(2000) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);