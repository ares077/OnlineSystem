package xiu.dao;

import java.util.List;

import xiu.entity.Forum;
import xiu.entity.PageForum;

public interface ForumDAO {
	//select par limit
		int countLimit(PageForum pageforum)throws Exception;
		List<Forum> findByLimit(PageForum pageforum) throws Exception; 
		
	//getname by stuid
		String getName(String id)throws Exception;
		//add modifier
		void add(Forum forum)throws Exception;
		void modifer(Forum forum)throws Exception;
		
		Forum findById(String id)throws Exception;
}
