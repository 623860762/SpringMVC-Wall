package com.ceit.ebs.cn.assys.expertScore.controller;




import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ceit.common.util.PageInfo;
import com.ceit.common.util.UUIDGenerator;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;
import com.ceit.ebs.cn.assys.expertScore.services.IExpertScoreService;
import com.ceit.ebs.cn.assys.wall.services.IAssWallService;


	public class ExpertScoreController extends MultiActionController{
		
		//依赖注入各个service层
		private IExpertScoreService expertScoreService;
		private IAssWallService assWallService;
	    //依赖注入一个名为mappings的参数,例如一个JSP文件，作为展示model的视图
		private Properties mappings;
		public Properties getMappings() {
			return mappings;
		}
		public void setMappings(Properties mappings) {
			this.mappings = mappings;
		}
		public void setExpertScoreService(IExpertScoreService expertScoreService) {
			this.expertScoreService = expertScoreService;
		}

		public void setAssWallService(IAssWallService assWallService) {
			this.assWallService = assWallService;
		}
		public ModelAndView forExpScoreList(HttpServletRequest req,
                HttpServletResponse res){
          String forward = getMappings().getProperty("forExpScoreList");
          String wallId = req.getParameter("wallId")==null?"":req.getParameter("wallId");
          req.setAttribute("wallId", wallId);
          return new ModelAndView(forward);
		}
		public ModelAndView forExpScoreMerge(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("forExpScoreMerge");
			String expertScoreId = req.getParameter("expertScoreId")==null?"":req.getParameter("expertScoreId");
			AssExpertScore assExpertScore = expertScoreService.getObjById(expertScoreId);
			req.setAttribute("assExpertScore", assExpertScore);
			return new ModelAndView(forward);
		}
		public ModelAndView forExpScorePersist(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("forExpScorePersist");
	        return new ModelAndView(forward);
		}
		public ModelAndView forListContent(HttpServletRequest req,
				HttpServletResponse res){
	        String forward = getMappings().getProperty("forListContent");
			//jsp返回当前页数
			String currentPageNumber = req.getParameter("page")==null?"1":req.getParameter("page");
			String wallId = req.getParameter("wallId")==null?"":req.getParameter("wallId");
			//jsp返回每页行数
			String perPageCount = req.getParameter("rows")==null?PageInfo.DEFAULT_ROWS:req.getParameter("rows");
			PageInfo<AssExpertScore> pageInfo = expertScoreService.getObjList(Integer.parseInt(currentPageNumber), Integer.parseInt(perPageCount),wallId);
			req.setAttribute("listContent", pageInfo.getContentJSon());
	        return new ModelAndView(forward);
		}
		public ModelAndView expPersist(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("msg");
			String wallId = req.getParameter("wallId")==null?"":req.getParameter("wallId");
			String expertName = req.getParameter("expertName")==null?"":req.getParameter("expertName");
			String steadyScore = req.getParameter("steadyScore")==null?"":req.getParameter("steadyScore");
			String baseScore = req.getParameter("baseScore")==null?"":req.getParameter("baseScore");
			String strenthScore = req.getParameter("strenthScore")==null?"":req.getParameter("strenthScore");
	        AssExpertScore assExpertScore =  new AssExpertScore();
	        String expertScoreId = UUIDGenerator.getUUID32();
	        assExpertScore.setExpertScoreId(expertScoreId);
	        assExpertScore.setExpertName(expertName);
	        assExpertScore.setSteadyScore(steadyScore);
	        assExpertScore.setBaseScore(baseScore);
	        assExpertScore.setWallId(wallId);
	        assExpertScore.setStrenthScore(strenthScore);
			String message = "1";
			
			if(expertScoreService.persistObj(assExpertScore)){
				message = "2";
			}
			
			req.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView expMerge(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("msg");
			String expertName = req.getParameter("expertName")==null?"":req.getParameter("expertName");
			String steadyScore = req.getParameter("steadyScore")==null?"":req.getParameter("steadyScore");
			String baseScore = req.getParameter("baseScore")==null?"":req.getParameter("baseScore");
			String strenthScore = req.getParameter("strenthScore")==null?"":req.getParameter("strenthScore");
			String expertScoreId = req.getParameter("expertScoreId")==null?"":req.getParameter("expertScoreId");
			
			AssExpertScore assExpertScore = expertScoreService.getObjById(expertScoreId);
			assExpertScore.setExpertName(expertName);
			assExpertScore.setSteadyScore(steadyScore);
			assExpertScore.setBaseScore(baseScore);
			assExpertScore.setStrenthScore(strenthScore);
			
			String message = "1";
			if(expertScoreService.mergeObj(assExpertScore)){
				message = "2";
			}
			
			req.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView expDelete(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("msg");
			String expertScoreIds = req.getParameter("objIds")==null?"":req.getParameter("objIds");
			String message = "1";
			
			if(expertScoreService.delObjsByIds(expertScoreIds)){
				message = "2";
			}
			req.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView uptWallStatu(HttpServletRequest req,
				HttpServletResponse res){
			String forward = getMappings().getProperty("msg");
			String wallId = req.getParameter("wallId")==null?"276342f6f06747da98276c8d6d81876c":req.getParameter("wallId");
			
			String message = "1";
			
			if(assWallService.uptWallStatu(wallId, "2")){
				message = "2";
			}
			req.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
}
