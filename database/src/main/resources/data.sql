INSERT INTO tbl_user(username, password, role, is_del) VALUES('admin', '$2a$10$ctsUF6k5jE4eVy/EJB1YNuMRVcXoOgyfyvuH4Qa16kxQ9MwVF6K32', 'ADMIN', false);
INSERT INTO tbl_worship(date, part, verses, title, content, audio_path, writer) VALUES ('2024-01-01', '오전 11시 예배', '창세기 1:1~21', '천지창조', '천지창조 내용', '/', 'admin');
INSERT INTO tbl_worship(date, part, verses, title, content, audio_path, writer) VALUES ('2024-06-12', '오전 11시 예배',
                                                                                        '로마서 10:14-21',
                                                                                        '믿음은 들음에서 나며',
                                                                                        '앞에서 예수 그리스도를 통한 구원의 원리를 설명한 바울은 본문에서 그 구원의 복음을 전파하는 사람의 중요성을 설명한다. 그러나 복음을 전해도 이스라엘 백성처럼 순종하지 않는 사람들이 있음을 설명한다.첫째, 우리는 모두 복음을 전파하는 사람이 되어야 한다(14). 주의 이름을 부르려면 믿어야 하는데 주를 전파하는 자가 없다면 듣지 못하고 믿지도 못하니 반드시 전파하는자가 있어야 한다. 하나님의 은혜로 먼저 구원을 얻은 우리가 복음을 전하는 아름다운사람들(15)이 되어야 한다. 불신자들이 복음을 듣게 해야 한다(17), 이것이 곧 우리의의무이다.둘째, 복음을 들어도 불순종하는 사람들은 있다(16). 유대인들은 예수께서 성경에 예언된 대로 오셔서 복음을 전하셨지만 그를 배척하였고 십자가에 못 박아 죽이기까지 하였다. 주님은 그 이유를 (마 23장)에서 그들의 조상으로부터 물려받은 불순종의 습성 때문이라고 하셨다. 믿음은 주의 말씀에 순종할 때 따라온다. 하나님의 말씀을 듣는다는것은 듣고 그 말씀대로 순종하는 데까지 가는 것이다. 그럴 때만 진정한 믿음의 사람으로 살 수 있다.',
                                                                                        'hc0y-RZu9hs', 'admin');
INSERT INTO tbl_bulletin(date, image1Path, image2Path, writer) VALUES ('2024-01-01', '/bulletin/240609_1.jpeg', '/bulletin/240609_2.jpeg', 'admin');
INSERT INTO tbl_bulletin(date, image1Path, image2Path, writer) VALUES ('2024-03-01', '/bulletin/240609_1.jpeg', '/bulletin/240609_2.jpeg', 'admin');
INSERT INTO tbl_bulletin(date, image1Path, image2Path, writer) VALUES ('2024-06-12', '/bulletin/240609_1.jpeg', '/bulletin/240609_2.jpeg', 'admin');
