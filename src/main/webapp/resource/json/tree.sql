create table resource (
	id smallint primary key ,
	name varchar(64) not null,
	url varchar(100),
	description varchar(255),
	icon varchar(32),
	pid int,
	seq tinyint not null default 0,
	state tinyint not null default 0,
	resourcetype tinyint not null default 0,
	createdatetime datetime not null default getdate()
    )
    insert into resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(1,'部门管理','','部门管理','icon_resource',null,7,0,0,'2015-06-16 01:00:00');
insert into resource(id,name,url,description,icon,pid,seq,state,resourcetype,createdatetime) values(11,'添加部门','dept/addDept.jsp','添加部门','icon_folder',1,0,0,1,'2015-06-16 01:00:00');