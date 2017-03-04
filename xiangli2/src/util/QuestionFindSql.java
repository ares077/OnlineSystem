package util;

public class QuestionFindSql {
	public static String findCountSql(String paperid,String type,String level,String key){
		if (paperid==null||type==null||level==null||key==null) {
			return "select count(*) from question where states=1";
		}
		if (paperid.equals("")&&type.equals("")&&level.equals("")&&key.equals("")) {
			return "select count(*) from question where states=1";
		}else if (type.equals("")&&level.equals("")&&key.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and states=1";
		}else if (paperid.equals("")&&level.equals("")&&key.equals("")) {
			return "select count(*) from question where type='"+type+"' and states=1";
		}else if (paperid.equals("")&&type.equals("")&&key.equals("")) {
			return "select count(*) from question where level='"+level+"' and states=1";
		}else if (paperid.equals("")&&type.equals("")&&level.equals("")) {
			return "select count(*) from question where description like '%"+key+"%' and states=1";
		}else if (level.equals("")&&key.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and type='"+type+"' and states=1";
		}else if (type.equals("")&&key.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and level='"+level+"' and states=1";
		}else if (type.equals("")&&level.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and description like '%"+key+"%' and states=1";
		}else if (paperid.equals("")&&key.equals("")) {
			return "select count(*) from question where type='"+type+"' and level='"+level+"' and states=1";
		}else if (paperid.equals("")&&level.equals("")) {
			return "select count(*) from question where type='"+type+"' and description like '%"+key+"%' and states=1";
		}else if (paperid.equals("")&&type.equals("")) {
			return "select count(*) from question where description like '%"+key+"%' and level='"+level+"' and states=1";
		}else if (paperid.equals("")) {
			return "select count(*) from question where and type='"+type+"' and description like '%"+key+"%' and level='"+level+"' and states=1";
		}else if (type.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and description like '%"+key+"%' and level='"+level+"' and states=1";
		}else if (level.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and type='"+type+"' and description like '%"+key+"%' and states=1";
		}else if (key.equals("")) {
			return "select count(*) from question where paperid='"+paperid+"' and type='"+type+"' and level='"+level+"' and states=1";
		}else {
			return "select count(*) from question where paperid='"+paperid+"' and type='"+type+"' and description like '%"+key+"%' and level='"+level+"' and states=1";
		}
	}
}
