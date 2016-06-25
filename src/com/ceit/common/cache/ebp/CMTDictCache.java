package com.ceit.common.cache.ebp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import com.ceit.common.cache.EhcacheManager;
import com.ceit.common.entity.CMTDict;
import com.ceit.common.services.ICMTDictService;
import com.ceit.servlet.CacheServiceInitServlet;

public class CMTDictCache {
	static Log log=LogFactory.getLog(CMTDictCache.class);
    static Cache cache=EhcacheManager.cacheManager.getCache("CMT_DICT");
   
    public static CMTDict get(String companyId,String dicId){
         Element e=cache.get(companyId+"_"+dicId);
         if(e==null){
              return null;
         }
         return (CMTDict)e.getObjectValue();
    }
   
    @SuppressWarnings("unchecked")
    public static List<CMTDict> getByIdOrCode(String companyId,String key) { 
         Element el=cache.get("LIST_"+companyId+"_"+key);
       TreeSet<CMTDict> set=(TreeSet<CMTDict>) el.getObjectValue();
       java.util.Iterator<CMTDict> it=set.iterator();
       List<CMTDict> list=new ArrayList<CMTDict>();
       while(it.hasNext())
       {
            CMTDict dict = it.next();
            list.add(dict);
       }
         return list;
    }
   
    public static void set(CMTDict dict) {
         log.info("正在数据字典配置信息:"+dict.getDicName());
         Element element = new Element(dict.getDicCompanyId()+"_"+dict.getDicId(),dict);
         cache.put(element);
    }
   
    public static void removeById(String companyId,String dict)
    {
         log.info("移除ID为"+dict+"的数据字典配置信息");
         CMTDict res= get(companyId,dict);
         String resId=res.getDicId();
         cache.remove(resId);
    }
   
    @SuppressWarnings("unchecked")
    public static void init(){
         log.info("正在初始化数据字典配置信息");
         if(cache!=null && cache.getSize()!=0){
              log.warn("数据字典配置数据不为空，首先进行清理");
              cache.removeAll();
         }
          
         ICMTDictService service=(ICMTDictService)CacheServiceInitServlet.springContext.getBean("cmtDictManager");
         List<CMTDict> list=service.getAll();
         for(int i=0;i<list.size();i++){
              CMTDict mc=list.get(i);
              String pid=mc.getDicParentId();
              Element e1=cache.get("LIST_"+mc.getDicCompanyId()+"_"+pid);
              if(e1==null){
                   e1=new Element("LIST_"+mc.getDicCompanyId()+"_"+pid,new TreeSet<CMTDict>());
                  cache.put(e1);
              }
              Set<CMTDict> set=(Set<CMTDict>)e1.getObjectValue();
              set.add(mc);

           Element e2=new  Element(mc.getDicCompanyId()+"_"+mc.getDicId().toUpperCase(),mc);
              cache.put(e2);
         }
         log.info("初始化完毕，共初始化:"+list.size()+"条数据");
    }
}
