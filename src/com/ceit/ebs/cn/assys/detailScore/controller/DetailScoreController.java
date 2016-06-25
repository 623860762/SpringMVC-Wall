package com.ceit.ebs.cn.assys.detailScore.controller;




import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import antlr.collections.List;

import com.ceit.common.util.PageInfo;
import com.ceit.common.util.UUIDGenerator;
import com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore;
import com.ceit.ebs.cn.assys.detailScore.services.IDetailScoreService;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;
import com.ceit.ebs.cn.assys.expertScore.services.IExpertScoreService;
import com.ceit.ebs.cn.assys.wall.services.IAssWallService;


	public class DetailScoreController extends MultiActionController{
		
		//依赖注入各个service层
		private IDetailScoreService detailScoreService;
	    //依赖注入一个名为mappings的参数,例如一个JSP文件，作为展示model的视图
		private Properties mappings;
		public Properties getMappings() {
			return mappings;
		}
		public void setMappings(Properties mappings) {
			this.mappings = mappings;
		}
		public void setDetailScoreService(IDetailScoreService detailScoreService) {
			this.detailScoreService = detailScoreService;
		}
		public ModelAndView forListContent(HttpServletRequest req,
				HttpServletResponse res){
	        String forward = getMappings().getProperty("forListContent");
	        List list = (List) detailScoreService.getListByWallId("9");
			System.out.println();
	        return new ModelAndView(forward);
		}
		

}
