package com.ceit.common.dao;

import java.util.List;
import java.util.Map;

import com.ceit.common.dao.entity.Orderby;
import com.ceit.common.dao.entity.Sysfield;
import com.ceit.common.dao.entity.Whereelement;
import com.ceit.common.entity.BaseEntity;

public interface ITableDao<E extends BaseEntity> {
	/**
	 * 向数据表新增Object，并返回新增Object的ID
	 * @param  obj 要新增的Object对象
	 * @return 新增Object的ID
	 */
	public Integer insert(Object obj);
	/**
	 * 向数据表新增Object，并返回新增Object的ID
	 * @param  obj 要新增的Object对象
	 * @return 新增Object的ID
	 */
	public boolean insertNew(E obj);
	public boolean insertNew2(E obj);
	public List querydataNew(String sql, boolean hql, int pageindex, int pagesize,Map<String, Object> params) throws Exception;
	public Object getEntitybyIdNew(String id, Class entityClass) throws Exception;
	public boolean deleteNew(String id, Class entityClass);
	/**
	 * 修改数据表中的Object
	 * @param   obj 要修改的Object对象
	 * @return  成功返回true 失败返回false
	 */
	public boolean update(E obj);
	/**
	 * 根据实体的ID，删除数据表中的Object
	 * @param id 要删除的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  成功返回true 失败返回false
	 */
	public boolean delete(Integer id, Class entityClass);
	/**
	 * 根据实体的ID，及其对应的实体类，获取数据表中的Object
	 * @param id 要获取的Object的ID
	 * @param entityClass  Object对应的实体类
	 * @return  查询到的实体
	 */
	public Object getEntitybyId(Integer id, Class entityClass)throws Exception;
	/**
	 * 根据查询语句，返回查询数据信息，可实现数据分页显示
	 * @param sql 查询语句字符串
	 * @param hql 查询语句是否是hql语句
	 * @param pageindex 分页起始页
	 * @param pagesize 分页大小
	 * @param params sql语句中的参数
	 * @return 查询到的数据集合
	 */
	public List querydata(String sql,boolean hql,int pageindex,int pagesize,Map<String, Object> params)throws Exception;
	/**
	 * 根据查询语句，返回查询数据信息,可实现获取数据的数量
	 * @param sql 查询语句字符串
	 * @param hql 查询语句是否是hql语句
	 * @param returnNot 执行查询语句后是否需要返回数据
	 * @param params sql语句中的参数
	 * @return 查询到的数据集合
	 */
	public List otherQuery(String sql, boolean isHql, boolean returnNot,Map<String, Object> params) throws Exception;
	public List getXXdataQuery(List<Sysfield> fieldList,Class entityClass, List<Whereelement> elementList, List<Orderby> orderbyList);

	/**
	 * 位置上移
	 * @param id 要上移的实体ID
	 * @param entityClass 实体的类型
	 * @return 成功返回true 失败返回false
	 */
	public boolean up(Integer id,Class entityClass);
	/**
	 * 位置下移
	 * @param id 要下移的实体ID
	 * @param entityClass 实体的类型
	 * @return 成功返回true 失败返回false
	 */
	public boolean down(Integer id,Class entityClass);
}
