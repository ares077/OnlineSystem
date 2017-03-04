
create database xiangli character set utf8 collate utf8_general_ci;
use xiangli;
create table studentinfo(
studentid varchar(11) primary key,
studentpw varchar(20) not null,
name varchar(20) ,
sex varchar(2) ,
idnumber varchar(18) ,
phonum varchar(11) ,
email varchar(50) ,
department varchar(20) ,
major varchar(20),
classinfo varchar(6) ,
notice varchar(50) ,
answer varchar(50) ,
states int(1) default 1
);
alter table studentinfo engine=innodb;
create table admin(
adminid varchar(20) primary key,
adminpw varchar(20) not null
);
alter table admin engine=innodb;
create table course (
courseid varchar(10) primary key,
coursename varchar(20),
states int(1) default 1
);
alter table course engine=innodb;
create table paper(
paperid varchar(10) primary key,
courseid varchar(10),
papername varchar(20),
states int(1) default 1
);
alter table paper engine=innodb;
alter table paper add constraint paper_courseid_fk foreign key (courseid) references course(courseid) on delete cascade on update cascade; 
create table note(
noteid varchar(20) primary key,
studentid varchar(11),
courseid varchar(10),
singlecho int(4),
multicho int(4),
total int(4),
cuoti varchar(100),
nandu varchar(20),
adddate date not null,
states int(1) default 1
);
alter table note engine=innodb;
alter table note add constraint note_studentid_fk foreign key (studentid) references studentinfo(studentid)on delete cascade on update cascade;
alter table note add constraint note_courseid_fk foreign key (courseid) references course(courseid)on delete cascade on update cascade;
create table question(
questionid int(64) auto_increment primary key,
description varchar(999),
type varchar(6),
level varchar(2),
a varchar(200),
b varchar(200),
c varchar(200),
d varchar(200),
e varchar(200),
f varchar(200),
answer varchar(10),
paperid varchar(10),
remark varchar(200),
adddate date,
states int(1) default 1
);
alter table question engine=innodb;
create table department(
dname varchar(50) primary key,
states int(1) default 1
);
alter table department engine=innodb;
create table major(
mname varchar(50) primary key,
dname varchar(50),
states int(1) default 1
);
alter table major engine=innodb;
alter table major add constraint major_dname_fk foreign key (dname) references department(dname) on delete cascade on update cascade;

insert into department(dname) values('计算机学院');
insert into department(dname) values('战争学院');
insert into department(dname) values('文学院');
insert into department(dname) values('艺术系');
insert into department(dname) values('问题少年院');
insert into major(mname,dname) values('信息管理系统','计算机学院');
insert into major(mname,dname) values('计算机科学','计算机学院');
insert into major(mname,dname) values('上单','战争学院');
insert into major(mname,dname) values('中单','战争学院');
insert into major(mname,dname) values('打野','战争学院');
insert into major(mname,dname) values('ADC','战争学院');
insert into major(mname,dname) values('辅助','战争学院');
insert into major(mname,dname) values('法语','文学院');
insert into major(mname,dname) values('德语','文学院');
insert into major(mname,dname) values('日语','文学院');
insert into major(mname,dname) values('英语','文学院');
insert into major(mname,dname) values('中文','文学院');
insert into major(mname,dname) values('文静小女生','艺术系');
insert into major(mname,dname) values('气质绿茶表','艺术系');
insert into major(mname,dname) values('天才','问题少年院');
insert into major(mname,dname) values('2B','问题少年院');
insert into major(mname,dname) values('无脑','问题少年院');

insert into studentinfo values('20114070401','123456','定同坏','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070402','123456','过礼物','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070403','123456','里草','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070404','123456','七爷','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070405','123456','栏动','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070406','123456','安家','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070407','123456','汉长','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo values('20114070408','123456','测试','男','410203122544583256',12035266856,'dth@163.com','计算机学院','信息管理系统',110704,'who i am?','同怀啊',1);
insert into studentinfo(studentid,studentpw,name) values('xiaojin','xiangli','丹鹤');
insert into studentinfo(studentid,studentpw,name) values('xiuxiu','xiangli','秀秀');
insert into studentinfo(studentid,studentpw,name) values('20114070409','123456','测试9');
insert into studentinfo(studentid,studentpw,name) values('20114070410','123456','测试10');
insert into studentinfo(studentid,studentpw,name) values('20114070411','123456','测试11');
insert into studentinfo(studentid,studentpw,name) values('20114070412','123456','测试12');
insert into studentinfo(studentid,studentpw,name) values('20114070413','123456','测试13');
insert into studentinfo(studentid,studentpw,name) values('20114070414','123456','测试14');
insert into studentinfo(studentid,studentpw,name) values('20114070415','123456','测试15');
insert into studentinfo(studentid,studentpw,name) values('20114070416','123456','测试16');
insert into studentinfo(studentid,studentpw,name) values('20114070417','123456','测试17');
insert into studentinfo(studentid,studentpw,name) values('20114070418','123456','测试18');
insert into studentinfo(studentid,studentpw,name) values('20114070419','123456','测试19');
insert into studentinfo(studentid,studentpw,name) values('20114070420','123456','测试20');
insert into studentinfo(studentid,studentpw,name) values('20114070421','123456','测试21');
insert into admin values('sherry','xiangli');
insert into admin values('xiaojin','xiangli');
insert into course values('French01','French基础',1);
insert into course values('Java01','Java基础',1);
insert into course values('English01','English基础',1);
insert into paper values('Java01A','Java01','2014Java基础测试A',1);
insert into paper values('Java01B','Java01','OCJP变态题集',1);
insert into paper values('English01A','English01','2014英语基础测试A',1);
insert into paper values('English01B','English01','2014英语基础测试B',1);
insert into paper values('French01A','French01','2014法语基础测试A',1);
insert into paper values('French01B','French01','2014法语基础测试B',1);
insert into paper values('French01C','French01','2014法语基础测试C',1);
insert into paper values('French01D','French01','2014法语基础测试D',1);
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040420140803','20114070404','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040420140804','20114070404','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040420140805','20114070404','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040420140806','20114070404','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140803','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140804','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140805','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140806','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140807','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140808','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140809','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140810','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140811','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into note(noteid,studentid,courseid,singlecho,multicho,total,cuoti,nandu,adddate) values('2011407040120140812','20114070401','Java01',20,20,40,'1,2,5','29',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('签约，订阅','单选','A1','abbonner','bataillon','angoisse','audace','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('关于，对于','多选','C2','aborder','appuyer',"à l'égard de",'allouer','par rapport à','articulation',"C,E",'French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('靠近，着手开始做','单选','A1','assumer','afflux','accorder','aborder','','','D','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)values('抽象的','单选','A1','sourd','abstrait','context','contester','','','B','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)values('进入，通向','单选','A1','accéder','consister','admettre','concurrence','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)values('给予','单选','A2','accorder','comptable','afflux','complice','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('增加，增长，扩大','多选','C1','afficher','accro?tre','cro?tre','constater','agir','aisé','B,C','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('迎接，接待','单选','A2','acquérir','accueillir','admettre','contexter','','','B','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('完成，结束','单选','A2','admettre','achèvement','comportement','','','','B','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('获得','单选','A2','acquérir','cadre','cesser','chiffre','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('当前地，目前地','单选','B1','chagrin','chiffre','citadin','actuellement','','','D','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('赞同','单选','B1','cerveau','adhérer','bourgeois','commune','','','B','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('接受','单选','B1','admettre','cibler','chair','certificat','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('影响','多选','C2','afficher','afflux','agir','affecter','influencer','aisé','D,E','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('张贴（布告，广告）','单选','B1','afficher','afficihe','affichir','certes','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('断言，肯定','单选','B2','affimer','affemer','affirmer','affirmir','','','C','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('涌向，汇集','单选','B2','afflux','agir','conscient','collaborer','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('使自由','单选','B2','affranchir','affrancher','affrenchir','affrencher','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('行动，干，做事','单选','C2','agir','réagir','ager','réager','','','A','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('农业的','单选','B2','agrico','agricole','agricol','agrecole','','','B','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('轻易的，富裕','单选','C1','aisé','eisé','aise','aiser','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)    values('食物','单选','C1','allouer','aliment','apercevoir','sapercevoir','','','B','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('国家拨给津贴，款项','单选','C1','alooer','alouer','allouer','aloue','','','C','French01','提示信息暂无',now());   
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('代替办法','单选','C2','alternative','alternatier','alternater','alternata','','','A','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('布置，治理，改进','单选','C2','apercevoir','aménagement','appartenir','affirmer','','','B','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)    values('焦虑，苦恼，恐慌','单选','C2','angoisse','angoise','engoisse','engoisse','','','A','French01','提示信息暂无',now());   
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)    values('瞥见，隐隐看见','单选','C2','apervevoi','sapervevoir','sapervevoi','apervevoir','','','D','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('属于','单选','C1','appartenie','appartinir','appartenir','appertenie','','','C','French01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)     values('领会','单选','C1','appartenie','apprénender','appuyer','agir','','','B','French01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('学徒期','单选','C2','apprentissage','apprentissager','apprantissage','apprantissager','','','A','French01','提示信息暂无',now());
 

 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('封装','单选','A1','encapsulation','capsulation','错误1','错误2','','','A','English01','提示信息暂无',now());   
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('继承','单选','A1','inheritance','错误1','错误2','错误3','','','A','English01','提示信息暂无',now());
insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)   values('多态','单选','A2','polimorphic','polymorphic','polymorphik','polimorphik','','','B','English01','提示信息暂无',now());
 insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)  values('耦合','单选','A1','coupling','错误1','错误2','错误3','','','A','English01','提示信息暂无',now());       
  insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)     values('聚合','单选','A1','cohesion','错误1','错误2','错误3','','','A','English01','提示信息暂无',now());                  
   insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)         values('默认','单选','A1','default','错误1','错误2','错误3','','','A','English01','提示信息暂无',now());      
   
   insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('测试多选1','多选','C1','错误','正确2','正确2','正确2','正确2','错误','B,C,D,E','French01','提示信息暂无',now());
   insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('测试多选2','多选','C1','正确1','正确2','正确3','错误','错误','错误','A,B,C','French01','提示信息暂无',now());
   insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate) values('测试多选3','多选','C2','错误','正确2','正确2','constater','错误','aisé','B,C','French01','提示信息暂无',now());   
 
      insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class ExamA {<br/>public static void main(String[] args) {<br/>new ExamA().go();<br/>}<br/>public void go() {<br/>Runnable r = new Runnable() {<br/>public void run() {<br/>System.out.print("foo");<br/>}<br/>};<br/>Thread t = new Thread(r);<br/>t.start();<br/>t.start();<br/>}<br/>}<br/><br/>What is the result?','单选','A1','Compilation fails.','An exception is thrown at runtime.','The code executes normally and prints "foo".','The code executes normally, but nothing is printed.','','','B','Java01','ExamA_Q5',now());
      
      insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class TestSeven extends Thread {<br/>private static int x;<br/>public synchronized void doThings() {<br/>int current = x;<br/>current++;<br/>x = current;<br/>}<br/>	doThings();<br/>}<br/>}<br/><br/>Which statement is true?' ,'单选' ,'A1' ,'Compilation fails.' ,'An exception is thrown at runtime.' ,'Synchronizing the run() method would make the class thread-safe.' ,'The data in variable "x" are protected from concurrent access problems.','Declaring the doThings() method as static would make the class thread-safe.' ,'Wrapping the statements within doThings() in a synchronized(new Object()) { } block would make the classthread-safe.' ,'E','Java01' ,'ExamBQ55' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class Barn {<br/>public static void main(String[] args) {<br/>new Barn().go("hi", 1);<br/>new Barn().go("hi", "world", 2);<br/>}<br/>public void go(String... y, int x) {<br/>System.out.print(y[y.length - 1] + " ");<br/>}<br/>}<br/><br/>What is the result?' ,'单选','A2','hi hi','hi world','world world','Compilation fails.','An exception is thrown at runtime.' ,'','D','Java01','The method go(String[], int) in the type Barn is not applicable for the arguments (String, int)<br/>The variable argument type String of the method go must be the last parameter',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>11.public class Person {<br/>12.&nbsp;String name = "No name";<br/>13.&nbsp;public Person(String nm) { name = nm; }<br/>14.&nbsp;}<br/>15.&nbsp;class Employee extends Person {<br/>16.&nbsp;String empID = "0000";<br/>17.&nbsp;public Employee(String id) { empID = id; }<br/>18.&nbsp;}<br/>19.&nbsp;class EmployeeTest {<br/>20.&nbsp;public static void main(String[] args){<br/>21.&nbsp;Employee e = new Employee("4321");<br/>22.&nbsp;System.out.println(e.empID);<br/>23.&nbsp;}<br/>24.&nbsp;}<br/><br/>What is the result?' ,'单选','A2','4321','0000','An exception is thrown at runtime.','Compilation fails because of an error in line 17.','' ,'','D','Java01','Implicit super constructor Person() is undefined. Must explicitly invoke another constructor' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>01. public class Rainbow {<br/>02.public enum MyColor {<br/>03.RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);<br/>04.private final int rgb;<br/>05.MyColor(int rgb) { this.rgb = rgb; }<br/>06.public int getRGB() { return rgb; }<br/>07.};<br/>08.public static void main(String[] args) {<br/>09.//insert code here<br/>10.}<br/>11.}<br/><br/>Which code fragment, inserted at line 9, allows the Rainbow class to compile?' ,'单选','B1','MyColor skyColor = BLUE;','MyColor treeColor = MyColor.GREEN;' ,'if(RED.getRGB() < BLUE.getRGB()) { }' ,'Compilation fails due to other error(s) in the code.' ,'MyColor purple = new MyColor(0xff00ff);' ,'MyColor purple = MyColor.BLUE + MyColor.RED;' ,'B','Java01' ,'ExamQ11' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class Mud {<br/>//insert code here<br/>System.out.println("hi");<br/>}<br/>}<br/><br/>And the following five fragments:<br/><br/>public static void main(String...a){<br/>public static void main(String.* a){<br/>public static void main(String... a){<br/>public static void main(String[]... a){<br/>public static void main(String...[] a){<br/><br/>How many of the code fragments, inserted independently at line 2, compile?' ,'单选' ,'B2' ,'0','1' ,'2','3','4','5','D','Java01' ,'1 3 4',now());
   
     insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Which Man class properly represents the relationship "Man has a best friend who is a Dog"?' ,'单选','B1' ,'class Man extends Dog{}','class Man implements Dog{}' ,'class Man {private BestFriend dog}' ,'class Man {private Dog bestFriend}' ,'class Man {private Dog<bestFriend>}' ,'class Man {private BestFriend<dog>}' ,'D','Java01','ExamAQ18',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>01. public class LineUp {<br/>02.public static void main(String[] args) {<br/>03.double d = 12.345;<br/>04.// insert code here<br/>05.}<br/>06. }<br/><br/>Which code fragment, inserted at line 4, produces the output | 12.345|?','单选','B1','System.out.printf("|%7d| \n", d);','System.out.printf("|%7f| \n", d);','System.out.printf("|%3.7d| \n", d);' ,'System.out.printf("|%3.7f| \n", d);','System.out.printf("|%7.3d| \n", d);' ,'System.out.printf("|%7.3f| \n", d);','F' ,'Java01','ExamAQ37' ,now());
   
     insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>01. public class Boxer1{<br/>02.Integer i;<br/>03.int x;<br/>04.public Boxer1(int y) {<br/>05.x = i+y;<br/>06.System.out.println(x);<br/>07.}<br/>08.public static void main(String[] args) {<br/>09.new Boxer1(new Integer(4));<br/>10.}<br/>11.}<br/><br/>What is the result?','单选','C1','The value "4" is printed at the command line.','Compilation fails because of an error in line 5.','Compilation fails because of an error in line 9.' ,'A NullPointerException occurs at runtime.','A NumberFormatException occurs at runtime.' ,'An IllegalStateException occurs at runtime.','D','Java01' ,'ExamAQ47' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('A UNIX user named Bob wants to replace his chess program with a new one, but he is not sure where the old one is installed.<br/>Bob is currently able to run a Java chess program starting from his home directory /home/bob using the command:<br/>java -classpath /test:/home/bob/downloads/*.jar games.Chess<br/>Bob‘s CLASSPATH is set (at login time) to:<br/>/usr/lib:/home/bob/classes:/opt/java/lib:/opt/java/lib/*.jar<br/><br/>What is a possible location for the Chess.class file?' ,'单选','C2' ,'/test/Chess.class','/home/bob/Chess.class' ,'/test/games/Chess.class','/usr/lib/games/Chess.class','inside jarfile /opt/java/lib/Games.jar (with a correct manifest)','inside jarfile /home/bob/downloads/Games.jar (with a correct manifest)','C','Java01','ExamAQ53' ,now());
   
      insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Which statement is true?'  ,'单选' ,'C1'  ,'A class‘s finalize() method CANNOT be invoked explicitly.' ,'super.finalize() is called implicitly by any overriding finalize() method.','The finalize() method for a given object is called no more than once by the garbage collector.','The order in which finalize() is called on two objects is based on the order in which the two objects becamefinalizable.'  ,'' ,'' ,'C' ,'Java01','ExamAQ56' ,now());
   
   insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class Yippee {<br/>public static void main(String [] args) {<br/>for(int x = 1; x < args.length; x++) {<br/>System.out.print(args[x] + " ");<br/>}<br/>}<br/>}<br/>and two separate command line invocations:<br/>java Yippee<br/>java Yippee 1 2 3 4<br/><br/>What is the result?' ,'单选','C2' ,'No output is produced.<br/>1 2 3' ,'No output is produced.<br/>2 3 4','No output is produced.<br/>1 2 3 4','An exception is thrown at runtime.<br/>1 2 3','An exception is thrown at runtime.<br/>2 3 4','An exception is thrown at runtime.<br/>1 2 3 4','B' ,'Java01' ,'ExamAQ58',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>01.interface Animal { void makeNoise(); }<br/>02.class Horse implements Animal {<br/>03.Long weight = 1200L;<br/>04.public void makeNoise() { System.out.println("whinny"); }<br/>05.}<br/>06.public class Icelandic extends Horse {<br/>07.public void makeNoise() { System.out.println("vinny"); }<br/>08.public static void main(String[] args) {<br/>09.Icelandic i1 = new Icelandic();<br/>10.Icelandic i2 = new Icelandic();<br/>11.Icelandic i3 = new Icelandic();<br/>12.i3 = i1; i1 = i2; i2 = null; i3 = i1;<br/>13.}<br/>14.}<br/><br/>When line 13 is reached, how many objects are eligible for the garbage collector?' ,'单选'  ,'C1'  ,'0'  ,'1'  ,'2' ,'3' ,'4' ,'6' ,'E' ,'Java01','ExamBQ1' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Given that the elements of a PriorityQueue are ordered according to natural ordering, and:<br/>import java.util.*;<br/>public class GetInLine {<br/>public static void main(String[] args) {<br/>PriorityQueue<String> pq = new PriorityQueue<String>();<br/>pq.add("banana");<br/>pq.add("pear");<br/>pq.add("apple");<br/>System.out.println(pq.poll() + " " + pq.peek());<br/>}<br/>}<br/><br/>What is the result?'  ,'单选' ,'C2' ,'apple pear' ,'banana pear','apple apple' ,'apple banana' ,'banana banana' ,'','D','Java01','ExamBQ12' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Given:<br/>enum Example { ONE, TWO, THREE }<br/><br/>Which statement is true?' ,'单选' ,'C1' ,'The expressions (ONE == ONE) and ONE.equals(ONE) are both guaranteed to be true.','The expression (ONE < TWO) is guaranteed to be true and ONE.compareTo(TWO) is guaranteed to beless than one.' ,'The Example values cannot be used in a raw java.util.HashMap;<br/>instead, the programmer must use ajava.util.EnumMap.','The Example values can be used in a java.util.SortedSet,<br/> but the set will NOT be sorted becauseenumerated types do NOT implement java.lang.Comparable.' ,'' ,''  ,'A' ,'Java01' ,'ExamBQ13' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Given that t1 is a reference to a live thread, which is true?' ,'单选' ,'C2','The Thread.sleep() method can take t1 as an argument.','The Object.notify() method can take t1 as an argument.' ,'The Thread.yield() method can take t1 as an argument.' ,'The Thread.setPriority() method can take t1 as an argument.' ,'The Object.notify() method arbitrarily chooses which thread to notify.' ,'' ,'E' ,'Java01','ExamBQ22',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('<br/>09.class Line {<br/>10.public static class Point {}<br/>11.}<br/>12.class Triangle {<br/>13.public Triangle(){<br/>14.// insert code here<br/>15.}<br/>16.}<br/><br/>Which code, inserted at line 15, creates an instance of the Point class defined in Line?' ,'单选','B1' ,'Point p = new Point();' ,'Line.Point p = new Line.Point();' ,'The Point class cannot be instatiated at line 15.' ,'Line l = new Line();<br/>l.Point p = new l.Point();' ,'' ,'' ,'B','Java01' ,'ExamBQ36',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class Foo {<br/>static int[] a;<br/>static { a[0]=2; }<br/>public static void main( String[] args ) {}<br/>}<br/><br/>Which exception or error will be thrown when a programmer attempts to run this code?' ,'单选','B2','java.lang.StackOverflowError' ,'java.lang.IllegalStateException' ,'java.lang.ExceptionInInitializerError' ,'java.lang.ArrayIndexOutOfBoundsException'  ,''  ,'' ,'C' ,'Java01','ExamAQ' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('public class Breaker {<br/>static String o = "";<br/>public static void main(String[] args) {<br/>z: o = o + 2;<br/>for (int x = 3; x < 8; x++) {<br/>if (x == 4)<br/>break;<br/>if (x == 6)<br/>break z;<br/>o = o + x;<br/>}<br/>System.out.println(o);<br/>}<br/>}<br/><br/>What is the result?' ,'单选'  ,'B2'  ,'23'  ,'235' ,'2357' ,'23572'  ,'Compilation fails.' ,'' ,'E'  ,'Java01' ,'Label placed incorrectly.' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Which can appropriately be thrown by a programmer using Java SE technology to create a desktop application?'  ,'单选' ,'B2' ,'ClassCastException' ,'NullPointerException' ,'NoClassDefFoundError'  ,'NumberFormatException' ,'ArrayIndexOutOfBoundsException' ,'' ,'D','Java01' ,'ExamBQ44' ,now());
   

    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Which two statements are true? (Choose two.)' ,'多选'  ,'C1' ,'It is possible for more than two threads to deadlock at once.' ,'The JVM implementation guarantees that multiple threads cannot enter into a deadlocked state.'  ,'Deadlocked threads release once their sleep() method‘s sleep duration has expired.' ,'Deadlocking can occur only when the wait(), notify(), and notifyAll() methods are used incorrectly.' ,'It is possible for a single-threaded application to deadlock if synchronized blocks are used incorrectly.','If a piece of code is capable of deadlocking, you cannot eliminate the possibility<br/> of deadlocking by insertinginvocations of Thread.yield().'  ,'A,F' ,'Java01' ,'ExamAQ',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Given a pre-generics implementation of a method:<br/>	11. public static int sum(List list) {<br/>12.int sum = 0;<br/>13.for ( Iterator iter = list.iterator(); iter.hasNext(); ) {<br/>14.int i = ((Integer)iter.next()).intValue();<br/>15.sum += i;<br/>16.	}<br/>17.return sum;<br/>18. }<br/><br/>What three changes allow the class to be used with generics and avoid an unchecked warning? (Choose three.)'  ,'多选'  ,'C2'  ,'Remove line 14.'  ,'Replace line 14 with int i = iter.next();' ,'Replace line 13 with for (int i : intList) {','Replace line 13 with for (Iterator iter : intList) {'  ,'Replace the method declaration with sum(List<int> intList)'  ,'Replace the method declaration with sum(List<Integer> intList)' ,'A,C,F' ,'Java01' ,'ExamAQ50',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('package com.company.application;<br/>public class MainClass {<br/>public static void main(String[] args) {}<br/>}<br/><br/>and MainClass exists in the /apps/com/company/application directory. Assume the CLASSPATH environment<br/>variable is set to "." (current directory). Which two java commands entered at the command line will run MainClass?'  ,'多选'  ,'C2'  ,'java MainClass if run from the /apps directory'  ,'java com.company.application.MainClass if run from the /apps directory'  ,'java -classpath /apps com.company.application.MainClass if run from any directory' ,'java -classpath . MainClass if run from the /apps/com/company/application directory' ,'java -classpath /apps/com/company/application:. MainClass if run from the /appsdirectory' ,'java com.company.application.MainClass if run from the /apps/com/company/applicationdirectory' ,'B,C'  ,'Java01','ExamAQ55' ,now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Which three statements concerning the use of the java.io.Serializable interface are true? ' ,'多选' ,'C1'  ,'Objects from classes that use aggregation cannot be serialized.'  ,'An object serialized on one JVM can be successfully deserialized on a different JVM.'  ,'The values in fields with the volatile modifier will NOT survive serialization and deserialization.' ,'The values in fields with the transient modifier will NOT survive serialization and deserialization.','It is legal to serialize an object of a type that has a supertype that does NOT implement java.io.Serializable.'  ,'' ,'B,D,E'  ,'Java01','ExamAQ',now());
   
    insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)
   values('Given that c is a reference to a valid java.io.Console object, which two code fragments read a line of text from the console?'  ,'多选'  ,'C1'  ,'String s=c.readLine();' ,'char[] c=c.readLine();' ,'String s=c.readConsole();' ,'char[] c=c.readConsole();' ,'String s=c.readLine("%s", "name ");' ,'char[] c=c.readLine("%s", "name ");'  ,'A,E'  ,'Java01' ,'ExamAQ60' ,now());
/*
   create table lexique(
LEXIQUEID INT(64) AUTO_INCREMENT PRIMARY KEY,
MOT VARCHAR(50),
DECLINAISON VARCHAR(10),
SENSCH VARCHAR(50),
SENSFR VARCHAR(200),
LOCUTION1 VARCHAR(100),
LOCUTION2 VARCHAR(100),
LOCUTION3 VARCHAR(100),
PHRASE1 VARCHAR(200),
PHRASE2 VARCHAR(200),
PHRASE3 VARCHAR(200),
JOUR VARCHAR(8),
USER VARCHAR(12),
STATE VARCHAR(1) DEFAULT 1
);
*/
   
   create table lexique(
LEXIQUEID INT(64) AUTO_INCREMENT PRIMARY KEY, 
MOT VARCHAR(50),
DECLINAISON VARCHAR(10),
SENSCH VARCHAR(50),
SENSFR VARCHAR(200),
LOCUTION1 VARCHAR(100),
LOCUTION2 VARCHAR(100),
LOCUTION3 VARCHAR(100),
PHRASE1 VARCHAR(200),
PHRASE2 VARCHAR(200),
PHRASE3 VARCHAR(200),
JOUR VARCHAR(8),
USER VARCHAR(12),
STATE VARCHAR(1) DEFAULT 1,
imgpath varchar(200) default '',
audiopath varchar(200) default '' ,
level int default 0 ,
answer varchar(200) default '',
box int default 1
);

   create table posts(
POSTSID INT(64) AUTO_INCREMENT PRIMARY KEY,
TITLE VARCHAR(50),
CATEGORY VARCHAR(10),
JOUR VARCHAR(8),
AUTHOR VARCHAR(50),
CONTENT VARCHAR(10000),
lien VARCHAR(100),
STATE VARCHAR(1) DEFAULT 1
);


