package com.ceit.common.util;

import java.math.BigDecimal;

public class UtilMethod {
	/*
	 * a=α;
	 * b=β；
	 * c=
	 * */
	public static double db_2(double d){
		BigDecimal b = new BigDecimal(d);
		return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public static double calExpScore(double x1,double x2,double x3){
		double d = 100 - (45*x1+20*x2+35*x3)/6;
		return d;
	}
	public static String getLevelNum(double score){
		if(score>=90){
			return "1";
		}else if(score>=75 && score < 90){
			return "2";
		}else if(score>=75 && score < 90){
			return "3";
		}else if(score>=45 && score < 60){
			return "4";
		}else if(score>=30 && score < 45){
			return "5";
		}else{
			return "6";
		}
	}
	/*
	 * Kx实际值，K为检算规范值，用来算Kc和Ko
	 * */
	public static String getKxLevel(double Kx,double K){
		if(Kx>=K){
			return "1";
		}else if(Kx>=0.96*K && Kx < K){
			return "2";
		}else if(Kx>=0.93*K && Kx < 0.96*K){
			return "3";
		}else if(Kx>=0.90*K && Kx < 0.93*K){
			return "4";
		}else if(Kx>=0.85*K && Kx < 0.90*K){
			return "5";
		}else{
			return "6";
		}
	}
	public static String getElevel(double e,double eo){
		if(e<=eo){
			return "1";
		}else if(e>eo && e <= 1.05*eo){
			return "2";
		}else if(e>1.05*eo && e <= 1.2*eo){
			return "3";
		}else if(e>=1.2*eo && e < 1.35*eo){
			return "4";
		}else if(e>1.35*eo && e <= 1.50*eo){
			return "5";
		}else{
			return "6";
		}
	}
	public static String getJlevel(double j,double jo){
		if(j<=jo){
			return "1";
		}else if(j>jo && j <= 1.05*jo){
			return "2";
		}else if(j>1.05*jo && j <= 1.1*jo){
			return "3";
		}else if(j>=1.1*jo && j < 1.15*jo){
			return "4";
		}else if(j>1.15*jo && j <= 1.20*jo){
			return "5";
		}else{
			return "6";
		}
	}
	public static double getTanO(double a,double b,double c){
		double tanA = Math.tan(a);
		double tanB = Math.tan(b);
		double tanC = Math.tan(c);
		double tanC2 = Math.pow(tanC, 2);
		double temp = (1+tanC2)*(tanC-tanB);
		temp/=(tanC-tanA)*(1+tanB*tanA);
		temp = tanC2-tanB*tanA-Math.pow(temp, 1.0/2);
		temp/=tanB*(1+tanC2)-tanC*(1+tanB*tanA);
		return temp;
	}
	//返回Ea
	public static double getEa(double r,double H,double Tan0,double a,double b,double c){
		double temp = (Tan0+Math.tan(a))*(1+Math.tan(a)*Math.tan(b))*(1-Tan0*Math.tan(c));
		temp/=(1-Tan0*Math.tan(b))*(Tan0+Math.tan(c));
		temp*=(0.5)*r*Math.pow(H, 2);
		return temp;
	}
	//返回Eay
	public static double getEay(double Ea,double a,double d){
		return Ea*(Math.sin(a)*Math.cos(d)+Math.cos(a)*Math.sin(d));
	}
	//返回Eax
	public static double getEax(double Ea,double a,double d){
		
		return Ea*(Math.cos(a)*Math.cos(d)-Math.sin(a)*Math.sin(d));
	}
	//返回G1(G=G1+G2)
	public static double getG1(double B1,double H,double r1){
		return B1*H*r1;
	}
	//返回G2
	public static double getG2(double B,double B1,double H,double r1){
		return (0.5)*(B-B1)*H*r1;
	}
	//返回抗滑系数
	public static double getKc(double Eax,double Eay,double G,double f){
		return f*(G+Eay)/Eax;
	}
	//返回抗倾覆系数
	public static double getKo(double Eax,double Eay,double G1,double G2,double B,double B1,double H){
		double temp = (0.5)*G1*B1+G2*((0.5)*B1+(1.0/3)*(B-B1));
		return temp/=(1.0/3)*H*Eax;
	}
	//返回墙身剪应力
	public static double getKj(double Eax,double Eay,double G1,double G2,double B,double u0){
		double temp = Eax-(G1+G2+Eay)*u0;
		return temp/=B;
	}
	//返回基底偏心距
	public static double gete(double Eax,double Eay,double G1,double G2,double B,double B1,double H){
		double temp = (0.5)*G1*B1+G2*((1.0/3)*B+(1.0/6)*B1)-(1.0/3)*H*Eax;
		return temp/=G1+G2+Eay;
	}

	public static void main(String[] args) {
/*		double H = 5;
		double c = 35*Math.PI/180;
		double a = 15*Math.PI/180;
		double b = 20*Math.PI/180;
		double d = 12*Math.PI/180;
		double r = 20;
		double f = 0.4;
		double r1 = 22;
		double u0 = 0.6;
		double B1 = 0.5;
		double B = 2;*/
		
/*		double H = 7;
		double c = 35*Math.PI/180;
		double a = 20*Math.PI/180;
		double b = 15*Math.PI/180;
		double d = 17*Math.PI/180;
		double r = 19;
		double f = 0.5;
		double r1 = 22;
		double u0 = 0.65;
		double B1 = 1;
		double B = 4;*/
		
		double H = 6;
		double c = 35*Math.PI/180;
		double a = 14*Math.PI/180;
		double b = 15*Math.PI/180;
		double d = 17.5*Math.PI/180;
		double r = 19;
		double f = 0.35;
		double r1 = 23;
		double u0 = 0.65;
		double B1 = 0.8;
		double B = 2.3;

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
		System.out.println("Tan0="+Tan0);
		System.out.println("Ea="+Ea);
		System.out.println("G1="+G1);
		System.out.println("G2="+G2);
		System.out.println("Eay="+Eay);
		System.out.println("Eax="+Eax);
		
		System.out.println("抗滑系数Kc="+Kc);
		System.out.println("返回墙身剪应力Kj="+Kj);
		System.out.println("返回抗倾覆系数Ko="+Ko);
		System.out.println("返回基底偏心距e="+e);
		System.out.println(Math.atan(0.25)*180/Math.PI);
		
	}

}
