CREATE TABLE PUBLIC.person (
   id INTEGER,
   firstName VARCHAR,
   phone VARCHAR,
   PRIMARY KEY (id)
)WITH "template=REPLICATED,CACHE_NAME=person,VALUE_TYPE=com.zj.model.Person";

INSERT INTO public.person values(1, '张三', '15071371253');
INSERT INTO public.person values(2, '李四', '15071371254');