package com.ceit.common.dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.dao.entity.Orderby;
import com.ceit.common.dao.entity.Sysfield;
import com.ceit.common.dao.entity.Whereelement;
import com.ceit.common.entity.BaseEntity;
import com.ceit.common.util.CommonUtil;

public class TableDao<E extends BaseEntity> extends HibernateDaoSupport implements ITableDao<E> {
	public Integer insert(Object obj) {
		Session session = getSession();
		try {
			if (obj != null) {
				session.save(obj);
				Field f = obj.getClass().getDeclaredField("id");
				f.setAccessible(true);
				Integer id = (Integer) f.get(obj);
				return id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean insertNew(E obj){
		Session session = getSession();
		try {
			if (obj != null){
				obj.setOpTime(System.currentTimeMillis());
				session.save(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean insertNew2(E obj){
		Session session = getSession();
		try {
			if (obj != null){
				obj.setOpTime(System.currentTimeMillis());
				session.save(obj);
				Field f = obj.getClass().getDeclaredField("wallId");
				f.setAccessible(true);
				String id = (String) f.get(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean update( E obj) {
		Session session = getSession();
		try {
			obj.setOpTime(System.currentTimeMillis());
			session.merge(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean delete(Integer id, Class entityClass) {
		Session session = getSession();
		try {
			Object obj = session.get(entityClass, Integer.valueOf(id));
			if (obj != null)
				session.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteNew(String id, Class entityClass){
		Session session = getSession();
		try {
			Object obj = session.get(entityClass, id);
			if (obj != null)
				session.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	public Object getEntitybyId(Integer id, Class entityClass) throws Exception{
		Session session = getSession();
		
		Object obj = session.get(entityClass, Integer.valueOf(id));
		return obj;
	}
	@SuppressWarnings("unchecked")
	public Object getEntitybyIdNew(String id, Class entityClass) throws Exception{
		Session session = getSession();
		
		Object obj = session.get(entityClass, id);
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List querydata(String sql, boolean hql, int pageindex, int pagesize,Map<String, Object> params) throws Exception{
		Session session = getSession();
		Query query ;
		if(hql){
			 query = session.createQuery(sql);
		}
		else{
			 query = session.createSQLQuery(sql);
		}
		query.setFirstResult(pageindex);
		query.setMaxResults(pagesize);
		
		if ((params != null) && (params.size() > 0)) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	public List querydataNew(String sql, boolean hql, int pageindex, int pagesize,Map<String, Object> params) throws Exception{
		Session session = getSession();
		Query query ;
		if(hql){
			query = session.createQuery(sql);
		}
		else{
			query = session.createSQLQuery(sql);
		}
		query.setFirstResult((pageindex-1)*pagesize);
		query.setMaxResults(pagesize);
		
		if ((params != null) && (params.size() > 0)) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		List list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List otherQuery(String sql, boolean isHql, boolean returnNot,Map<String, Object> params) throws Exception{
		Session session = getSession();
		List list = new ArrayList();
		if(isHql){
			Query query = session.createQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					query.setParameter(key, params.get(key));	
				}
			}
			if(!returnNot){
				query.executeUpdate();
			}
			else{
				list = query.list();
			}
		}
		else {
			Query query = session.createSQLQuery(sql);
			if ((params != null) && (params.size() > 0)) {
				for (String key : params.keySet()) {
					query.setParameter(key, params.get(key));
				}
			}
			if(!returnNot){
				query.executeUpdate();
			}
			else{
				list = query.list();
			}
		}
		return list;
	}
	/**
	 * 该方法用于根据权限查询List实体集，返回entityClass类型的实体List。
	 * @author wujinshui
	 */
	@SuppressWarnings("unchecked")
	public List getXXdataQuery(List<Sysfield> fieldList,Class entityClass, List<Whereelement> elementList, List<Orderby> orderbyList){
		Session session = getSession();
		String hql="select ";
		/**以下为拼写sysfield字段**/
		if(fieldList == null || fieldList.size() == 0){
			return null;
		}else{
			for(int i=0; i<fieldList.size(); i++){		
				hql=hql+"t."+fieldList.get(i).getFieldname()+",";
			}
			hql=hql.substring(0, hql.length()-1);
		}
		/**以下为获得去掉包名后实体（表）的名字，并拼写where子句**/
		hql += " from "+entityClass.getName().substring(entityClass.getName().lastIndexOf(".")+1,entityClass.getName().length())+" t where '1' = '1' ";
		if(elementList != null && elementList.size() > 0){
			for(int i=0; i<elementList.size(); i++){
				if(!"".equals(elementList.get(i).getValue())&&elementList.get(i).getValue()!=null){
					hql += " and t."+elementList.get(i).getFieldname()+" "+elementList.get(i).getType()+" "+elementList.get(i).getValue();
				}
			}
		}
		/**以下为拼order子句 **/
		if(orderbyList != null && orderbyList.size() > 0){
			hql=hql+" order by ";
			for(int k=0; k<orderbyList.size(); k++){		
				hql=hql+"t."+orderbyList.get(k).getName()+" "+orderbyList.get(k).getType()+" ,";
			}
			hql=hql.substring(0, hql.length()-1);
		}
		try{
			/**为了获得表中列的类型，将sql查询结果构成实体类 **/
			SQLQuery query = session.createSQLQuery(hql); 
			for(int i=0; i<fieldList.size(); i++){
				Field f;
				/**获得实体的列。反射机制**/
				f = entityClass.getDeclaredField(fieldList.get(i).getFieldname());	
				query.addScalar(f.getName(), CommonUtil.getNullabletype(f.getType()));
				
			}
			return query.setResultTransformer(Transformers.aliasToBean(entityClass)).list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean down(Integer id,Class entityClass) {
		Session session = getSession();
		Object obj=new Object();
		obj=session.get(entityClass, id);
		
		Field fpid,fid,fdispindex1,fdispindex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentid");
			
			if(fpid!=null)
			{
				fpid.setAccessible(true);
				Integer pid = (Integer)fpid.get(obj);
			    List list = new ArrayList();
			
			String sql = "select p from "+entityClass.getName()+" p where p.parentid=:parentId ";
			sql += "order by p.dispindex desc ";
			Query query = session.createQuery(sql);
			query.setParameter("parentId", pid);
			list = query.list();
			
			if(list.isEmpty()) return false;
			for(int i=0;i<list.size()-1;i++){
				
				Object obj1 = list.get(i);
				fid=obj1.getClass().getDeclaredField("id");
				fid.setAccessible(true);
				Integer id1 = (Integer)fid.get(obj1);
		
				if(id1==id){
					fdispindex1=obj1.getClass().getDeclaredField("dispindex");
					fdispindex1.setAccessible(true);		
					Integer dispindex1 = (Integer)fdispindex1.get(obj1);
					
					Object obj2=list.get(i+1);
					fdispindex2=obj2.getClass().getDeclaredField("dispindex");
					fdispindex2.setAccessible(true);
					Integer dispindex2=(Integer)fdispindex2.get(obj2);	

					Class[] argsclass=new Class[3];
					argsclass[1]=obj1.getClass();
					argsclass[2]=obj2.getClass();
				
					Method m1=obj1.getClass().getDeclaredMethod("setDispindex",fdispindex1.getType());
					Method m2=obj2.getClass().getDeclaredMethod("setDispindex",fdispindex2.getType());
					m1.invoke(obj1, dispindex2);
					m2.invoke(obj2, dispindex1);
					
					session.update(list.get(i));
					session.update(list.get(i+1));
				}
			}
			return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean up(Integer id,Class entityClass) {
		Session session = getSession();
		Object obj=new Object();
		obj=session.get(entityClass, id);
		
		Field fpid,fid,fdispindex1,fdispindex2;
		try {
			fpid = obj.getClass().getDeclaredField("parentid");
			
			if(fpid!=null)
			{
				fpid.setAccessible(true);
				Integer pid = (Integer)fpid.get(obj);

			    List list = new ArrayList();
			
			String sql = "select p from "+entityClass.getName()+" p where p.parentid=:parentId ";
			sql += "order by p.dispindex desc ";
			Query query = session.createQuery(sql);
			query.setParameter("parentId", pid);
			list = query.list();
			
			if(list.isEmpty()) return false;
			for(int i=1;i<list.size();i++){
				
				Object obj1 = list.get(i);
				fid=obj1.getClass().getDeclaredField("id");
				fid.setAccessible(true);
				Integer id1 = (Integer)fid.get(obj1);
				
				if(id1==id){
					fdispindex1=obj1.getClass().getDeclaredField("dispindex");
					fdispindex1.setAccessible(true);		
					Integer dispindex1 = (Integer)fdispindex1.get(obj1);
					
					Object obj2=list.get(i-1);
					fdispindex2=obj2.getClass().getDeclaredField("dispindex");
					fdispindex2.setAccessible(true);
					Integer dispindex2=(Integer)fdispindex2.get(obj2);	

					Class[] argsclass=new Class[3];
					argsclass[1]=obj1.getClass();
					argsclass[2]=obj2.getClass();
				
					Method m1=obj1.getClass().getDeclaredMethod("setDispindex",fdispindex1.getType());
					Method m2=obj2.getClass().getDeclaredMethod("setDispindex",fdispindex2.getType());
					m1.invoke(obj1, dispindex2);
					m2.invoke(obj2, dispindex1);
					
					session.update(list.get(i));
					session.update(list.get(i-1));
				}
			}
			return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 	
		return false;		
	}
}
