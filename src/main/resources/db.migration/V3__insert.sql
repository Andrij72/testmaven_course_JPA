--fill table <course>
insert  into course (created_date, cost, name,begin_date,end_date) values (1564420012900,9000,'Java_Beginner',55555445555,55555556663);
insert into course (created_date, cost, name,begin_date,end_date) values (1564410575075, 14000, 'Java_Middle',5553444545655,555555588863);
insert  into course (created_date, cost, name,begin_date,end_date) values (1563010012918,19000,'Java_Professional',544454455445,5533356663);

--fill table <section>
insert  into section (created_date, name, course_id,comment) values (1564420012900, 'Java_core', 1, 'Part1, Part2');
insert  into section (created_date, name, course_id) values (1564420012900, 'Java_8', 2);
insert  into section (created_date, name, course_id) values (1565290029118, 'Spring_Framework', 3);

--fill table <lesson>
insert  into lesson (created_date, name, section_id) values (1563310012918, 'Google Java Style Guide', 1);
insert  into lesson (created_date, name, section_id) values (1564420012908, 'Lambda,Stream API,Optional, Optional extra', 2);
insert  into lesson (created_date, name, section_id) values (1563310012018, 'Regular expression&Data API, Reflection', 3);