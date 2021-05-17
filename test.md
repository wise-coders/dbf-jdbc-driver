#MySql
Generated using [DbSchema](https://dbschema.com)




<a name='layout1'>### Layout with Tools
![img](./LayoutwithTools.svg)



### Table admin 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.admin_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.admin_usuario'>usuario</a>| varchar&#40;20&#41;  |
|  | <a name='testone.admin_senha'>senha</a>| varchar&#40;20&#41;  |
| Indexes |
| 🔑 | pk&#95;admin || ON id|


### Table alunos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.alunos_MATRICULA'>MATRICULA</a>| int AUTO_INCREMENT |
| *| <a name='testone.alunos_NOME_ALUNO'>NOME&#95;ALUNO</a>| varchar&#40;30&#41;  DEFAULT '' |
| *| <a name='testone.alunos_TEL_ALUNO'>TEL&#95;ALUNO</a>| varchar&#40;10&#41;  DEFAULT '' |
|  | <a name='testone.alunos_ENDERECO_ALUNO'>ENDERECO&#95;ALUNO</a>| varchar&#40;30&#41;  |
|  | <a name='testone.alunos_CIDADE_ALUNO'>CIDADE&#95;ALUNO</a>| varchar&#40;20&#41;  DEFAULT 'Rio de Janeiro' |
|  | <a name='testone.alunos_UF'>UF</a>| char&#40;2&#41;  DEFAULT 'RJ' |
| Indexes |
| 🔑 | pk&#95;alunos || ON MATRICULA|


### Table autor 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.autor_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.autor_version'>version</a>| bigint  |
| *| <a name='testone.autor_nascimento'>nascimento</a>| datetime  |
| *| <a name='testone.autor_nome'>nome</a>| varchar&#40;255&#41;  |
| Indexes |
| 🔑 | pk&#95;autor || ON id|


### Table bin185_statistics 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.bin185_statistics_bin185_statistics_id'>bin185&#95;statistics&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.bin185_statistics_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.bin185_statistics_surname'>surname</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.bin185_statistics_age'>age</a>| smallint  |
| *| <a name='testone.bin185_statistics_last_scared'>last&#95;scared</a>| date  |
| *| <a name='testone.bin185_statistics_braveness'>braveness</a>| float&#40;12&#44;0&#41;  |
| Indexes |
| 🔑 | pk&#95;bin185&#95;statistics || ON bin185&#95;statistics&#95;id|


### Table books 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.books_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.books_title'>title</a>| varchar&#40;255&#41;  DEFAULT '' |
| *| <a name='testone.books_author'>author</a>| varchar&#40;255&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;books || ON id|


### Table campi 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.campi_campi_id'>campi&#95;id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.campi_universities_id'>universities&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.campi_geo_cities_br_id'>geo&#95;cities&#95;br&#95;id</a>| bigint  |
| *| <a name='testone.campi_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;campi || ON campi&#95;id|
| 🔎  | campi&#95;city&#95;br&#95;fk || ON geo&#95;cities&#95;br&#95;id|
| 🔎  | campi&#95;university&#95;fk || ON universities&#95;id|
| Foreign Keys |
|  | campi_city_br_fk | ( geo&#95;cities&#95;br&#95;id ) ref [testone&#46;geo&#95;cities&#95;br](#geo&#95;cities&#95;br) (geo&#95;cities&#95;br&#95;id) |
|  | campi_university_fk | ( universities&#95;id ) ref [testone&#46;universities](#universities) (universities&#95;id) |


### Table categorias 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.categorias_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.categorias_nome'>nome</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;categorias || ON id|


### Table classrooms 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.classrooms_classrooms_id'>classrooms&#95;id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.classrooms_campi_id'>campi&#95;id</a>| bigint  |
| *| <a name='testone.classrooms_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;classrooms || ON classrooms&#95;id|
| 🔎  | classrooms&#95;campus&#95;fk || ON campi&#95;id|
| Foreign Keys |
|  | classrooms_campus_fk | ( campi&#95;id ) ref [testone&#46;campi](#campi) (campi&#95;id) |


### Table cliente 
This is <br>a comment for cliente table&#46;<br>THis is a good job

| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 | <a name='testone.cliente_id'>id</a>| bigint AUTO_INCREMENT |  |
| *| <a name='testone.cliente_cpf'>cpf</a>| varchar&#40;12&#41;  DEFAULT '' |  |
|  | <a name='testone.cliente_phone'>phone</a>| varchar&#40;16&#41;  |  |
|  | <a name='testone.cliente_cel'>cel</a>| varchar&#40;16&#41;  |  |
| *| <a name='testone.cliente_gender'>gender</a>| varchar&#40;1&#41;  DEFAULT '' |  |
| 🔎 ⬈ | <a name='testone.cliente_endereco_fk'>endereco&#95;fk</a>| bigint  |  |
| 🔎 ⬈ | <a name='testone.cliente_login_fk'>login&#95;fk</a>| bigint  |  |
| Indexes |
| 🔑 | pk&#95;cliente || ON id |  |
| 🔎  | cliente&#95;endereco&#95;fk || ON endereco&#95;fk |  |
| 🔎  | cliente&#95;login&#95;fk || ON login&#95;fk |  |
| Foreign Keys |
|  | cliente_endereco_fk | ( endereco&#95;fk ) ref [testone&#46;endereco](#endereco) (id) |  |
|  | fk_cliente | ( login&#95;fk ) ref [testone&#46;login](#login) (id) |  |


### Table contas_grupos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.contas_grupos_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.contas_grupos_nome'>nome</a>| varchar&#40;50&#41;  |
|  | <a name='testone.contas_grupos_obs'>obs</a>| varchar&#40;200&#41;  |
| Indexes |
| 🔑 | pk&#95;contas&#95;grupos || ON id|


### Table contas_receita 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.contas_receita_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.contas_receita_descricao'>descricao</a>| varchar&#40;100&#41;  |
|  | <a name='testone.contas_receita_obs'>obs</a>| varchar&#40;200&#41;  |
| 🔎 | <a name='testone.contas_receita_fk_grupos'>fk&#95;grupos</a>| int  |
| Indexes |
| 🔑 | pk&#95;contas&#95;receita || ON id|
| 🔎  | idx&#95;contas&#95;receita || ON fk&#95;grupos|


### Table contas_tipodoc 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.contas_tipodoc_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.contas_tipodoc_sigla'>sigla</a>| varchar&#40;2&#41;  |
|  | <a name='testone.contas_tipodoc_descricao'>descricao</a>| varchar&#40;50&#41;  |
| Indexes |
| 🔑 | pk&#95;contas&#95;tipodoc || ON id|


### Table contas_usuario 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 | <a name='testone.contas_usuario_id'>id</a>| int AUTO_INCREMENT |  |
|  | <a name='testone.contas_usuario_login'>login</a>| varchar&#40;50&#41;  |  |
|  | <a name='testone.contas_usuario_nome'>nome</a>| varchar&#40;100&#41;  |  |
|  | <a name='testone.contas_usuario_endereco'>endereco</a>| varchar&#40;200&#41;  |  |
|  | <a name='testone.contas_usuario_cidade'>cidade</a>| varchar&#40;100&#41;  DEFAULT 'Rio de Janeiro' |  |
|  | <a name='testone.contas_usuario_estado'>estado</a>| varchar&#40;50&#41;  DEFAULT 'RJ' |  |
|  | <a name='testone.contas_usuario_telefones'>telefones</a>| varchar&#40;200&#41;  | delimited by commas |
| 🔎 | <a name='testone.contas_usuario_fk_responsavel'>fk&#95;responsavel</a>| int  |  |
|  | <a name='testone.contas_usuario_obs'>obs</a>| varchar&#40;2000&#41;  |  |
| *| <a name='testone.contas_usuario_data'>data</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |  |
| Indexes |
| 🔑 | pk&#95;contas&#95;usuario || ON id |  |
| 🔎  | idx&#95;contas&#95;usuario || ON fk&#95;responsavel |  |


### Table contas_vendas 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 | <a name='testone.contas_vendas_id'>id</a>| int AUTO_INCREMENT |  |
|  | <a name='testone.contas_vendas_pagante'>pagante</a>| varchar&#40;100&#41;  DEFAULT '' |  |
| *| <a name='testone.contas_vendas_produto'>produto</a>| varchar&#40;100&#41;  DEFAULT '' |  |
|  | <a name='testone.contas_vendas_doc_num'>doc&#95;num</a>| varchar&#40;12&#41;  |  |
| *| <a name='testone.contas_vendas_valor'>valor</a>| double  |  |
|  | <a name='testone.contas_vendas_vencimento'>vencimento</a>| date  |  |
| *| <a name='testone.contas_vendas_lancamento'>lancamento</a>| date  |  |
| *| <a name='testone.contas_vendas_tipo_doc'>tipo&#95;doc</a>| varchar&#40;2&#41;  DEFAULT 'ch' |  |
|  | <a name='testone.contas_vendas_pagador'>pagador</a>| varchar&#40;100&#41;  | nome da pessoa que arca com a despesa |
| 🔎 | <a name='testone.contas_vendas_fk_pagante'>fk&#95;pagante</a>| int  |  |
| 🔎 | <a name='testone.contas_vendas_fk_pagador'>fk&#95;pagador</a>| int  |  |
| 🔎 | <a name='testone.contas_vendas_fk_contas_receitas'>fk&#95;contas&#95;receitas</a>| int  |  |
| Indexes |
| 🔑 | pk&#95;contas&#95;vendas || ON id |  |
| 🔎  | idx&#95;contas&#95;vendas || ON fk&#95;pagante |  |
| 🔎  | idx&#95;contas&#95;vendas&#95;0 || ON fk&#95;pagador |  |
| 🔎  | idx&#95;contas&#95;vendas&#95;1 || ON fk&#95;contas&#95;receitas |  |


### Table contatcts 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.contatcts_id'>id</a>| int AUTO_INCREMENT |
|  | <a name='testone.contatcts_firstname'>firstname</a>| varchar&#40;30&#41;  |
|  | <a name='testone.contatcts_lastname'>lastname</a>| varchar&#40;30&#41;  |
|  | <a name='testone.contatcts_telephone'>telephone</a>| varchar&#40;15&#41;  |
|  | <a name='testone.contatcts_email'>email</a>| varchar&#40;30&#41;  |
| *| <a name='testone.contatcts_created'>created</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
| Indexes |
| 🔑 | pk&#95;contatcts || ON id|


### Table counter 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.counter_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.counter_count'>count</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;counter || ON id|


### Table courses 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.courses_courses_id'>courses&#95;id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.courses_gen_events_id'>gen&#95;events&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.courses_departments_id'>departments&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.courses_classrooms_id'>classrooms&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.courses_gen_schedules_id'>gen&#95;schedules&#95;id</a>| bigint  |
| *| <a name='testone.courses_acronym'>acronym</a>| varchar&#40;6&#41;  DEFAULT '' |
| *| <a name='testone.courses_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;courses || ON courses&#95;id|
| 🔎  | idx&#95;courses || ON gen&#95;schedules&#95;id|
| 🔎  | idx&#95;courses&#95;0 || ON classrooms&#95;id|
| 🔎  | idx&#95;courses&#95;1 || ON departments&#95;id|
| 🔎  | idx&#95;courses&#95;2 || ON gen&#95;events&#95;id|
| Foreign Keys |
|  | fk_courses_classrooms | ( classrooms&#95;id ) ref [testone&#46;classrooms](#classrooms) (classrooms&#95;id) |
|  | fk_courses_departments | ( departments&#95;id ) ref [testone&#46;departments](#departments) (departments&#95;id) |
|  | fk_courses_events | ( gen&#95;events&#95;id ) ref [testone&#46;gen&#95;events](#gen&#95;events) (gen&#95;events&#95;id) |
|  | fk_courses_schedules | ( gen&#95;schedules&#95;id ) ref [testone&#46;gen&#95;schedules](#gen&#95;schedules) (gen&#95;schedules&#95;id) |


### Table courses_pupils 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 ⬈ | <a name='testone.courses_pupils_pupils_id'>pupils&#95;id</a>| bigint AUTO_INCREMENT |  |
| *🔑 ⬈ | <a name='testone.courses_pupils_courses_id'>courses&#95;id</a>| bigint  |  |
| *| <a name='testone.courses_pupils_registration_date'>registration&#95;date</a>| timestamp  DEFAULT CURRENT_TIMESTAMP | pupil&#39;s registration date on a course |
| Indexes |
| 🔑 | pk&#95;courses&#95;pupils || ON pupils&#95;id&#44; courses&#95;id |  |
| 🔎  | courses&#95;pupils&#95;pupil&#95;fk || ON pupils&#95;id |  |
| 🔎  | idx&#95;courses&#95;pupils || ON courses&#95;id |  |
| Foreign Keys |
|  | fk_courses_pupils_courses | ( courses&#95;id ) ref [testone&#46;courses](#courses) (courses&#95;id) |  |
|  | courses_pupils_pupil_fk | ( pupils&#95;id ) ref [testone&#46;pupils](#pupils) (pupils&#95;id) |  |


### Table cursos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.cursos_COD_CURSO'>COD&#95;CURSO</a>| int AUTO_INCREMENT |
| *🔍 | <a name='testone.cursos_NOME_CURSO'>NOME&#95;CURSO</a>| varchar&#40;60&#41;  DEFAULT '' |
|  | <a name='testone.cursos_CARGA_HORARIA'>CARGA&#95;HORARIA</a>| int  |
|  | <a name='testone.cursos_PRECO'>PRECO</a>| int  DEFAULT 0 |
| 🔎 ⬈ | <a name='testone.cursos_PRE_REQUISITO'>PRE&#95;REQUISITO</a>| int  |
| 🔎 ⬈ | <a name='testone.cursos_NIVEL_FK'>NIVEL&#95;FK</a>| int  |
| Indexes |
| 🔑 | pk&#95;cursos || ON COD&#95;CURSO|
| 🔍  | SYS&#95;C005803 || ON NOME&#95;CURSO|
| 🔎  | CURSOS&#95;NIVEL&#95;FK || ON NIVEL&#95;FK|
| 🔎  | CURSOS&#95;PRE&#95;REQUISITO || ON PRE&#95;REQUISITO|
| Foreign Keys |
|  | CURSOS_PRE_REQUISITO | ( PRE&#95;REQUISITO ) ref [testone&#46;cursos](#cursos) (COD&#95;CURSO) |
|  | CURSOS_NIVEL_FK | ( NIVEL&#95;FK ) ref [testone&#46;niveis](#niveis) (COD&#95;NIVEL) |


### Table departments 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.departments_departments_id'>departments&#95;id</a>| bigint AUTO_INCREMENT |
| 🔎 ⬈ | <a name='testone.departments_campi_id'>campi&#95;id</a>| bigint  |
| *| <a name='testone.departments_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;departments || ON departments&#95;id|
| 🔎  | departments&#95;campus&#95;fk || ON campi&#95;id|
| Foreign Keys |
|  | departments_campus_fk | ( campi&#95;id ) ref [testone&#46;campi](#campi) (campi&#95;id) |


### Table developer 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.developer_ID'>ID</a>| int  |
| *🔍 ⬈ | <a name='testone.developer_manager'>manager</a>| int  |
| *🔍 | <a name='testone.developer_NAME'>NAME</a>| varchar&#40;50&#41;  |
| *| <a name='testone.developer_DOC'>DOC</a>| varchar&#40;50&#41;  |
| *🔎 | <a name='testone.developer_PRJROLE'>PRJROLE</a>| int  |
|  | <a name='testone.developer_starttime'>starttime</a>| date  |
| Indexes |
| 🔑 | pk&#95;developer || ON ID|
| 🔍  | fk&#95;developer&#95;developer || ON manager|
| 🔍  | NAME || ON NAME|
| 🔎  | FK&#95;DEVELOPER&#95;PRJROLE || ON PRJROLE|
| Foreign Keys |
|  | fk_developer_developer | ( manager ) ref [testone&#46;developer](#developer) (ID) |


### Table end_entrega 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.end_entrega_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.end_entrega_endereco'>endereco</a>| varchar&#40;200&#41;  |
|  | <a name='testone.end_entrega_bairro'>bairro</a>| varchar&#40;50&#41;  |
|  | <a name='testone.end_entrega_cidade'>cidade</a>| varchar&#40;50&#41;  |
|  | <a name='testone.end_entrega_estado'>estado</a>| varchar&#40;2&#41;  |
|  | <a name='testone.end_entrega_cep'>cep</a>| varchar&#40;9&#41;  |
| Indexes |
| 🔑 | pk&#95;end&#95;entrega || ON id|


### Table endereco 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.endereco_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.endereco_logradouro'>logradouro</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.endereco_numero'>numero</a>| varchar&#40;10&#41;  DEFAULT '' |
| *| <a name='testone.endereco_bairro'>bairro</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.endereco_cidade'>cidade</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.endereco_estado'>estado</a>| varchar&#40;2&#41;  DEFAULT '' |
| *| <a name='testone.endereco_cep'>cep</a>| varchar&#40;9&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;endereco || ON id|


### Table eshop_books 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.eshop_books_book_id'>book&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.eshop_books_title'>title</a>| varchar&#40;70&#41;  |
|  | <a name='testone.eshop_books_author'>author</a>| varchar&#40;70&#41;  |
|  | <a name='testone.eshop_books_price'>price</a>| decimal&#40;7&#44;2&#41;  |
| 🔎 ⬈ | <a name='testone.eshop_books_category_id'>category&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;eshop&#95;books || ON book&#95;id|
| 🔎  | eshop&#95;category&#95;fk || ON category&#95;id|
| Foreign Keys |
|  | eshop_category_fk | ( category&#95;id ) ref [testone&#46;eshop&#95;categories](#eshop&#95;categories) (category&#95;id) |


### Table eshop_categories 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.eshop_categories_category_id'>category&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.eshop_categories_category_name'>category&#95;name</a>| varchar&#40;70&#41;  |
| Indexes |
| 🔑 | pk&#95;eshop&#95;categories || ON category&#95;id|


### Table eshop_client 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.eshop_client_client_id'>client&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.eshop_client_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.eshop_client_cc_name'>cc&#95;name</a>| varchar&#40;30&#41;  DEFAULT '' |
| *| <a name='testone.eshop_client_cc_number'>cc&#95;number</a>| varchar&#40;19&#41;  DEFAULT '' |
| *| <a name='testone.eshop_client_cc_expiration'>cc&#95;expiration</a>| varchar&#40;22&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;eshop&#95;client || ON client&#95;id|


### Table eshop_order_details 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.eshop_order_details_order_detail_id'>order&#95;detail&#95;id</a>| bigint  |
|  | <a name='testone.eshop_order_details_book_id'>book&#95;id</a>| bigint  |
|  | <a name='testone.eshop_order_details_title'>title</a>| varchar&#40;70&#41;  |
|  | <a name='testone.eshop_order_details_author'>author</a>| varchar&#40;70&#41;  |
|  | <a name='testone.eshop_order_details_quantity'>quantity</a>| int  |
|  | <a name='testone.eshop_order_details_price'>price</a>| decimal&#40;7&#44;2&#41;  |
| *🔍 ⬈ | <a name='testone.eshop_order_details_order_id'>order&#95;id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;eshop&#95;order&#95;details || ON order&#95;detail&#95;id|
| 🔍  | order&#95;id || ON order&#95;id|
| Foreign Keys |
|  | eshop_order_details_fk | ( order&#95;id ) ref [testone&#46;eshop&#95;orders](#eshop&#95;orders) (order&#95;id) |


### Table eshop_orders 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.eshop_orders_order_id'>order&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.eshop_orders_delivery_name'>delivery&#95;name</a>| varchar&#40;70&#41;  |
|  | <a name='testone.eshop_orders_delivery_address'>delivery&#95;address</a>| varchar&#40;70&#41;  |
| *🔎 ⬈ | <a name='testone.eshop_orders_client_id'>client&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;eshop&#95;orders || ON order&#95;id|
| 🔎  | idx&#95;eshop&#95;orders || ON client&#95;id|
| Foreign Keys |
|  | fk_eshop_orders | ( client&#95;id ) ref [testone&#46;eshop&#95;client](#eshop&#95;client) (client&#95;id) |


### Table faixas 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔍 | <a name='testone.faixas_COD_FAIXA'>COD&#95;FAIXA</a>| int AUTO_INCREMENT |
| *| <a name='testone.faixas_DESCRICAO'>DESCRICAO</a>| varchar&#40;60&#41;  DEFAULT '' |
| *| <a name='testone.faixas_MINIMO'>MINIMO</a>| int  |
| *| <a name='testone.faixas_MAXIMO'>MAXIMO</a>| int  |
| Indexes |
| 🔍  | COD&#95;FAIXA || ON COD&#95;FAIXA|


### Table gen_actions 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.gen_actions_gen_actions_id'>gen&#95;actions&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_actions_description'>description</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;gen&#95;actions || ON gen&#95;actions&#95;id|


### Table gen_addresses 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_addresses_gen_addresses_id'>gen&#95;addresses&#95;id</a>| bigint AUTO_INCREMENT |  |
|  | <a name='testone.gen_addresses_region'>region</a>| varchar&#40;100&#41;  | neighborhood&#44; &quot;pt&#95;br&#58; bairro&#44; etc&#46; |
|  | <a name='testone.gen_addresses_name'>name</a>| varchar&#40;200&#41;  | Name or description&#46;nFor instance&#44; street&#44; avenue&#44; square&#44; etc&#46; |
| 🔎 ⬈ | <a name='testone.gen_addresses_geo_cities_id'>geo&#95;cities&#95;id</a>| bigint  |  |
| 🔎 ⬈ | <a name='testone.gen_addresses_geo_cities_br_id'>geo&#95;cities&#95;br&#95;id</a>| bigint  |  |
| Indexes |
| 🔑 | pk&#95;gen&#95;addresses || ON gen&#95;addresses&#95;id |  |
| 🔎  | fk&#95;gen&#95;addresses&#95;0 || ON geo&#95;cities&#95;id |  |
| 🔎  | idx&#95;gen&#95;addresses || ON geo&#95;cities&#95;br&#95;id |  |
| Foreign Keys |
|  | fk_gen_addresses_0 | ( geo&#95;cities&#95;id ) ref [testone&#46;geo&#95;cities](#geo&#95;cities) (geo&#95;cities&#95;id) |  |
|  | fk_gen_addresses | ( geo&#95;cities&#95;br&#95;id ) ref [testone&#46;geo&#95;cities&#95;br](#geo&#95;cities&#95;br) (geo&#95;cities&#95;br&#95;id) |  |


### Table gen_addresses_types 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.gen_addresses_types_gen_addresses_types_id'>gen&#95;addresses&#95;types&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_addresses_types_name'>name</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;gen&#95;addresses&#95;types || ON gen&#95;addresses&#95;types&#95;id|


### Table gen_companies 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_companies_gen_companies_id'>gen&#95;companies&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_companies_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.gen_companies_gen_addresses_id'>gen&#95;addresses&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.gen_companies_gen_companies_types_id'>gen&#95;companies&#95;types&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;gen&#95;companies || ON gen&#95;companies&#95;id|
| 🔎  | idx&#95;companies&#95;addresses || ON gen&#95;addresses&#95;id|
| 🔎  | idx&#95;gen&#95;companies || ON gen&#95;companies&#95;types&#95;id|
| Foreign Keys |
|  | fk_companies_addresses | ( gen&#95;addresses&#95;id ) ref [testone&#46;gen&#95;addresses](#gen&#95;addresses) (gen&#95;addresses&#95;id) |
|  | fk_gen_companies | ( gen&#95;companies&#95;types&#95;id ) ref [testone&#46;gen&#95;companies&#95;types](#gen&#95;companies&#95;types) (gen&#95;companies&#95;types&#95;id) |


### Table gen_companies_types 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_companies_types_gen_companies_types_id'>gen&#95;companies&#95;types&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_companies_types_name'>name</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;gen&#95;companies&#95;types || ON gen&#95;companies&#95;types&#95;id|


### Table gen_company_owners 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬈ | <a name='testone.gen_company_owners_gen_company_owners_id'>gen&#95;company&#95;owners&#95;id</a>| bigint AUTO_INCREMENT |
| 🔎 ⬈ | <a name='testone.gen_company_owners_gen_companies_id'>gen&#95;companies&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.gen_company_owners_ownership_types_id'>ownership&#95;types&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;gen&#95;company&#95;owners || ON gen&#95;company&#95;owners&#95;id|
| 🔎  | fk&#95;gen&#95;company&#95;owners&#95;0 || ON gen&#95;companies&#95;id|
| 🔎  | idx&#95;gen&#95;company&#95;owners&#95;1 || ON ownership&#95;types&#95;id|
| Foreign Keys |
|  | fk_gen_company_owners_0 | ( gen&#95;companies&#95;id ) ref [testone&#46;gen&#95;companies](#gen&#95;companies) (gen&#95;companies&#95;id) |
|  | fk_gen_company_owners | ( gen&#95;company&#95;owners&#95;id ) ref [testone&#46;gen&#95;entities](#gen&#95;entities) (gen&#95;entities&#95;id) |
|  | fk_gen_company_owners_1 | ( ownership&#95;types&#95;id ) ref [testone&#46;ownership&#95;types](#ownership&#95;types) (ownership&#95;types&#95;id) |


### Table gen_docs 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬈ | <a name='testone.gen_docs_gen_docs_id'>gen&#95;docs&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.gen_docs_type'>type</a>| varchar&#40;30&#41;  |
|  | <a name='testone.gen_docs_number'>number</a>| varchar&#40;30&#41;  |
| *| <a name='testone.gen_docs_date_'>date&#95;</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
| Indexes |
| 🔑 | pk&#95;gen&#95;docs || ON gen&#95;docs&#95;id|
| Foreign Keys |
|  | fk_gen_docs | ( gen&#95;docs&#95;id ) ref [testone&#46;gen&#95;persons](#gen&#95;persons) (gen&#95;docs&#95;id) |


### Table gen_entities 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔍 ⬋ | <a name='testone.gen_entities_gen_entities_id'>gen&#95;entities&#95;id</a>| bigint AUTO_INCREMENT |
| 🔎 ⬈ | <a name='testone.gen_entities_gen_persons_id'>gen&#95;persons&#95;id</a>| bigint  DEFAULT 0 |
| 🔎 ⬈ | <a name='testone.gen_entities_gen_companies_id'>gen&#95;companies&#95;id</a>| bigint  DEFAULT 0 |
| Indexes |
| 🔍  | pk&#95;entities || ON gen&#95;entities&#95;id|
| 🔎  | idx&#95;entities || ON gen&#95;companies&#95;id|
| 🔎  | idx&#95;entities&#95;0 || ON gen&#95;persons&#95;id|
| Foreign Keys |
|  | fk_entities_companies | ( gen&#95;companies&#95;id ) ref [testone&#46;gen&#95;companies](#gen&#95;companies) (gen&#95;companies&#95;id) |
|  | fk_entities_persons | ( gen&#95;persons&#95;id ) ref [testone&#46;gen&#95;persons](#gen&#95;persons) (gen&#95;persons&#95;id) |


### Table gen_events 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_events_gen_events_id'>gen&#95;events&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.gen_events_dateof'>dateof</a>| date  |
|  | <a name='testone.gen_events_purpose'>purpose</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.gen_events_gen_schedules_id'>gen&#95;schedules&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.gen_events_gen_addresses_id'>gen&#95;addresses&#95;id</a>| bigint  |
| 🔎 ⬈ | <a name='testone.gen_events_gen_entities_id'>gen&#95;entities&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;gen&#95;events || ON gen&#95;events&#95;id|
| 🔎  | idx&#95;events || ON gen&#95;schedules&#95;id|
| 🔎  | idx&#95;events&#95;0 || ON gen&#95;addresses&#95;id|
| 🔎  | idx&#95;events&#95;1 || ON gen&#95;entities&#95;id|
| Foreign Keys |
|  | fk_events_addresses | ( gen&#95;addresses&#95;id ) ref [testone&#46;gen&#95;addresses](#gen&#95;addresses) (gen&#95;addresses&#95;id) |
|  | fk_events_entities | ( gen&#95;entities&#95;id ) ref [testone&#46;gen&#95;entities](#gen&#95;entities) (gen&#95;entities&#95;id) |
|  | fk_events_schedules | ( gen&#95;schedules&#95;id ) ref [testone&#46;gen&#95;schedules](#gen&#95;schedules) (gen&#95;schedules&#95;id) |


### Table gen_persons 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_persons_gen_persons_id'>gen&#95;persons&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_persons_sex'>sex</a>| varchar&#40;1&#41;  DEFAULT '' |
| *| <a name='testone.gen_persons_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔍 ⬋ | <a name='testone.gen_persons_gen_docs_id'>gen&#95;docs&#95;id</a>| bigint  |
| *| <a name='testone.gen_persons_gen_addresses_id'>gen&#95;addresses&#95;id</a>| bigint  |
|  | <a name='testone.gen_persons_notes'>notes</a>| varchar&#40;60&#41;  |
| Indexes |
| 🔑 | pk&#95;gen&#95;persons || ON gen&#95;persons&#95;id|
| 🔍  | idx&#95;gen&#95;persons || ON gen&#95;docs&#95;id|


### Table gen_resources 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.gen_resources_gen_resources_id'>gen&#95;resources&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.gen_resources_name'>name</a>| varchar&#40;30&#41;  |
| *🔎 ⬈ | <a name='testone.gen_resources_gen_systems_id'>gen&#95;systems&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;gen&#95;resources || ON gen&#95;resources&#95;id|
| 🔎  | idx&#95;resources || ON gen&#95;systems&#95;id|
| Foreign Keys |
|  | fk_resources_systems | ( gen&#95;systems&#95;id ) ref [testone&#46;gen&#95;systems](#gen&#95;systems) (gen&#95;systems&#95;id) |


### Table gen_roles 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.gen_roles_gen_roles_id'>gen&#95;roles&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_roles_name'>name</a>| varchar&#40;50&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;gen&#95;roles || ON gen&#95;roles&#95;id|


### Table gen_schedules 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_schedules_gen_schedules_id'>gen&#95;schedules&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_schedules_time_hm_end'>time&#95;hm&#95;end</a>| varchar&#40;5&#41;  DEFAULT '' |
| *| <a name='testone.gen_schedules_time_hm_begin'>time&#95;hm&#95;begin</a>| varchar&#40;5&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;gen&#95;schedules || ON gen&#95;schedules&#95;id|


### Table gen_systems 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.gen_systems_gen_systems_id'>gen&#95;systems&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.gen_systems_name'>name</a>| varchar&#40;30&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.gen_systems_gen_entities_id'>gen&#95;entities&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;gen&#95;systems || ON gen&#95;systems&#95;id|
| 🔎  | idx&#95;systems || ON gen&#95;entities&#95;id|
| Foreign Keys |
|  | fk_systems_entities | ( gen&#95;entities&#95;id ) ref [testone&#46;gen&#95;entities](#gen&#95;entities) (gen&#95;entities&#95;id) |


### Table geo_capitals_br 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_capitals_br_geo_capitals_br_id'>geo&#95;capitals&#95;br&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_capitals_br_state'>state</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_capitals_br_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;capitals&#95;br || ON geo&#95;capitals&#95;br&#95;id|


### Table geo_cep_ac 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ac_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ac_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ac_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ac_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ac_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ac_place_type'>place&#95;type</a>| varchar&#40;20&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ac || ON geo&#95;cep&#95;id|


### Table geo_cep_al 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_al_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_al_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_al_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_al_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_al_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_al_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;al || ON geo&#95;cep&#95;id|


### Table geo_cep_am 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_am_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_am_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_am_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_am_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_am_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_am_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;am || ON geo&#95;cep&#95;id|


### Table geo_cep_ap 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ap_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ap_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ap_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ap_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ap_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ap_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ap || ON geo&#95;cep&#95;id|


### Table geo_cep_ba 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ba_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ba_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ba_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ba_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ba_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ba_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ba || ON geo&#95;cep&#95;id|


### Table geo_cep_ce 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ce_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ce_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ce_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ce_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ce_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ce_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ce || ON geo&#95;cep&#95;id|


### Table geo_cep_df 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_df_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_df_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_df_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_df_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_df_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_df_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;df || ON geo&#95;cep&#95;id|


### Table geo_cep_es 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_es_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_es_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_es_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_es_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_es_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_es_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;es || ON geo&#95;cep&#95;id|


### Table geo_cep_go 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_go_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_go_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_go_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_go_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_go_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_go_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;go || ON geo&#95;cep&#95;id|


### Table geo_cep_index 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_index_geo_cep_index'>geo&#95;cep&#95;index</a>| int  |
| *| <a name='testone.geo_cep_index_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_index_state'>state</a>| varchar&#40;2&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;index || ON geo&#95;cep&#95;index|


### Table geo_cep_ma 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ma_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ma_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ma_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ma_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ma_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ma_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ma || ON geo&#95;cep&#95;id|


### Table geo_cep_mg 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_mg_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_mg_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mg_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mg_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mg_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mg_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;mg || ON geo&#95;cep&#95;id|


### Table geo_cep_ms 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ms_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ms_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ms_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ms_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ms_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ms_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ms || ON geo&#95;cep&#95;id|


### Table geo_cep_mt 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_mt_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_mt_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mt_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mt_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mt_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_mt_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;mt || ON geo&#95;cep&#95;id|


### Table geo_cep_pa 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_pa_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_pa_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pa_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pa_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pa_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pa_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;pa || ON geo&#95;cep&#95;id|


### Table geo_cep_pb 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_pb_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_pb_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pb_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pb_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pb_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pb_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;pb || ON geo&#95;cep&#95;id|


### Table geo_cep_pe 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_pe_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_pe_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pe_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pe_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pe_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pe_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;pe || ON geo&#95;cep&#95;id|


### Table geo_cep_pi 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_pi_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_pi_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pi_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pi_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pi_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pi_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;pi || ON geo&#95;cep&#95;id|


### Table geo_cep_pr 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_pr_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_pr_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pr_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pr_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pr_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_pr_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;pr || ON geo&#95;cep&#95;id|


### Table geo_cep_rj 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_rj_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_rj_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rj_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rj_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rj_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rj_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;rj || ON geo&#95;cep&#95;id|


### Table geo_cep_rn 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_rn_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_rn_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rn_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rn_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rn_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rn_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;rn || ON geo&#95;cep&#95;id|


### Table geo_cep_ro 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_ro_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_ro_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ro_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ro_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ro_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_ro_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;ro || ON geo&#95;cep&#95;id|


### Table geo_cep_rr 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_rr_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_rr_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rr_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rr_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rr_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rr_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;rr || ON geo&#95;cep&#95;id|


### Table geo_cep_rs 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_rs_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_rs_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rs_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rs_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rs_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_rs_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;rs || ON geo&#95;cep&#95;id|


### Table geo_cep_sc 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_sc_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_sc_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sc_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sc_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sc_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sc_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;sc || ON geo&#95;cep&#95;id|


### Table geo_cep_se 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_se_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_se_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_se_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_se_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_se_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_se_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;se || ON geo&#95;cep&#95;id|


### Table geo_cep_sp 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_sp_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_sp_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sp_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sp_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sp_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_sp_place_type'>place&#95;type</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;sp || ON geo&#95;cep&#95;id|


### Table geo_cep_to 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_to_geo_cep_id'>geo&#95;cep&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_to_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_to_place'>place</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_to_neighborhood'>neighborhood</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_to_code'>code</a>| varchar&#40;9&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_to_place_type'>place&#95;type</a>| varchar&#40;20&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;to || ON geo&#95;cep&#95;id|


### Table geo_cep_unique 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.geo_cep_unique_geo_cep_unique_id'>geo&#95;cep&#95;unique&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cep_unique_name'>name</a>| varchar&#40;70&#41;  DEFAULT '' |
| *| <a name='testone.geo_cep_unique_name_without_accent'>name&#95;without&#95;accent</a>| varchar&#40;70&#41;  DEFAULT '' |
|  | <a name='testone.geo_cep_unique_code'>code</a>| varchar&#40;9&#41;  |
| *| <a name='testone.geo_cep_unique_state'>state</a>| varchar&#40;2&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;cep&#95;unique || ON geo&#95;cep&#95;unique&#95;id|


### Table geo_cities 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.geo_cities_geo_cities_id'>geo&#95;cities&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.geo_cities_name'>name</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.geo_cities_geo_states_id'>geo&#95;states&#95;id</a>| bigint  |
|  | <a name='testone.geo_cities_iscapital'>iscapital</a>| varchar&#40;1&#41;  |
|  | <a name='testone.geo_cities_phone_code'>phone&#95;code</a>| int  |
| Indexes |
| 🔑 | pk&#95;geo&#95;cities || ON geo&#95;cities&#95;id|
| 🔎  | idx&#95;geo&#95;cities || ON geo&#95;states&#95;id|
| Foreign Keys |
|  | fk_geo_cities | ( geo&#95;states&#95;id ) ref [testone&#46;geo&#95;states](#geo&#95;states) (geo&#95;states&#95;id) |


### Table geo_cities_br 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.geo_cities_br_geo_cities_br_id'>geo&#95;cities&#95;br&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_cities_br_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
|  | <a name='testone.geo_cities_br_iscapital'>iscapital</a>| varchar&#40;1&#41;  |
|  | <a name='testone.geo_cities_br_ddd'>ddd</a>| int  |
| *🔎 ⬈ | <a name='testone.geo_cities_br_geo_states_br_id'>geo&#95;states&#95;br&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;geo&#95;cities&#95;br || ON geo&#95;cities&#95;br&#95;id|
| 🔎  | cities&#95;br&#95;state&#95;br&#95;fk || ON geo&#95;states&#95;br&#95;id|
| Foreign Keys |
|  | cities_br_state_br_fk | ( geo&#95;states&#95;br&#95;id ) ref [testone&#46;geo&#95;states&#95;br](#geo&#95;states&#95;br) (geo&#95;states&#95;br&#95;id) |


### Table geo_countries 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.geo_countries_geo_countries_id'>geo&#95;countries&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_countries_name'>name</a>| varchar&#40;50&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;geo&#95;countries || ON geo&#95;countries&#95;id|


### Table geo_states 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.geo_states_geo_states_id'>geo&#95;states&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_states_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.geo_states_geo_countries_id'>geo&#95;countries&#95;id</a>| bigint  |
|  | <a name='testone.geo_states_alpha_code'>alpha&#95;code</a>| varchar&#40;6&#41;  |
|  | <a name='testone.geo_states_numerical_code'>numerical&#95;code</a>| int  |
|  | <a name='testone.geo_states_abbreviation'>abbreviation</a>| varchar&#40;10&#41;  |
| Indexes |
| 🔑 | pk&#95;geo&#95;states || ON geo&#95;states&#95;id|
| 🔎  | idx&#95;geo&#95;states || ON geo&#95;countries&#95;id|
| Foreign Keys |
|  | fk_geo_states_geo_countries | ( geo&#95;countries&#95;id ) ref [testone&#46;geo&#95;countries](#geo&#95;countries) (geo&#95;countries&#95;id) |


### Table geo_states_br 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.geo_states_br_geo_states_br_id'>geo&#95;states&#95;br&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.geo_states_br_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.geo_states_br_alpha_code'>alpha&#95;code</a>| varchar&#40;2&#41;  DEFAULT '' |
|  | <a name='testone.geo_states_br_numerical_code'>numerical&#95;code</a>| int  |
| *🔎 ⬈ | <a name='testone.geo_states_br_geo_countries_id'>geo&#95;countries&#95;id</a>| bigint  |
|  | <a name='testone.geo_states_br_capital'>capital</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;geo&#95;states&#95;br || ON geo&#95;states&#95;br&#95;id|
| 🔎  | idx&#95;geo&#95;states&#95;br || ON geo&#95;countries&#95;id|
| Foreign Keys |
|  | fk_geo_states_br | ( geo&#95;countries&#95;id ) ref [testone&#46;geo&#95;countries](#geo&#95;countries) (geo&#95;countries&#95;id) |


### Table getit_address 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 ⬋ | <a name='testone.getit_address_id'>id</a>| bigint AUTO_INCREMENT |  |
| *| <a name='testone.getit_address_place'>place</a>| varchar&#40;100&#41;  DEFAULT '' |  |
| *| <a name='testone.getit_address_number'>number</a>| varchar&#40;10&#41;  DEFAULT '' |  |
| *| <a name='testone.getit_address_area'>area</a>| varchar&#40;100&#41;  DEFAULT '' | neighborhood&#44; suburb&#44; rural area&#44; etc&#46; |
| *| <a name='testone.getit_address_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |  |
| *| <a name='testone.getit_address_state'>state</a>| varchar&#40;2&#41;  DEFAULT '' |  |
| *| <a name='testone.getit_address_zip'>zip</a>| varchar&#40;9&#41;  DEFAULT '' |  |
| *🔎 ⬈ | <a name='testone.getit_address_country_fk'>country&#95;fk</a>| bigint  |  |
| Indexes |
| 🔑 | pk&#95;getit&#95;address || ON id |  |
| 🔎  | idx&#95;getit&#95;address || ON country&#95;fk |  |
| Foreign Keys |
|  | fk_address | ( country&#95;fk ) ref [testone&#46;geo&#95;countries](#geo&#95;countries) (geo&#95;countries&#95;id) |  |


### Table getit_client 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.getit_client_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.getit_client_doc'>doc</a>| varchar&#40;16&#41;  DEFAULT '' |
|  | <a name='testone.getit_client_phone'>phone</a>| varchar&#40;16&#41;  |
|  | <a name='testone.getit_client_cel'>cel</a>| varchar&#40;16&#41;  |
| *| <a name='testone.getit_client_gender'>gender</a>| varchar&#40;1&#41;  DEFAULT '' |
| 🔎 | <a name='testone.getit_client_address_fk'>address&#95;fk</a>| bigint  |
| 🔎 ⬈ | <a name='testone.getit_client_logon_fk'>logon&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;getit&#95;client || ON id|
| 🔎  | getit&#95;cliente&#95;endereco&#95;fk&#95;0 || ON address&#95;fk|
| 🔎  | getit&#95;cliente&#95;login&#95;fk&#95;0 || ON logon&#95;fk|
| Foreign Keys |
|  | fk_client_0 | ( logon&#95;fk ) ref [testone&#46;getit&#95;address](#getit&#95;address) (id) |
|  | fk_client | ( logon&#95;fk ) ref [testone&#46;getit&#95;logon](#getit&#95;logon) (id) |


### Table getit_logon 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.getit_logon_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.getit_logon_email'>email</a>| varchar&#40;50&#41;  DEFAULT '' |
| *| <a name='testone.getit_logon_login'>login</a>| varchar&#40;10&#41;  DEFAULT '' |
| *| <a name='testone.getit_logon_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.getit_logon_password'>password</a>| varchar&#40;10&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;getit&#95;logon || ON id|


### Table getit_post 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.getit_post_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.getit_post_subject'>subject</a>| varchar&#40;255&#41;  DEFAULT '' |
| *| <a name='testone.getit_post_header_from'>header&#95;from</a>| varchar&#40;50&#41;  DEFAULT '' |
| *| <a name='testone.getit_post_header_date'>header&#95;date</a>| varchar&#40;30&#41;  DEFAULT '' |
| *| <a name='testone.getit_post_url'>url</a>| varchar&#40;500&#41;  DEFAULT '' |
| *| <a name='testone.getit_post_content'>content</a>| text  |
|  | <a name='testone.getit_post_img'>img</a>| blob  |
|  | <a name='testone.getit_post_tokens'>tokens</a>| varchar&#40;255&#41;  |
| Indexes |
| 🔑 | pk&#95;getit&#95;post || ON id|


### Table getit_recipient 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 | <a name='testone.getit_recipient_id'>id</a>| bigint AUTO_INCREMENT |  |
| *| <a name='testone.getit_recipient_email'>email</a>| varchar&#40;50&#41;  DEFAULT '' |  |
| 🔎 ⬈ | <a name='testone.getit_recipient_logon_fk'>logon&#95;fk</a>| bigint  |  |
| *🔎 ⬈ | <a name='testone.getit_recipient_post_fk'>post&#95;fk</a>| bigint  |  |
| *| <a name='testone.getit_recipient_times'>times</a>| int  | number of times that the same post was sent &#40;default &#61;1&#41; |
| Indexes |
| 🔑 | pk&#95;getit&#95;recipient || ON id |  |
| 🔎  | idx&#95;getit&#95;recipient || ON logon&#95;fk |  |
| 🔎  | idx&#95;getit&#95;recipient&#95;0 || ON post&#95;fk |  |
| Foreign Keys |
|  | fk_recipient | ( logon&#95;fk ) ref [testone&#46;getit&#95;logon](#getit&#95;logon) (id) |  |
|  | fk_recipient_0 | ( post&#95;fk ) ref [testone&#46;getit&#95;post](#getit&#95;post) (id) |  |


### Table grupo 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.grupo_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.grupo_nome'>nome</a>| varchar&#40;100&#41;  |
|  | <a name='testone.grupo_obs'>obs</a>| varchar&#40;100&#41;  |
| *| <a name='testone.grupo_lastupdate'>lastupdate</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
| Indexes |
| 🔑 | pk&#95;grupo || ON id|


### Table hilosequences 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.hilosequences_sequencename'>sequencename</a>| varchar&#40;50&#41;  DEFAULT '' |
| *| <a name='testone.hilosequences_highvalues'>highvalues</a>| int  |
| Indexes |
| 🔑 | pk&#95;hilosequences || ON sequencename|


### Table instrutores 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.instrutores_COD_INSTRUTOR'>COD&#95;INSTRUTOR</a>| int AUTO_INCREMENT |
| *| <a name='testone.instrutores_NOME_INSTRUTOR'>NOME&#95;INSTRUTOR</a>| varchar&#40;60&#41;  DEFAULT '' |
|  | <a name='testone.instrutores_TEL_INSTRUTOR'>TEL&#95;INSTRUTOR</a>| varchar&#40;10&#41;  |
|  | <a name='testone.instrutores_ADMISSAO'>ADMISSAO</a>| date  |
| 🔎 ⬈ | <a name='testone.instrutores_COD_TITULO'>COD&#95;TITULO</a>| int  |
| Indexes |
| 🔑 | pk&#95;instrutores || ON COD&#95;INSTRUTOR|
| 🔎  | INSTRUTORES&#95;TITULO&#95;FK || ON COD&#95;TITULO|
| Foreign Keys |
|  | INSTRUTORES_TITULO_FK | ( COD&#95;TITULO ) ref [testone&#46;titulos](#titulos) (COD&#95;TITULO) |


### Table itens_pedido 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔎 ⬈ | <a name='testone.itens_pedido_pedido_fk'>pedido&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.itens_pedido_produto_fk'>produto&#95;fk</a>| bigint  |
|  | <a name='testone.itens_pedido_qtd'>qtd</a>| bigint  |
|  | <a name='testone.itens_pedido_preco'>preco</a>| float&#40;12&#44;0&#41;  |
| Indexes |
| 🔎  | idx&#95;itens&#95;pedido&#95;pedido&#95;fk || ON pedido&#95;fk|
| 🔎  | idx&#95;itens&#95;pedido&#95;produto&#95;fk || ON produto&#95;fk|
| Foreign Keys |
|  | itens_pedido_pedido_fk | ( pedido&#95;fk ) ref [testone&#46;pedidos](#pedidos) (id) |
|  | itens_pedido_produto_fk | ( produto&#95;fk ) ref [testone&#46;produtos](#produtos) (id) |


### Table lgn_authorization 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔎 | <a name='testone.lgn_authorization_role_fk'>role&#95;fk</a>| bigint  |
| *🔎 | <a name='testone.lgn_authorization_login_fk'>login&#95;fk</a>| bigint  |
| *🔎 | <a name='testone.lgn_authorization_resource_fk'>resource&#95;fk</a>| bigint  |
| *| <a name='testone.lgn_authorization_status'>status</a>| varchar&#40;1&#41;  DEFAULT '' |
| Indexes |
| 🔎  | idx&#95;lgn&#95;permission || ON resource&#95;fk|
| 🔎  | idx&#95;lgn&#95;permission&#95;login || ON login&#95;fk|
| 🔎  | idx&#95;lgn&#95;permission&#95;role || ON role&#95;fk|


### Table lgn_login 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.lgn_login_id'>id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.lgn_login_profile_fk'>profile&#95;fk</a>| bigint  |
| *| <a name='testone.lgn_login_password'>password</a>| varchar&#40;20&#41;  DEFAULT '' |
| *| <a name='testone.lgn_login_email'>email</a>| varchar&#40;40&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;lgn&#95;login || ON id|
| 🔎  | idx&#95;lgn&#95;login || ON profile&#95;fk|
| Foreign Keys |
|  | fk_lgn_login_profile | ( profile&#95;fk ) ref [testone&#46;lgn&#95;profile](#lgn&#95;profile) (id) |


### Table lgn_permission 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔎 ⬈ | <a name='testone.lgn_permission_role_fk'>role&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.lgn_permission_login_fk'>login&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.lgn_permission_resource_fk'>resource&#95;fk</a>| bigint  |
| Indexes |
| 🔎  | idx&#95;lgn&#95;permission || ON resource&#95;fk|
| 🔎  | idx&#95;lgn&#95;permission&#95;login || ON login&#95;fk|
| 🔎  | idx&#95;lgn&#95;permission&#95;role || ON role&#95;fk|
| Foreign Keys |
|  | fk_lgn_permission_login | ( login&#95;fk ) ref [testone&#46;lgn&#95;login](#lgn&#95;login) (id) |
|  | fk_lgn_permission_resource | ( resource&#95;fk ) ref [testone&#46;lgn&#95;resource](#lgn&#95;resource) (id) |
|  | fk_lgn_permission_role | ( role&#95;fk ) ref [testone&#46;lgn&#95;role](#lgn&#95;role) (id) |


### Table lgn_profile 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 ⬋ | <a name='testone.lgn_profile_id'>id</a>| bigint AUTO_INCREMENT |  |
| *| <a name='testone.lgn_profile_code'>code</a>| int UNSIGNED  | access degree&#46; |
| *| <a name='testone.lgn_profile_title'>title</a>| varchar&#40;100&#41;  DEFAULT '' |  |
| Indexes |
| 🔑 | pk&#95;lgn&#95;profile || ON id |  |


### Table lgn_resource 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.lgn_resource_id'>id</a>| bigint AUTO_INCREMENT |
| 🔎 | <a name='testone.lgn_resource_parent_fk'>parent&#95;fk</a>| bigint  |
| *| <a name='testone.lgn_resource_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;lgn&#95;resource || ON id|
| 🔎  | idx&#95;lgn&#95;resource || ON parent&#95;fk|


### Table lgn_role 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.lgn_role_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.lgn_role_title'>title</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.lgn_role_code'>code</a>| int UNSIGNED  |
| 🔎 ⬈ | <a name='testone.lgn_role_profile_fk'>profile&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;lgn&#95;role || ON id|
| 🔎  | idx&#95;lgn&#95;role || ON profile&#95;fk|
| Foreign Keys |
|  | fk_lgn_role_profile | ( profile&#95;fk ) ref [testone&#46;lgn&#95;profile](#lgn&#95;profile) (id) |


### Table livro 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.livro_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.livro_version'>version</a>| bigint  |
| *🔎 ⬈ | <a name='testone.livro_autor_id'>autor&#95;id</a>| bigint  |
| *| <a name='testone.livro_titulo'>titulo</a>| varchar&#40;255&#41;  |
| *| <a name='testone.livro_valor'>valor</a>| float&#40;12&#44;0&#41;  |
| Indexes |
| 🔑 | pk&#95;livro || ON id|
| 🔎  | FK&#95;jiba630fqnramd9goavw4xor0 || ON autor&#95;id|
| Foreign Keys |
|  | FK_jiba630fqnramd9goavw4xor0 | ( autor&#95;id ) ref [testone&#46;autor](#autor) (id) |


### Table loc_categorias 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.loc_categorias_loc_categorias_id'>loc&#95;categorias&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.loc_categorias_descricao'>descricao</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;loc&#95;categorias || ON loc&#95;categorias&#95;id|


### Table loc_clientes 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.loc_clientes_loc_clientes_id'>loc&#95;clientes&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.loc_clientes_nome'>nome</a>| varchar&#40;100&#41;  DEFAULT '' |
|  | <a name='testone.loc_clientes_telefone'>telefone</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_clientes_celular'>celular</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_clientes_email'>email</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_clientes_loc_enderecos_id'>loc&#95;enderecos&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;loc&#95;clientes || ON loc&#95;clientes&#95;id|


### Table loc_enderecos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬈ | <a name='testone.loc_enderecos_loc_clientes_id'>loc&#95;clientes&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.loc_enderecos_rua'>rua</a>| varchar&#40;100&#41;  DEFAULT '' |
|  | <a name='testone.loc_enderecos_numero'>numero</a>| int  |
|  | <a name='testone.loc_enderecos_bairro'>bairro</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_enderecos_cidade'>cidade</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_enderecos_estado'>estado</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_enderecos_cep'>cep</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_enderecos_complemento'>complemento</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;loc&#95;enderecos || ON loc&#95;clientes&#95;id|
| Foreign Keys |
|  | fk_loc_enderecos | ( loc&#95;clientes&#95;id ) ref [testone&#46;loc&#95;clientes](#loc&#95;clientes) (loc&#95;clientes&#95;id) |


### Table loc_filmes 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.loc_filmes_loc_filmes_id'>loc&#95;filmes&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.loc_filmes_descricao'>descricao</a>| varchar&#40;100&#41;  |
|  | <a name='testone.loc_filmes_ano'>ano</a>| int  |
| *🔎 ⬈ | <a name='testone.loc_filmes_loc_categorias_id'>loc&#95;categorias&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;loc&#95;filmes || ON loc&#95;filmes&#95;id|
| 🔎  | loc&#95;categorias&#95;fk || ON loc&#95;categorias&#95;id|
| Foreign Keys |
|  | loc_categorias_fk | ( loc&#95;categorias&#95;id ) ref [testone&#46;loc&#95;categorias](#loc&#95;categorias) (loc&#95;categorias&#95;id) |


### Table loc_locacoes 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.loc_locacoes_loc_locacoes_id'>loc&#95;locacoes&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.loc_locacoes_data_emprestimo'>data&#95;emprestimo</a>| date  |
|  | <a name='testone.loc_locacoes_hora_emprestimo'>hora&#95;emprestimo</a>| time  |
|  | <a name='testone.loc_locacoes_data_devolucao'>data&#95;devolucao</a>| date  |
|  | <a name='testone.loc_locacoes_observacao'>observacao</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.loc_locacoes_loc_midia_id'>loc&#95;midia&#95;id</a>| bigint  |
| *🔎 ⬈ | <a name='testone.loc_locacoes_loc_clientes_id'>loc&#95;clientes&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;loc&#95;locacoes || ON loc&#95;locacoes&#95;id|
| 🔎  | loc&#95;clientes&#95;fk || ON loc&#95;clientes&#95;id|
| 🔎  | loc&#95;midia&#95;fk || ON loc&#95;midia&#95;id|
| Foreign Keys |
|  | loc_clientes_fk | ( loc&#95;clientes&#95;id ) ref [testone&#46;loc&#95;clientes](#loc&#95;clientes) (loc&#95;clientes&#95;id) |
|  | loc_midia_fk | ( loc&#95;midia&#95;id ) ref [testone&#46;loc&#95;midia](#loc&#95;midia) (loc&#95;midia&#95;id) |


### Table loc_midia 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.loc_midia_loc_midia_id'>loc&#95;midia&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.loc_midia_inutilizada'>inutilizada</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.loc_midia_loc_filmes_id'>loc&#95;filmes&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;loc&#95;midia || ON loc&#95;midia&#95;id|
| 🔎  | loc&#95;filmes&#95;fk || ON loc&#95;filmes&#95;id|
| Foreign Keys |
|  | loc_filmes_fk | ( loc&#95;filmes&#95;id ) ref [testone&#46;loc&#95;filmes](#loc&#95;filmes) (loc&#95;filmes&#95;id) |


### Table loc_users 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.loc_users_loc_users_id'>loc&#95;users&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.loc_users_nome'>nome</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔍 | <a name='testone.loc_users_login'>login</a>| varchar&#40;15&#41;  DEFAULT '' |
|  | <a name='testone.loc_users_email'>email</a>| varchar&#40;100&#41;  |
| *| <a name='testone.loc_users_senha'>senha</a>| varchar&#40;10&#41;  DEFAULT '' |
| *| <a name='testone.loc_users_nascimento'>nascimento</a>| date  |
| *| <a name='testone.loc_users_celular'>celular</a>| varchar&#40;25&#41;  DEFAULT '' |
| *| <a name='testone.loc_users_idioma'>idioma</a>| varchar&#40;15&#41;  DEFAULT '' |
| *| <a name='testone.loc_users_ativo'>ativo</a>| smallint  |
| Indexes |
| 🔑 | pk&#95;loc&#95;users || ON loc&#95;users&#95;id|
| 🔍  | login&#95;unique || ON login|


### Table login 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.login_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.login_email'>email</a>| varchar&#40;50&#41;  DEFAULT '' |
| *| <a name='testone.login_login'>login</a>| varchar&#40;10&#41;  DEFAULT '' |
| *| <a name='testone.login_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.login_password'>password</a>| varchar&#40;10&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;login || ON id|


### Table manufacturer 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.manufacturer_id'>id</a>| bigint  DEFAULT 0 |
|  | <a name='testone.manufacturer_nome'>nome</a>| varchar&#40;30&#41;  |
| Indexes |
| 🔑 | pk&#95;manufacturer || ON id|


### Table model 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.model_id'>id</a>| bigint  DEFAULT 0 |
|  | <a name='testone.model_model'>model</a>| varchar&#40;30&#41;  |
|  | <a name='testone.model_version'>version</a>| varchar&#40;60&#41;  |
|  | <a name='testone.model_accessories'>accessories</a>| varchar&#40;100&#41;  |
| 🔎 | <a name='testone.model_manufacturer_fk'>manufacturer&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;model || ON id|
| 🔎  | model&#95;manufacturer&#95;fk || ON manufacturer&#95;fk|


### Table mp3_posts 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔍 | <a name='testone.mp3_posts_id'>id</a>| bigint UNSIGNED AUTO_INCREMENT |
| *| <a name='testone.mp3_posts_subject'>subject</a>| varchar&#40;255&#41;  DEFAULT '' |
| *| <a name='testone.mp3_posts_from_'>from&#95;</a>| varchar&#40;255&#41;  DEFAULT '' |
| *| <a name='testone.mp3_posts_date_'>date&#95;</a>| varchar&#40;30&#41;  DEFAULT '' |
| *| <a name='testone.mp3_posts_link'>link</a>| varchar&#40;1000&#41;  DEFAULT '' |
| Indexes |
| 🔍  | id || ON id|


### Table niveis 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.niveis_COD_NIVEL'>COD&#95;NIVEL</a>| int AUTO_INCREMENT |
| *| <a name='testone.niveis_DESCRICAO'>DESCRICAO</a>| varchar&#40;60&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;niveis || ON COD&#95;NIVEL|


### Table nulltest 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.nulltest_id'>id</a>| int  DEFAULT 0 |
|  | <a name='testone.nulltest_nome'>nome</a>| varchar&#40;50&#41;  |
|  | <a name='testone.nulltest_fk_matricula'>fk&#95;matricula</a>| int  |
|  | <a name='testone.nulltest_desconto'>desconto</a>| float&#40;4&#44;2&#41;  |
| Indexes |
| 🔑 | pk&#95;nulltest || ON id|


### Table openjpa_sequence_table 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.openjpa_sequence_table_ID'>ID</a>| tinyint  |
|  | <a name='testone.openjpa_sequence_table_SEQUENCE_VALUE'>SEQUENCE&#95;VALUE</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;openjpa&#95;sequence&#95;table || ON ID|


### Table ownership_types 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.ownership_types_ownership_types_id'>ownership&#95;types&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.ownership_types_name'>name</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;ownership&#95;types || ON ownership&#95;types&#95;id|


### Table pedidos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.pedidos_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.pedidos_tipo'>tipo</a>| bigint  |
|  | <a name='testone.pedidos_data_pedido'>data&#95;pedido</a>| date  |
|  | <a name='testone.pedidos_data_expedicao'>data&#95;expedicao</a>| date  |
|  | <a name='testone.pedidos_data_remessa'>data&#95;remessa</a>| date  |
| *🔎 ⬈ | <a name='testone.pedidos_usuario_fk'>usuario&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.pedidos_vendedor_fk'>vendedor&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.pedidos_pedidos_detalhes_fk'>pedidos&#95;detalhes&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;pedidos || ON id|
| 🔎  | pedidos&#95;detalhes&#95;fk || ON pedidos&#95;detalhes&#95;fk|
| 🔎  | pedidos&#95;usuario&#95;fk || ON usuario&#95;fk|
| 🔎  | pedidos&#95;vendedor&#95;fk || ON vendedor&#95;fk|
| Foreign Keys |
|  | pedidos_detalhes_fk | ( pedidos&#95;detalhes&#95;fk ) ref [testone&#46;pedidos&#95;detalhes](#pedidos&#95;detalhes) (id) |
|  | pedidos_usuario_fk | ( usuario&#95;fk ) ref [testone&#46;usuarios](#usuarios) (id) |
|  | pedidos_vendedor_fk | ( vendedor&#95;fk ) ref [testone&#46;vendedores](#vendedores) (id) |


### Table pedidos_detalhes 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.pedidos_detalhes_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.pedidos_detalhes_resp_expedicao'>resp&#95;expedicao</a>| bigint  |
|  | <a name='testone.pedidos_detalhes_resp_entrega'>resp&#95;entrega</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;pedidos&#95;detalhes || ON id|


### Table pricelist 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.pricelist_id'>id</a>| bigint  DEFAULT 0 |
|  | <a name='testone.pricelist_price'>price</a>| double  |
| 🔎 ⬈ | <a name='testone.pricelist_model_fk'>model&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;pricelist || ON id|
| 🔎  | pricelist&#95;model&#95;fk || ON model&#95;fk|
| Foreign Keys |
|  | pricelist_model_fk | ( model&#95;fk ) ref [testone&#46;model](#model) (id) |


### Table prjrole 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.prjrole_ID'>ID</a>| int  |
| *🔍 | <a name='testone.prjrole_TITLE'>TITLE</a>| varchar&#40;50&#41;  |
| Indexes |
| 🔑 | pk&#95;prjrole || ON ID|
| 🔍  | TITLE || ON TITLE|


### Table products 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.products_id'>id</a>| int AUTO_INCREMENT |
|  | <a name='testone.products_description'>description</a>| varchar&#40;255&#41;  |
|  | <a name='testone.products_price'>price</a>| decimal&#40;15&#44;2&#41;  |
| Indexes |
| 🔑 | pk&#95;products || ON id|


### Table produtos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.produtos_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.produtos_nome'>nome</a>| varchar&#40;40&#41;  |
|  | <a name='testone.produtos_preco'>preco</a>| float&#40;12&#44;0&#41;  |
|  | <a name='testone.produtos_desconto'>desconto</a>| decimal&#40;2&#44;2&#41;  |
|  | <a name='testone.produtos_imagem'>imagem</a>| blob  |
| *🔎 ⬈ | <a name='testone.produtos_categoria_fk'>categoria&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;produtos || ON id|
| 🔎  | produtos&#95;categoria&#95;fk || ON categoria&#95;fk|
| Foreign Keys |
|  | produtos_categoria_fk | ( categoria&#95;fk ) ref [testone&#46;categorias](#categorias) (id) |


### Table project 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.project_ID'>ID</a>| int  |
| *🔍 | <a name='testone.project_TITLE'>TITLE</a>| varchar&#40;50&#41;  |
|  | <a name='testone.project_STARTTIME'>STARTTIME</a>| date  |
| *| <a name='testone.project_ENDTIME'>ENDTIME</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
| Indexes |
| 🔑 | pk&#95;project || ON ID|
| 🔍  | TITLE || ON TITLE|


### Table project_developer 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.project_developer_idprj'>idprj</a>| int  |
| *🔑 | <a name='testone.project_developer_idprole'>idprole</a>| int  |
| *🔑 | <a name='testone.project_developer_iddev'>iddev</a>| int  |
| *🔎 | <a name='testone.project_developer_IDSTATUS'>IDSTATUS</a>| int  |
| *| <a name='testone.project_developer_starttime'>starttime</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
|  | <a name='testone.project_developer_endtime'>endtime</a>| date  |
| Indexes |
| 🔑 | pk&#95;project&#95;developer || ON idprj&#44; idprole&#44; iddev|
| 🔎  | fk&#95;project&#95;developer&#95;0 || ON idprole|
| 🔎  | fk&#95;project&#95;developer&#95;1 || ON iddev|
| 🔎  | fk&#95;project&#95;developer&#95;2 || ON IDSTATUS|
| 🔎  | idx&#95;project&#95;developer || ON idprj|


### Table pupils 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.pupils_pupils_id'>pupils&#95;id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.pupils_gen_persons_id'>gen&#95;persons&#95;id</a>| bigint  |
| *| <a name='testone.pupils_registration'>registration</a>| varchar&#40;20&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;pupils || ON pupils&#95;id|
| 🔎  | courses&#95;person&#95;fk || ON gen&#95;persons&#95;id|
| Foreign Keys |
|  | courses_person_fk | ( gen&#95;persons&#95;id ) ref [testone&#46;gen&#95;persons](#gen&#95;persons) (gen&#95;persons&#95;id) |


### Table request 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.request_id'>id</a>| bigint  DEFAULT 0 |
| *| <a name='testone.request_quantity'>quantity</a>| int  |
| *🔎 ⬈ | <a name='testone.request_login_fk'>login&#95;fk</a>| bigint  |
| *🔎 ⬈ | <a name='testone.request_pricelist_fk'>pricelist&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;request || ON id|
| 🔎  | request&#95;login&#95;fk || ON login&#95;fk|
| 🔎  | request&#95;pricelist&#95;fk || ON pricelist&#95;fk|
| Foreign Keys |
|  | request_login_fk | ( login&#95;fk ) ref [testone&#46;login](#login) (id) |
|  | request_pricelist_fk | ( pricelist&#95;fk ) ref [testone&#46;pricelist](#pricelist) (id) |


### Table rin199_simple_property 
| Idx | Field Name | Data Type | Description |
|---|---|---|---|
| *🔑 | <a name='testone.rin199_simple_property_id'>id</a>| varchar&#40;100&#41;  DEFAULT '' |  |
|  | <a name='testone.rin199_simple_property_val'>val</a>| varchar&#40;100&#41;  | key&#96;s value |
| Indexes |
| 🔑 | pk&#95;rin199&#95;simple&#95;property || ON id |  |


### Table rin220_role 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.rin220_role_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.rin220_role_name'>name</a>| varchar&#40;32&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;rin220&#95;role || ON id|


### Table rin220_usr 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.rin220_usr_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.rin220_usr_name'>name</a>| varchar&#40;32&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;rin220&#95;usr || ON id|


### Table signup 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.signup_id'>id</a>| bigint AUTO_INCREMENT |
| *🔍 | <a name='testone.signup_email'>email</a>| varchar&#40;50&#41;  DEFAULT '' |
| *🔍 | <a name='testone.signup_login'>login</a>| varchar&#40;10&#41;  DEFAULT '' |
| *| <a name='testone.signup_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.signup_password'>password</a>| varchar&#40;15&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;signup || ON id|
| 🔍  | email || ON email|
| 🔍  | login || ON login|


### Table status 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.status_ID'>ID</a>| int  |
| *🔍 | <a name='testone.status_TITLE'>TITLE</a>| varchar&#40;50&#41;  |
| Indexes |
| 🔑 | pk&#95;status || ON ID|
| 🔍  | TITLE || ON TITLE|


### Table sys_dao_short_test 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.sys_dao_short_test_sys_dao_test_id'>sys&#95;dao&#95;test&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.sys_dao_short_test_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;sys&#95;dao&#95;short&#95;test || ON sys&#95;dao&#95;test&#95;id|


### Table sys_dao_test 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.sys_dao_test_sys_dao_test_id'>sys&#95;dao&#95;test&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.sys_dao_test_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test_login'>login</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test_event_timestamp'>event&#95;timestamp</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
| *| <a name='testone.sys_dao_test_event_date'>event&#95;date</a>| date  |
| *| <a name='testone.sys_dao_test_event_time'>event&#95;time</a>| time  |
| *| <a name='testone.sys_dao_test_enabled'>enabled</a>| varchar&#40;1&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;sys&#95;dao&#95;test || ON sys&#95;dao&#95;test&#95;id|


### Table sys_dao_test3 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.sys_dao_test3_sys_dao_test3_id'>sys&#95;dao&#95;test3&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.sys_dao_test3_fullname'>fullname</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_login'>login</a>| varchar&#40;40&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_email'>email</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_passwd'>passwd</a>| varchar&#40;8&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_user_id'>user&#95;id</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_user_doc_type'>user&#95;doc&#95;type</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_birth_date'>birth&#95;date</a>| date  |
| *| <a name='testone.sys_dao_test3_phone'>phone</a>| varchar&#40;12&#41;  DEFAULT '' |
| *| <a name='testone.sys_dao_test3_locale'>locale</a>| varchar&#40;5&#41;  DEFAULT '' |
|  | <a name='testone.sys_dao_test3_enabled'>enabled</a>| varchar&#40;1&#41;  |
|  | <a name='testone.sys_dao_test3_version'>version</a>| bigint  |
|  | <a name='testone.sys_dao_test3_author'>author</a>| varchar&#40;40&#41;  |
|  | <a name='testone.sys_dao_test3_event_timestamp'>event&#95;timestamp</a>| date  |
| Indexes |
| 🔑 | pk&#95;sys&#95;dao&#95;test3 || ON sys&#95;dao&#95;test3&#95;id|


### Table sys_users 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.sys_users_sys_users_id'>sys&#95;users&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.sys_users_fullname'>fullname</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_login'>login</a>| varchar&#40;40&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_email'>email</a>| varchar&#40;200&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_passwd'>passwd</a>| varchar&#40;8&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_user_id'>user&#95;id</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_user_doc_type'>user&#95;doc&#95;type</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_birth_date'>birth&#95;date</a>| date  |
| *| <a name='testone.sys_users_phone'>phone</a>| varchar&#40;12&#41;  DEFAULT '' |
| *| <a name='testone.sys_users_locale'>locale</a>| varchar&#40;5&#41;  DEFAULT '' |
|  | <a name='testone.sys_users_enabled'>enabled</a>| varchar&#40;1&#41;  |
|  | <a name='testone.sys_users_version'>version</a>| bigint  |
|  | <a name='testone.sys_users_author'>author</a>| varchar&#40;40&#41;  |
|  | <a name='testone.sys_users_event_timestamp'>event&#95;timestamp</a>| date  |
| Indexes |
| 🔑 | pk&#95;sys&#95;users || ON sys&#95;users&#95;id|


### Table sys_versioning 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.sys_versioning_sys_versioning_id'>sys&#95;versioning&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.sys_versioning_version'>version</a>| bigint  |
| *| <a name='testone.sys_versioning_event_timestamp'>event&#95;timestamp</a>| date  |
|  | <a name='testone.sys_versioning_author'>author</a>| varchar&#40;40&#41;  |
| Indexes |
| 🔑 | pk&#95;sys&#95;versioning || ON sys&#95;versioning&#95;id|


### Table tb_multa 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.tb_multa_ID_MULTA'>ID&#95;MULTA</a>| int AUTO_INCREMENT |
|  | <a name='testone.tb_multa_VL_MULTA'>VL&#95;MULTA</a>| double  |
|  | <a name='testone.tb_multa_DE_MOTIVO'>DE&#95;MOTIVO</a>| varchar&#40;255&#41;  |
|  | <a name='testone.tb_multa_DE_STATUS'>DE&#95;STATUS</a>| varchar&#40;18&#41;  |
|  | <a name='testone.tb_multa_DH_MULTA'>DH&#95;MULTA</a>| date  |
| 🔎 ⬈ | <a name='testone.tb_multa_ID_VEICULO'>ID&#95;VEICULO</a>| int  |
| Indexes |
| 🔑 | pk&#95;tb&#95;multa || ON ID&#95;MULTA|
| 🔎  | TB&#95;MULTA&#95;VEICULO&#95;FK || ON ID&#95;VEICULO|
| Foreign Keys |
|  | TB_MULTA_VEICULO_FK | ( ID&#95;VEICULO ) ref [testone&#46;tb&#95;veiculo](#tb&#95;veiculo) (ID&#95;VEICULO) |


### Table tb_uf 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.tb_uf_SG_UF'>SG&#95;UF</a>| int AUTO_INCREMENT |
|  | <a name='testone.tb_uf_NM_UF'>NM&#95;UF</a>| varchar&#40;2&#41;  |
| Indexes |
| 🔑 | pk&#95;tb&#95;uf || ON SG&#95;UF|


### Table tb_veiculo 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.tb_veiculo_ID_VEICULO'>ID&#95;VEICULO</a>| int AUTO_INCREMENT |
|  | <a name='testone.tb_veiculo_NR_PLACA'>NR&#95;PLACA</a>| varchar&#40;8&#41;  |
|  | <a name='testone.tb_veiculo_NR_RENAVAM'>NR&#95;RENAVAM</a>| varchar&#40;9&#41;  |
|  | <a name='testone.tb_veiculo_CD_CHASSIS'>CD&#95;CHASSIS</a>| varchar&#40;18&#41;  |
|  | <a name='testone.tb_veiculo_NR_ANO_MODELO'>NR&#95;ANO&#95;MODELO</a>| int  |
|  | <a name='testone.tb_veiculo_NR_ANO_FABRICACAO'>NR&#95;ANO&#95;FABRICACAO</a>| int  |
| 🔎 ⬈ | <a name='testone.tb_veiculo_SG_UF'>SG&#95;UF</a>| int  |
| Indexes |
| 🔑 | pk&#95;tb&#95;veiculo || ON ID&#95;VEICULO|
| 🔎  | TB&#95;VEICULO&#95;UF&#95;FK || ON SG&#95;UF|
| Foreign Keys |
|  | TB_VEICULO_UF_FK | ( SG&#95;UF ) ref [testone&#46;tb&#95;uf](#tb&#95;uf) (SG&#95;UF) |


### Table teams 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.teams_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.teams_name'>name</a>| varchar&#40;40&#41;  DEFAULT '' |
| *| <a name='testone.teams_rating'>rating</a>| int  |
| Indexes |
| 🔑 | pk&#95;teams || ON id|


### Table test 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_name'>name</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test || ON id|


### Table test_alphanum 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_alphanum_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_alphanum_alphanum'>alphanum</a>| varchar&#40;8&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;alphanum || ON id|


### Table test_author 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_author_author_id'>author&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_author_name'>name</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;author || ON author&#95;id|


### Table test_authors 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.test_authors_author_id'>author&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_authors_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;authors || ON author&#95;id|


### Table test_authors2 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_authors2_author_id'>author&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_authors2_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;authors2 || ON author&#95;id|


### Table test_binary 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_binary_binary_id'>binary&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_binary_image'>image</a>| tinyblob  |
| *| <a name='testone.test_binary_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;binary || ON binary&#95;id|


### Table test_books 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_books_book_id'>book&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_books_title'>title</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.test_books_fk_author_id'>fk&#95;author&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;test&#95;books || ON book&#95;id|
| 🔎  | idx&#95;test&#95;books || ON fk&#95;author&#95;id|
| Foreign Keys |
|  | fk_test_books | ( fk&#95;author&#95;id ) ref [testone&#46;test&#95;authors](#test&#95;authors) (author&#95;id) |


### Table test_books2 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_books2_book_id'>book&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_books2_title'>title</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;books2 || ON book&#95;id|


### Table test_car 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_car_test_car_id'>test&#95;car&#95;id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_car_name'>name</a>| varchar&#40;50&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;car || ON test&#95;car&#95;id|


### Table test_customer 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.test_customer_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_customer_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;test&#95;customer || ON id|


### Table test_customer_details 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_customer_details_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_customer_details_address'>address</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.test_customer_details_fk_customer_id'>fk&#95;customer&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;test&#95;customer&#95;details || ON id|
| 🔎  | idx&#95;test&#95;customer&#95;details || ON fk&#95;customer&#95;id|
| Foreign Keys |
|  | fk_test_customer_details | ( fk&#95;customer&#95;id ) ref [testone&#46;test&#95;customer](#test&#95;customer) (id) |


### Table test_idgenseq 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_idgenseq_id'>id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;test&#95;idgenseq || ON id|


### Table test_idgenseq2 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_idgenseq2_id'>id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;test&#95;idgenseq2 || ON id|


### Table test_idtablegen 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_idtablegen_id'>id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;test&#95;idtablegen || ON id|


### Table test_inhe1_bankaccount 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1_bankaccount_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1_bankaccount_owner'>owner</a>| varchar&#40;100&#41;  |
|  | <a name='testone.test_inhe1_bankaccount_accountnumber'>accountnumber</a>| int  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1&#95;bankaccount || ON billingdetails&#95;id|


### Table test_inhe1_creditcard 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1_creditcard_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1_creditcard_owner'>owner</a>| varchar&#40;100&#41;  |
|  | <a name='testone.test_inhe1_creditcard_cardnumber'>cardnumber</a>| int  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1&#95;creditcard || ON billingdetails&#95;id|


### Table test_inhe1b_bankaccount 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1b_bankaccount_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1b_bankaccount_accountnumber'>accountnumber</a>| int  |
|  | <a name='testone.test_inhe1b_bankaccount_owner'>owner</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1b&#95;bankaccount || ON billingdetails&#95;id|


### Table test_inhe1b_creditcard 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1b_creditcard_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1b_creditcard_cardnumber'>cardnumber</a>| int  |
|  | <a name='testone.test_inhe1b_creditcard_owner'>owner</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1b&#95;creditcard || ON billingdetails&#95;id|


### Table test_inhe1c_bankaccount 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1c_bankaccount_bankaccount_id'>bankaccount&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1c_bankaccount_accountnumber'>accountnumber</a>| int  |
|  | <a name='testone.test_inhe1c_bankaccount_bankaccount_owner'>bankaccount&#95;owner</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1c&#95;bankaccount || ON bankaccount&#95;id|


### Table test_inhe1c_creditcard 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe1c_creditcard_credicard_id'>credicard&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe1c_creditcard_cardnumber'>cardnumber</a>| int  |
|  | <a name='testone.test_inhe1c_creditcard_credicard_owner'>credicard&#95;owner</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe1c&#95;creditcard || ON credicard&#95;id|


### Table test_inhe2_billingdetails 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_inhe2_billingdetails_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe2_billingdetails_billingdetails_type'>billingdetails&#95;type</a>| varchar&#40;1&#41;  |
|  | <a name='testone.test_inhe2_billingdetails_owner'>owner</a>| varchar&#40;100&#41;  |
|  | <a name='testone.test_inhe2_billingdetails_accountnumber'>accountnumber</a>| int  |
|  | <a name='testone.test_inhe2_billingdetails_cardnumber'>cardnumber</a>| int  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe2&#95;billingdetails || ON billingdetails&#95;id|


### Table test_inhe3_bankaccount 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬈ | <a name='testone.test_inhe3_bankaccount_bankaccount_id'>bankaccount&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe3_bankaccount_accountnumber'>accountnumber</a>| int  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe3&#95;bankaccount || ON bankaccount&#95;id|
| Foreign Keys |
|  | fk_bankaccount_id | ( bankaccount&#95;id ) ref [testone&#46;test&#95;inhe3&#95;billingdetails](#test&#95;inhe3&#95;billingdetails) (billingdetails&#95;id) |


### Table test_inhe3_billingdetails 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.test_inhe3_billingdetails_billingdetails_id'>billingdetails&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe3_billingdetails_owner'>owner</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe3&#95;billingdetails || ON billingdetails&#95;id|


### Table test_inhe3_creditcard 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬈ | <a name='testone.test_inhe3_creditcard_creditcard_id'>creditcard&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_inhe3_creditcard_cardnumber'>cardnumber</a>| int  |
| Indexes |
| 🔑 | pk&#95;test&#95;inhe3&#95;creditcard || ON creditcard&#95;id|
| Foreign Keys |
|  | fk_creditcard_id | ( creditcard&#95;id ) ref [testone&#46;test&#95;inhe3&#95;billingdetails](#test&#95;inhe3&#95;billingdetails) (billingdetails&#95;id) |


### Table test_mouth 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.test_mouth_mouth_id'>mouth&#95;id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;test&#95;mouth || ON mouth&#95;id|


### Table test_order 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_order_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.test_order_number'>number</a>| int  |
| *🔎 ⬈ | <a name='testone.test_order_fk_customer_id'>fk&#95;customer&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;test&#95;order || ON id|
| 🔎  | idx&#95;test&#95;order || ON fk&#95;customer&#95;id|
| Foreign Keys |
|  | fk_test_order | ( fk&#95;customer&#95;id ) ref [testone&#46;test&#95;customer](#test&#95;customer) (id) |


### Table test_person 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_person_id'>id</a>| int  |
|  | <a name='testone.test_person_name'>name</a>| varchar&#40;100&#41;  |
|  | <a name='testone.test_person_country'>country</a>| varchar&#40;50&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;person || ON id|


### Table test_sample 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_sample_id'>id</a>| bigint AUTO_INCREMENT |
| Indexes |
| 🔑 | pk&#95;test&#95;sample || ON id|


### Table test_tooth 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_tooth_tooth_id'>tooth&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_tooth_tooth_name'>tooth&#95;name</a>| varchar&#40;100&#41;  |
| *🔎 ⬈ | <a name='testone.test_tooth_fk_mouth_id'>fk&#95;mouth&#95;id</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;test&#95;tooth || ON tooth&#95;id|
| 🔎  | idx&#95;test&#95;tooth || ON fk&#95;mouth&#95;id|
| Foreign Keys |
|  | fk_test_tooth | ( fk&#95;mouth&#95;id ) ref [testone&#46;test&#95;mouth](#test&#95;mouth) (mouth&#95;id) |


### Table test_types 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.test_types_types_id'>types&#95;id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.test_types_types_date'>types&#95;date</a>| date  |
|  | <a name='testone.test_types_types_time'>types&#95;time</a>| time  |
| *| <a name='testone.test_types_types_timestamp'>types&#95;timestamp</a>| timestamp  DEFAULT CURRENT_TIMESTAMP |
|  | <a name='testone.test_types_description'>description</a>| varchar&#40;50&#41;  |
| Indexes |
| 🔑 | pk&#95;test&#95;types || ON types&#95;id|


### Table titulos 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.titulos_COD_TITULO'>COD&#95;TITULO</a>| int AUTO_INCREMENT |
| *| <a name='testone.titulos_TITULO'>TITULO</a>| varchar&#40;30&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;titulos || ON COD&#95;TITULO|


### Table universities 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.universities_universities_id'>universities&#95;id</a>| bigint AUTO_INCREMENT |
| *🔎 ⬈ | <a name='testone.universities_geo_cities_br_id'>geo&#95;cities&#95;br&#95;id</a>| bigint  |
| *| <a name='testone.universities_acronym'>acronym</a>| varchar&#40;6&#41;  DEFAULT '' |
| *| <a name='testone.universities_name'>name</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;universities || ON universities&#95;id|
| 🔎  | universities&#95;city&#95;br&#95;fk || ON geo&#95;cities&#95;br&#95;id|
| Foreign Keys |
|  | universities_city_br_fk | ( geo&#95;cities&#95;br&#95;id ) ref [testone&#46;geo&#95;cities&#95;br](#geo&#95;cities&#95;br) (geo&#95;cities&#95;br&#95;id) |


### Table users 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.users_id'>id</a>| bigint UNSIGNED AUTO_INCREMENT |
| *🔍 | <a name='testone.users_login'>login</a>| varchar&#40;64&#41;  DEFAULT '' |
| *| <a name='testone.users_password'>password</a>| varchar&#40;32&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;users || ON id|
| 🔍  | users&#95;login&#95;key || ON login|


### Table usuario 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.usuario_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.usuario_version'>version</a>| bigint  |
| *| <a name='testone.usuario_login'>login</a>| varchar&#40;255&#41;  |
| *| <a name='testone.usuario_nome'>nome</a>| varchar&#40;255&#41;  |
| *| <a name='testone.usuario_senha'>senha</a>| varchar&#40;255&#41;  |
| Indexes |
| 🔑 | pk&#95;usuario || ON id|


### Table usuarios 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.usuarios_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.usuarios_nome'>nome</a>| varchar&#40;50&#41;  |
|  | <a name='testone.usuarios_email'>email</a>| varchar&#40;100&#41;  |
|  | <a name='testone.usuarios_senha'>senha</a>| varchar&#40;20&#41;  |
|  | <a name='testone.usuarios_endereco'>endereco</a>| varchar&#40;200&#41;  |
|  | <a name='testone.usuarios_bairro'>bairro</a>| varchar&#40;100&#41;  |
|  | <a name='testone.usuarios_cidade'>cidade</a>| varchar&#40;100&#41;  |
|  | <a name='testone.usuarios_estado'>estado</a>| varchar&#40;50&#41;  |
|  | <a name='testone.usuarios_cep'>cep</a>| varchar&#40;9&#41;  |
| 🔎 ⬈ | <a name='testone.usuarios_end_entrega_fk'>end&#95;entrega&#95;fk</a>| bigint  |
| Indexes |
| 🔑 | pk&#95;usuarios || ON id|
| 🔎  | usuarios&#95;end&#95;entrega&#95;fk || ON end&#95;entrega&#95;fk|
| Foreign Keys |
|  | usuarios_end_entrega_fk | ( end&#95;entrega&#95;fk ) ref [testone&#46;end&#95;entrega](#end&#95;entrega) (id) |


### Table vendedores 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.vendedores_id'>id</a>| bigint AUTO_INCREMENT |
|  | <a name='testone.vendedores_nome'>nome</a>| varchar&#40;50&#41;  |
|  | <a name='testone.vendedores_email'>email</a>| varchar&#40;100&#41;  |
|  | <a name='testone.vendedores_senha'>senha</a>| varchar&#40;20&#41;  |
|  | <a name='testone.vendedores_endereco'>endereco</a>| varchar&#40;200&#41;  |
|  | <a name='testone.vendedores_bairro'>bairro</a>| varchar&#40;100&#41;  |
|  | <a name='testone.vendedores_cidade'>cidade</a>| varchar&#40;100&#41;  |
|  | <a name='testone.vendedores_estado'>estado</a>| varchar&#40;50&#41;  |
|  | <a name='testone.vendedores_cep'>cep</a>| varchar&#40;9&#41;  |
| Indexes |
| 🔑 | pk&#95;vendedores || ON id|


### Table widget 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.widget_id'>id</a>| bigint AUTO_INCREMENT |
| *| <a name='testone.widget_partNumber'>partNumber</a>| varchar&#40;100&#41;  |
| *| <a name='testone.widget_name'>name</a>| varchar&#40;100&#41;  |
| *| <a name='testone.widget_description'>description</a>| varchar&#40;100&#41;  |
| Indexes |
| 🔑 | pk&#95;widget || ON id|


### Table wth_atmosphere 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.wth_atmosphere_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.wth_atmosphere_humidity'>humidity</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_atmosphere_visibility'>visibility</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_atmosphere_pressure'>pressure</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_atmosphere_rising'>rising</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.wth_atmosphere_weather_fk'>weather&#95;fk</a>| int  |
| Indexes |
| 🔑 | pk&#95;wth&#95;atmosphere || ON id|
| 🔎  | idx&#95;testone&#95;wth&#95;atmosphere&#95;weather || ON weather&#95;fk|
| Foreign Keys |
|  | fk_testone_wth_atmosphere_weather | ( weather&#95;fk ) ref [testone&#46;wth&#95;weather](#wth&#95;weather) (id) |


### Table wth_condition 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 | <a name='testone.wth_condition_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.wth_condition_text'>text</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_condition_code'>code</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_condition_temp'>temp</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_condition_date'>date</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.wth_condition_weather_fk'>weather&#95;fk</a>| int  |
| Indexes |
| 🔑 | pk&#95;wth&#95;condition || ON id|
| 🔎  | idx&#95;testone&#95;wth&#95;condition&#95;weather || ON weather&#95;fk|
| Foreign Keys |
|  | fk_testone_wth_condition_weather | ( weather&#95;fk ) ref [testone&#46;wth&#95;weather](#wth&#95;weather) (id) |


### Table wth_location 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.wth_location_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.wth_location_zip'>zip</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_location_city'>city</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_location_region'>region</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_location_country'>country</a>| varchar&#40;100&#41;  DEFAULT '' |
| Indexes |
| 🔑 | pk&#95;wth&#95;location || ON id|


### Table wth_weather 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.wth_weather_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.wth_weather_date'>date</a>| date  |
| *🔎 ⬈ | <a name='testone.wth_weather_wind_fk'>wind&#95;fk</a>| int  |
| *🔎 ⬈ | <a name='testone.wth_weather_atmosphere_fk'>atmosphere&#95;fk</a>| int  |
| *🔎 ⬈ | <a name='testone.wth_weather_location_fk'>location&#95;fk</a>| int  |
| *🔎 | <a name='testone.wth_weather_condition_fk'>condition&#95;fk</a>| int  |
| Indexes |
| 🔑 | pk&#95;wth&#95;weather || ON id|
| 🔎  | idx&#95;testone&#95;wth&#95;weather&#95;atmosphere || ON atmosphere&#95;fk|
| 🔎  | idx&#95;testone&#95;wth&#95;weather&#95;condition || ON condition&#95;fk|
| 🔎  | idx&#95;testone&#95;wth&#95;weather&#95;location || ON location&#95;fk|
| 🔎  | idx&#95;testone&#95;wth&#95;weather&#95;wind || ON wind&#95;fk|
| Foreign Keys |
|  | fk_testone_wth_weather_atmosphere | ( atmosphere&#95;fk ) ref [testone&#46;wth&#95;atmosphere](#wth&#95;atmosphere) (id) |
|  | fk_testone_wth_weather_location | ( location&#95;fk ) ref [testone&#46;wth&#95;location](#wth&#95;location) (id) |
|  | fk_testone_wth_weather_wind | ( wind&#95;fk ) ref [testone&#46;wth&#95;wind](#wth&#95;wind) (id) |


### Table wth_wind 
| Idx | Field Name | Data Type |
|---|---|---|
| *🔑 ⬋ | <a name='testone.wth_wind_id'>id</a>| int AUTO_INCREMENT |
| *| <a name='testone.wth_wind_chill'>chill</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_wind_direction'>direction</a>| varchar&#40;100&#41;  DEFAULT '' |
| *| <a name='testone.wth_wind_speed'>speed</a>| varchar&#40;100&#41;  DEFAULT '' |
| *🔎 ⬈ | <a name='testone.wth_wind_weather_fk'>weather&#95;fk</a>| int  |
| Indexes |
| 🔑 | pk&#95;wth&#95;wind || ON id|
| 🔎  | idx&#95;testone&#95;wth&#95;wind&#95;weather || ON weather&#95;fk|
| Foreign Keys |
|  | fk_testone_wth_wind_weather | ( weather&#95;fk ) ref [testone&#46;wth&#95;weather](#wth&#95;weather) (id) |



