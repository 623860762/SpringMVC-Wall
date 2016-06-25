package com.ceit.ebs.cn.assys.wall.controller;



import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ceit.common.util.DeEData;
import com.ceit.common.util.DeJData;
import com.ceit.common.util.DeSteadyData;
import com.ceit.common.util.LevelData;
import com.ceit.common.util.PageInfo;
import com.ceit.common.util.UUIDGenerator;
import com.ceit.common.util.UtilMethod;
import com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore;
import com.ceit.ebs.cn.assys.detailScore.services.IDetailScoreService;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;
import com.ceit.ebs.cn.assys.expertScore.services.IExpertScoreService;
import com.ceit.ebs.cn.assys.overallScore.entity.AssOverallScore;
import com.ceit.ebs.cn.assys.overallScore.services.IOverallScoreService;
import com.ceit.ebs.cn.assys.wall.entity.AssWall;
import com.ceit.ebs.cn.assys.wall.services.IAssWallService;


	public class AssWallController extends MultiActionController {
		
		private IAssWallService assWallService;
		private IExpertScoreService expertScoreService;
		private IOverallScoreService overallScoreService;
		private IDetailScoreService detailScoreService;
	    //依赖注入一个名为mappings的参数,例如一个JSP文件，作为展示model的视图
		private Properties mappings;
		public Properties getMappings() {
			return mappings;
		}
		public void setMappings(Properties mappings) {
			this.mappings = mappings;
		}
		public void setAssWallService(IAssWallService assWallService) {
			this.assWallService = assWallService;
		}

		public void setExpertScoreService(IExpertScoreService expertScoreService) {
			this.expertScoreService = expertScoreService;
		}
		public void setOverallScoreService(IOverallScoreService overallScoreService) {
			this.overallScoreService = overallScoreService;
		}
		
		public void setDetailScoreService(IDetailScoreService detailScoreService) {
			this.detailScoreService = detailScoreService;
		}
		public ModelAndView forWallList(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forWallList");
			return new ModelAndView(forward);
		}
		
		public ModelAndView forWallPersist(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forWallPersist");
			return new ModelAndView(forward);
		}
		
		public ModelAndView forListContent(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("forListContent");
			//jsp返回当前页数
			String currentPageNumber = request.getParameter("page")==null?"1":request.getParameter("page");
			//jsp返回每页行数
			String perPageCount = request.getParameter("rows")==null?PageInfo.DEFAULT_ROWS:request.getParameter("rows");
			PageInfo<AssWall> pageInfo = assWallService.getWallList(Integer.parseInt(currentPageNumber), Integer.parseInt(perPageCount));
			request.setAttribute("listContent", pageInfo.getContentJSon());
			return new ModelAndView(forward);
		}
		
		public ModelAndView wallPersist(HttpServletRequest request,HttpServletResponse response){
			String forward = getMappings().getProperty("msg");
			String wallId = UUIDGenerator.getUUID32();
			String wallName = request.getParameter("wallName")==null?"":request.getParameter("wallName");
			String wallLocation = request.getParameter("wallLocation")==null?"":request.getParameter("wallLocation");
			String wallOwer = request.getParameter("wallOwer")==null?"":request.getParameter("wallOwer");
			String wallHeight =request.getParameter("wallHeight")==null?"":request.getParameter("wallHeight");
			String wallTopWidhth =request.getParameter("wallTopWidhth")==null?"":request.getParameter("wallTopWidhth");
			String wallBottomWidth =request.getParameter("wallBottomWidth")==null?"":request.getParameter("wallBottomWidth");
			String backSlopeGradient =request.getParameter("backSlopeGradient")==null?"":request.getParameter("backSlopeGradient");
			String fillerCohesion =request.getParameter("fillerCohesion")==null?"":request.getParameter("fillerCohesion");
			String fillerSevere =request.getParameter("fillerSevere")==null?"":request.getParameter("fillerSevere");
			String fillerInnerAngle =request.getParameter("fillerInnerAngle")==null?"":request.getParameter("fillerInnerAngle");
			String wallSevere =request.getParameter("wallSevere")==null?"":request.getParameter("wallSevere");
			String baseFrictionRatio =request.getParameter("baseFrictionRatio")==null?"":request.getParameter("baseFrictionRatio");
			String outFrictionAngle =request.getParameter("outFrictionAngle")==null?"":request.getParameter("outFrictionAngle");
			String backFilterAngle =request.getParameter("backFilterAngle")==null?"":request.getParameter("backFilterAngle");
			String wallFrictionValue =request.getParameter("wallFrictionValue")==null?"":request.getParameter("wallFrictionValue");
			String topShiftMax =request.getParameter("topShiftMax")==null?"":request.getParameter("topShiftMax");
			String antiSlipValue =request.getParameter("antiSlipValue")==null?"":request.getParameter("antiSlipValue");
			String antiOverturnValue =request.getParameter("antiOverturnValue")==null?"":request.getParameter("antiOverturnValue");
			String shearStressValue =request.getParameter("shearStressValue")==null?"":request.getParameter("shearStressValue");
			String baseStressDistance =request.getParameter("baseStressDistance")==null?"":request.getParameter("baseStressDistance");			
			
			
			AssWall assWall = new AssWall();
			assWall.setWallId(wallId);
			assWall.setWallName(wallName);
			assWall.setWallLocation(wallLocation);
			assWall.setWallOwer(wallOwer);
			assWall.setWallHeight(wallHeight);
			assWall.setWallTopWidth(wallTopWidhth);
			assWall.setBackSlopeGradient(backSlopeGradient);
			assWall.setWallBottomWidth(wallBottomWidth);
			assWall.setFillerCohesion(fillerCohesion);
			assWall.setFillerSevere(fillerSevere);
			assWall.setFillerInnerAngle(fillerInnerAngle);
			assWall.setWallSevere(wallSevere);
			assWall.setBaseFrictionRatio(baseFrictionRatio);
			assWall.setOutFrictionAngle(outFrictionAngle);
			assWall.setTopShiftMax(topShiftMax);
			assWall.setAntiOverturnValue(antiOverturnValue);
			assWall.setAntiSlipValue(antiSlipValue);
			assWall.setShearStressValue(shearStressValue);
			assWall.setBaseStressDistance(baseStressDistance);
			assWall.setAssWallStatu("1");
			assWall.setBackFilterAngle(backFilterAngle);
			assWall.setWallFrictionValue(wallFrictionValue);
			
			String message = "1";
			if(assWallService.assWallPersist(assWall)){
				message = "2";
			}
			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView wallMerge(HttpServletRequest request,HttpServletResponse response){
			String forward = getMappings().getProperty("msg");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");;
			String wallName = request.getParameter("wallName")==null?"":request.getParameter("wallName");
			String wallLocation = request.getParameter("wallLocation")==null?"":request.getParameter("wallLocation");
			String wallOwer = request.getParameter("wallOwer")==null?"":request.getParameter("wallOwer");
			String wallHeight =request.getParameter("wallHeight")==null?"":request.getParameter("wallHeight");
			String wallTopWidhth =request.getParameter("wallTopWidhth")==null?"":request.getParameter("wallTopWidhth");
			String wallBottomWidth =request.getParameter("wallBottomWidth")==null?"":request.getParameter("wallBottomWidth");
			String backSlopeGradient =request.getParameter("backSlopeGradient")==null?"":request.getParameter("backSlopeGradient");
			String fillerCohesion =request.getParameter("fillerCohesion")==null?"":request.getParameter("fillerCohesion");
			String fillerSevere =request.getParameter("fillerSevere")==null?"":request.getParameter("fillerSevere");
			String fillerInnerAngle =request.getParameter("fillerInnerAngle")==null?"":request.getParameter("fillerInnerAngle");
			String wallSevere =request.getParameter("wallSevere")==null?"":request.getParameter("wallSevere");
			String baseFrictionRatio =request.getParameter("baseFrictionRatio")==null?"":request.getParameter("baseFrictionRatio");
			String outFrictionAngle =request.getParameter("outFrictionAngle")==null?"":request.getParameter("outFrictionAngle");
			String backFilterAngle =request.getParameter("backFilterAngle")==null?"":request.getParameter("backFilterAngle");
			String wallFrictionValue =request.getParameter("wallFrictionValue")==null?"":request.getParameter("wallFrictionValue");
			String topShiftMax =request.getParameter("topShiftMax")==null?"":request.getParameter("topShiftMax");
			String antiSlipValue =request.getParameter("antiSlipValue")==null?"":request.getParameter("antiSlipValue");
			String antiOverturnValue =request.getParameter("antiOverturnValue")==null?"":request.getParameter("antiOverturnValue");
			String shearStressValue =request.getParameter("shearStressValue")==null?"":request.getParameter("shearStressValue");
			String baseStressDistance =request.getParameter("baseStressDistance")==null?"":request.getParameter("baseStressDistance");
			
			AssWall assWall = assWallService.getWallById(wallId);
			assWall.setWallName(wallName);
			assWall.setWallLocation(wallLocation);
			assWall.setWallOwer(wallOwer);
			assWall.setWallHeight(wallHeight);
			assWall.setWallTopWidth(wallTopWidhth);
			assWall.setBackSlopeGradient(backSlopeGradient);
			assWall.setWallBottomWidth(wallBottomWidth);
			assWall.setFillerCohesion(fillerCohesion);
			assWall.setFillerSevere(fillerSevere);
			assWall.setFillerInnerAngle(fillerInnerAngle);
			assWall.setWallSevere(wallSevere);
			assWall.setBaseFrictionRatio(baseFrictionRatio);
			assWall.setOutFrictionAngle(outFrictionAngle);
			assWall.setTopShiftMax(topShiftMax);
			assWall.setAntiOverturnValue(antiOverturnValue);
			assWall.setAntiSlipValue(antiSlipValue);
			assWall.setShearStressValue(shearStressValue);
			assWall.setBaseStressDistance(baseStressDistance);
			assWall.setBackFilterAngle(backFilterAngle);
			assWall.setWallFrictionValue(wallFrictionValue);
			
			String message = "1";
			if(assWallService.WallMerge(assWall)){
				message = "2";
			}
			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView forWall(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forWall");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			AssWall assWall = assWallService.getWallById(wallId);
			request.setAttribute("assWall", assWall);
			return new ModelAndView(forward);
		}
		public ModelAndView forOverScore(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forOverScore");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			AssWall assWall = assWallService.getWallById(wallId);
			AssOverallScore assOverallScore = (AssOverallScore) overallScoreService.getListByWallId(wallId).get(0);
			request.setAttribute("assWall", assWall);
			request.setAttribute("assOverallScore", assOverallScore);
			return new ModelAndView(forward);
		}
		public ModelAndView forDetailScore(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forDetailScore");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			AssWall assWall = assWallService.getWallById(wallId);
			 List<AssDetailScore> detailScorelist = detailScoreService.getListByWallId(wallId);
			request.setAttribute("assWall", assWall);
			request.setAttribute("detailScorelist", detailScorelist);
			return new ModelAndView(forward);
		}
		public ModelAndView CalDetailScore(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("msg");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			String assWallStatu = request.getParameter("assWallStatu")==null?"":request.getParameter("assWallStatu");
			AssWall assWall = assWallService.getWallById(wallId);
			
/*			double H = 6;
			double c = 35*Math.PI/180;
			double a = 14*Math.PI/180;
			double b = 15*Math.PI/180;
			double d = 17.5*Math.PI/180;
			double r = 19;
			double f = 0.35;
			double r1 = 23;
			double u0 = 0.65;
			double B1 = 0.8;
			double B = 2.3;*/
			
			double H = Double.parseDouble(assWall.getWallHeight());
			double c = Double.parseDouble(assWall.getFillerInnerAngle())*Math.PI/180;
			double a = Double.parseDouble(assWall.getBackSlopeGradient())*Math.PI/180;
			double b = Double.parseDouble(assWall.getBackFilterAngle())*Math.PI/180;
			double d = Double.parseDouble(assWall.getOutFrictionAngle())*Math.PI/180;
			double r = Double.parseDouble(assWall.getFillerCohesion());
			double f = Double.parseDouble(assWall.getBaseFrictionRatio());
			double r1 = Double.parseDouble(assWall.getWallSevere());
			double u0 = Double.parseDouble(assWall.getWallFrictionValue());
			double B1 = Double.parseDouble(assWall.getWallTopWidth());
			double B = Double.parseDouble(assWall.getWallBottomWidth());
			
			double Tan0 = UtilMethod.getTanO(a, B, c);
			double Ea = UtilMethod.getEa(r1, H, Tan0, a, B, c);
			double G1 = UtilMethod.getG1(B1, H, r1);
			double G2 = UtilMethod.getG2(B, B1, H, r1);
			double G = G1+G2;
			double Eay = UtilMethod.getEay(Ea, a, d);
			double Eax = UtilMethod.getEax(Ea, a, d);
			
			double Kc = UtilMethod.getKc(Eax, Eay, G, f);
			double Kj = UtilMethod.getKj(Eax, Eay, G1, G2, B, u0);
			double Ko = UtilMethod.getKo(Eax, Eay, G1, G2, B, B1, H);
			double e = UtilMethod.gete(Eax, Eay, G1, G2, B, B1, H);
			Kc = UtilMethod.db_2(Kc);
			Kj = UtilMethod.db_2(Kj);
			Ko = UtilMethod.db_2(Ko);
			e = UtilMethod.db_2(e);
			
			System.out.println("Tan0="+Tan0);
			System.out.println("Ea="+Ea);
			System.out.println("G1="+G1);
			System.out.println("G2="+G2);
			System.out.println("Eay="+Eay);
			System.out.println("Eax="+Eax);
			
			System.out.println("抗滑系数Kc="+Kc);
			System.out.println("返回抗倾覆系数Ko="+Ko);
			System.out.println("返回基底偏心距e="+e);
			System.out.println("返回墙身剪应力Kj="+Kj);

/*			String KcLevel = UtilMethod.getKxLevel(Kc, 1.3);
			String KoLevel = UtilMethod.getKxLevel(Ko, 1.6);
			String Jlevel = UtilMethod.getJlevel(Kj, 300.0);
			String Elevel = UtilMethod.getElevel(e, 0.23);
			*/
			
			
			String KcLevel = UtilMethod.getKxLevel(Kc, Double.parseDouble(assWall.getAntiSlipValue()));
			String KoLevel = UtilMethod.getKxLevel(Ko, Double.parseDouble(assWall.getAntiOverturnValue()));
			String Jlevel = UtilMethod.getJlevel(Kj, Double.parseDouble(assWall.getShearStressValue()));
			String Elevel = UtilMethod.getElevel(e, Double.parseDouble(assWall.getBaseStressDistance()));
			
			DeSteadyData KcData = new DeSteadyData(KcLevel);
			DeSteadyData KoData = new DeSteadyData(KoLevel);
			DeEData dEData = new DeEData(Elevel);
			DeJData deJData = new DeJData(Jlevel);
			
			AssDetailScore assKc = new AssDetailScore();
				assKc.setDetailScoreId(UUIDGenerator.getUUID32());
				assKc.setScoreName("抗滑系数");
				assKc.setWallId(wallId);
				assKc.setDetailScore(String.valueOf(Kc));
				assKc.setSecurityLevel(KcData.getSecurityLevel());
				assKc.setSecurityStatus(KcData.getSecurityStatus());
				assKc.setWallSecuRemark(KcData.getSecurity_remark());
			AssDetailScore assKo = new AssDetailScore();
				assKo.setDetailScoreId(UUIDGenerator.getUUID32());
				assKo.setScoreName("抗倾覆系数");
				assKo.setWallId(wallId);
				assKo.setDetailScore(String.valueOf(Ko));
				assKo.setSecurityLevel(KoData.getSecurityLevel());
				assKo.setSecurityStatus(KoData.getSecurityStatus());
				assKo.setWallSecuRemark(KoData.getSecurity_remark());
			AssDetailScore assE = new AssDetailScore();
				assE.setDetailScoreId(UUIDGenerator.getUUID32());
				assE.setScoreName("基底偏心距");
				assE.setWallId(wallId);
				assE.setDetailScore(String.valueOf(e));
				assE.setSecurityLevel(dEData.getSecurityLevel());
				assE.setSecurityStatus(dEData.getSecurityStatus());
				assE.setWallSecuRemark(dEData.getSecurity_remark());
			AssDetailScore assJ= new AssDetailScore();
				assJ.setDetailScoreId(UUIDGenerator.getUUID32());
				assJ.setScoreName("墙身剪应力");
				assJ.setWallId(wallId);
				assJ.setDetailScore(String.valueOf(Kj));
				assJ.setSecurityLevel(deJData.getSecurityLevel());
				assJ.setSecurityStatus(deJData.getSecurityStatus());
				assJ.setWallSecuRemark(deJData.getSecurity_remark());
			
				 detailScoreService.persistObj(assKc);
				 detailScoreService.persistObj(assKo);
				 detailScoreService.persistObj(assE);
				 detailScoreService.persistObj(assJ);
			String message = "1";
			if(assWallService.uptWallStatu(wallId, assWallStatu)){
				message = "2";
			}

			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView forWallStatus(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forWallStatus");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			AssWall assWall = assWallService.getWallById(wallId);
			request.setAttribute("assWall", assWall);
			return new ModelAndView(forward);
		}
		public ModelAndView forWallMerge(HttpServletRequest request,HttpServletResponse response) {
			String forward = getMappings().getProperty("forWallMerge");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			AssWall assWall = assWallService.getWallById(wallId);
			request.setAttribute("assWall", assWall);
			return new ModelAndView(forward);
		}
		public ModelAndView uptWallStatu(HttpServletRequest request,HttpServletResponse response){
			String forward = getMappings().getProperty("msg");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			String assWallStatu = request.getParameter("assWallStatu")==null?"":request.getParameter("assWallStatu");
			String message = "1";
			if(assWallService.uptWallStatu(wallId, assWallStatu)){
				message = "2";
			}
			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		public ModelAndView CalExpScore(HttpServletRequest request,HttpServletResponse response){
			String forward = getMappings().getProperty("msg");
			String wallId = request.getParameter("wallId")==null?"":request.getParameter("wallId");
			String assWallStatu = request.getParameter("assWallStatu")==null?"":request.getParameter("assWallStatu");
			System.out.println(assWallStatu);
			List<AssExpertScore> list = expertScoreService.getListByWallId(wallId);
			int ExpNums = list.size();
			double sumExpScore = 0;
			for(int i = 0;i<list.size();i++){
				double d = UtilMethod.calExpScore(Double.parseDouble(list.get(i).getSteadyScore()), 
						Double.parseDouble(list.get(i).getStrenthScore()), Double.parseDouble(list.get(i).getBaseScore()));
				sumExpScore+=d;
			}
			sumExpScore/=ExpNums;
			sumExpScore = UtilMethod.db_2(sumExpScore);
			
			LevelData levelData = new LevelData(UtilMethod.getLevelNum(sumExpScore));
			
			System.out.println(sumExpScore);
			String overallScoreId = UUIDGenerator.getUUID32();
			AssOverallScore assOverallScore = new AssOverallScore();
			assOverallScore.setOverallScoreId(overallScoreId);
			assOverallScore.setWallId(wallId);
			assOverallScore.setOverallScore(String.valueOf(sumExpScore));
			assOverallScore.setSecurityLevel(levelData.getSecurityLevel());
			assOverallScore.setSecurityStatus(levelData.getSecurityStatus());
			assOverallScore.setWallSecuRemark(levelData.getSecurity_remark());
			
			String message = "1";
			if(assWallService.uptWallStatu(wallId, assWallStatu) && overallScoreService.persistObj(assOverallScore)){
				message = "2";
			}
			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		
		public ModelAndView wallDelete(HttpServletRequest request,HttpServletResponse response){
			String forward = getMappings().getProperty("msg");
			String wallIds = request.getParameter("objIds")==null?"":request.getParameter("objIds");
			String message = "1";
			if(assWallService.delWallByIds(wallIds)){
				message = "2";
			}
			
			request.setAttribute("msg", message);
			return new ModelAndView(forward);
		}
		
		/*
		 * new页面
		 */
		public ModelAndView newIndex(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newIndex");
			return new ModelAndView(forward);
		}
		public ModelAndView newSubmit2(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newSubmit2");
			return new ModelAndView(forward);
		}
		public ModelAndView newWeight3(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newWeight3");
			return new ModelAndView(forward);
		}
		public ModelAndView newView4(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newView4");
			return new ModelAndView(forward);
		}
		public ModelAndView newMaterial5(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newMaterial5");
			return new ModelAndView(forward);
		}
		public ModelAndView newPower6(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newPower6");
			return new ModelAndView(forward);
		}
		public ModelAndView newResult7(HttpServletRequest request,HttpServletResponse response) {
			
			String forward = getMappings().getProperty("newResult7");
			return new ModelAndView(forward);
		}
}
